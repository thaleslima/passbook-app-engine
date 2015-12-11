 $('#gerar').click(function(){


            var params = {
                "nome": "Fulano da silva",
                "carterinha": "1254 2568 5412 5412",
                "plano": "Especial",
                "acomodacao": "Apartamento",
                "produto": "598",
                "cobertura": "Ambulatorial + Hospitalar + Obstreticia",
                "empresa": "00379 Sul America Companinha de Seguro Saúde",
                "ans": "416428",
                "nascimento": "29/06/1972"
            }

            $.ajax({
                type: "GET",
                url: "https://sas-passbook.appspot.com/passbook/saude",
                //data: params,
                success: function(response, status, xhr) {
                    // check for a filename
                    var filename = "";
                    var disposition = xhr.getResponseHeader('Content-Disposition');
                    if (disposition && disposition.indexOf('attachment') !== -1) {
                        var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                        var matches = filenameRegex.exec(disposition);
                        if (matches != null && matches[1]) filename = matches[1].replace(/['"]/g, '');
                    }

                    var type = xhr.getResponseHeader('Content-Type');
                    var blob = new Blob([response], { type: type });

                    if (typeof window.navigator.msSaveBlob !== 'undefined') {
                        // IE workaround for "HTML7007: One or more blob URLs were revoked by closing the blob for which they were created. These URLs will no longer resolve as the data backing the URL has been freed."
                        window.navigator.msSaveBlob(blob, filename);
                    } else {
                        var URL = window.URL || window.webkitURL;
                        var downloadUrl = URL.createObjectURL(blob);

                        if (filename) {
                            // use HTML5 a[download] attribute to specify filename
                            var a = document.createElement("a");
                            // safari doesn't support this yet
                            if (typeof a.download === 'undefined') {
                                window.location = downloadUrl;
                            } else {

                                var divEl = document.getElementById("passbook");
                            //    var aElem = document.createElement("a");
                            //    aElem.setAttribute("target", "_blank");
                            //    aElem.setAttribute("href", downloadUrl);
                            //    aElem.appendChild(document.createTextNode("sssss"));
                            //    aElem.appendChild(document.createTextNode("Ready! Click To Open."))
                            //    divEl.appendChild(aElem);

                                a.href = downloadUrl;
                                a.download = filename;
                                a.appendChild(document.createTextNode("Ready! Click To Open."))
                                //document.body.appendChild(a);

                                divEl.appendChild(a);

                                a.click();
                            }
                        } else {
                            window.location = downloadUrl;
                        }

                        setTimeout(function () { URL.revokeObjectURL(downloadUrl); }, 100); // cleanup
                    }
                }
            });



 });