import React, { useState } from "react";

export default function LandingPage() {

  const [activeTab, setActiveTab] = useState("shorten");
  const [longUrl, setLongUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");
  const [result, setResult] = useState("");
  const [copied, setCopied] = useState(false);

  const handleShorten = async (e) => {
    e.preventDefault();
    try{
      const res=await fetch("http://localhost:8080/api/shortenUrl",{
        method: "POST",
        headers: {
          "Content-Type":"application/json",
        },
        body: JSON.stringify({longUrl})
      });
      
      if(!res.ok)
        throw new Error("Failed to shorten url");

      const short=await res.text();
      setResult(short);
    }catch(err){
      alert(err.message);
    }
  };

  const handleRedirect = (e) => {
  e.preventDefault();
  window.open(`http://localhost:8080/api/${shortUrl}`,"_blank");
};

const handleCopy = async () => {
    await navigator.clipboard.writeText(result);
    setCopied(true);

    setTimeout(()=>{
      setCopied(false);
    },1500)
  };

  return (
    <div className="min-h-screen flex items-center justify-center px-4 bg-slate-950">
      <div className="w-full max-w-lg bg-white rounded-xl p-6">
        <h1 className="text-2xl font-semibold">URL Shortener</h1>
        <p className="text-sm text-slate-600 mt-1">
          Shorten long links or redirect using short URL.
        </p>

        <div className="flex gap-2 mt-6">
          <button
            onClick={() => setActiveTab("shorten")}
            className={`flex-1 py-2 rounded-lg text-sm font-medium border ${
              activeTab === "shorten"
                ? "bg-slate-900 text-white border-slate-900"
                : "bg-white text-slate-700 border-slate-300"
            }`}
          >
            Shorten
          </button>

          <button
            onClick={() => setActiveTab("redirect")}
            className={`flex-1 py-2 rounded-lg text-sm font-medium border ${
              activeTab === "redirect"
                ? "bg-slate-900 text-white border-slate-900"
                : "bg-white text-slate-700 border-slate-300"
            }`}
          >
            Redirect
          </button>
        </div>

        <div className="mt-6">
          {activeTab === "shorten" ? (
            <div className="space-y-4">
            <form onSubmit={handleShorten} className="space-y-4">
              <input
                type="text"
                placeholder="Enter long URL..."
                value={longUrl}
                onChange={(e) => setLongUrl(e.target.value)}
                className="w-full border border-slate-300 rounded-lg px-3 py-2 outline-none focus:ring-2 focus:ring-slate-300"
              />

              <button
                type="submit"
                className="w-full bg-slate-900 text-white rounded-lg py-2 font-medium"
              >
                Shorten URL
              </button>
            </form>

            {result !== "" && (
      <div className="border border-slate-300 rounded-lg p-3 flex items-center justify-between gap-3">
        <p className="text-sm font-medium text-slate-800 break-all">
          {result}
        </p>

        <button
          onClick={handleCopy}
          className="px-3 py-2 rounded-lg bg-slate-900 text-white text-sm"
        >
          {copied?"Copied!":"Copy"}
        </button>
      </div>
    )}
  </div>
          ) : (
            <form onSubmit={handleRedirect} className="space-y-4">
              <input
                type="text"
                placeholder="Enter short URL / code..."
                value={shortUrl}
                onChange={(e) => setShortUrl(e.target.value)}
                className="w-full border border-slate-300 rounded-lg px-3 py-2 outline-none focus:ring-2 focus:ring-slate-300"
              />

              <button
                type="submit"
                className="w-full bg-slate-900 text-white rounded-lg py-2 font-medium"
              >
                Redirect
              </button>
            </form>
          )}
        </div>
      </div>
    </div>
  );
}