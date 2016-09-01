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


import com.bydan.erp.inventario.util.SegmentoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SegmentoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SegmentoProductoParameterGeneral;

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
final public class SegmentoProductoConstantesFunciones extends SegmentoProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SegmentoProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SegmentoProducto"+SegmentoProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SegmentoProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SegmentoProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SegmentoProductoConstantesFunciones.SCHEMA+"_"+SegmentoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SegmentoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SegmentoProductoConstantesFunciones.SCHEMA+"_"+SegmentoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SegmentoProductoConstantesFunciones.SCHEMA+"_"+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SegmentoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SegmentoProductoConstantesFunciones.SCHEMA+"_"+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SegmentoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SegmentoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SegmentoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SegmentoProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SegmentoProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SegmentoProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SegmentoProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Segmento Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Segmento Producto";
	public static final String SCLASSWEBTITULO_LOWER="Segmento Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SegmentoProducto";
	public static final String OBJECTNAME="segmentoproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="segmento_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select segmentoproducto from "+SegmentoProductoConstantesFunciones.SPERSISTENCENAME+" segmentoproducto";
	public static String QUERYSELECTNATIVE="select "+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".id,"+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".version_row,"+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".id_empresa,"+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".codigo,"+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME+".nombre from "+SegmentoProductoConstantesFunciones.SCHEMA+"."+SegmentoProductoConstantesFunciones.TABLENAME;//+" as "+SegmentoProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SegmentoProductoConstantesFuncionesAdditional segmentoproductoConstantesFuncionesAdditional=null;
	
	public SegmentoProductoConstantesFuncionesAdditional getSegmentoProductoConstantesFuncionesAdditional() {
		return this.segmentoproductoConstantesFuncionesAdditional;
	}
	
	public void setSegmentoProductoConstantesFuncionesAdditional(SegmentoProductoConstantesFuncionesAdditional segmentoproductoConstantesFuncionesAdditional) {
		try {
			this.segmentoproductoConstantesFuncionesAdditional=segmentoproductoConstantesFuncionesAdditional;
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
	
	public static String getSegmentoProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SegmentoProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=SegmentoProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=SegmentoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(SegmentoProductoConstantesFunciones.CODIGO)) {sLabelColumna=SegmentoProductoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SegmentoProductoConstantesFunciones.NOMBRE)) {sLabelColumna=SegmentoProductoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getSegmentoProductoDescripcion(SegmentoProducto segmentoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(segmentoproducto !=null/* && segmentoproducto.getId()!=0*/) {
			sDescripcion=segmentoproducto.getcodigo();//segmentoproductosegmentoproducto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSegmentoProductoDescripcionDetallado(SegmentoProducto segmentoproducto) {
		String sDescripcion="";
			
		sDescripcion+=SegmentoProductoConstantesFunciones.ID+"=";
		sDescripcion+=segmentoproducto.getId().toString()+",";
		sDescripcion+=SegmentoProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=segmentoproducto.getVersionRow().toString()+",";
		sDescripcion+=SegmentoProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=segmentoproducto.getid_empresa().toString()+",";
		sDescripcion+=SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=segmentoproducto.getid_tipo_producto().toString()+",";
		sDescripcion+=SegmentoProductoConstantesFunciones.CODIGO+"=";
		sDescripcion+=segmentoproducto.getcodigo()+",";
		sDescripcion+=SegmentoProductoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=segmentoproducto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setSegmentoProductoDescripcion(SegmentoProducto segmentoproducto,String sValor) throws Exception {			
		if(segmentoproducto !=null) {
			segmentoproducto.setcodigo(sValor);;//segmentoproductosegmentoproducto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosSegmentoProducto(SegmentoProducto segmentoproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		segmentoproducto.setcodigo(segmentoproducto.getcodigo().trim());
		segmentoproducto.setnombre(segmentoproducto.getnombre().trim());
	}
	
	public static void quitarEspaciosSegmentoProductos(List<SegmentoProducto> segmentoproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SegmentoProducto segmentoproducto: segmentoproductos) {
			segmentoproducto.setcodigo(segmentoproducto.getcodigo().trim());
			segmentoproducto.setnombre(segmentoproducto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSegmentoProducto(SegmentoProducto segmentoproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && segmentoproducto.getConCambioAuxiliar()) {
			segmentoproducto.setIsDeleted(segmentoproducto.getIsDeletedAuxiliar());	
			segmentoproducto.setIsNew(segmentoproducto.getIsNewAuxiliar());	
			segmentoproducto.setIsChanged(segmentoproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			segmentoproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			segmentoproducto.setIsDeletedAuxiliar(false);	
			segmentoproducto.setIsNewAuxiliar(false);	
			segmentoproducto.setIsChangedAuxiliar(false);
			
			segmentoproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSegmentoProductos(List<SegmentoProducto> segmentoproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SegmentoProducto segmentoproducto : segmentoproductos) {
			if(conAsignarBase && segmentoproducto.getConCambioAuxiliar()) {
				segmentoproducto.setIsDeleted(segmentoproducto.getIsDeletedAuxiliar());	
				segmentoproducto.setIsNew(segmentoproducto.getIsNewAuxiliar());	
				segmentoproducto.setIsChanged(segmentoproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				segmentoproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				segmentoproducto.setIsDeletedAuxiliar(false);	
				segmentoproducto.setIsNewAuxiliar(false);	
				segmentoproducto.setIsChangedAuxiliar(false);
				
				segmentoproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSegmentoProducto(SegmentoProducto segmentoproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSegmentoProductos(List<SegmentoProducto> segmentoproductos,Boolean conEnteros) throws Exception  {
		
		for(SegmentoProducto segmentoproducto: segmentoproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSegmentoProducto(List<SegmentoProducto> segmentoproductos,SegmentoProducto segmentoproductoAux) throws Exception  {
		SegmentoProductoConstantesFunciones.InicializarValoresSegmentoProducto(segmentoproductoAux,true);
		
		for(SegmentoProducto segmentoproducto: segmentoproductos) {
			if(segmentoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSegmentoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SegmentoProductoConstantesFunciones.getArrayColumnasGlobalesSegmentoProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSegmentoProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SegmentoProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SegmentoProductoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSegmentoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SegmentoProducto> segmentoproductos,SegmentoProducto segmentoproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SegmentoProducto segmentoproductoAux: segmentoproductos) {
			if(segmentoproductoAux!=null && segmentoproducto!=null) {
				if((segmentoproductoAux.getId()==null && segmentoproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(segmentoproductoAux.getId()!=null && segmentoproducto.getId()!=null){
					if(segmentoproductoAux.getId().equals(segmentoproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSegmentoProducto(List<SegmentoProducto> segmentoproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SegmentoProducto segmentoproducto: segmentoproductos) {			
			if(segmentoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSegmentoProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_ID, SegmentoProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_VERSIONROW, SegmentoProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_IDEMPRESA, SegmentoProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO, SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_CODIGO, SegmentoProductoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SegmentoProductoConstantesFunciones.LABEL_NOMBRE, SegmentoProductoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSegmentoProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SegmentoProductoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSegmentoProducto() throws Exception  {
		return SegmentoProductoConstantesFunciones.getTiposSeleccionarSegmentoProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSegmentoProducto(Boolean conFk) throws Exception  {
		return SegmentoProductoConstantesFunciones.getTiposSeleccionarSegmentoProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSegmentoProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SegmentoProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SegmentoProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SegmentoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(SegmentoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SegmentoProductoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SegmentoProductoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SegmentoProductoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SegmentoProductoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSegmentoProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSegmentoProducto(SegmentoProducto segmentoproductoAux) throws Exception {
		
			segmentoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(segmentoproductoAux.getEmpresa()));
			segmentoproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(segmentoproductoAux.getTipoProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSegmentoProducto(List<SegmentoProducto> segmentoproductosTemp) throws Exception {
		for(SegmentoProducto segmentoproductoAux:segmentoproductosTemp) {
			
			segmentoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(segmentoproductoAux.getEmpresa()));
			segmentoproductoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(segmentoproductoAux.getTipoProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSegmentoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSegmentoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSegmentoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SegmentoProductoConstantesFunciones.getClassesRelationshipsOfSegmentoProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSegmentoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSegmentoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SegmentoProductoConstantesFunciones.getClassesRelationshipsFromStringsOfSegmentoProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSegmentoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SegmentoProducto segmentoproducto,List<SegmentoProducto> segmentoproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SegmentoProducto segmentoproductoEncontrado=null;
			
			for(SegmentoProducto segmentoproductoLocal:segmentoproductos) {
				if(segmentoproductoLocal.getId().equals(segmentoproducto.getId())) {
					segmentoproductoEncontrado=segmentoproductoLocal;
					
					segmentoproductoLocal.setIsChanged(segmentoproducto.getIsChanged());
					segmentoproductoLocal.setIsNew(segmentoproducto.getIsNew());
					segmentoproductoLocal.setIsDeleted(segmentoproducto.getIsDeleted());
					
					segmentoproductoLocal.setGeneralEntityOriginal(segmentoproducto.getGeneralEntityOriginal());
					
					segmentoproductoLocal.setId(segmentoproducto.getId());	
					segmentoproductoLocal.setVersionRow(segmentoproducto.getVersionRow());	
					segmentoproductoLocal.setid_empresa(segmentoproducto.getid_empresa());	
					segmentoproductoLocal.setid_tipo_producto(segmentoproducto.getid_tipo_producto());	
					segmentoproductoLocal.setcodigo(segmentoproducto.getcodigo());	
					segmentoproductoLocal.setnombre(segmentoproducto.getnombre());	
					
					
					segmentoproductoLocal.setProductos(segmentoproducto.getProductos());
					segmentoproductoLocal.setParametroInventarioDefectos(segmentoproducto.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!segmentoproducto.getIsDeleted()) {
				if(!existe) {
					segmentoproductos.add(segmentoproducto);
				}
			} else {
				if(segmentoproductoEncontrado!=null && permiteQuitar)  {
					segmentoproductos.remove(segmentoproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SegmentoProducto segmentoproducto,List<SegmentoProducto> segmentoproductos) throws Exception {
		try	{			
			for(SegmentoProducto segmentoproductoLocal:segmentoproductos) {
				if(segmentoproductoLocal.getId().equals(segmentoproducto.getId())) {
					segmentoproductoLocal.setIsSelected(segmentoproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSegmentoProducto(List<SegmentoProducto> segmentoproductosAux) throws Exception {
		//this.segmentoproductosAux=segmentoproductosAux;
		
		for(SegmentoProducto segmentoproductoAux:segmentoproductosAux) {
			if(segmentoproductoAux.getIsChanged()) {
				segmentoproductoAux.setIsChanged(false);
			}		
			
			if(segmentoproductoAux.getIsNew()) {
				segmentoproductoAux.setIsNew(false);
			}	
			
			if(segmentoproductoAux.getIsDeleted()) {
				segmentoproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSegmentoProducto(SegmentoProducto segmentoproductoAux) throws Exception {
		//this.segmentoproductoAux=segmentoproductoAux;
		
			if(segmentoproductoAux.getIsChanged()) {
				segmentoproductoAux.setIsChanged(false);
			}		
			
			if(segmentoproductoAux.getIsNew()) {
				segmentoproductoAux.setIsNew(false);
			}	
			
			if(segmentoproductoAux.getIsDeleted()) {
				segmentoproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SegmentoProducto segmentoproductoAsignar,SegmentoProducto segmentoproducto) throws Exception {
		segmentoproductoAsignar.setId(segmentoproducto.getId());	
		segmentoproductoAsignar.setVersionRow(segmentoproducto.getVersionRow());	
		segmentoproductoAsignar.setid_empresa(segmentoproducto.getid_empresa());
		segmentoproductoAsignar.setempresa_descripcion(segmentoproducto.getempresa_descripcion());	
		segmentoproductoAsignar.setid_tipo_producto(segmentoproducto.getid_tipo_producto());
		segmentoproductoAsignar.settipoproducto_descripcion(segmentoproducto.gettipoproducto_descripcion());	
		segmentoproductoAsignar.setcodigo(segmentoproducto.getcodigo());	
		segmentoproductoAsignar.setnombre(segmentoproducto.getnombre());	
	}
	
	public static void inicializarSegmentoProducto(SegmentoProducto segmentoproducto) throws Exception {
		try {
				segmentoproducto.setId(0L);	
					
				segmentoproducto.setid_empresa(-1L);	
				segmentoproducto.setid_tipo_producto(-1L);	
				segmentoproducto.setcodigo("");	
				segmentoproducto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSegmentoProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SegmentoProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SegmentoProductoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SegmentoProductoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SegmentoProductoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSegmentoProducto(String sTipo,Row row,Workbook workbook,SegmentoProducto segmentoproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(segmentoproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(segmentoproducto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(segmentoproducto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(segmentoproducto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySegmentoProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySegmentoProducto() {
		return this.sFinalQuerySegmentoProducto;
	}
	
	public void setsFinalQuerySegmentoProducto(String sFinalQuerySegmentoProducto) {
		this.sFinalQuerySegmentoProducto= sFinalQuerySegmentoProducto;
	}
	
	public Border resaltarSeleccionarSegmentoProducto=null;
	
	public Border setResaltarSeleccionarSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSegmentoProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSegmentoProducto() {
		return this.resaltarSeleccionarSegmentoProducto;
	}
	
	public void setResaltarSeleccionarSegmentoProducto(Border borderResaltarSeleccionarSegmentoProducto) {
		this.resaltarSeleccionarSegmentoProducto= borderResaltarSeleccionarSegmentoProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSegmentoProducto=null;
	public Boolean mostraridSegmentoProducto=true;
	public Boolean activaridSegmentoProducto=true;

	public Border resaltarid_empresaSegmentoProducto=null;
	public Boolean mostrarid_empresaSegmentoProducto=true;
	public Boolean activarid_empresaSegmentoProducto=true;
	public Boolean cargarid_empresaSegmentoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSegmentoProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoSegmentoProducto=null;
	public Boolean mostrarid_tipo_productoSegmentoProducto=true;
	public Boolean activarid_tipo_productoSegmentoProducto=true;
	public Boolean cargarid_tipo_productoSegmentoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoSegmentoProducto=false;//ConEventDepend=true

	public Border resaltarcodigoSegmentoProducto=null;
	public Boolean mostrarcodigoSegmentoProducto=true;
	public Boolean activarcodigoSegmentoProducto=true;

	public Border resaltarnombreSegmentoProducto=null;
	public Boolean mostrarnombreSegmentoProducto=true;
	public Boolean activarnombreSegmentoProducto=true;

	
	

	public Border setResaltaridSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltaridSegmentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSegmentoProducto() {
		return this.resaltaridSegmentoProducto;
	}

	public void setResaltaridSegmentoProducto(Border borderResaltar) {
		this.resaltaridSegmentoProducto= borderResaltar;
	}

	public Boolean getMostraridSegmentoProducto() {
		return this.mostraridSegmentoProducto;
	}

	public void setMostraridSegmentoProducto(Boolean mostraridSegmentoProducto) {
		this.mostraridSegmentoProducto= mostraridSegmentoProducto;
	}

	public Boolean getActivaridSegmentoProducto() {
		return this.activaridSegmentoProducto;
	}

	public void setActivaridSegmentoProducto(Boolean activaridSegmentoProducto) {
		this.activaridSegmentoProducto= activaridSegmentoProducto;
	}

	public Border setResaltarid_empresaSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaSegmentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSegmentoProducto() {
		return this.resaltarid_empresaSegmentoProducto;
	}

	public void setResaltarid_empresaSegmentoProducto(Border borderResaltar) {
		this.resaltarid_empresaSegmentoProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaSegmentoProducto() {
		return this.mostrarid_empresaSegmentoProducto;
	}

	public void setMostrarid_empresaSegmentoProducto(Boolean mostrarid_empresaSegmentoProducto) {
		this.mostrarid_empresaSegmentoProducto= mostrarid_empresaSegmentoProducto;
	}

	public Boolean getActivarid_empresaSegmentoProducto() {
		return this.activarid_empresaSegmentoProducto;
	}

	public void setActivarid_empresaSegmentoProducto(Boolean activarid_empresaSegmentoProducto) {
		this.activarid_empresaSegmentoProducto= activarid_empresaSegmentoProducto;
	}

	public Boolean getCargarid_empresaSegmentoProducto() {
		return this.cargarid_empresaSegmentoProducto;
	}

	public void setCargarid_empresaSegmentoProducto(Boolean cargarid_empresaSegmentoProducto) {
		this.cargarid_empresaSegmentoProducto= cargarid_empresaSegmentoProducto;
	}

	public Border setResaltarid_tipo_productoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoSegmentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoSegmentoProducto() {
		return this.resaltarid_tipo_productoSegmentoProducto;
	}

	public void setResaltarid_tipo_productoSegmentoProducto(Border borderResaltar) {
		this.resaltarid_tipo_productoSegmentoProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoSegmentoProducto() {
		return this.mostrarid_tipo_productoSegmentoProducto;
	}

	public void setMostrarid_tipo_productoSegmentoProducto(Boolean mostrarid_tipo_productoSegmentoProducto) {
		this.mostrarid_tipo_productoSegmentoProducto= mostrarid_tipo_productoSegmentoProducto;
	}

	public Boolean getActivarid_tipo_productoSegmentoProducto() {
		return this.activarid_tipo_productoSegmentoProducto;
	}

	public void setActivarid_tipo_productoSegmentoProducto(Boolean activarid_tipo_productoSegmentoProducto) {
		this.activarid_tipo_productoSegmentoProducto= activarid_tipo_productoSegmentoProducto;
	}

	public Boolean getCargarid_tipo_productoSegmentoProducto() {
		return this.cargarid_tipo_productoSegmentoProducto;
	}

	public void setCargarid_tipo_productoSegmentoProducto(Boolean cargarid_tipo_productoSegmentoProducto) {
		this.cargarid_tipo_productoSegmentoProducto= cargarid_tipo_productoSegmentoProducto;
	}

	public Border setResaltarcodigoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltarcodigoSegmentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSegmentoProducto() {
		return this.resaltarcodigoSegmentoProducto;
	}

	public void setResaltarcodigoSegmentoProducto(Border borderResaltar) {
		this.resaltarcodigoSegmentoProducto= borderResaltar;
	}

	public Boolean getMostrarcodigoSegmentoProducto() {
		return this.mostrarcodigoSegmentoProducto;
	}

	public void setMostrarcodigoSegmentoProducto(Boolean mostrarcodigoSegmentoProducto) {
		this.mostrarcodigoSegmentoProducto= mostrarcodigoSegmentoProducto;
	}

	public Boolean getActivarcodigoSegmentoProducto() {
		return this.activarcodigoSegmentoProducto;
	}

	public void setActivarcodigoSegmentoProducto(Boolean activarcodigoSegmentoProducto) {
		this.activarcodigoSegmentoProducto= activarcodigoSegmentoProducto;
	}

	public Border setResaltarnombreSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltar);
		
		this.resaltarnombreSegmentoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSegmentoProducto() {
		return this.resaltarnombreSegmentoProducto;
	}

	public void setResaltarnombreSegmentoProducto(Border borderResaltar) {
		this.resaltarnombreSegmentoProducto= borderResaltar;
	}

	public Boolean getMostrarnombreSegmentoProducto() {
		return this.mostrarnombreSegmentoProducto;
	}

	public void setMostrarnombreSegmentoProducto(Boolean mostrarnombreSegmentoProducto) {
		this.mostrarnombreSegmentoProducto= mostrarnombreSegmentoProducto;
	}

	public Boolean getActivarnombreSegmentoProducto() {
		return this.activarnombreSegmentoProducto;
	}

	public void setActivarnombreSegmentoProducto(Boolean activarnombreSegmentoProducto) {
		this.activarnombreSegmentoProducto= activarnombreSegmentoProducto;
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
		
		
		this.setMostraridSegmentoProducto(esInicial);
		this.setMostrarid_empresaSegmentoProducto(esInicial);
		this.setMostrarid_tipo_productoSegmentoProducto(esInicial);
		this.setMostrarcodigoSegmentoProducto(esInicial);
		this.setMostrarnombreSegmentoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.ID)) {
				this.setMostraridSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSegmentoProducto(esAsigna);
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
		
		
		this.setActivaridSegmentoProducto(esInicial);
		this.setActivarid_empresaSegmentoProducto(esInicial);
		this.setActivarid_tipo_productoSegmentoProducto(esInicial);
		this.setActivarcodigoSegmentoProducto(esInicial);
		this.setActivarnombreSegmentoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.ID)) {
				this.setActivaridSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSegmentoProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSegmentoProducto(esInicial);
		this.setResaltarid_empresaSegmentoProducto(esInicial);
		this.setResaltarid_tipo_productoSegmentoProducto(esInicial);
		this.setResaltarcodigoSegmentoProducto(esInicial);
		this.setResaltarnombreSegmentoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.ID)) {
				this.setResaltaridSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSegmentoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(SegmentoProductoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSegmentoProducto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoSegmentoProducto=null;

	public Border getResaltarProductoSegmentoProducto() {
		return this.resaltarProductoSegmentoProducto;
	}

	public void setResaltarProductoSegmentoProducto(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoSegmentoProducto= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltarProducto);
			
		this.resaltarProductoSegmentoProducto= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoSegmentoProducto=true;

	public Boolean getMostrarProductoSegmentoProducto() {
		return this.mostrarProductoSegmentoProducto;
	}

	public void setMostrarProductoSegmentoProducto(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoSegmentoProducto= visibilidadResaltarProducto;
	}



	public Boolean activarProductoSegmentoProducto=true;

	public Boolean gethabilitarResaltarProductoSegmentoProducto() {
		return this.activarProductoSegmentoProducto;
	}

	public void setActivarProductoSegmentoProducto(Boolean habilitarResaltarProducto) {
		this.activarProductoSegmentoProducto= habilitarResaltarProducto;
	}


	public Border resaltarParametroInventarioDefectoSegmentoProducto=null;

	public Border getResaltarParametroInventarioDefectoSegmentoProducto() {
		return this.resaltarParametroInventarioDefectoSegmentoProducto;
	}

	public void setResaltarParametroInventarioDefectoSegmentoProducto(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoSegmentoProducto= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//segmentoproductoBeanSwingJInternalFrame.jTtoolBarSegmentoProducto.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoSegmentoProducto= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoSegmentoProducto=true;

	public Boolean getMostrarParametroInventarioDefectoSegmentoProducto() {
		return this.mostrarParametroInventarioDefectoSegmentoProducto;
	}

	public void setMostrarParametroInventarioDefectoSegmentoProducto(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoSegmentoProducto= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoSegmentoProducto=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoSegmentoProducto() {
		return this.activarParametroInventarioDefectoSegmentoProducto;
	}

	public void setActivarParametroInventarioDefectoSegmentoProducto(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoSegmentoProducto= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarProductoSegmentoProducto(esInicial);
		this.setMostrarParametroInventarioDefectoSegmentoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoSegmentoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoSegmentoProducto(esAsigna);
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

		this.setActivarProductoSegmentoProducto(esInicial);
		this.setActivarParametroInventarioDefectoSegmentoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoSegmentoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoSegmentoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoSegmentoProducto(esInicial);
		this.setResaltarParametroInventarioDefectoSegmentoProducto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoSegmentoProducto(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoSegmentoProducto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoSegmentoProducto=true;

	public Boolean getMostrarBusquedaPorCodigoSegmentoProducto() {
		return this.mostrarBusquedaPorCodigoSegmentoProducto;
	}

	public void setMostrarBusquedaPorCodigoSegmentoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoSegmentoProducto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreSegmentoProducto=true;

	public Boolean getMostrarBusquedaPorNombreSegmentoProducto() {
		return this.mostrarBusquedaPorNombreSegmentoProducto;
	}

	public void setMostrarBusquedaPorNombreSegmentoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreSegmentoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSegmentoProducto=true;

	public Boolean getMostrarFK_IdEmpresaSegmentoProducto() {
		return this.mostrarFK_IdEmpresaSegmentoProducto;
	}

	public void setMostrarFK_IdEmpresaSegmentoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSegmentoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoSegmentoProducto=true;

	public Boolean getMostrarFK_IdTipoProductoSegmentoProducto() {
		return this.mostrarFK_IdTipoProductoSegmentoProducto;
	}

	public void setMostrarFK_IdTipoProductoSegmentoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoSegmentoProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoSegmentoProducto=true;

	public Boolean getActivarBusquedaPorCodigoSegmentoProducto() {
		return this.activarBusquedaPorCodigoSegmentoProducto;
	}

	public void setActivarBusquedaPorCodigoSegmentoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoSegmentoProducto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreSegmentoProducto=true;

	public Boolean getActivarBusquedaPorNombreSegmentoProducto() {
		return this.activarBusquedaPorNombreSegmentoProducto;
	}

	public void setActivarBusquedaPorNombreSegmentoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreSegmentoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSegmentoProducto=true;

	public Boolean getActivarFK_IdEmpresaSegmentoProducto() {
		return this.activarFK_IdEmpresaSegmentoProducto;
	}

	public void setActivarFK_IdEmpresaSegmentoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSegmentoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoSegmentoProducto=true;

	public Boolean getActivarFK_IdTipoProductoSegmentoProducto() {
		return this.activarFK_IdTipoProductoSegmentoProducto;
	}

	public void setActivarFK_IdTipoProductoSegmentoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoSegmentoProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoSegmentoProducto=null;

	public Border getResaltarBusquedaPorCodigoSegmentoProducto() {
		return this.resaltarBusquedaPorCodigoSegmentoProducto;
	}

	public void setResaltarBusquedaPorCodigoSegmentoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoSegmentoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoSegmentoProducto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreSegmentoProducto=null;

	public Border getResaltarBusquedaPorNombreSegmentoProducto() {
		return this.resaltarBusquedaPorNombreSegmentoProducto;
	}

	public void setResaltarBusquedaPorNombreSegmentoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreSegmentoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreSegmentoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSegmentoProducto=null;

	public Border getResaltarFK_IdEmpresaSegmentoProducto() {
		return this.resaltarFK_IdEmpresaSegmentoProducto;
	}

	public void setResaltarFK_IdEmpresaSegmentoProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSegmentoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSegmentoProducto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoSegmentoProducto=null;

	public Border getResaltarFK_IdTipoProductoSegmentoProducto() {
		return this.resaltarFK_IdTipoProductoSegmentoProducto;
	}

	public void setResaltarFK_IdTipoProductoSegmentoProducto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoSegmentoProducto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoSegmentoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*SegmentoProductoBeanSwingJInternalFrame segmentoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoSegmentoProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}