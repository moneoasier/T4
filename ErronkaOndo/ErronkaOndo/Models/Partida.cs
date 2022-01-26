using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Models
{
    public class Partida
    {
        public int partidaId { get; set; }
        public int puntuazioa { get; set; }
        public DateTime data { get; set; }
        public int employeeid { get; set; }
        public int adina { get; set; }

        public string departamentua { get; set; }
    }
}
