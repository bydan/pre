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


import com.bydan.erp.inventario.util.TipoPedidoCompraConstantesFunciones;
//import com.bydan.erp.inventario.util.TipoPedidoCompraReturnGeneral;
//import com.bydan.erp.inventario.util.TipoPedidoCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPedidoCompraConstantesFunciones{		
	
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="TipoPedidoCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPedidoCompra"+TipoPedidoCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPedidoCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPedidoCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPedidoCompraConstantesFunciones.SCHEMA+"_"+TipoPedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPedidoCompraConstantesFunciones.SCHEMA+"_"+TipoPedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPedidoCompraConstantesFunciones.SCHEMA+"_"+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPedidoCompraConstantesFunciones.SCHEMA+"_"+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPedidoCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPedidoCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Pedido Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	
	public static final String CLASSNAME="TipoPedidoCompra";
	public static final String OBJECTNAME="tipopedidocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_pedido_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipopedidocompra from "+TipoPedidoCompraConstantesFunciones.SPERSISTENCENAME+" tipopedidocompra";
	public static String QUERYSELECTNATIVE="select "+TipoPedidoCompraConstantesFunciones.SCHEMA+"."+TipoPedidoCompraConstantesFunciones.TABLENAME+".id,"+TipoPedidoCompraConstantesFunciones.SCHEMA+"."+TipoPedidoCompraConstantesFunciones.TABLENAME+".version_row,"+TipoPedidoCompraConstantesFunciones.SCHEMA+"."+TipoPedidoCompraConstantesFunciones.TABLENAME+".codigo,"+TipoPedidoCompraConstantesFunciones.SCHEMA+"."+TipoPedidoCompraConstantesFunciones.TABLENAME+".nombre from "+TipoPedidoCompraConstantesFunciones.SCHEMA+"."+TipoPedidoCompraConstantesFunciones.TABLENAME;//+" as "+TipoPedidoCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoPedidoCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPedidoCompraConstantesFunciones.CODIGO)) {sLabelColumna=TipoPedidoCompraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPedidoCompraConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPedidoCompraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPedidoCompraDescripcion(TipoPedidoCompra tipopedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipopedidocompra !=null/* && tipopedidocompra.getId()!=0*/) {
			sDescripcion=tipopedidocompra.getcodigo();//tipopedidocompratipopedidocompra.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static void setTipoPedidoCompraDescripcion(TipoPedidoCompra tipopedidocompra,String sValor) throws Exception {			
		if(tipopedidocompra !=null) {
			tipopedidocompra.setcodigo(sValor);;//tipopedidocompratipopedidocompra.getcodigo().trim();
		}		
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPedidoCompra(TipoPedidoCompra tipopedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipopedidocompra.setcodigo(tipopedidocompra.getcodigo().trim());
		tipopedidocompra.setnombre(tipopedidocompra.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPedidoCompras(List<TipoPedidoCompra> tipopedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPedidoCompra tipopedidocompra: tipopedidocompras) {
			tipopedidocompra.setcodigo(tipopedidocompra.getcodigo().trim());
			tipopedidocompra.setnombre(tipopedidocompra.getnombre().trim());
		
		}
	}
	
	public static void InicializarValoresTipoPedidoCompra(TipoPedidoCompra tipopedidocompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPedidoCompras(List<TipoPedidoCompra> tipopedidocompras,Boolean conEnteros) throws Exception  {
		
		for(TipoPedidoCompra tipopedidocompra: tipopedidocompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPedidoCompra(List<TipoPedidoCompra> tipopedidocompras,TipoPedidoCompra tipopedidocompraAux) throws Exception  {
		TipoPedidoCompraConstantesFunciones.InicializarValoresTipoPedidoCompra(tipopedidocompraAux,true);
		
		for(TipoPedidoCompra tipopedidocompra: tipopedidocompras) {
			if(tipopedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPedidoCompraConstantesFunciones.getArrayColumnasGlobalesTipoPedidoCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPedidoCompra> tipopedidocompras,TipoPedidoCompra tipopedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPedidoCompra tipopedidocompraAux: tipopedidocompras) {
			if((tipopedidocompraAux.getId()==null && tipopedidocompra.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipopedidocompraAux.getId()!=null && tipopedidocompra.getId()!=null){
				if(tipopedidocompraAux.getId().equals(tipopedidocompra.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPedidoCompra(List<TipoPedidoCompra> tipopedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPedidoCompra tipopedidocompra: tipopedidocompras) {			
			if(tipopedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPedidoCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPedidoCompraConstantesFunciones.LABEL_ID, TipoPedidoCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPedidoCompraConstantesFunciones.LABEL_VERSIONROW, TipoPedidoCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPedidoCompraConstantesFunciones.LABEL_CODIGO, TipoPedidoCompraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPedidoCompraConstantesFunciones.LABEL_NOMBRE, TipoPedidoCompraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPedidoCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPedidoCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPedidoCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPedidoCompraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPedidoCompraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPedidoCompra() throws Exception  {
		return TipoPedidoCompraConstantesFunciones.getTiposSeleccionarTipoPedidoCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPedidoCompra(Boolean conFk) throws Exception  {
		return TipoPedidoCompraConstantesFunciones.getTiposSeleccionarTipoPedidoCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPedidoCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPedidoCompraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPedidoCompraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPedidoCompraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPedidoCompraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPedidoCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPedidoCompra(TipoPedidoCompra tipopedidocompraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPedidoCompra(List<TipoPedidoCompra> tipopedidocomprasTemp) throws Exception {
		for(TipoPedidoCompra tipopedidocompraAux:tipopedidocomprasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPedidoCompraConstantesFunciones.getClassesRelationshipsOfTipoPedidoCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPedidoCompraConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPedidoCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoPedidoCompra tipopedidocompra,List<TipoPedidoCompra> tipopedidocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPedidoCompra tipopedidocompraEncontrado=null;
			
			for(TipoPedidoCompra tipopedidocompraLocal:tipopedidocompras) {
				if(tipopedidocompraLocal.getId().equals(tipopedidocompra.getId())) {
					tipopedidocompraEncontrado=tipopedidocompraLocal;
					
					tipopedidocompraLocal.setIsChanged(tipopedidocompra.getIsChanged());
					tipopedidocompraLocal.setIsNew(tipopedidocompra.getIsNew());
					tipopedidocompraLocal.setIsDeleted(tipopedidocompra.getIsDeleted());
					
					tipopedidocompraLocal.setGeneralEntityOriginal(tipopedidocompra.getGeneralEntityOriginal());
					
					tipopedidocompraLocal.setId(tipopedidocompra.getId());	
					tipopedidocompraLocal.setVersionRow(tipopedidocompra.getVersionRow());	
					tipopedidocompraLocal.setcodigo(tipopedidocompra.getcodigo());	
					tipopedidocompraLocal.setnombre(tipopedidocompra.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipopedidocompra.getIsDeleted()) {
				if(!existe) {
					tipopedidocompras.add(tipopedidocompra);
				}
			} else {
				if(tipopedidocompraEncontrado!=null && permiteQuitar)  {
					tipopedidocompras.remove(tipopedidocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPedidoCompra tipopedidocompra,List<TipoPedidoCompra> tipopedidocompras) throws Exception {
		try	{			
			for(TipoPedidoCompra tipopedidocompraLocal:tipopedidocompras) {
				if(tipopedidocompraLocal.getId().equals(tipopedidocompra.getId())) {
					tipopedidocompraLocal.setIsSelected(tipopedidocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPedidoCompra(List<TipoPedidoCompra> tipopedidocomprasAux) throws Exception {
		//this.tipopedidocomprasAux=tipopedidocomprasAux;
		
		for(TipoPedidoCompra tipopedidocompraAux:tipopedidocomprasAux) {
			if(tipopedidocompraAux.getIsChanged()) {
				tipopedidocompraAux.setIsChanged(false);
			}		
			
			if(tipopedidocompraAux.getIsNew()) {
				tipopedidocompraAux.setIsNew(false);
			}	
			
			if(tipopedidocompraAux.getIsDeleted()) {
				tipopedidocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPedidoCompra(TipoPedidoCompra tipopedidocompraAux) throws Exception {
		//this.tipopedidocompraAux=tipopedidocompraAux;
		
			if(tipopedidocompraAux.getIsChanged()) {
				tipopedidocompraAux.setIsChanged(false);
			}		
			
			if(tipopedidocompraAux.getIsNew()) {
				tipopedidocompraAux.setIsNew(false);
			}	
			
			if(tipopedidocompraAux.getIsDeleted()) {
				tipopedidocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPedidoCompra tipopedidocompraAsignar,TipoPedidoCompra tipopedidocompra) throws Exception {
		tipopedidocompraAsignar.setId(tipopedidocompra.getId());	
		tipopedidocompraAsignar.setVersionRow(tipopedidocompra.getVersionRow());	
		tipopedidocompraAsignar.setcodigo(tipopedidocompra.getcodigo());	
		tipopedidocompraAsignar.setnombre(tipopedidocompra.getnombre());	
	}
	
	public static void inicializarTipoPedidoCompra(TipoPedidoCompra tipopedidocompra) throws Exception {
		try {
				tipopedidocompra.setId(0L);	
					
				tipopedidocompra.setcodigo("");	
				tipopedidocompra.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPedidoCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPedidoCompraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPedidoCompraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPedidoCompra(String sTipo,Row row,Workbook workbook,TipoPedidoCompra tipopedidocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopedidocompra.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopedidocompra.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	//CONTROL_FUNCION2
}

