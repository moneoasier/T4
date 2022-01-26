using ErronkaOndo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Services
{
    public interface IkomentarioService
    {


        Task Gehitu(Komentario komentario);
       Task <IList<Komentario>> Erakutsi();
    }
}
