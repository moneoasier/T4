using ErronkaOndo.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.ViewComponents
{
    [ViewComponent(Name = "Partidak")]
    public class PartidakViewComponent : ViewComponent
    {

        private readonly IPartidaService _partidaService;
        /// <summary>
        /// IpartidaService dependentzia injektatzen da
        /// </summary>
        /// <param name="partidaService"></param>
        public PartidakViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(string employee)
        {
            return View(await _partidaService.GetPartidaPertsona(employee));

        }

    }
}
