using ErronkaOndo.Data;
using ErronkaOndo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Services
{

    
    public class InkestaService:IinkestaService
    {
        private readonly ErronkaOndoDbContext _dbContext;

        public InkestaService(ErronkaOndoDbContext kontestua) {

            this._dbContext = kontestua;

        }


        public async Task Bidali(Inkesta inkesta) {

            _dbContext.Inkesta.Add(inkesta);
            _dbContext.SaveChanges();
        
        }
    }
}
