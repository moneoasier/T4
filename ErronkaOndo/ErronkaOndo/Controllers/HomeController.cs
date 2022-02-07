using ErronkaOndo.Models;
using ErronkaOndo.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Controllers
{
    /// <summary>
    /// HomeController kontroladorea
    /// </summary>
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IkomentarioService _komentarioService;
        private readonly IPartidaService _partidaService;

        public HomeController(ILogger<HomeController> logger,IkomentarioService komentarioService,IPartidaService partidaService)
        {
            _logger = logger;
            _komentarioService = komentarioService;
            _partidaService = partidaService;

        }

        public IActionResult Index()
        {
            return View();
        }
        public IActionResult HallOfFame()
        {

            return View();
        }
        public IActionResult HallOfShame()
        {

            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        public IActionResult Foroa()
        {
            return View();
        }

        public async Task<IActionResult> PartidakEmployee(int id)
        {
            IEnumerable<Partida> list = await _partidaService.GetPartidaPertsona(id+"");

            ViewData["cuantos"] = list.Count();
            ViewData["empid"] = id;

            return View(list);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Foroa(Komentario komentario)
        {
            try
            {
                _komentarioService.Gehitu(komentario);

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }


        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
