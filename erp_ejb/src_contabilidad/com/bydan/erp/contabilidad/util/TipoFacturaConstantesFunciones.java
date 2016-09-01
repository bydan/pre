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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoFacturaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFacturaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFactura";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFactura"+TipoFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFacturaConstantesFunciones.SCHEMA+"_"+TipoFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFacturaConstantesFunciones.SCHEMA+"_"+TipoFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFacturaConstantesFunciones.SCHEMA+"_"+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFacturaConstantesFunciones.SCHEMA+"_"+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Factura";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFactura";
	public static final String OBJECTNAME="tipofactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipofactura from "+TipoFacturaConstantesFunciones.SPERSISTENCENAME+" tipofactura";
	public static String QUERYSELECTNATIVE="select "+TipoFacturaConstantesFunciones.SCHEMA+"."+TipoFacturaConstantesFunciones.TABLENAME+".id,"+TipoFacturaConstantesFunciones.SCHEMA+"."+TipoFacturaConstantesFunciones.TABLENAME+".version_row,"+TipoFacturaConstantesFunciones.SCHEMA+"."+TipoFacturaConstantesFunciones.TABLENAME+".codigo,"+TipoFacturaConstantesFunciones.SCHEMA+"."+TipoFacturaConstantesFunciones.TABLENAME+".nombre from "+TipoFacturaConstantesFunciones.SCHEMA+"."+TipoFacturaConstantesFunciones.TABLENAME;//+" as "+TipoFacturaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFacturaConstantesFunciones.CODIGO)) {sLabelColumna=TipoFacturaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoFacturaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFacturaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFacturaDescripcion(TipoFactura tipofactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipofactura !=null/* && tipofactura.getId()!=0*/) {
			sDescripcion=tipofactura.getnombre();//tipofacturatipofactura.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFacturaDescripcionDetallado(TipoFactura tipofactura) {
		String sDescripcion="";
			
		sDescripcion+=TipoFacturaConstantesFunciones.ID+"=";
		sDescripcion+=tipofactura.getId().toString()+",";
		sDescripcion+=TipoFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipofactura.getVersionRow().toString()+",";
		sDescripcion+=TipoFacturaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipofactura.getcodigo()+",";
		sDescripcion+=TipoFacturaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipofactura.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFacturaDescripcion(TipoFactura tipofactura,String sValor) throws Exception {			
		if(tipofactura !=null) {
			tipofactura.setnombre(sValor);;//tipofacturatipofactura.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoFactura(TipoFactura tipofactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipofactura.setcodigo(tipofactura.getcodigo().trim());
		tipofactura.setnombre(tipofactura.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFacturas(List<TipoFactura> tipofacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFactura tipofactura: tipofacturas) {
			tipofactura.setcodigo(tipofactura.getcodigo().trim());
			tipofactura.setnombre(tipofactura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFactura(TipoFactura tipofactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipofactura.getConCambioAuxiliar()) {
			tipofactura.setIsDeleted(tipofactura.getIsDeletedAuxiliar());	
			tipofactura.setIsNew(tipofactura.getIsNewAuxiliar());	
			tipofactura.setIsChanged(tipofactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipofactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipofactura.setIsDeletedAuxiliar(false);	
			tipofactura.setIsNewAuxiliar(false);	
			tipofactura.setIsChangedAuxiliar(false);
			
			tipofactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFacturas(List<TipoFactura> tipofacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFactura tipofactura : tipofacturas) {
			if(conAsignarBase && tipofactura.getConCambioAuxiliar()) {
				tipofactura.setIsDeleted(tipofactura.getIsDeletedAuxiliar());	
				tipofactura.setIsNew(tipofactura.getIsNewAuxiliar());	
				tipofactura.setIsChanged(tipofactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipofactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipofactura.setIsDeletedAuxiliar(false);	
				tipofactura.setIsNewAuxiliar(false);	
				tipofactura.setIsChangedAuxiliar(false);
				
				tipofactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFactura(TipoFactura tipofactura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFacturas(List<TipoFactura> tipofacturas,Boolean conEnteros) throws Exception  {
		
		for(TipoFactura tipofactura: tipofacturas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFactura(List<TipoFactura> tipofacturas,TipoFactura tipofacturaAux) throws Exception  {
		TipoFacturaConstantesFunciones.InicializarValoresTipoFactura(tipofacturaAux,true);
		
		for(TipoFactura tipofactura: tipofacturas) {
			if(tipofactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFacturaConstantesFunciones.getArrayColumnasGlobalesTipoFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFactura> tipofacturas,TipoFactura tipofactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFactura tipofacturaAux: tipofacturas) {
			if(tipofacturaAux!=null && tipofactura!=null) {
				if((tipofacturaAux.getId()==null && tipofactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipofacturaAux.getId()!=null && tipofactura.getId()!=null){
					if(tipofacturaAux.getId().equals(tipofactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFactura(List<TipoFactura> tipofacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFactura tipofactura: tipofacturas) {			
			if(tipofactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFacturaConstantesFunciones.LABEL_ID, TipoFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaConstantesFunciones.LABEL_VERSIONROW, TipoFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaConstantesFunciones.LABEL_CODIGO, TipoFacturaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaConstantesFunciones.LABEL_NOMBRE, TipoFacturaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFactura() throws Exception  {
		return TipoFacturaConstantesFunciones.getTiposSeleccionarTipoFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFactura(Boolean conFk) throws Exception  {
		return TipoFacturaConstantesFunciones.getTiposSeleccionarTipoFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFacturaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoFacturaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFacturaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFacturaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFactura(TipoFactura tipofacturaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFactura(List<TipoFactura> tipofacturasTemp) throws Exception {
		for(TipoFactura tipofacturaAux:tipofacturasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFacturaConstantesFunciones.getClassesRelationshipsOfTipoFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(ParametroCartera.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCartera.class)) {
						classes.add(new Classe(ParametroCartera.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(ParametroCartera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCartera.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(ParametroCartera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCartera.class)); continue;
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
	public static void actualizarLista(TipoFactura tipofactura,List<TipoFactura> tipofacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFactura tipofacturaEncontrado=null;
			
			for(TipoFactura tipofacturaLocal:tipofacturas) {
				if(tipofacturaLocal.getId().equals(tipofactura.getId())) {
					tipofacturaEncontrado=tipofacturaLocal;
					
					tipofacturaLocal.setIsChanged(tipofactura.getIsChanged());
					tipofacturaLocal.setIsNew(tipofactura.getIsNew());
					tipofacturaLocal.setIsDeleted(tipofactura.getIsDeleted());
					
					tipofacturaLocal.setGeneralEntityOriginal(tipofactura.getGeneralEntityOriginal());
					
					tipofacturaLocal.setId(tipofactura.getId());	
					tipofacturaLocal.setVersionRow(tipofactura.getVersionRow());	
					tipofacturaLocal.setcodigo(tipofactura.getcodigo());	
					tipofacturaLocal.setnombre(tipofactura.getnombre());	
					
					
					tipofacturaLocal.setFacturas(tipofactura.getFacturas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipofactura.getIsDeleted()) {
				if(!existe) {
					tipofacturas.add(tipofactura);
				}
			} else {
				if(tipofacturaEncontrado!=null && permiteQuitar)  {
					tipofacturas.remove(tipofacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFactura tipofactura,List<TipoFactura> tipofacturas) throws Exception {
		try	{			
			for(TipoFactura tipofacturaLocal:tipofacturas) {
				if(tipofacturaLocal.getId().equals(tipofactura.getId())) {
					tipofacturaLocal.setIsSelected(tipofactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFactura(List<TipoFactura> tipofacturasAux) throws Exception {
		//this.tipofacturasAux=tipofacturasAux;
		
		for(TipoFactura tipofacturaAux:tipofacturasAux) {
			if(tipofacturaAux.getIsChanged()) {
				tipofacturaAux.setIsChanged(false);
			}		
			
			if(tipofacturaAux.getIsNew()) {
				tipofacturaAux.setIsNew(false);
			}	
			
			if(tipofacturaAux.getIsDeleted()) {
				tipofacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFactura(TipoFactura tipofacturaAux) throws Exception {
		//this.tipofacturaAux=tipofacturaAux;
		
			if(tipofacturaAux.getIsChanged()) {
				tipofacturaAux.setIsChanged(false);
			}		
			
			if(tipofacturaAux.getIsNew()) {
				tipofacturaAux.setIsNew(false);
			}	
			
			if(tipofacturaAux.getIsDeleted()) {
				tipofacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFactura tipofacturaAsignar,TipoFactura tipofactura) throws Exception {
		tipofacturaAsignar.setId(tipofactura.getId());	
		tipofacturaAsignar.setVersionRow(tipofactura.getVersionRow());	
		tipofacturaAsignar.setcodigo(tipofactura.getcodigo());	
		tipofacturaAsignar.setnombre(tipofactura.getnombre());	
	}
	
	public static void inicializarTipoFactura(TipoFactura tipofactura) throws Exception {
		try {
				tipofactura.setId(0L);	
					
				tipofactura.setcodigo("");	
				tipofactura.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFacturaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFacturaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFactura(String sTipo,Row row,Workbook workbook,TipoFactura tipofactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofactura.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofactura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFactura() {
		return this.sFinalQueryTipoFactura;
	}
	
	public void setsFinalQueryTipoFactura(String sFinalQueryTipoFactura) {
		this.sFinalQueryTipoFactura= sFinalQueryTipoFactura;
	}
	
	public Border resaltarSeleccionarTipoFactura=null;
	
	public Border setResaltarSeleccionarTipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipofacturaBeanSwingJInternalFrame.jTtoolBarTipoFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFactura() {
		return this.resaltarSeleccionarTipoFactura;
	}
	
	public void setResaltarSeleccionarTipoFactura(Border borderResaltarSeleccionarTipoFactura) {
		this.resaltarSeleccionarTipoFactura= borderResaltarSeleccionarTipoFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFactura=null;
	public Boolean mostraridTipoFactura=true;
	public Boolean activaridTipoFactura=true;

	public Border resaltarcodigoTipoFactura=null;
	public Boolean mostrarcodigoTipoFactura=true;
	public Boolean activarcodigoTipoFactura=true;

	public Border resaltarnombreTipoFactura=null;
	public Boolean mostrarnombreTipoFactura=true;
	public Boolean activarnombreTipoFactura=true;

	
	

	public Border setResaltaridTipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturaBeanSwingJInternalFrame.jTtoolBarTipoFactura.setBorder(borderResaltar);
		
		this.resaltaridTipoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFactura() {
		return this.resaltaridTipoFactura;
	}

	public void setResaltaridTipoFactura(Border borderResaltar) {
		this.resaltaridTipoFactura= borderResaltar;
	}

	public Boolean getMostraridTipoFactura() {
		return this.mostraridTipoFactura;
	}

	public void setMostraridTipoFactura(Boolean mostraridTipoFactura) {
		this.mostraridTipoFactura= mostraridTipoFactura;
	}

	public Boolean getActivaridTipoFactura() {
		return this.activaridTipoFactura;
	}

	public void setActivaridTipoFactura(Boolean activaridTipoFactura) {
		this.activaridTipoFactura= activaridTipoFactura;
	}

	public Border setResaltarcodigoTipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturaBeanSwingJInternalFrame.jTtoolBarTipoFactura.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoFactura() {
		return this.resaltarcodigoTipoFactura;
	}

	public void setResaltarcodigoTipoFactura(Border borderResaltar) {
		this.resaltarcodigoTipoFactura= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoFactura() {
		return this.mostrarcodigoTipoFactura;
	}

	public void setMostrarcodigoTipoFactura(Boolean mostrarcodigoTipoFactura) {
		this.mostrarcodigoTipoFactura= mostrarcodigoTipoFactura;
	}

	public Boolean getActivarcodigoTipoFactura() {
		return this.activarcodigoTipoFactura;
	}

	public void setActivarcodigoTipoFactura(Boolean activarcodigoTipoFactura) {
		this.activarcodigoTipoFactura= activarcodigoTipoFactura;
	}

	public Border setResaltarnombreTipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturaBeanSwingJInternalFrame.jTtoolBarTipoFactura.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFactura() {
		return this.resaltarnombreTipoFactura;
	}

	public void setResaltarnombreTipoFactura(Border borderResaltar) {
		this.resaltarnombreTipoFactura= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFactura() {
		return this.mostrarnombreTipoFactura;
	}

	public void setMostrarnombreTipoFactura(Boolean mostrarnombreTipoFactura) {
		this.mostrarnombreTipoFactura= mostrarnombreTipoFactura;
	}

	public Boolean getActivarnombreTipoFactura() {
		return this.activarnombreTipoFactura;
	}

	public void setActivarnombreTipoFactura(Boolean activarnombreTipoFactura) {
		this.activarnombreTipoFactura= activarnombreTipoFactura;
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
		
		
		this.setMostraridTipoFactura(esInicial);
		this.setMostrarcodigoTipoFactura(esInicial);
		this.setMostrarnombreTipoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaConstantesFunciones.ID)) {
				this.setMostraridTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFactura(esAsigna);
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
		
		
		this.setActivaridTipoFactura(esInicial);
		this.setActivarcodigoTipoFactura(esInicial);
		this.setActivarnombreTipoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaConstantesFunciones.ID)) {
				this.setActivaridTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFactura(esInicial);
		this.setResaltarcodigoTipoFactura(esInicial);
		this.setResaltarnombreTipoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaConstantesFunciones.ID)) {
				this.setResaltaridTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFactura(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaTipoFactura=null;

	public Border getResaltarFacturaTipoFactura() {
		return this.resaltarFacturaTipoFactura;
	}

	public void setResaltarFacturaTipoFactura(Border borderResaltarFactura) {
		if(borderResaltarFactura!=null) {
			this.resaltarFacturaTipoFactura= borderResaltarFactura;
		}
	}

	public Border setResaltarFacturaTipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltarFactura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipofacturaBeanSwingJInternalFrame.jTtoolBarTipoFactura.setBorder(borderResaltarFactura);
			
		this.resaltarFacturaTipoFactura= borderResaltarFactura;

		 return borderResaltarFactura;
	}



	public Boolean mostrarFacturaTipoFactura=true;

	public Boolean getMostrarFacturaTipoFactura() {
		return this.mostrarFacturaTipoFactura;
	}

	public void setMostrarFacturaTipoFactura(Boolean visibilidadResaltarFactura) {
		this.mostrarFacturaTipoFactura= visibilidadResaltarFactura;
	}



	public Boolean activarFacturaTipoFactura=true;

	public Boolean gethabilitarResaltarFacturaTipoFactura() {
		return this.activarFacturaTipoFactura;
	}

	public void setActivarFacturaTipoFactura(Boolean habilitarResaltarFactura) {
		this.activarFacturaTipoFactura= habilitarResaltarFactura;
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

		this.setMostrarFacturaTipoFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setMostrarFacturaTipoFactura(esAsigna);
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

		this.setActivarFacturaTipoFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setActivarFacturaTipoFactura(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFacturaBeanSwingJInternalFrame tipofacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaTipoFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setResaltarFacturaTipoFactura(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}