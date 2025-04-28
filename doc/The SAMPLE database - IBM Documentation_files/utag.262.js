//tealium universal tag - utag.262 ut4.0.202504171551, Copyright 2025 Tealium.com Inc. All Rights Reserved.
try{(function(id,loader){var u={"id":id};utag.o[loader].sender[id]=u;if(utag.ut===undefined){utag.ut={};}
var match=/ut\d\.(\d*)\..*/.exec(utag.cfg.v);if(utag.ut.loader===undefined||!match||parseInt(match[1])<41){u.loader=function(o,a,b,c,l,m){utag.DB(o);a=document;if(o.type=="iframe"){m=a.getElementById(o.id);if(m&&m.tagName=="IFRAME"){b=m;}else{b=a.createElement("iframe");}o.attrs=o.attrs||{};utag.ut.merge(o.attrs,{"height":"1","width":"1","style":"display:none"},0);}else if(o.type=="img"){utag.DB("Attach img: "+o.src);b=new Image();}else{b=a.createElement("script");b.language="javascript";b.type="text/javascript";b.async=1;b.charset="utf-8";}if(o.id){b.id=o.id;}for(l in utag.loader.GV(o.attrs)){b.setAttribute(l,o.attrs[l]);}b.setAttribute("src",o.src);if(typeof o.cb=="function"){if(b.addEventListener){b.addEventListener("load",function(){o.cb();},false);}else{b.onreadystatechange=function(){if(this.readyState=="complete"||this.readyState=="loaded"){this.onreadystatechange=null;o.cb();}};}}if(o.type!="img"&&!m){l=o.loc||"head";c=a.getElementsByTagName(l)[0];if(c){utag.DB("Attach to "+l+": "+o.src);if(l=="script"){c.parentNode.insertBefore(b,c);}else{c.appendChild(b);}}}};}else{u.loader=utag.ut.loader;}
if(utag.ut.typeOf===undefined){u.typeOf=function(e){return({}).toString.call(e).match(/\s([a-zA-Z]+)/)[1].toLowerCase();};}else{u.typeOf=utag.ut.typeOf;}
u.ev={"view":1,"link":1};u.initialized=false;u.scriptrequested=false;u.map={"ddo.p.s.thetradedesk.view_advId":"adv_id_view","ddo.p.s.thetradedesk.link_advId":"adv_id_link","ddo.p.s.thetradedesk.view_pid":"up_id_view","ddo.p.s.thetradedesk.link_pid":"up_id_link","ddo.p.s.thetradedesk.view_td1":"td1_view","ddo.p.s.thetradedesk.link_td1":"td1_link","ddo.p.s.thetradedesk.view_td2":"td2_view","ddo.p.s.thetradedesk.link_td2":"td2_link"};u.extend=[];u.clearEmptyKeys=function(object){Object.keys(object).forEach(function(key){if(object[key]===""||object[key]===undefined){delete object[key];}});return object;};u.loader_cb=function(et){utag.DB("send:262:CALLBACK");u.initialized=true;if(et==='view'){if(u.data.adv_id_view){let advId=u.data.adv_id_view
let pid=u.data.up_id_view
let td1=u.data.td1_view
let td2=u.data.td2_view
if(!Array.isArray(u.data.adv_id_view)){advId=[u.data.adv_id_view];}
if(!Array.isArray(u.data.up_id_view)){pid=[u.data.up_id_view];}
if(!Array.isArray(u.data.td1_view)){td1=[u.data.td1_view];}
if(!Array.isArray(u.data.td2_view)){td2=[u.data.td2_view];}
advId.forEach((id,i)=>{let advId=id
let pid=u.data.up_id_view[i]
if(typeof TTDUniversalPixelApi==="function"){var universalPixelApi=new TTDUniversalPixelApi();var config=u.clearEmptyKeys({td1:td1[i],td2:td2[i]});universalPixelApi.init(advId,[pid],"https://insight.adsrvr.org/track/up",Object.keys(config).length?config:"ttdUniversalPixelTag"+u.data.pixel_tag_id);}})}}else{if(u.data.adv_id_link){let advId=u.data.adv_id_link
let pid=u.data.up_id_link
let td1=u.data.td1_link
let td2=u.data.td2_link
if(!Array.isArray(u.data.adv_id_link)){advId=[u.data.adv_id_link];}
if(!Array.isArray(u.data.up_id_link)){pid=[u.data.up_id_link];}
if(!Array.isArray(u.data.td1_link)){td1=[u.data.td1_link];}
if(!Array.isArray(u.data.td2_link)){td2=[u.data.td2_link];}
advId.forEach((id,i)=>{let advId=id
let pid=u.data.up_id_link[i]
if(typeof TTDUniversalPixelApi==="function"){var universalPixelApi=new TTDUniversalPixelApi();var config=u.clearEmptyKeys({td1:td1[i],td2:td2[i]});universalPixelApi.init(advId,[pid],"https://insight.adsrvr.org/track/up",Object.keys(config).length?config:"ttdUniversalPixelTag"+u.data.pixel_tag_id);}})}}
utag.DB("send:262:CALLBACK:COMPLETE");};u.send=function(a,b){if(u.ev[a]||u.ev.all!==undefined){utag.DB("send:262");utag.DB(b);var et,c,d,e,f;et=a
u.data={qsp_delim:"&",kvp_delim:"=",base_url:"//js.adsrvr.org/up_loader.1.1.0.js",adv_id:"",up_id:"",pixel_tag_id:"",td1:"",td2:""};utag.DB("send:262:EXTENSIONS");utag.DB(b);for(d in utag.loader.GV(u.map)){if(b[d]!==undefined&&b[d]!==""){e=u.map[d].split(",");for(f=0;f<e.length;f++){u.data[e[f]]=b[d];}}}
utag.DB("send:262:MAPPINGS");utag.DB(u.data);if(!u.data.adv_id_view&&!u.data.adv_id_link){utag.DB(u.id+": Tag not fired: Required attribute not populated");return;}
if(u.initialized){u.loader_cb(et);}else{if(!u.scriptrequested){u.scriptrequested=true;var missing=!(document.getElementById('ttdUniversalPixelTag'+u.data.pixel_tag_id));let nonce=null;if(!!document.querySelector("[nonce]")&&!!document.querySelector("[nonce]").nonce){nonce=document.querySelector("[nonce]").nonce}
else if(!!window.nonce){nonce=window.nonce}
if(missing){var div=document.createElement('div');div.setAttribute('id','ttdUniversalPixelTag'+u.data.pixel_tag_id);if(!!nonce){div.setAttribute("nonce",nonce)}
div.setAttribute('style','display: none;');document.getElementsByTagName('body')[0].appendChild(div);}
u.loader({"type":"script","src":u.data.base_url,"cb":function(){u.loader_cb(et)},"loc":"script","id":"utag_262","attrs":{}});}}
utag.DB("send:262:COMPLETE");}};utag.o[loader].loader.LOAD(id);}("262","ibm.web"));}catch(error){utag.DB(error);}
