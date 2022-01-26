using ErronkaOndo.Models;
using ErronkaOndo.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Controllers
{
  // [Authorize]
    public class KomentarioController : Controller
    {
        private readonly IkomentarioService _komentarioService;

        public KomentarioController(IkomentarioService komentarioService)
        {
            _komentarioService = komentarioService;
        }
        

        // GET: KomentarioController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: KomentarioController/Create
        public ActionResult Index(int partidaId)
        {
            ViewBag.partidaId = partidaId;
            return View();
        }

        // POST: KomentarioController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Index(Komentario komentario)
        {
            try
            {
                _komentarioService.Gehitu(komentario);
                return View();
            }
            catch
            {
                return View();
            }
        }

        // GET: KomentarioController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: KomentarioController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: KomentarioController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: KomentarioController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
