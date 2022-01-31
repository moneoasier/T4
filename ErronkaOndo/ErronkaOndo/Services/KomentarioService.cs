using ErronkaOndo.Data;
using ErronkaOndo.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Services
{
    public class KomentarioService : IkomentarioService
    {
        private readonly ErronkaOndoDbContext _dbContext;
        public KomentarioService(ErronkaOndoDbContext kontestua) {


            this._dbContext = kontestua;
        
        
        }
        /// <summary>
        /// SQL server-en dauden komentarioak erakusten ditu
        /// </summary>
        /// <returns></returns>


        public async Task<IList<Komentario>> Erakutsi()
        {

                return await _dbContext.Komentario.ToListAsync();

        }

        /// <summary>
        /// SQL server-en komentarioak sartzen ditu
        /// </summary>
        /// <param name="komentario"></param>
        /// <returns></returns>

        public async Task Gehitu(Komentario komentario)
        {
            _dbContext.Komentario.Add(komentario);

            _dbContext.SaveChanges();
        }
    }
}
