using ErronkaOndo.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace ErronkaOndo.Services
{
    public class PartidaService:IPartidaService
    {


        private Uri rutaTodos = new Uri("http://192.168.65.4:8080/");

        public async Task<IList<Partida>> GetPartida()
        {
            List<Partida> partidaList = new List<Partida>();
            Uri rutaPartidak = new Uri(rutaTodos, "partidakFame");
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaPartidak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partidaList = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partidaList;
        }
        public async Task<IList<Partida>> GetPartidaShame()
        {
            List<Partida> partidaList = new List<Partida>();
            Uri rutaPartidak = new Uri(rutaTodos, "partidakShame");
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaPartidak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partidaList = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partidaList;
        }

    }
}
