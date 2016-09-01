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


import com.bydan.erp.inventario.util.ClaseProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ClaseProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ClaseProductoParameterGeneral;

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
final public class ClaseProductoConstantesFunciones extends ClaseProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ClaseProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClaseProducto"+ClaseProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClaseProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClaseProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClaseProductoConstantesFunciones.SCHEMA+"_"+ClaseProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClaseProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClaseProductoConstantesFunciones.SCHEMA+"_"+ClaseProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClaseProductoConstantesFunciones.SCHEMA+"_"+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClaseProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClaseProductoConstantesFunciones.SCHEMA+"_"+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClaseProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClaseProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClaseProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClaseProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClaseProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClaseProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Clase Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Clase Producto";
	public static final String SCLASSWEBTITULO_LOWER="Clase Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClaseProducto";
	public static final String OBJECTNAME="claseproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="clase_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select claseproducto from "+ClaseProductoConstantesFunciones.SPERSISTENCENAME+" claseproducto";
	public static String QUERYSELECTNATIVE="select "+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".id,"+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".version_row,"+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".id_empresa,"+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".codigo,"+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME+".nombre from "+ClaseProductoConstantesFunciones.SCHEMA+"."+ClaseProductoConstantesFunciones.TABLENAME;//+" as "+ClaseProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClaseProductoConstantesFuncionesAdditional claseproductoConstantesFuncionesAdditional=null;
	
	public ClaseProductoConstantesFuncionesAdditional getClaseProductoConstantesFuncionesAdditional() {
		return this.claseproductoConstantesFuncionesAdditional;
	}
	
	public void setClaseProductoConstantesFuncionesAdditional(ClaseProductoConstantesFuncionesAdditional claseproductoConstantesFuncionesAdditional) {
		try {
			this.claseproductoConstantesFuncionesAdditional=claseproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getClaseProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClaseProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ClaseProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ClaseProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=ClaseProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(ClaseProductoConstantesFunciones.CODIGO)) {sLabelColumna=ClaseProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ClaseProductoConstantesFunciones.NOMBRE)) {sLabelColumna=ClaseProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getClaseProductoDescripcion(ClaseProducto claseproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(claseproducto !=null/* && claseproducto.getId()!=0*/) {
			sDescripcion=claseproducto.getcodigo();//claseproductoclaseproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getClaseProductoDescripcionDetallado(ClaseProducto claseproducto) {
		String sDescripcion="";
			
		sDescripcion+=ClaseProductoConstantesFunciones.ID+"=";
		sDescripcion+=claseproducto.getId().toString()+",";
		sDescripcion+=ClaseProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=claseproducto.getVersionRow().toString()+",";
		sDescripcion+=ClaseProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=claseproducto.getid_empresa().toString()+",";
		sDescripcion+=ClaseProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=claseproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=ClaseProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=claseproducto.getcodigo()+",";
		sDescripcion+=ClaseProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=claseproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setClaseProductoDescripcion(ClaseProducto claseproducto,String sValor) throws Exception {			
		if(claseproducto !=null) {
			claseproducto.setcodigo(sValor);;//claseproductoclaseproducto.getcodigo().trim();
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

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClaseProducto(ClaseProducto claseproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		claseproducto.setcodigo(claseproducto.getcodigo().trim());
		claseproducto.setnombre(claseproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosClaseProductos(List<ClaseProducto> claseproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClaseProducto claseproducto: claseproductos) {
			claseproducto.setcodigo(claseproducto.getcodigo().trim());
			claseproducto.setnombre(claseproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClaseProducto(ClaseProducto claseproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && claseproducto.getConCambioAuxiliar()) {
			claseproducto.setIsDeleted(claseproducto.getIsDeletedAuxiliar());	
			claseproducto.setIsNew(claseproducto.getIsNewAuxiliar());	
			claseproducto.setIsChanged(claseproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			claseproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			claseproducto.setIsDeletedAuxiliar(false);	
			claseproducto.setIsNewAuxiliar(false);	
			claseproducto.setIsChangedAuxiliar(false);
			
			claseproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClaseProductos(List<ClaseProducto> claseproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClaseProducto claseproducto : claseproductos) {
			if(conAsignarBase && claseproducto.getConCambioAuxiliar()) {
				claseproducto.setIsDeleted(claseproducto.getIsDeletedAuxiliar());	
				claseproducto.setIsNew(claseproducto.getIsNewAuxiliar());	
				claseproducto.setIsChanged(claseproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				claseproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				claseproducto.setIsDeletedAuxiliar(false);	
				claseproducto.setIsNewAuxiliar(false);	
				claseproducto.setIsChangedAuxiliar(false);
				
				claseproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClaseProducto(ClaseProducto claseproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClaseProductos(List<ClaseProducto> claseproductos,Boolean conEnteros) throws Exception  {
		
		for(ClaseProducto claseproducto: claseproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClaseProducto(List<ClaseProducto> claseproductos,ClaseProducto claseproductoAux) throws Exception  {
		ClaseProductoConstantesFunciones.InicializarValoresClaseProducto(claseproductoAux,true);
		
		for(ClaseProducto claseproducto: claseproductos) {
			if(claseproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClaseProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClaseProductoConstantesFunciones.getArrayColumnasGlobalesClaseProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClaseProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClaseProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClaseProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClaseProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClaseProducto> claseproductos,ClaseProducto claseproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClaseProducto claseproductoAux: claseproductos) {
			if(claseproductoAux!=null && claseproducto!=null) {
				if((claseproductoAux.getId()==null && claseproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(claseproductoAux.getId()!=null && claseproducto.getId()!=null){
					if(claseproductoAux.getId().equals(claseproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClaseProducto(List<ClaseProducto> claseproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ClaseProducto claseproducto: claseproductos) {			
			if(claseproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClaseProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_ID, ClaseProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_VERSIONROW, ClaseProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_IDEMPRESA, ClaseProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, ClaseProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_CODIGO, ClaseProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseProductoConstantesFunciones.LABEL_NOMBRE, ClaseProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClaseProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseProducto() throws Exception  {
		return ClaseProductoConstantesFunciones.getTiposSeleccionarClaseProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseProducto(Boolean conFk) throws Exception  {
		return ClaseProductoConstantesFunciones.getTiposSeleccionarClaseProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ClaseProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(ClaseProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ClaseProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ClaseProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClaseProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClaseProducto(ClaseProducto claseproductoAux) throws Exception {
		
			claseproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(claseproductoAux.getEmpresa()));
			claseproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(claseproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClaseProducto(List<ClaseProducto> claseproductosTemp) throws Exception {
		for(ClaseProducto claseproductoAux:claseproductosTemp) {
			
			claseproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(claseproductoAux.getEmpresa()));
			claseproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(claseproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClaseProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoProducto.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClaseProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClaseProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClaseProductoConstantesFunciones.getClassesRelationshipsOfClaseProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClaseProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClaseProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClaseProductoConstantesFunciones.getClassesRelationshipsFromStringsOfClaseProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClaseProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClaseProducto claseproducto,List<ClaseProducto> claseproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClaseProducto claseproductoEncontrado=null;
			
			for(ClaseProducto claseproductoLocal:claseproductos) {
				if(claseproductoLocal.getId().equals(claseproducto.getId())) {
					claseproductoEncontrado=claseproductoLocal;
					
					claseproductoLocal.setIsChanged(claseproducto.getIsChanged());
					claseproductoLocal.setIsNew(claseproducto.getIsNew());
					claseproductoLocal.setIsDeleted(claseproducto.getIsDeleted());
					
					claseproductoLocal.setGeneralEntityOriginal(claseproducto.getGeneralEntityOriginal());
					
					claseproductoLocal.setId(claseproducto.getId());	
					claseproductoLocal.setVersionRow(claseproducto.getVersionRow());	
					claseproductoLocal.setid_empresa(claseproducto.getid_empresa());	
					claseproductoLocal.setid_tipo_producto(claseproducto.getid_tipo_producto());	
					claseproductoLocal.setcodigo(claseproducto.getcodigo());	
					claseproductoLocal.setnombre(claseproducto.getnombre());	
					
					
					claseproductoLocal.setProductos(claseproducto.getProductos());
					claseproductoLocal.setParametroInventarioDefectos(claseproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!claseproducto.getIsDeleted()) {
				if(!existe) {
					claseproductos.add(claseproducto);
				}
			} else {
				if(claseproductoEncontrado!=null && permiteQuitar)  {
					claseproductos.remove(claseproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClaseProducto claseproducto,List<ClaseProducto> claseproductos) throws Exception {
		try	{			
			for(ClaseProducto claseproductoLocal:claseproductos) {
				if(claseproductoLocal.getId().equals(claseproducto.getId())) {
					claseproductoLocal.setIsSelected(claseproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClaseProducto(List<ClaseProducto> claseproductosAux) throws Exception {
		//this.claseproductosAux=claseproductosAux;
		
		for(ClaseProducto claseproductoAux:claseproductosAux) {
			if(claseproductoAux.getIsChanged()) {
				claseproductoAux.setIsChanged(false);
			}		
			
			if(claseproductoAux.getIsNew()) {
				claseproductoAux.setIsNew(false);
			}	
			
			if(claseproductoAux.getIsDeleted()) {
				claseproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClaseProducto(ClaseProducto claseproductoAux) throws Exception {
		//this.claseproductoAux=claseproductoAux;
		
			if(claseproductoAux.getIsChanged()) {
				claseproductoAux.setIsChanged(false);
			}		
			
			if(claseproductoAux.getIsNew()) {
				claseproductoAux.setIsNew(false);
			}	
			
			if(claseproductoAux.getIsDeleted()) {
				claseproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClaseProducto claseproductoAsignar,ClaseProducto claseproducto) throws Exception {
		claseproductoAsignar.setId(claseproducto.getId());	
		claseproductoAsignar.setVersionRow(claseproducto.getVersionRow());	
		claseproductoAsignar.setid_empresa(claseproducto.getid_empresa());
		claseproductoAsignar.setempresa_descripcion(claseproducto.getempresa_descripcion());	
		claseproductoAsignar.setid_tipo_producto(claseproducto.getid_tipo_producto());
		claseproductoAsignar.settipoproducto_descripcion(claseproducto.gettipoproducto_descripcion());	
		claseproductoAsignar.setcodigo(claseproducto.getcodigo());	
		claseproductoAsignar.setnombre(claseproducto.getnombre());	
	}
	
	public static void inicializarClaseProducto(ClaseProducto claseproducto) throws Exception {
		try {
				claseproducto.setId(0L);	
					
				claseproducto.setid_empresa(-1L);	
				claseproducto.setid_tipo_producto(-1L);	
				claseproducto.setcodigo("");	
				claseproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClaseProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClaseProducto(String sTipo,Row row,Workbook workbook,ClaseProducto claseproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(claseproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(claseproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(claseproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(claseproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClaseProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClaseProducto() {
		return this.sFinalQueryClaseProducto;
	}
	
	public void setsFinalQueryClaseProducto(String sFinalQueryClaseProducto) {
		this.sFinalQueryClaseProducto= sFinalQueryClaseProducto;
	}
	
	public Border resaltarSeleccionarClaseProducto=null;
	
	public Border setResaltarSeleccionarClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClaseProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClaseProducto() {
		return this.resaltarSeleccionarClaseProducto;
	}
	
	public void setResaltarSeleccionarClaseProducto(Border borderResaltarSeleccionarClaseProducto) {
		this.resaltarSeleccionarClaseProducto= borderResaltarSeleccionarClaseProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClaseProducto=null;
	public Boolean mostraridClaseProducto=true;
	public Boolean activaridClaseProducto=true;

	public Border resaltarid_empresaClaseProducto=null;
	public Boolean mostrarid_empresaClaseProducto=true;
	public Boolean activarid_empresaClaseProducto=true;
	public Boolean cargarid_empresaClaseProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaClaseProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoClaseProducto=null;
	public Boolean mostrarid_tipo_productoClaseProducto=true;
	public Boolean activarid_tipo_productoClaseProducto=true;
	public Boolean cargarid_tipo_productoClaseProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoClaseProducto=false;//ConEventDepend=true

	public Border resaltarcodigoClaseProducto=null;
	public Boolean mostrarcodigoClaseProducto=true;
	public Boolean activarcodigoClaseProducto=true;

	public Border resaltarnombreClaseProducto=null;
	public Boolean mostrarnombreClaseProducto=true;
	public Boolean activarnombreClaseProducto=true;

	
	

	public Border setResaltaridClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltaridClaseProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClaseProducto() {
		return this.resaltaridClaseProducto;
	}

	public void setResaltaridClaseProducto(Border borderResaltar) {
		this.resaltaridClaseProducto= borderResaltar;
	}

	public Boolean getMostraridClaseProducto() {
		return this.mostraridClaseProducto;
	}

	public void setMostraridClaseProducto(Boolean mostraridClaseProducto) {
		this.mostraridClaseProducto= mostraridClaseProducto;
	}

	public Boolean getActivaridClaseProducto() {
		return this.activaridClaseProducto;
	}

	public void setActivaridClaseProducto(Boolean activaridClaseProducto) {
		this.activaridClaseProducto= activaridClaseProducto;
	}

	public Border setResaltarid_empresaClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaClaseProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaClaseProducto() {
		return this.resaltarid_empresaClaseProducto;
	}

	public void setResaltarid_empresaClaseProducto(Border borderResaltar) {
		this.resaltarid_empresaClaseProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaClaseProducto() {
		return this.mostrarid_empresaClaseProducto;
	}

	public void setMostrarid_empresaClaseProducto(Boolean mostrarid_empresaClaseProducto) {
		this.mostrarid_empresaClaseProducto= mostrarid_empresaClaseProducto;
	}

	public Boolean getActivarid_empresaClaseProducto() {
		return this.activarid_empresaClaseProducto;
	}

	public void setActivarid_empresaClaseProducto(Boolean activarid_empresaClaseProducto) {
		this.activarid_empresaClaseProducto= activarid_empresaClaseProducto;
	}

	public Boolean getCargarid_empresaClaseProducto() {
		return this.cargarid_empresaClaseProducto;
	}

	public void setCargarid_empresaClaseProducto(Boolean cargarid_empresaClaseProducto) {
		this.cargarid_empresaClaseProducto= cargarid_empresaClaseProducto;
	}

	public Border setResaltarid_tipo_productoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoClaseProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoClaseProducto() {
		return this.resaltarid_tipo_productoClaseProducto;
	}

	public void setResaltarid_tipo_productoClaseProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoClaseProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoClaseProducto() {
		return this.mostrarid_tipo_productoClaseProducto;
	}

	public void setMostrarid_tipo_productoClaseProducto(Boolean mostrarid_tipo_productoClaseProducto) {
		this.mostrarid_tipo_productoClaseProducto= mostrarid_tipo_productoClaseProducto;
	}

	public Boolean getActivarid_tipo_productoClaseProducto() {
		return this.activarid_tipo_productoClaseProducto;
	}

	public void setActivarid_tipo_productoClaseProducto(Boolean activarid_tipo_productoClaseProducto) {
		this.activarid_tipo_productoClaseProducto= activarid_tipo_productoClaseProducto;
	}

	public Boolean getCargarid_tipo_productoClaseProducto() {
		return this.cargarid_tipo_productoClaseProducto;
	}

	public void setCargarid_tipo_productoClaseProducto(Boolean cargarid_tipo_productoClaseProducto) {
		this.cargarid_tipo_productoClaseProducto= cargarid_tipo_productoClaseProducto;
	}

	public Border setResaltarcodigoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoClaseProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoClaseProducto() {
		return this.resaltarcodigoClaseProducto;
	}

	public void setResaltarcodigoClaseProducto(Border borderResaltar) {
		this.resaltarcodigoClaseProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoClaseProducto() {
		return this.mostrarcodigoClaseProducto;
	}

	public void setMostrarcodigoClaseProducto(Boolean mostrarcodigoClaseProducto) {
		this.mostrarcodigoClaseProducto= mostrarcodigoClaseProducto;
	}

	public Boolean getActivarcodigoClaseProducto() {
		return this.activarcodigoClaseProducto;
	}

	public void setActivarcodigoClaseProducto(Boolean activarcodigoClaseProducto) {
		this.activarcodigoClaseProducto= activarcodigoClaseProducto;
	}

	public Border setResaltarnombreClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltar);
		
		this.resaltarnombreClaseProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreClaseProducto() {
		return this.resaltarnombreClaseProducto;
	}

	public void setResaltarnombreClaseProducto(Border borderResaltar) {
		this.resaltarnombreClaseProducto= borderResaltar;
	}

	public Boolean getMostrarnombreClaseProducto() {
		return this.mostrarnombreClaseProducto;
	}

	public void setMostrarnombreClaseProducto(Boolean mostrarnombreClaseProducto) {
		this.mostrarnombreClaseProducto= mostrarnombreClaseProducto;
	}

	public Boolean getActivarnombreClaseProducto() {
		return this.activarnombreClaseProducto;
	}

	public void setActivarnombreClaseProducto(Boolean activarnombreClaseProducto) {
		this.activarnombreClaseProducto= activarnombreClaseProducto;
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
		
		
		this.setMostraridClaseProducto(esInicial);
		this.setMostrarid_empresaClaseProducto(esInicial);
		this.setMostrarid_tipo_productoClaseProducto(esInicial);
		this.setMostrarcodigoClaseProducto(esInicial);
		this.setMostrarnombreClaseProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseProductoConstantesFunciones.ID)) {
				this.setMostraridClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreClaseProducto(esAsigna);
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
		
		
		this.setActivaridClaseProducto(esInicial);
		this.setActivarid_empresaClaseProducto(esInicial);
		this.setActivarid_tipo_productoClaseProducto(esInicial);
		this.setActivarcodigoClaseProducto(esInicial);
		this.setActivarnombreClaseProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseProductoConstantesFunciones.ID)) {
				this.setActivaridClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreClaseProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClaseProducto(esInicial);
		this.setResaltarid_empresaClaseProducto(esInicial);
		this.setResaltarid_tipo_productoClaseProducto(esInicial);
		this.setResaltarcodigoClaseProducto(esInicial);
		this.setResaltarnombreClaseProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseProductoConstantesFunciones.ID)) {
				this.setResaltaridClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoClaseProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreClaseProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoClaseProducto=null;

	public Border getResaltarProductoClaseProducto() {
		return this.resaltarProductoClaseProducto;
	}

	public void setResaltarProductoClaseProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoClaseProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoClaseProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoClaseProducto=true;

	public Boolean getMostrarProductoClaseProducto() {
		return this.mostrarProductoClaseProducto;
	}

	public void setMostrarProductoClaseProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoClaseProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoClaseProducto=true;

	public Boolean gethabilitarResaltarProductoClaseProducto() {
		return this.activarProductoClaseProducto;
	}

	public void setActivarProductoClaseProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoClaseProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoClaseProducto=null;

	public Border getResaltarParametroInventarioDefectoClaseProducto() {
		return this.resaltarParametroInventarioDefectoClaseProducto;
	}

	public void setResaltarParametroInventarioDefectoClaseProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoClaseProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//claseproductoBeanSwingJInternalFrame.jTtoolBarClaseProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoClaseProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoClaseProducto=true;

	public Boolean getMostrarParametroInventarioDefectoClaseProducto() {
		return this.mostrarParametroInventarioDefectoClaseProducto;
	}

	public void setMostrarParametroInventarioDefectoClaseProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoClaseProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoClaseProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoClaseProducto() {
		return this.activarParametroInventarioDefectoClaseProducto;
	}

	public void setActivarParametroInventarioDefectoClaseProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoClaseProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoClaseProducto(esInicial);
		this.setMostrarParametroInventarioDefectoClaseProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoClaseProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoClaseProducto(esAsigna);
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

		this.setActivarProductoClaseProducto(esInicial);
		this.setActivarParametroInventarioDefectoClaseProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoClaseProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoClaseProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoClaseProducto(esInicial);
		this.setResaltarParametroInventarioDefectoClaseProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoClaseProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoClaseProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoClaseProducto=true;

	public Boolean getMostrarBusquedaPorCodigoClaseProducto() {
		return this.mostrarBusquedaPorCodigoClaseProducto;
	}

	public void setMostrarBusquedaPorCodigoClaseProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoClaseProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreClaseProducto=true;

	public Boolean getMostrarBusquedaPorNombreClaseProducto() {
		return this.mostrarBusquedaPorNombreClaseProducto;
	}

	public void setMostrarBusquedaPorNombreClaseProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreClaseProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaClaseProducto=true;

	public Boolean getMostrarFK_IdEmpresaClaseProducto() {
		return this.mostrarFK_IdEmpresaClaseProducto;
	}

	public void setMostrarFK_IdEmpresaClaseProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaClaseProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoClaseProducto=true;

	public Boolean getMostrarFK_IdTipoProductoClaseProducto() {
		return this.mostrarFK_IdTipoProductoClaseProducto;
	}

	public void setMostrarFK_IdTipoProductoClaseProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoClaseProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoClaseProducto=true;

	public Boolean getActivarBusquedaPorCodigoClaseProducto() {
		return this.activarBusquedaPorCodigoClaseProducto;
	}

	public void setActivarBusquedaPorCodigoClaseProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoClaseProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreClaseProducto=true;

	public Boolean getActivarBusquedaPorNombreClaseProducto() {
		return this.activarBusquedaPorNombreClaseProducto;
	}

	public void setActivarBusquedaPorNombreClaseProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreClaseProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaClaseProducto=true;

	public Boolean getActivarFK_IdEmpresaClaseProducto() {
		return this.activarFK_IdEmpresaClaseProducto;
	}

	public void setActivarFK_IdEmpresaClaseProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaClaseProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoClaseProducto=true;

	public Boolean getActivarFK_IdTipoProductoClaseProducto() {
		return this.activarFK_IdTipoProductoClaseProducto;
	}

	public void setActivarFK_IdTipoProductoClaseProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoClaseProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoClaseProducto=null;

	public Border getResaltarBusquedaPorCodigoClaseProducto() {
		return this.resaltarBusquedaPorCodigoClaseProducto;
	}

	public void setResaltarBusquedaPorCodigoClaseProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoClaseProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoClaseProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreClaseProducto=null;

	public Border getResaltarBusquedaPorNombreClaseProducto() {
		return this.resaltarBusquedaPorNombreClaseProducto;
	}

	public void setResaltarBusquedaPorNombreClaseProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreClaseProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreClaseProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaClaseProducto=null;

	public Border getResaltarFK_IdEmpresaClaseProducto() {
		return this.resaltarFK_IdEmpresaClaseProducto;
	}

	public void setResaltarFK_IdEmpresaClaseProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaClaseProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaClaseProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoClaseProducto=null;

	public Border getResaltarFK_IdTipoProductoClaseProducto() {
		return this.resaltarFK_IdTipoProductoClaseProducto;
	}

	public void setResaltarFK_IdTipoProductoClaseProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoClaseProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoClaseProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseProductoBeanSwingJInternalFrame claseproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoClaseProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}