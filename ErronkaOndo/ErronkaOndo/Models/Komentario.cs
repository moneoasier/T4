using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Models
{
    public class Komentario
    {
        [Key]
        [ScaffoldColumn(false)]
        public int komentarioId { get; set; }
        public string testua { get; set; }
        public string erabiltzailea { get; set; }
        public int partidaId { get; set; }
       
    }
}
