#pragma checksum "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "d4a2a3d8190f204e816ada1116f21f8c7ea51cd4"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Components_Partida_Default), @"mvc.1.0.view", @"/Views/Shared/Components/Partida/Default.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\_ViewImports.cshtml"
using ErronkaOndo;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\_ViewImports.cshtml"
using ErronkaOndo.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 1 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
using Microsoft.AspNetCore.Identity;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d4a2a3d8190f204e816ada1116f21f8c7ea51cd4", @"/Views/Shared/Components/Partida/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"148d45b9fa047d481d80db30a0f52954e0b674ca", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_Partida_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<ErronkaOndo.Models.Partida>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-controller", "Komentario", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Index", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\n\n\n");
            WriteLiteral("\n");
#nullable restore
#line 9 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
  
    ViewData["Title"] = "Default";

#line default
#line hidden
#nullable disable
            WriteLiteral(@"



<table class=""table"">
    <thead>
        <tr>
            <th>
                Partida Id
            </th>
            <th>
                Puntuazioa
            </th>
            <th>
                Data
            </th>
            <th>
                Langile Id
            </th>
            <th>
                Adina
            </th>
            <th>
                Departamendua
            </th>
            <th></th>
        </tr>
    </thead>
    <tbody>





");
#nullable restore
#line 46 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
         foreach (var item in Model)
        {

#line default
#line hidden
#nullable disable
            WriteLiteral("            <tr>\n                <td>\n                    ");
#nullable restore
#line 50 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.partidaId));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 53 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 56 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.data));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 59 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.employeeid));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 62 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.adina));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 65 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.departamentua));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "d4a2a3d8190f204e816ada1116f21f8c7ea51cd47350", async() => {
                WriteLiteral("<button type=\"button\" class=\"btn btn-outline-info\">Komentatu</button>");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Controller = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-partidaId", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 68 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
                                                                               WriteLiteral(item.partidaId);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["partidaId"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-partidaId", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["partidaId"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\n                </td>\n            </tr>\n");
#nullable restore
#line 71 "C:\Users\moneo.asier\Documents\GitHub\T4\ErronkaOndo\ErronkaOndo\Views\Shared\Components\Partida\Default.cshtml"
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\n</table>\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public UserManager<IdentityUser> UserManager { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public SignInManager<IdentityUser> SignInManager { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<ErronkaOndo.Models.Partida>> Html { get; private set; }
    }
}
#pragma warning restore 1591