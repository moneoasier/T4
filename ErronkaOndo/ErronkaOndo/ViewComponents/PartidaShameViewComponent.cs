using ErronkaOndo.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.ViewComponents
{
    [ViewComponent(Name = "PartidaShame")]
    public class PartidaShameViewComponent : ViewComponent
    {
        private readonly IPartidaService _partidaService;
        /// <summary>
        /// IpartidaService dependentzia injektatzen da
        /// </summary>
        /// <param name="partidaService"></param>
        public PartidaShameViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _partidaService.GetPartidaShame());

        }





    }
}

