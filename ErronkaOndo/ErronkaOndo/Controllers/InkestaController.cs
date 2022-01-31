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
    /// <summary>
    /// InkestaController kontroladorea
    /// </summary>
    [Authorize]
    public class InkestaController : Controller
    {
        private readonly IinkestaService _inkestaService;


        public InkestaController(IinkestaService inkestaService)
        {
            _inkestaService = inkestaService;
        }

        // GET: InkestaController
        public ActionResult Index()
        {
            return View();
        }

        // GET: InkestaController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

       

        // POST: InkestaController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Index(Inkesta inkesta)
        {
            try
            {
                _inkestaService.Bidali(inkesta);

                return View();
            }
            catch
            {
                return View();
            }
        }

        // GET: InkestaController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: InkestaController/Edit/5
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

        // GET: InkestaController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: InkestaController/Delete/5
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
