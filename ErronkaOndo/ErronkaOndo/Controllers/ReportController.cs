using AspNetCore.Reporting;
using ErronkaOndo.Services;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ErronkaOndo.Controllers
{
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnvironment;
        private readonly IPartidaService _partidaService;
        private readonly IkomentarioService _komentarioService;
        public ReportController(IWebHostEnvironment webHostEnvironment,IPartidaService partidaService, IkomentarioService komentarioService)
        {
            _webHostEnvironment = webHostEnvironment;
            _partidaService = partidaService;
            _komentarioService = komentarioService;
        }
        public async Task<IActionResult> InprimatuFame()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\Report1.rdlc";
            Dictionary<string, string> parameters = new Dictionary<string, string>();
            var fame = await _partidaService.GetPartida();
            var kopuru = await _partidaService.Getpartidakopurua();
            parameters.Add("rp1", kopuru.ToString() );
            LocalReport localReport = new LocalReport(path);
            localReport.AddDataSource("DataSetHallOfFame", fame);

            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
            return File(result.MainStream, "application/pdf");
        }


        public async Task<IActionResult> InprimatuShame()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\Report2.rdlc";
            Dictionary<string, string> parameters = new Dictionary<string, string>();
            var shame = await _partidaService.GetPartidaShame();

            LocalReport localReport = new LocalReport(path);
            localReport.AddDataSource("DataSetHallOfShame", shame);
            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
            return File(result.MainStream, "application/pdf");
        }


        public async Task<IActionResult> InprimatuKomentario()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\Report3.rdlc";
            Dictionary<string, string> parameters = new Dictionary<string, string>();
            var komentario = await _komentarioService.Erakutsi();

            LocalReport localReport = new LocalReport(path);
            localReport.AddDataSource("DataSetKomentario", komentario);
            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
            return File(result.MainStream, "application/pdf");
        }


    }
}
