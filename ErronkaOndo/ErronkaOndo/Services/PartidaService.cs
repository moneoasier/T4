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


        /// <summary>
        /// Partidak lortzen ditu Rest api-tik
        /// </summary>
        /// <returns></returns>

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
        /// <summary>
        /// Rest api-tik Hall of shame partidak hartzen ditu
        /// </summary>
        /// <returns></returns>

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

        
        public async Task<List<Partida>> GetPartidaPertsona(string employee)
        {
            List<Partida> partidaList = new List<Partida>();
            Uri rutaPartidak = new Uri(rutaTodos, "partidaEmployee?employee="+employee);
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
        

        public async Task<int> Getpartidakopurua()
        {
            int partida;
            Uri rutaPartidak = new Uri(rutaTodos, "partidakKopurua");
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaPartidak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida = JsonConvert.DeserializeObject<int>(apiResponse);
                }
            }
            return partida;
        }

    }
}
