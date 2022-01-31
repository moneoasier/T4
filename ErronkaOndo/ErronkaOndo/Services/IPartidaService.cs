using ErronkaOndo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Services
{
   public interface IPartidaService
    {

        Task<IList<Partida>> GetPartida();
        Task<IList<Partida>> GetPartidaShame();
        Task<IList<Partida>> GetPartidaPertsona();


    }
}
