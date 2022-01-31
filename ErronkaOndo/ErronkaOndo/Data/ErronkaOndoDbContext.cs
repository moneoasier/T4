using ErronkaOndo.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ErronkaOndo.Data
{
    public class ErronkaOndoDbContext : DbContext
    {
        /// <summary>
        /// DbContext-a ezartzen da klase honetan
        /// </summary>
        /// <param name="options"></param>
        public ErronkaOndoDbContext(DbContextOptions<ErronkaOndoDbContext> options): base(options)
        {
        }
        public DbSet<Komentario> Komentario { get; set; }
        public DbSet<Inkesta> Inkesta { get; set; }


    }
}
