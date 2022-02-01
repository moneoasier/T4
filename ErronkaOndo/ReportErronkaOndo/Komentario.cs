using System;
using System.Collections.Generic;

using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Models
{
    /// <summary>
    /// Komentario klasea
    /// </summary>
    public class Komentario
    {
 
        public int komentarioId { get; set; }
        public string testua { get; set; }
        public string erabiltzailea { get; set; }
        public int partidaId { get; set; }
       
    }
}
