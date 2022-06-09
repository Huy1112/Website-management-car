!function(e,t){"function"==typeof define&&define.amd?define([],t):"object"==typeof exports?module.exports=t():e.sortable=t()}(this,function(){"use strict";function e(e,t,n){var r=null;return 0===t?e:function(){var a=n||this,o=arguments;clearTimeout(r),r=setTimeout(function(){e.apply(a,o)},t)}}var t,n,r=[],a=[],o=function(e,t,n){return void 0===n?e&&e.h5s&&e.h5s.data&&e.h5s.data[t]:(e.h5s=e.h5s||{},e.h5s.data=e.h5s.data||{},e.h5s.data[t]=n,void 0)},i=function(e){e.h5s&&delete e.h5s.data},s=function(e,t){return(e.matches||e.matchesSelector||e.msMatchesSelector||e.mozMatchesSelector||e.webkitMatchesSelector||e.oMatchesSelector).call(e,t)},l=function(e,t){if(!t)return Array.prototype.slice.call(e);for(var n=[],r=0;r<e.length;++r)"string"==typeof t&&s(e[r],t)&&n.push(e[r]),t.indexOf(e[r])!==-1&&n.push(e[r]);return n},d=function(e,t,n){if(e instanceof Array)for(var r=0;r<e.length;++r)d(e[r],t,n);else e.addEventListener(t,n),e.h5s=e.h5s||{},e.h5s.events=e.h5s.events||{},e.h5s.events[t]=n},c=function(e,t){if(e instanceof Array)for(var n=0;n<e.length;++n)c(e[n],t);else e.h5s&&e.h5s.events&&e.h5s.events[t]&&(e.removeEventListener(t,e.h5s.events[t]),delete e.h5s.events[t])},f=function(e,t,n){if(e instanceof Array)for(var r=0;r<e.length;++r)f(e[r],t,n);else e.setAttribute(t,n)},u=function(e,t){if(e instanceof Array)for(var n=0;n<e.length;++n)u(e[n],t);else e.removeAttribute(t)},p=function(e){var t=e.getClientRects()[0];return{left:t.left+window.scrollX,top:t.top+window.scrollY}},h=function(e){c(e,"dragstart"),c(e,"dragend"),c(e,"selectstart"),c(e,"dragover"),c(e,"dragenter"),c(e,"drop")},g=function(e){c(e,"dragover"),c(e,"dragenter"),c(e,"drop")},m=function(e,t){e.dataTransfer.effectAllowed="move",e.dataTransfer.setData("text",""),e.dataTransfer.setDragImage&&e.dataTransfer.setDragImage(t.draggedItem,t.x,t.y)},v=function(e,t){return t.x||(t.x=parseInt(e.pageX-p(t.draggedItem).left)),t.y||(t.y=parseInt(e.pageY-p(t.draggedItem).top)),t},y=function(e){return{draggedItem:e}},b=function(e,t){var n=y(t);n=v(e,n),m(e,n)},E=function(e){i(e),u(e,"aria-dropeffect")},x=function(e){u(e,"aria-grabbed"),u(e,"draggable"),u(e,"role")},I=function(e,t){return e===t||void 0!==o(e,"connectWith")&&o(e,"connectWith")===o(t,"connectWith")},w=function(e,t){var n,r=[];if(!t)return e;for(var a=0;a<e.length;++a)n=e[a].querySelectorAll(t),r=r.concat(Array.prototype.slice.call(n));return r},A=function(e){var t=o(e,"opts")||{},n=l(e.children,t.items),r=w(n,t.handle);g(e),E(e),c(r,"mousedown"),h(n),x(n)},C=function(e){var t=o(e,"opts"),n=l(e.children,t.items),r=w(n,t.handle);f(e,"aria-dropeffect","move"),f(r,"draggable","true");var a=(document||window.document).createElement("span");"function"!=typeof a.dragDrop||t.disableIEFix||d(r,"mousedown",function(){if(n.indexOf(this)!==-1)this.dragDrop();else{for(var e=this.parentElement;n.indexOf(e)===-1;)e=e.parentElement;e.dragDrop()}})},D=function(e){var t=o(e,"opts"),n=l(e.children,t.items),r=w(n,t.handle);f(e,"aria-dropeffect","none"),f(r,"draggable","false"),c(r,"mousedown")},S=function(e){var t=o(e,"opts"),n=l(e.children,t.items),r=w(n,t.handle);h(n),c(r,"mousedown"),g(e)},L=function(e){return e.parentElement?Array.prototype.indexOf.call(e.parentElement.children,e):0},O=function(e){return!!e.parentNode},T=function(e,t){if("string"!=typeof e)return e;var n=document.createElement(t);return n.innerHTML=e,n.firstChild},W=function(e,t){e.parentElement.insertBefore(t,e)},N=function(e,t){e.parentElement.insertBefore(t,e.nextElementSibling)},M=function(e){e.parentNode&&e.parentNode.removeChild(e)},P=function(e,t){var n=document.createEvent("Event");return t&&(n.detail=t),n.initEvent(e,!1,!0),n},Y=function(e,t){a.forEach(function(n){I(e,n)&&n.dispatchEvent(t)})},q=function(i,c){var u=String(c);return c=function(e){var t={connectWith:!1,placeholder:null,dragImage:null,disableIEFix:!1,placeholderClass:"sortable-placeholder",draggingClass:"sortable-dragging",hoverClass:!1,debounce:0};for(var n in e)t[n]=e[n];return t}(c),"string"==typeof i&&(i=document.querySelectorAll(i)),i instanceof window.Element&&(i=[i]),i=Array.prototype.slice.call(i),i.forEach(function(i){if(/enable|disable|destroy/.test(u))return void q[u](i);c=o(i,"opts")||c,o(i,"opts",c),S(i);var h,g,v=l(i.children,c.items),y=c.placeholder;if(y||(y=document.createElement(/^ul|ol$/i.test(i.tagName)?"li":"div")),y=T(y,i.tagName),y.classList.add.apply(y.classList,c.placeholderClass.split(" ")),!i.getAttribute("data-sortable-id")){var E=a.length;a[E]=i,f(i,"data-sortable-id",E),f(v,"data-item-sortable-id",E)}if(o(i,"items",c.items),r.push(y),c.connectWith&&o(i,"connectWith",c.connectWith),C(i),f(v,"role","option"),f(v,"aria-grabbed","false"),c.hoverClass){var x="sortable-over";"string"==typeof c.hoverClass&&(x=c.hoverClass),d(v,"mouseenter",function(){this.classList.add(x)}),d(v,"mouseleave",function(){this.classList.remove(x)})}d(v,"dragstart",function(e){e.stopImmediatePropagation(),c.handle&&!s(e.target,c.handle)||(c.dragImage?(m(e,{draggedItem:c.dragImage,x:0,y:0}),console.log("WARNING: dragImage option is deprecated and will be removed in the future!")):b(e,this),this.classList.add(c.draggingClass),t=this,f(t,"aria-grabbed","true"),h=L(t),n=parseInt(window.getComputedStyle(t).height),g=this.parentElement,Y(i,P("sortstart",{item:t,placeholder:y,startparent:g})))}),d(v,"dragend",function(){var e;t&&(t.classList.remove(c.draggingClass),f(t,"aria-grabbed","false"),t.style.display=t.oldDisplay,delete t.oldDisplay,r.forEach(M),e=this.parentElement,Y(i,P("sortstop",{item:t,startparent:g})),h===L(t)&&g===e||Y(i,P("sortupdate",{item:t,index:l(e.children,o(e,"items")).indexOf(t),oldindex:v.indexOf(t),elementIndex:L(t),oldElementIndex:h,startparent:g,endparent:e})),t=null,n=null)}),d([i,y],"drop",function(e){var n;I(i,t.parentElement)&&(e.preventDefault(),e.stopPropagation(),n=r.filter(O)[0],N(n,t),t.dispatchEvent(P("dragend")))});var w=e(function(e,a){if(t)if(v.indexOf(e)!==-1){var o=parseInt(window.getComputedStyle(e).height),i=L(y),s=L(e);if(c.forcePlaceholderSize&&(y.style.height=n+"px"),o>n){var d=o-n,f=p(e).top;if(i<s&&a<f+d)return;if(i>s&&a>f+o-d)return}void 0===t.oldDisplay&&(t.oldDisplay=t.style.display),t.style.display="none",i<s?N(e,y):W(e,y),r.filter(function(e){return e!==y}).forEach(M)}else r.indexOf(e)!==-1||l(e.children,c.items).length||(r.forEach(M),e.appendChild(y))},c.debounce),A=function(e){I(i,t.parentElement)&&(e.preventDefault(),e.stopPropagation(),e.dataTransfer.dropEffect="move",w(this,e.pageY))};d(v.concat(i),"dragover",A),d(v.concat(i),"dragenter",A)}),i};return q.destroy=function(e){A(e)},q.enable=function(e){C(e)},q.disable=function(e){D(e)},q});
//# sourceMappingURL=html.sortable.min.js.map