using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Models
{
    /// <summary>
    /// Inkesta klasea
    /// </summary>
    public class Inkesta
    {
        [Key]
        [ScaffoldColumn(false)]
        public int id { get; set; }

        public int puntuazioa { get; set; }

        public string hobekuntza { get; set; }

        public int gomendioa { get; set; }

        public string jokugaia { get; set; }
        
        public string gustora { get; set; }

    }
}
