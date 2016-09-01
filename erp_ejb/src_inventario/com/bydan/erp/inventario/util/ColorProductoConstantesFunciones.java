/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.inventario.util.ColorProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ColorProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ColorProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ColorProductoConstantesFunciones extends ColorProductoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ColorProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ColorProducto"+ColorProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ColorProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ColorProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ColorProductoConstantesFunciones.SCHEMA+"_"+ColorProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ColorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ColorProductoConstantesFunciones.SCHEMA+"_"+ColorProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ColorProductoConstantesFunciones.SCHEMA+"_"+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ColorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ColorProductoConstantesFunciones.SCHEMA+"_"+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ColorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ColorProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ColorProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ColorProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ColorProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ColorProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ColorProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Color Productoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Color Producto";
	public static final String SCLASSWEBTITULO_LOWER="Color Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ColorProducto";
	public static final String OBJECTNAME="colorproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="color_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select colorproducto from "+ColorProductoConstantesFunciones.SPERSISTENCENAME+" colorproducto";
	public static String QUERYSELECTNATIVE="select "+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".id,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".version_row,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".id_empresa,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".id_grupo_color,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".codigo,"+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME+".nombre from "+ColorProductoConstantesFunciones.SCHEMA+"."+ColorProductoConstantesFunciones.TABLENAME;//+" as "+ColorProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ColorProductoConstantesFuncionesAdditional colorproductoConstantesFuncionesAdditional=null;
	
	public ColorProductoConstantesFuncionesAdditional getColorProductoConstantesFuncionesAdditional() {
		return this.colorproductoConstantesFuncionesAdditional;
	}
	
	public void setColorProductoConstantesFuncionesAdditional(ColorProductoConstantesFuncionesAdditional colorproductoConstantesFuncionesAdditional) {
		try {
			this.colorproductoConstantesFuncionesAdditional=colorproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String IDGRUPOCOLOR= "id_grupo_color";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_IDGRUPOCOLOR= "Grupo Color";
		public static final String LABEL_IDGRUPOCOLOR_LOWER= "Grupo Color";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getColorProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ColorProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ColorProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ColorProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=ColorProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(ColorProductoConstantesFunciones.IDGRUPOCOLOR)) {sLabelColumna=ColorProductoConstantesFunciones.LABEL_IDGRUPOCOLOR;}
		if(sNombreColumna.equals(ColorProductoConstantesFunciones.CODIGO)) {sLabelColumna=ColorProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ColorProductoConstantesFunciones.NOMBRE)) {sLabelColumna=ColorProductoConstantesFunciones.LABEL_NOMBRE;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
	
	public static String getColorProductoDescripcion(ColorProducto colorproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(colorproducto !=null/* && colorproducto.getId()!=0*/) {
			sDescripcion=colorproducto.getcodigo();//colorproductocolorproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getColorProductoDescripcionDetallado(ColorProducto colorproducto) {
		String sDescripcion="";
			
		sDescripcion+=ColorProductoConstantesFunciones.ID+"=";
		sDescripcion+=colorproducto.getId().toString()+",";
		sDescripcion+=ColorProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=colorproducto.getVersionRow().toString()+",";
		sDescripcion+=ColorProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=colorproducto.getid_empresa().toString()+",";
		sDescripcion+=ColorProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=colorproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=ColorProductoConstantesFunciones.IDGRUPOCOLOR+"=";
		sDescripcion+=colorproducto.getid_grupo_color().toString()+",";
		sDescripcion+=ColorProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=colorproducto.getcodigo()+",";
		sDescripcion+=ColorProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=colorproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setColorProductoDescripcion(ColorProducto colorproducto,String sValor) throws Exception {			
		if(colorproducto !=null) {
			colorproducto.setcodigo(sValor);;//colorproductocolorproducto.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproducto!=null/*&&tipoproducto.getId()>0*/) {
			sDescripcion=TipoProductoConstantesFunciones.getTipoProductoDescripcion(tipoproducto);
		}

		return sDescripcion;
	}

	public static String getGrupoColorDescripcion(GrupoColor grupocolor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocolor!=null/*&&grupocolor.getId()>0*/) {
			sDescripcion=GrupoColorConstantesFunciones.getGrupoColorDescripcion(grupocolor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoColor")) {
			sNombreIndice="Tipo=  Por Grupo Color";
		} else if(sNombreIndice.equals("FK_IdTipoProducto")) {
			sNombreIndice="Tipo=  Por Tipo Producto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoColor(Long id_grupo_color) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_color!=null) {sDetalleIndice+=" Codigo Unico De Grupo Color="+id_grupo_color.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosColorProducto(ColorProducto colorproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		colorproducto.setcodigo(colorproducto.getcodigo().trim());
		colorproducto.setnombre(colorproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosColorProductos(List<ColorProducto> colorproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ColorProducto colorproducto: colorproductos) {
			colorproducto.setcodigo(colorproducto.getcodigo().trim());
			colorproducto.setnombre(colorproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresColorProducto(ColorProducto colorproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && colorproducto.getConCambioAuxiliar()) {
			colorproducto.setIsDeleted(colorproducto.getIsDeletedAuxiliar());	
			colorproducto.setIsNew(colorproducto.getIsNewAuxiliar());	
			colorproducto.setIsChanged(colorproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			colorproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			colorproducto.setIsDeletedAuxiliar(false);	
			colorproducto.setIsNewAuxiliar(false);	
			colorproducto.setIsChangedAuxiliar(false);
			
			colorproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresColorProductos(List<ColorProducto> colorproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ColorProducto colorproducto : colorproductos) {
			if(conAsignarBase && colorproducto.getConCambioAuxiliar()) {
				colorproducto.setIsDeleted(colorproducto.getIsDeletedAuxiliar());	
				colorproducto.setIsNew(colorproducto.getIsNewAuxiliar());	
				colorproducto.setIsChanged(colorproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				colorproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				colorproducto.setIsDeletedAuxiliar(false);	
				colorproducto.setIsNewAuxiliar(false);	
				colorproducto.setIsChangedAuxiliar(false);
				
				colorproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresColorProducto(ColorProducto colorproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresColorProductos(List<ColorProducto> colorproductos,Boolean conEnteros) throws Exception  {
		
		for(ColorProducto colorproducto: colorproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaColorProducto(List<ColorProducto> colorproductos,ColorProducto colorproductoAux) throws Exception  {
		ColorProductoConstantesFunciones.InicializarValoresColorProducto(colorproductoAux,true);
		
		for(ColorProducto colorproducto: colorproductos) {
			if(colorproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesColorProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ColorProductoConstantesFunciones.getArrayColumnasGlobalesColorProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesColorProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ColorProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ColorProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoColorProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ColorProducto> colorproductos,ColorProducto colorproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ColorProducto colorproductoAux: colorproductos) {
			if(colorproductoAux!=null && colorproducto!=null) {
				if((colorproductoAux.getId()==null && colorproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(colorproductoAux.getId()!=null && colorproducto.getId()!=null){
					if(colorproductoAux.getId().equals(colorproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaColorProducto(List<ColorProducto> colorproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ColorProducto colorproducto: colorproductos) {			
			if(colorproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaColorProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_ID, ColorProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_VERSIONROW, ColorProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_IDEMPRESA, ColorProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, ColorProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_IDGRUPOCOLOR, ColorProductoConstantesFunciones.IDGRUPOCOLOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_CODIGO, ColorProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ColorProductoConstantesFunciones.LABEL_NOMBRE, ColorProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasColorProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.IDGRUPOCOLOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ColorProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorProducto() throws Exception  {
		return ColorProductoConstantesFunciones.getTiposSeleccionarColorProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorProducto(Boolean conFk) throws Exception  {
		return ColorProductoConstantesFunciones.getTiposSeleccionarColorProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarColorProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ColorProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(ColorProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorProductoConstantesFunciones.LABEL_IDGRUPOCOLOR);
			reporte.setsDescripcion(ColorProductoConstantesFunciones.LABEL_IDGRUPOCOLOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ColorProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ColorProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ColorProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesColorProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesColorProducto(ColorProducto colorproductoAux) throws Exception {
		
			colorproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(colorproductoAux.getEmpresa()));
			colorproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(colorproductoAux.getTipoProducto()));
			colorproductoAux.setgrupocolor_descripcion(GrupoColorConstantesFunciones.getGrupoColorDescripcion(colorproductoAux.getGrupoColor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesColorProducto(List<ColorProducto> colorproductosTemp) throws Exception {
		for(ColorProducto colorproductoAux:colorproductosTemp) {
			
			colorproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(colorproductoAux.getEmpresa()));
			colorproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(colorproductoAux.getTipoProducto()));
			colorproductoAux.setgrupocolor_descripcion(GrupoColorConstantesFunciones.getGrupoColorDescripcion(colorproductoAux.getGrupoColor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfColorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoProducto.class));
				classes.add(new Classe(GrupoColor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProducto.class)) {
						classes.add(new Classe(TipoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoColor.class)) {
						classes.add(new Classe(GrupoColor.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfColorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(GrupoColor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoColor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(GrupoColor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoColor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfColorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ColorProductoConstantesFunciones.getClassesRelationshipsOfColorProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfColorProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfColorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ColorProductoConstantesFunciones.getClassesRelationshipsFromStringsOfColorProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfColorProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ColorProducto colorproducto,List<ColorProducto> colorproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ColorProducto colorproductoEncontrado=null;
			
			for(ColorProducto colorproductoLocal:colorproductos) {
				if(colorproductoLocal.getId().equals(colorproducto.getId())) {
					colorproductoEncontrado=colorproductoLocal;
					
					colorproductoLocal.setIsChanged(colorproducto.getIsChanged());
					colorproductoLocal.setIsNew(colorproducto.getIsNew());
					colorproductoLocal.setIsDeleted(colorproducto.getIsDeleted());
					
					colorproductoLocal.setGeneralEntityOriginal(colorproducto.getGeneralEntityOriginal());
					
					colorproductoLocal.setId(colorproducto.getId());	
					colorproductoLocal.setVersionRow(colorproducto.getVersionRow());	
					colorproductoLocal.setid_empresa(colorproducto.getid_empresa());	
					colorproductoLocal.setid_tipo_producto(colorproducto.getid_tipo_producto());	
					colorproductoLocal.setid_grupo_color(colorproducto.getid_grupo_color());	
					colorproductoLocal.setcodigo(colorproducto.getcodigo());	
					colorproductoLocal.setnombre(colorproducto.getnombre());	
					
					
					colorproductoLocal.setParametroInventarioDefectos(colorproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!colorproducto.getIsDeleted()) {
				if(!existe) {
					colorproductos.add(colorproducto);
				}
			} else {
				if(colorproductoEncontrado!=null && permiteQuitar)  {
					colorproductos.remove(colorproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ColorProducto colorproducto,List<ColorProducto> colorproductos) throws Exception {
		try	{			
			for(ColorProducto colorproductoLocal:colorproductos) {
				if(colorproductoLocal.getId().equals(colorproducto.getId())) {
					colorproductoLocal.setIsSelected(colorproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesColorProducto(List<ColorProducto> colorproductosAux) throws Exception {
		//this.colorproductosAux=colorproductosAux;
		
		for(ColorProducto colorproductoAux:colorproductosAux) {
			if(colorproductoAux.getIsChanged()) {
				colorproductoAux.setIsChanged(false);
			}		
			
			if(colorproductoAux.getIsNew()) {
				colorproductoAux.setIsNew(false);
			}	
			
			if(colorproductoAux.getIsDeleted()) {
				colorproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesColorProducto(ColorProducto colorproductoAux) throws Exception {
		//this.colorproductoAux=colorproductoAux;
		
			if(colorproductoAux.getIsChanged()) {
				colorproductoAux.setIsChanged(false);
			}		
			
			if(colorproductoAux.getIsNew()) {
				colorproductoAux.setIsNew(false);
			}	
			
			if(colorproductoAux.getIsDeleted()) {
				colorproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ColorProducto colorproductoAsignar,ColorProducto colorproducto) throws Exception {
		colorproductoAsignar.setId(colorproducto.getId());	
		colorproductoAsignar.setVersionRow(colorproducto.getVersionRow());	
		colorproductoAsignar.setid_empresa(colorproducto.getid_empresa());
		colorproductoAsignar.setempresa_descripcion(colorproducto.getempresa_descripcion());	
		colorproductoAsignar.setid_tipo_producto(colorproducto.getid_tipo_producto());
		colorproductoAsignar.settipoproducto_descripcion(colorproducto.gettipoproducto_descripcion());	
		colorproductoAsignar.setid_grupo_color(colorproducto.getid_grupo_color());
		colorproductoAsignar.setgrupocolor_descripcion(colorproducto.getgrupocolor_descripcion());	
		colorproductoAsignar.setcodigo(colorproducto.getcodigo());	
		colorproductoAsignar.setnombre(colorproducto.getnombre());	
	}
	
	public static void inicializarColorProducto(ColorProducto colorproducto) throws Exception {
		try {
				colorproducto.setId(0L);	
					
				colorproducto.setid_empresa(-1L);	
				colorproducto.setid_tipo_producto(-1L);	
				colorproducto.setid_grupo_color(-1L);	
				colorproducto.setcodigo("");	
				colorproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderColorProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorProductoConstantesFunciones.LABEL_IDGRUPOCOLOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ColorProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataColorProducto(String sTipo,Row row,Workbook workbook,ColorProducto colorproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(colorproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(colorproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(colorproducto.getgrupocolor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(colorproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(colorproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryColorProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryColorProducto() {
		return this.sFinalQueryColorProducto;
	}
	
	public void setsFinalQueryColorProducto(String sFinalQueryColorProducto) {
		this.sFinalQueryColorProducto= sFinalQueryColorProducto;
	}
	
	public Border resaltarSeleccionarColorProducto=null;
	
	public Border setResaltarSeleccionarColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarColorProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarColorProducto() {
		return this.resaltarSeleccionarColorProducto;
	}
	
	public void setResaltarSeleccionarColorProducto(Border borderResaltarSeleccionarColorProducto) {
		this.resaltarSeleccionarColorProducto= borderResaltarSeleccionarColorProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridColorProducto=null;
	public Boolean mostraridColorProducto=true;
	public Boolean activaridColorProducto=true;

	public Border resaltarid_empresaColorProducto=null;
	public Boolean mostrarid_empresaColorProducto=true;
	public Boolean activarid_empresaColorProducto=true;
	public Boolean cargarid_empresaColorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaColorProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoColorProducto=null;
	public Boolean mostrarid_tipo_productoColorProducto=true;
	public Boolean activarid_tipo_productoColorProducto=true;
	public Boolean cargarid_tipo_productoColorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoColorProducto=false;//ConEventDepend=true

	public Border resaltarid_grupo_colorColorProducto=null;
	public Boolean mostrarid_grupo_colorColorProducto=true;
	public Boolean activarid_grupo_colorColorProducto=true;
	public Boolean cargarid_grupo_colorColorProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_colorColorProducto=false;//ConEventDepend=true

	public Border resaltarcodigoColorProducto=null;
	public Boolean mostrarcodigoColorProducto=true;
	public Boolean activarcodigoColorProducto=true;

	public Border resaltarnombreColorProducto=null;
	public Boolean mostrarnombreColorProducto=true;
	public Boolean activarnombreColorProducto=true;

	
	

	public Border setResaltaridColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltaridColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridColorProducto() {
		return this.resaltaridColorProducto;
	}

	public void setResaltaridColorProducto(Border borderResaltar) {
		this.resaltaridColorProducto= borderResaltar;
	}

	public Boolean getMostraridColorProducto() {
		return this.mostraridColorProducto;
	}

	public void setMostraridColorProducto(Boolean mostraridColorProducto) {
		this.mostraridColorProducto= mostraridColorProducto;
	}

	public Boolean getActivaridColorProducto() {
		return this.activaridColorProducto;
	}

	public void setActivaridColorProducto(Boolean activaridColorProducto) {
		this.activaridColorProducto= activaridColorProducto;
	}

	public Border setResaltarid_empresaColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaColorProducto() {
		return this.resaltarid_empresaColorProducto;
	}

	public void setResaltarid_empresaColorProducto(Border borderResaltar) {
		this.resaltarid_empresaColorProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaColorProducto() {
		return this.mostrarid_empresaColorProducto;
	}

	public void setMostrarid_empresaColorProducto(Boolean mostrarid_empresaColorProducto) {
		this.mostrarid_empresaColorProducto= mostrarid_empresaColorProducto;
	}

	public Boolean getActivarid_empresaColorProducto() {
		return this.activarid_empresaColorProducto;
	}

	public void setActivarid_empresaColorProducto(Boolean activarid_empresaColorProducto) {
		this.activarid_empresaColorProducto= activarid_empresaColorProducto;
	}

	public Boolean getCargarid_empresaColorProducto() {
		return this.cargarid_empresaColorProducto;
	}

	public void setCargarid_empresaColorProducto(Boolean cargarid_empresaColorProducto) {
		this.cargarid_empresaColorProducto= cargarid_empresaColorProducto;
	}

	public Border setResaltarid_tipo_productoColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoColorProducto() {
		return this.resaltarid_tipo_productoColorProducto;
	}

	public void setResaltarid_tipo_productoColorProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoColorProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoColorProducto() {
		return this.mostrarid_tipo_productoColorProducto;
	}

	public void setMostrarid_tipo_productoColorProducto(Boolean mostrarid_tipo_productoColorProducto) {
		this.mostrarid_tipo_productoColorProducto= mostrarid_tipo_productoColorProducto;
	}

	public Boolean getActivarid_tipo_productoColorProducto() {
		return this.activarid_tipo_productoColorProducto;
	}

	public void setActivarid_tipo_productoColorProducto(Boolean activarid_tipo_productoColorProducto) {
		this.activarid_tipo_productoColorProducto= activarid_tipo_productoColorProducto;
	}

	public Boolean getCargarid_tipo_productoColorProducto() {
		return this.cargarid_tipo_productoColorProducto;
	}

	public void setCargarid_tipo_productoColorProducto(Boolean cargarid_tipo_productoColorProducto) {
		this.cargarid_tipo_productoColorProducto= cargarid_tipo_productoColorProducto;
	}

	public Border setResaltarid_grupo_colorColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarid_grupo_colorColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_colorColorProducto() {
		return this.resaltarid_grupo_colorColorProducto;
	}

	public void setResaltarid_grupo_colorColorProducto(Border borderResaltar) {
		this.resaltarid_grupo_colorColorProducto= borderResaltar;
	}

	public Boolean getMostrarid_grupo_colorColorProducto() {
		return this.mostrarid_grupo_colorColorProducto;
	}

	public void setMostrarid_grupo_colorColorProducto(Boolean mostrarid_grupo_colorColorProducto) {
		this.mostrarid_grupo_colorColorProducto= mostrarid_grupo_colorColorProducto;
	}

	public Boolean getActivarid_grupo_colorColorProducto() {
		return this.activarid_grupo_colorColorProducto;
	}

	public void setActivarid_grupo_colorColorProducto(Boolean activarid_grupo_colorColorProducto) {
		this.activarid_grupo_colorColorProducto= activarid_grupo_colorColorProducto;
	}

	public Boolean getCargarid_grupo_colorColorProducto() {
		return this.cargarid_grupo_colorColorProducto;
	}

	public void setCargarid_grupo_colorColorProducto(Boolean cargarid_grupo_colorColorProducto) {
		this.cargarid_grupo_colorColorProducto= cargarid_grupo_colorColorProducto;
	}

	public Border setResaltarcodigoColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoColorProducto() {
		return this.resaltarcodigoColorProducto;
	}

	public void setResaltarcodigoColorProducto(Border borderResaltar) {
		this.resaltarcodigoColorProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoColorProducto() {
		return this.mostrarcodigoColorProducto;
	}

	public void setMostrarcodigoColorProducto(Boolean mostrarcodigoColorProducto) {
		this.mostrarcodigoColorProducto= mostrarcodigoColorProducto;
	}

	public Boolean getActivarcodigoColorProducto() {
		return this.activarcodigoColorProducto;
	}

	public void setActivarcodigoColorProducto(Boolean activarcodigoColorProducto) {
		this.activarcodigoColorProducto= activarcodigoColorProducto;
	}

	public Border setResaltarnombreColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltar);
		
		this.resaltarnombreColorProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreColorProducto() {
		return this.resaltarnombreColorProducto;
	}

	public void setResaltarnombreColorProducto(Border borderResaltar) {
		this.resaltarnombreColorProducto= borderResaltar;
	}

	public Boolean getMostrarnombreColorProducto() {
		return this.mostrarnombreColorProducto;
	}

	public void setMostrarnombreColorProducto(Boolean mostrarnombreColorProducto) {
		this.mostrarnombreColorProducto= mostrarnombreColorProducto;
	}

	public Boolean getActivarnombreColorProducto() {
		return this.activarnombreColorProducto;
	}

	public void setActivarnombreColorProducto(Boolean activarnombreColorProducto) {
		this.activarnombreColorProducto= activarnombreColorProducto;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridColorProducto(esInicial);
		this.setMostrarid_empresaColorProducto(esInicial);
		this.setMostrarid_tipo_productoColorProducto(esInicial);
		this.setMostrarid_grupo_colorColorProducto(esInicial);
		this.setMostrarcodigoColorProducto(esInicial);
		this.setMostrarnombreColorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorProductoConstantesFunciones.ID)) {
				this.setMostraridColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDGRUPOCOLOR)) {
				this.setMostrarid_grupo_colorColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreColorProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridColorProducto(esInicial);
		this.setActivarid_empresaColorProducto(esInicial);
		this.setActivarid_tipo_productoColorProducto(esInicial);
		this.setActivarid_grupo_colorColorProducto(esInicial);
		this.setActivarcodigoColorProducto(esInicial);
		this.setActivarnombreColorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorProductoConstantesFunciones.ID)) {
				this.setActivaridColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDGRUPOCOLOR)) {
				this.setActivarid_grupo_colorColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreColorProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridColorProducto(esInicial);
		this.setResaltarid_empresaColorProducto(esInicial);
		this.setResaltarid_tipo_productoColorProducto(esInicial);
		this.setResaltarid_grupo_colorColorProducto(esInicial);
		this.setResaltarcodigoColorProducto(esInicial);
		this.setResaltarnombreColorProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ColorProductoConstantesFunciones.ID)) {
				this.setResaltaridColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.IDGRUPOCOLOR)) {
				this.setResaltarid_grupo_colorColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoColorProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ColorProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreColorProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroInventarioDefectoColorProducto=null;

	public Border getResaltarParametroInventarioDefectoColorProducto() {
		return this.resaltarParametroInventarioDefectoColorProducto;
	}

	public void setResaltarParametroInventarioDefectoColorProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoColorProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//colorproductoBeanSwingJInternalFrame.jTtoolBarColorProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoColorProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoColorProducto=true;

	public Boolean getMostrarParametroInventarioDefectoColorProducto() {
		return this.mostrarParametroInventarioDefectoColorProducto;
	}

	public void setMostrarParametroInventarioDefectoColorProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoColorProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoColorProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoColorProducto() {
		return this.activarParametroInventarioDefectoColorProducto;
	}

	public void setActivarParametroInventarioDefectoColorProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoColorProducto= habilitarResaltarParametroInventarioDefecto;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarParametroInventarioDefectoColorProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoColorProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarParametroInventarioDefectoColorProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoColorProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroInventarioDefectoColorProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoColorProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoColorProducto=true;

	public Boolean getMostrarBusquedaPorCodigoColorProducto() {
		return this.mostrarBusquedaPorCodigoColorProducto;
	}

	public void setMostrarBusquedaPorCodigoColorProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoColorProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreColorProducto=true;

	public Boolean getMostrarBusquedaPorNombreColorProducto() {
		return this.mostrarBusquedaPorNombreColorProducto;
	}

	public void setMostrarBusquedaPorNombreColorProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreColorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaColorProducto=true;

	public Boolean getMostrarFK_IdEmpresaColorProducto() {
		return this.mostrarFK_IdEmpresaColorProducto;
	}

	public void setMostrarFK_IdEmpresaColorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaColorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoColorColorProducto=true;

	public Boolean getMostrarFK_IdGrupoColorColorProducto() {
		return this.mostrarFK_IdGrupoColorColorProducto;
	}

	public void setMostrarFK_IdGrupoColorColorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoColorColorProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoColorProducto=true;

	public Boolean getMostrarFK_IdTipoProductoColorProducto() {
		return this.mostrarFK_IdTipoProductoColorProducto;
	}

	public void setMostrarFK_IdTipoProductoColorProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoColorProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoColorProducto=true;

	public Boolean getActivarBusquedaPorCodigoColorProducto() {
		return this.activarBusquedaPorCodigoColorProducto;
	}

	public void setActivarBusquedaPorCodigoColorProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoColorProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreColorProducto=true;

	public Boolean getActivarBusquedaPorNombreColorProducto() {
		return this.activarBusquedaPorNombreColorProducto;
	}

	public void setActivarBusquedaPorNombreColorProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreColorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaColorProducto=true;

	public Boolean getActivarFK_IdEmpresaColorProducto() {
		return this.activarFK_IdEmpresaColorProducto;
	}

	public void setActivarFK_IdEmpresaColorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaColorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoColorColorProducto=true;

	public Boolean getActivarFK_IdGrupoColorColorProducto() {
		return this.activarFK_IdGrupoColorColorProducto;
	}

	public void setActivarFK_IdGrupoColorColorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoColorColorProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoColorProducto=true;

	public Boolean getActivarFK_IdTipoProductoColorProducto() {
		return this.activarFK_IdTipoProductoColorProducto;
	}

	public void setActivarFK_IdTipoProductoColorProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoColorProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoColorProducto=null;

	public Border getResaltarBusquedaPorCodigoColorProducto() {
		return this.resaltarBusquedaPorCodigoColorProducto;
	}

	public void setResaltarBusquedaPorCodigoColorProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoColorProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoColorProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreColorProducto=null;

	public Border getResaltarBusquedaPorNombreColorProducto() {
		return this.resaltarBusquedaPorNombreColorProducto;
	}

	public void setResaltarBusquedaPorNombreColorProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreColorProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreColorProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaColorProducto=null;

	public Border getResaltarFK_IdEmpresaColorProducto() {
		return this.resaltarFK_IdEmpresaColorProducto;
	}

	public void setResaltarFK_IdEmpresaColorProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaColorProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaColorProducto= borderResaltar;
	}

	public Border resaltarFK_IdGrupoColorColorProducto=null;

	public Border getResaltarFK_IdGrupoColorColorProducto() {
		return this.resaltarFK_IdGrupoColorColorProducto;
	}

	public void setResaltarFK_IdGrupoColorColorProducto(Border borderResaltar) {
		this.resaltarFK_IdGrupoColorColorProducto= borderResaltar;
	}

	public void setResaltarFK_IdGrupoColorColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoColorColorProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoColorProducto=null;

	public Border getResaltarFK_IdTipoProductoColorProducto() {
		return this.resaltarFK_IdTipoProductoColorProducto;
	}

	public void setResaltarFK_IdTipoProductoColorProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoColorProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoColorProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ColorProductoBeanSwingJInternalFrame colorproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoColorProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}