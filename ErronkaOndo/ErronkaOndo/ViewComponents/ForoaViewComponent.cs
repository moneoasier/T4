using ErronkaOndo.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.ViewComponents
{
    [ViewComponent(Name = "Foroa")]
    public class ForoaViewComponent:ViewComponent
    {

            private readonly IkomentarioService _komentarioservice;

            public ForoaViewComponent(IkomentarioService komentarioservice)
            {
                _komentarioservice = komentarioservice;
            }
            public async Task<IViewComponentResult> InvokeAsync()
            {
                return View(await _komentarioservice.Erakutsi());

            }

    }
}
