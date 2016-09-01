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


import com.bydan.erp.inventario.util.UtilidadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.UtilidadProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UtilidadProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UtilidadProductoConstantesFunciones extends UtilidadProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UtilidadProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UtilidadProducto"+UtilidadProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UtilidadProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UtilidadProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UtilidadProductoConstantesFunciones.SCHEMA+"_"+UtilidadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UtilidadProductoConstantesFunciones.SCHEMA+"_"+UtilidadProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UtilidadProductoConstantesFunciones.SCHEMA+"_"+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UtilidadProductoConstantesFunciones.SCHEMA+"_"+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UtilidadProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UtilidadProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UtilidadProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UtilidadProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Utilidad Productoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Utilidad Producto";
	public static final String SCLASSWEBTITULO_LOWER="Utilidad Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UtilidadProducto";
	public static final String OBJECTNAME="utilidadproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="utilidad_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select utilidadproducto from "+UtilidadProductoConstantesFunciones.SPERSISTENCENAME+" utilidadproducto";
	public static String QUERYSELECTNATIVE="select "+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".id,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".version_row,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".id_sucursal,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".id_bodega,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".id_producto,"+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME+".porcentaje from "+UtilidadProductoConstantesFunciones.SCHEMA+"."+UtilidadProductoConstantesFunciones.TABLENAME;//+" as "+UtilidadProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UtilidadProductoConstantesFuncionesAdditional utilidadproductoConstantesFuncionesAdditional=null;
	
	public UtilidadProductoConstantesFuncionesAdditional getUtilidadProductoConstantesFuncionesAdditional() {
		return this.utilidadproductoConstantesFuncionesAdditional;
	}
	
	public void setUtilidadProductoConstantesFuncionesAdditional(UtilidadProductoConstantesFuncionesAdditional utilidadproductoConstantesFuncionesAdditional) {
		try {
			this.utilidadproductoConstantesFuncionesAdditional=utilidadproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
	
	public static String getUtilidadProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UtilidadProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=UtilidadProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UtilidadProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=UtilidadProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(UtilidadProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=UtilidadProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(UtilidadProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=UtilidadProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(UtilidadProductoConstantesFunciones.PORCENTAJE)) {sLabelColumna=UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getUtilidadProductoDescripcion(UtilidadProducto utilidadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(utilidadproducto !=null/* && utilidadproducto.getId()!=0*/) {
			if(utilidadproducto.getId()!=null) {
				sDescripcion=utilidadproducto.getId().toString();
			}//utilidadproductoutilidadproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUtilidadProductoDescripcionDetallado(UtilidadProducto utilidadproducto) {
		String sDescripcion="";
			
		sDescripcion+=UtilidadProductoConstantesFunciones.ID+"=";
		sDescripcion+=utilidadproducto.getId().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=utilidadproducto.getVersionRow().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=utilidadproducto.getid_empresa().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=utilidadproducto.getid_sucursal().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=utilidadproducto.getid_bodega().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=utilidadproducto.getid_producto().toString()+",";
		sDescripcion+=UtilidadProductoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=utilidadproducto.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUtilidadProductoDescripcion(UtilidadProducto utilidadproducto,String sValor) throws Exception {			
		if(utilidadproducto !=null) {
			//utilidadproductoutilidadproducto.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdBodegaPorIdProducto")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdBodegaPorIdProducto(Long id_bodega,Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUtilidadProducto(UtilidadProducto utilidadproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosUtilidadProductos(List<UtilidadProducto> utilidadproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UtilidadProducto utilidadproducto: utilidadproductos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadProducto(UtilidadProducto utilidadproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && utilidadproducto.getConCambioAuxiliar()) {
			utilidadproducto.setIsDeleted(utilidadproducto.getIsDeletedAuxiliar());	
			utilidadproducto.setIsNew(utilidadproducto.getIsNewAuxiliar());	
			utilidadproducto.setIsChanged(utilidadproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			utilidadproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			utilidadproducto.setIsDeletedAuxiliar(false);	
			utilidadproducto.setIsNewAuxiliar(false);	
			utilidadproducto.setIsChangedAuxiliar(false);
			
			utilidadproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadProductos(List<UtilidadProducto> utilidadproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UtilidadProducto utilidadproducto : utilidadproductos) {
			if(conAsignarBase && utilidadproducto.getConCambioAuxiliar()) {
				utilidadproducto.setIsDeleted(utilidadproducto.getIsDeletedAuxiliar());	
				utilidadproducto.setIsNew(utilidadproducto.getIsNewAuxiliar());	
				utilidadproducto.setIsChanged(utilidadproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				utilidadproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				utilidadproducto.setIsDeletedAuxiliar(false);	
				utilidadproducto.setIsNewAuxiliar(false);	
				utilidadproducto.setIsChangedAuxiliar(false);
				
				utilidadproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUtilidadProducto(UtilidadProducto utilidadproducto,Boolean conEnteros) throws Exception  {
		utilidadproducto.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUtilidadProductos(List<UtilidadProducto> utilidadproductos,Boolean conEnteros) throws Exception  {
		
		for(UtilidadProducto utilidadproducto: utilidadproductos) {
			utilidadproducto.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUtilidadProducto(List<UtilidadProducto> utilidadproductos,UtilidadProducto utilidadproductoAux) throws Exception  {
		UtilidadProductoConstantesFunciones.InicializarValoresUtilidadProducto(utilidadproductoAux,true);
		
		for(UtilidadProducto utilidadproducto: utilidadproductos) {
			if(utilidadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			utilidadproductoAux.setporcentaje(utilidadproductoAux.getporcentaje()+utilidadproducto.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UtilidadProductoConstantesFunciones.getArrayColumnasGlobalesUtilidadProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUtilidadProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UtilidadProducto> utilidadproductos,UtilidadProducto utilidadproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UtilidadProducto utilidadproductoAux: utilidadproductos) {
			if(utilidadproductoAux!=null && utilidadproducto!=null) {
				if((utilidadproductoAux.getId()==null && utilidadproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(utilidadproductoAux.getId()!=null && utilidadproducto.getId()!=null){
					if(utilidadproductoAux.getId().equals(utilidadproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUtilidadProducto(List<UtilidadProducto> utilidadproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(UtilidadProducto utilidadproducto: utilidadproductos) {			
			if(utilidadproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=utilidadproducto.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadProductoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUtilidadProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_ID, UtilidadProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_VERSIONROW, UtilidadProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_IDEMPRESA, UtilidadProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_IDSUCURSAL, UtilidadProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_IDBODEGA, UtilidadProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_IDPRODUCTO, UtilidadProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE, UtilidadProductoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUtilidadProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadProductoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadProducto() throws Exception  {
		return UtilidadProductoConstantesFunciones.getTiposSeleccionarUtilidadProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadProducto(Boolean conFk) throws Exception  {
		return UtilidadProductoConstantesFunciones.getTiposSeleccionarUtilidadProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUtilidadProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadProducto(UtilidadProducto utilidadproductoAux) throws Exception {
		
			utilidadproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadproductoAux.getEmpresa()));
			utilidadproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadproductoAux.getSucursal()));
			utilidadproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(utilidadproductoAux.getBodega()));
			utilidadproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(utilidadproductoAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadProducto(List<UtilidadProducto> utilidadproductosTemp) throws Exception {
		for(UtilidadProducto utilidadproductoAux:utilidadproductosTemp) {
			
			utilidadproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadproductoAux.getEmpresa()));
			utilidadproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadproductoAux.getSucursal()));
			utilidadproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(utilidadproductoAux.getBodega()));
			utilidadproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(utilidadproductoAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUtilidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadProductoConstantesFunciones.getClassesRelationshipsOfUtilidadProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadProductoConstantesFunciones.getClassesRelationshipsFromStringsOfUtilidadProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(UtilidadProducto utilidadproducto,List<UtilidadProducto> utilidadproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UtilidadProducto utilidadproductoEncontrado=null;
			
			for(UtilidadProducto utilidadproductoLocal:utilidadproductos) {
				if(utilidadproductoLocal.getId().equals(utilidadproducto.getId())) {
					utilidadproductoEncontrado=utilidadproductoLocal;
					
					utilidadproductoLocal.setIsChanged(utilidadproducto.getIsChanged());
					utilidadproductoLocal.setIsNew(utilidadproducto.getIsNew());
					utilidadproductoLocal.setIsDeleted(utilidadproducto.getIsDeleted());
					
					utilidadproductoLocal.setGeneralEntityOriginal(utilidadproducto.getGeneralEntityOriginal());
					
					utilidadproductoLocal.setId(utilidadproducto.getId());	
					utilidadproductoLocal.setVersionRow(utilidadproducto.getVersionRow());	
					utilidadproductoLocal.setid_empresa(utilidadproducto.getid_empresa());	
					utilidadproductoLocal.setid_sucursal(utilidadproducto.getid_sucursal());	
					utilidadproductoLocal.setid_bodega(utilidadproducto.getid_bodega());	
					utilidadproductoLocal.setid_producto(utilidadproducto.getid_producto());	
					utilidadproductoLocal.setporcentaje(utilidadproducto.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!utilidadproducto.getIsDeleted()) {
				if(!existe) {
					utilidadproductos.add(utilidadproducto);
				}
			} else {
				if(utilidadproductoEncontrado!=null && permiteQuitar)  {
					utilidadproductos.remove(utilidadproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UtilidadProducto utilidadproducto,List<UtilidadProducto> utilidadproductos) throws Exception {
		try	{			
			for(UtilidadProducto utilidadproductoLocal:utilidadproductos) {
				if(utilidadproductoLocal.getId().equals(utilidadproducto.getId())) {
					utilidadproductoLocal.setIsSelected(utilidadproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUtilidadProducto(List<UtilidadProducto> utilidadproductosAux) throws Exception {
		//this.utilidadproductosAux=utilidadproductosAux;
		
		for(UtilidadProducto utilidadproductoAux:utilidadproductosAux) {
			if(utilidadproductoAux.getIsChanged()) {
				utilidadproductoAux.setIsChanged(false);
			}		
			
			if(utilidadproductoAux.getIsNew()) {
				utilidadproductoAux.setIsNew(false);
			}	
			
			if(utilidadproductoAux.getIsDeleted()) {
				utilidadproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUtilidadProducto(UtilidadProducto utilidadproductoAux) throws Exception {
		//this.utilidadproductoAux=utilidadproductoAux;
		
			if(utilidadproductoAux.getIsChanged()) {
				utilidadproductoAux.setIsChanged(false);
			}		
			
			if(utilidadproductoAux.getIsNew()) {
				utilidadproductoAux.setIsNew(false);
			}	
			
			if(utilidadproductoAux.getIsDeleted()) {
				utilidadproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UtilidadProducto utilidadproductoAsignar,UtilidadProducto utilidadproducto) throws Exception {
		utilidadproductoAsignar.setId(utilidadproducto.getId());	
		utilidadproductoAsignar.setVersionRow(utilidadproducto.getVersionRow());	
		utilidadproductoAsignar.setid_empresa(utilidadproducto.getid_empresa());
		utilidadproductoAsignar.setempresa_descripcion(utilidadproducto.getempresa_descripcion());	
		utilidadproductoAsignar.setid_sucursal(utilidadproducto.getid_sucursal());
		utilidadproductoAsignar.setsucursal_descripcion(utilidadproducto.getsucursal_descripcion());	
		utilidadproductoAsignar.setid_bodega(utilidadproducto.getid_bodega());
		utilidadproductoAsignar.setbodega_descripcion(utilidadproducto.getbodega_descripcion());	
		utilidadproductoAsignar.setid_producto(utilidadproducto.getid_producto());
		utilidadproductoAsignar.setproducto_descripcion(utilidadproducto.getproducto_descripcion());	
		utilidadproductoAsignar.setporcentaje(utilidadproducto.getporcentaje());	
	}
	
	public static void inicializarUtilidadProducto(UtilidadProducto utilidadproducto) throws Exception {
		try {
				utilidadproducto.setId(0L);	
					
				utilidadproducto.setid_empresa(-1L);	
				utilidadproducto.setid_sucursal(-1L);	
				utilidadproducto.setid_bodega(-1L);	
				utilidadproducto.setid_producto(-1L);	
				utilidadproducto.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUtilidadProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadProductoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUtilidadProducto(String sTipo,Row row,Workbook workbook,UtilidadProducto utilidadproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadproducto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUtilidadProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUtilidadProducto() {
		return this.sFinalQueryUtilidadProducto;
	}
	
	public void setsFinalQueryUtilidadProducto(String sFinalQueryUtilidadProducto) {
		this.sFinalQueryUtilidadProducto= sFinalQueryUtilidadProducto;
	}
	
	public Border resaltarSeleccionarUtilidadProducto=null;
	
	public Border setResaltarSeleccionarUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUtilidadProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUtilidadProducto() {
		return this.resaltarSeleccionarUtilidadProducto;
	}
	
	public void setResaltarSeleccionarUtilidadProducto(Border borderResaltarSeleccionarUtilidadProducto) {
		this.resaltarSeleccionarUtilidadProducto= borderResaltarSeleccionarUtilidadProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUtilidadProducto=null;
	public Boolean mostraridUtilidadProducto=true;
	public Boolean activaridUtilidadProducto=true;

	public Border resaltarid_empresaUtilidadProducto=null;
	public Boolean mostrarid_empresaUtilidadProducto=true;
	public Boolean activarid_empresaUtilidadProducto=true;
	public Boolean cargarid_empresaUtilidadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUtilidadProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalUtilidadProducto=null;
	public Boolean mostrarid_sucursalUtilidadProducto=true;
	public Boolean activarid_sucursalUtilidadProducto=true;
	public Boolean cargarid_sucursalUtilidadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalUtilidadProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaUtilidadProducto=null;
	public Boolean mostrarid_bodegaUtilidadProducto=true;
	public Boolean activarid_bodegaUtilidadProducto=true;
	public Boolean cargarid_bodegaUtilidadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaUtilidadProducto=false;//ConEventDepend=true

	public Border resaltarid_productoUtilidadProducto=null;
	public Boolean mostrarid_productoUtilidadProducto=true;
	public Boolean activarid_productoUtilidadProducto=true;
	public Boolean cargarid_productoUtilidadProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoUtilidadProducto=false;//ConEventDepend=true

	public Border resaltarporcentajeUtilidadProducto=null;
	public Boolean mostrarporcentajeUtilidadProducto=true;
	public Boolean activarporcentajeUtilidadProducto=true;

	
	

	public Border setResaltaridUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltaridUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUtilidadProducto() {
		return this.resaltaridUtilidadProducto;
	}

	public void setResaltaridUtilidadProducto(Border borderResaltar) {
		this.resaltaridUtilidadProducto= borderResaltar;
	}

	public Boolean getMostraridUtilidadProducto() {
		return this.mostraridUtilidadProducto;
	}

	public void setMostraridUtilidadProducto(Boolean mostraridUtilidadProducto) {
		this.mostraridUtilidadProducto= mostraridUtilidadProducto;
	}

	public Boolean getActivaridUtilidadProducto() {
		return this.activaridUtilidadProducto;
	}

	public void setActivaridUtilidadProducto(Boolean activaridUtilidadProducto) {
		this.activaridUtilidadProducto= activaridUtilidadProducto;
	}

	public Border setResaltarid_empresaUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUtilidadProducto() {
		return this.resaltarid_empresaUtilidadProducto;
	}

	public void setResaltarid_empresaUtilidadProducto(Border borderResaltar) {
		this.resaltarid_empresaUtilidadProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaUtilidadProducto() {
		return this.mostrarid_empresaUtilidadProducto;
	}

	public void setMostrarid_empresaUtilidadProducto(Boolean mostrarid_empresaUtilidadProducto) {
		this.mostrarid_empresaUtilidadProducto= mostrarid_empresaUtilidadProducto;
	}

	public Boolean getActivarid_empresaUtilidadProducto() {
		return this.activarid_empresaUtilidadProducto;
	}

	public void setActivarid_empresaUtilidadProducto(Boolean activarid_empresaUtilidadProducto) {
		this.activarid_empresaUtilidadProducto= activarid_empresaUtilidadProducto;
	}

	public Boolean getCargarid_empresaUtilidadProducto() {
		return this.cargarid_empresaUtilidadProducto;
	}

	public void setCargarid_empresaUtilidadProducto(Boolean cargarid_empresaUtilidadProducto) {
		this.cargarid_empresaUtilidadProducto= cargarid_empresaUtilidadProducto;
	}

	public Border setResaltarid_sucursalUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalUtilidadProducto() {
		return this.resaltarid_sucursalUtilidadProducto;
	}

	public void setResaltarid_sucursalUtilidadProducto(Border borderResaltar) {
		this.resaltarid_sucursalUtilidadProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalUtilidadProducto() {
		return this.mostrarid_sucursalUtilidadProducto;
	}

	public void setMostrarid_sucursalUtilidadProducto(Boolean mostrarid_sucursalUtilidadProducto) {
		this.mostrarid_sucursalUtilidadProducto= mostrarid_sucursalUtilidadProducto;
	}

	public Boolean getActivarid_sucursalUtilidadProducto() {
		return this.activarid_sucursalUtilidadProducto;
	}

	public void setActivarid_sucursalUtilidadProducto(Boolean activarid_sucursalUtilidadProducto) {
		this.activarid_sucursalUtilidadProducto= activarid_sucursalUtilidadProducto;
	}

	public Boolean getCargarid_sucursalUtilidadProducto() {
		return this.cargarid_sucursalUtilidadProducto;
	}

	public void setCargarid_sucursalUtilidadProducto(Boolean cargarid_sucursalUtilidadProducto) {
		this.cargarid_sucursalUtilidadProducto= cargarid_sucursalUtilidadProducto;
	}

	public Border setResaltarid_bodegaUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaUtilidadProducto() {
		return this.resaltarid_bodegaUtilidadProducto;
	}

	public void setResaltarid_bodegaUtilidadProducto(Border borderResaltar) {
		this.resaltarid_bodegaUtilidadProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaUtilidadProducto() {
		return this.mostrarid_bodegaUtilidadProducto;
	}

	public void setMostrarid_bodegaUtilidadProducto(Boolean mostrarid_bodegaUtilidadProducto) {
		this.mostrarid_bodegaUtilidadProducto= mostrarid_bodegaUtilidadProducto;
	}

	public Boolean getActivarid_bodegaUtilidadProducto() {
		return this.activarid_bodegaUtilidadProducto;
	}

	public void setActivarid_bodegaUtilidadProducto(Boolean activarid_bodegaUtilidadProducto) {
		this.activarid_bodegaUtilidadProducto= activarid_bodegaUtilidadProducto;
	}

	public Boolean getCargarid_bodegaUtilidadProducto() {
		return this.cargarid_bodegaUtilidadProducto;
	}

	public void setCargarid_bodegaUtilidadProducto(Boolean cargarid_bodegaUtilidadProducto) {
		this.cargarid_bodegaUtilidadProducto= cargarid_bodegaUtilidadProducto;
	}

	public Border setResaltarid_productoUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoUtilidadProducto() {
		return this.resaltarid_productoUtilidadProducto;
	}

	public void setResaltarid_productoUtilidadProducto(Border borderResaltar) {
		this.resaltarid_productoUtilidadProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoUtilidadProducto() {
		return this.mostrarid_productoUtilidadProducto;
	}

	public void setMostrarid_productoUtilidadProducto(Boolean mostrarid_productoUtilidadProducto) {
		this.mostrarid_productoUtilidadProducto= mostrarid_productoUtilidadProducto;
	}

	public Boolean getActivarid_productoUtilidadProducto() {
		return this.activarid_productoUtilidadProducto;
	}

	public void setActivarid_productoUtilidadProducto(Boolean activarid_productoUtilidadProducto) {
		this.activarid_productoUtilidadProducto= activarid_productoUtilidadProducto;
	}

	public Boolean getCargarid_productoUtilidadProducto() {
		return this.cargarid_productoUtilidadProducto;
	}

	public void setCargarid_productoUtilidadProducto(Boolean cargarid_productoUtilidadProducto) {
		this.cargarid_productoUtilidadProducto= cargarid_productoUtilidadProducto;
	}

	public Border setResaltarporcentajeUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadproductoBeanSwingJInternalFrame.jTtoolBarUtilidadProducto.setBorder(borderResaltar);
		
		this.resaltarporcentajeUtilidadProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeUtilidadProducto() {
		return this.resaltarporcentajeUtilidadProducto;
	}

	public void setResaltarporcentajeUtilidadProducto(Border borderResaltar) {
		this.resaltarporcentajeUtilidadProducto= borderResaltar;
	}

	public Boolean getMostrarporcentajeUtilidadProducto() {
		return this.mostrarporcentajeUtilidadProducto;
	}

	public void setMostrarporcentajeUtilidadProducto(Boolean mostrarporcentajeUtilidadProducto) {
		this.mostrarporcentajeUtilidadProducto= mostrarporcentajeUtilidadProducto;
	}

	public Boolean getActivarporcentajeUtilidadProducto() {
		return this.activarporcentajeUtilidadProducto;
	}

	public void setActivarporcentajeUtilidadProducto(Boolean activarporcentajeUtilidadProducto) {
		this.activarporcentajeUtilidadProducto= activarporcentajeUtilidadProducto;
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
		
		
		this.setMostraridUtilidadProducto(esInicial);
		this.setMostrarid_empresaUtilidadProducto(esInicial);
		this.setMostrarid_sucursalUtilidadProducto(esInicial);
		this.setMostrarid_bodegaUtilidadProducto(esInicial);
		this.setMostrarid_productoUtilidadProducto(esInicial);
		this.setMostrarporcentajeUtilidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.ID)) {
				this.setMostraridUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeUtilidadProducto(esAsigna);
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
		
		
		this.setActivaridUtilidadProducto(esInicial);
		this.setActivarid_empresaUtilidadProducto(esInicial);
		this.setActivarid_sucursalUtilidadProducto(esInicial);
		this.setActivarid_bodegaUtilidadProducto(esInicial);
		this.setActivarid_productoUtilidadProducto(esInicial);
		this.setActivarporcentajeUtilidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.ID)) {
				this.setActivaridUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeUtilidadProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUtilidadProducto(esInicial);
		this.setResaltarid_empresaUtilidadProducto(esInicial);
		this.setResaltarid_sucursalUtilidadProducto(esInicial);
		this.setResaltarid_bodegaUtilidadProducto(esInicial);
		this.setResaltarid_productoUtilidadProducto(esInicial);
		this.setResaltarporcentajeUtilidadProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.ID)) {
				this.setResaltaridUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoUtilidadProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadProductoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeUtilidadProducto(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdBodegaPorIdProductoUtilidadProducto=true;

	public Boolean getMostrarBusquedaPorIdBodegaPorIdProductoUtilidadProducto() {
		return this.mostrarBusquedaPorIdBodegaPorIdProductoUtilidadProducto;
	}

	public void setMostrarBusquedaPorIdBodegaPorIdProductoUtilidadProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdBodegaPorIdProductoUtilidadProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaUtilidadProducto=true;

	public Boolean getMostrarFK_IdBodegaUtilidadProducto() {
		return this.mostrarFK_IdBodegaUtilidadProducto;
	}

	public void setMostrarFK_IdBodegaUtilidadProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaUtilidadProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUtilidadProducto=true;

	public Boolean getMostrarFK_IdEmpresaUtilidadProducto() {
		return this.mostrarFK_IdEmpresaUtilidadProducto;
	}

	public void setMostrarFK_IdEmpresaUtilidadProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUtilidadProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalUtilidadProducto=true;

	public Boolean getMostrarFK_IdSucursalUtilidadProducto() {
		return this.mostrarFK_IdSucursalUtilidadProducto;
	}

	public void setMostrarFK_IdSucursalUtilidadProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalUtilidadProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdBodegaPorIdProductoUtilidadProducto=true;

	public Boolean getActivarBusquedaPorIdBodegaPorIdProductoUtilidadProducto() {
		return this.activarBusquedaPorIdBodegaPorIdProductoUtilidadProducto;
	}

	public void setActivarBusquedaPorIdBodegaPorIdProductoUtilidadProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdBodegaPorIdProductoUtilidadProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaUtilidadProducto=true;

	public Boolean getActivarFK_IdBodegaUtilidadProducto() {
		return this.activarFK_IdBodegaUtilidadProducto;
	}

	public void setActivarFK_IdBodegaUtilidadProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaUtilidadProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUtilidadProducto=true;

	public Boolean getActivarFK_IdEmpresaUtilidadProducto() {
		return this.activarFK_IdEmpresaUtilidadProducto;
	}

	public void setActivarFK_IdEmpresaUtilidadProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUtilidadProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalUtilidadProducto=true;

	public Boolean getActivarFK_IdSucursalUtilidadProducto() {
		return this.activarFK_IdSucursalUtilidadProducto;
	}

	public void setActivarFK_IdSucursalUtilidadProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalUtilidadProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto=null;

	public Border getResaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto() {
		return this.resaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto;
	}

	public void setResaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto(Border borderResaltar) {
		this.resaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdBodegaPorIdProductoUtilidadProducto= borderResaltar;
	}

	public Border resaltarFK_IdBodegaUtilidadProducto=null;

	public Border getResaltarFK_IdBodegaUtilidadProducto() {
		return this.resaltarFK_IdBodegaUtilidadProducto;
	}

	public void setResaltarFK_IdBodegaUtilidadProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaUtilidadProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaUtilidadProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUtilidadProducto=null;

	public Border getResaltarFK_IdEmpresaUtilidadProducto() {
		return this.resaltarFK_IdEmpresaUtilidadProducto;
	}

	public void setResaltarFK_IdEmpresaUtilidadProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUtilidadProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUtilidadProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalUtilidadProducto=null;

	public Border getResaltarFK_IdSucursalUtilidadProducto() {
		return this.resaltarFK_IdSucursalUtilidadProducto;
	}

	public void setResaltarFK_IdSucursalUtilidadProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalUtilidadProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalUtilidadProducto(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadProductoBeanSwingJInternalFrame utilidadproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalUtilidadProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}