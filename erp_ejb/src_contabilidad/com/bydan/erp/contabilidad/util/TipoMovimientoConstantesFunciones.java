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


import com.bydan.erp.contabilidad.util.TipoMovimientoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoMovimientoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoMovimientoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMovimientoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMovimiento";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMovimiento"+TipoMovimientoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMovimientoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMovimientoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMovimientoConstantesFunciones.SCHEMA+"_"+TipoMovimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMovimientoConstantesFunciones.SCHEMA+"_"+TipoMovimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMovimientoConstantesFunciones.SCHEMA+"_"+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMovimientoConstantesFunciones.SCHEMA+"_"+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMovimientoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMovimientoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMovimientoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMovimientoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Movimientos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Movimiento";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Movimiento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMovimiento";
	public static final String OBJECTNAME="tipomovimiento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_movimiento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomovimiento from "+TipoMovimientoConstantesFunciones.SPERSISTENCENAME+" tipomovimiento";
	public static String QUERYSELECTNATIVE="select "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".id,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".codigo,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoMovimientoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMovimientoConstantesFunciones.CODIGO)) {sLabelColumna=TipoMovimientoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMovimientoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMovimientoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomovimiento !=null/* && tipomovimiento.getId()!=0*/) {
			sDescripcion=tipomovimiento.getnombre();//tipomovimientotipomovimiento.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMovimientoDescripcionDetallado(TipoMovimiento tipomovimiento) {
		String sDescripcion="";
			
		sDescripcion+=TipoMovimientoConstantesFunciones.ID+"=";
		sDescripcion+=tipomovimiento.getId().toString()+",";
		sDescripcion+=TipoMovimientoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomovimiento.getVersionRow().toString()+",";
		sDescripcion+=TipoMovimientoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomovimiento.getcodigo()+",";
		sDescripcion+=TipoMovimientoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomovimiento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMovimientoDescripcion(TipoMovimiento tipomovimiento,String sValor) throws Exception {			
		if(tipomovimiento !=null) {
			tipomovimiento.setnombre(sValor);;//tipomovimientotipomovimiento.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMovimiento(TipoMovimiento tipomovimiento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomovimiento.setcodigo(tipomovimiento.getcodigo().trim());
		tipomovimiento.setnombre(tipomovimiento.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoMovimientos(List<TipoMovimiento> tipomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMovimiento tipomovimiento: tipomovimientos) {
			tipomovimiento.setcodigo(tipomovimiento.getcodigo().trim());
			tipomovimiento.setnombre(tipomovimiento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimiento(TipoMovimiento tipomovimiento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomovimiento.getConCambioAuxiliar()) {
			tipomovimiento.setIsDeleted(tipomovimiento.getIsDeletedAuxiliar());	
			tipomovimiento.setIsNew(tipomovimiento.getIsNewAuxiliar());	
			tipomovimiento.setIsChanged(tipomovimiento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomovimiento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomovimiento.setIsDeletedAuxiliar(false);	
			tipomovimiento.setIsNewAuxiliar(false);	
			tipomovimiento.setIsChangedAuxiliar(false);
			
			tipomovimiento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimientos(List<TipoMovimiento> tipomovimientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMovimiento tipomovimiento : tipomovimientos) {
			if(conAsignarBase && tipomovimiento.getConCambioAuxiliar()) {
				tipomovimiento.setIsDeleted(tipomovimiento.getIsDeletedAuxiliar());	
				tipomovimiento.setIsNew(tipomovimiento.getIsNewAuxiliar());	
				tipomovimiento.setIsChanged(tipomovimiento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomovimiento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomovimiento.setIsDeletedAuxiliar(false);	
				tipomovimiento.setIsNewAuxiliar(false);	
				tipomovimiento.setIsChangedAuxiliar(false);
				
				tipomovimiento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMovimiento(TipoMovimiento tipomovimiento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMovimientos(List<TipoMovimiento> tipomovimientos,Boolean conEnteros) throws Exception  {
		
		for(TipoMovimiento tipomovimiento: tipomovimientos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMovimiento(List<TipoMovimiento> tipomovimientos,TipoMovimiento tipomovimientoAux) throws Exception  {
		TipoMovimientoConstantesFunciones.InicializarValoresTipoMovimiento(tipomovimientoAux,true);
		
		for(TipoMovimiento tipomovimiento: tipomovimientos) {
			if(tipomovimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMovimientoConstantesFunciones.getArrayColumnasGlobalesTipoMovimiento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimiento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMovimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMovimiento> tipomovimientos,TipoMovimiento tipomovimiento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMovimiento tipomovimientoAux: tipomovimientos) {
			if(tipomovimientoAux!=null && tipomovimiento!=null) {
				if((tipomovimientoAux.getId()==null && tipomovimiento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomovimientoAux.getId()!=null && tipomovimiento.getId()!=null){
					if(tipomovimientoAux.getId().equals(tipomovimiento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMovimiento(List<TipoMovimiento> tipomovimientos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMovimiento tipomovimiento: tipomovimientos) {			
			if(tipomovimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMovimiento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMovimientoConstantesFunciones.LABEL_ID, TipoMovimientoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoConstantesFunciones.LABEL_VERSIONROW, TipoMovimientoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoConstantesFunciones.LABEL_CODIGO, TipoMovimientoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoConstantesFunciones.LABEL_NOMBRE, TipoMovimientoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMovimiento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento() throws Exception  {
		return TipoMovimientoConstantesFunciones.getTiposSeleccionarTipoMovimiento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento(Boolean conFk) throws Exception  {
		return TipoMovimientoConstantesFunciones.getTiposSeleccionarTipoMovimiento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimientoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMovimientoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimientoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMovimientoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMovimiento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimiento(TipoMovimiento tipomovimientoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimiento(List<TipoMovimiento> tipomovimientosTemp) throws Exception {
		for(TipoMovimiento tipomovimientoAux:tipomovimientosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMovimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMovimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimientoConstantesFunciones.getClassesRelationshipsOfTipoMovimiento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimientoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMovimiento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoMovimiento tipomovimiento,List<TipoMovimiento> tipomovimientos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMovimiento tipomovimientoEncontrado=null;
			
			for(TipoMovimiento tipomovimientoLocal:tipomovimientos) {
				if(tipomovimientoLocal.getId().equals(tipomovimiento.getId())) {
					tipomovimientoEncontrado=tipomovimientoLocal;
					
					tipomovimientoLocal.setIsChanged(tipomovimiento.getIsChanged());
					tipomovimientoLocal.setIsNew(tipomovimiento.getIsNew());
					tipomovimientoLocal.setIsDeleted(tipomovimiento.getIsDeleted());
					
					tipomovimientoLocal.setGeneralEntityOriginal(tipomovimiento.getGeneralEntityOriginal());
					
					tipomovimientoLocal.setId(tipomovimiento.getId());	
					tipomovimientoLocal.setVersionRow(tipomovimiento.getVersionRow());	
					tipomovimientoLocal.setcodigo(tipomovimiento.getcodigo());	
					tipomovimientoLocal.setnombre(tipomovimiento.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomovimiento.getIsDeleted()) {
				if(!existe) {
					tipomovimientos.add(tipomovimiento);
				}
			} else {
				if(tipomovimientoEncontrado!=null && permiteQuitar)  {
					tipomovimientos.remove(tipomovimientoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMovimiento tipomovimiento,List<TipoMovimiento> tipomovimientos) throws Exception {
		try	{			
			for(TipoMovimiento tipomovimientoLocal:tipomovimientos) {
				if(tipomovimientoLocal.getId().equals(tipomovimiento.getId())) {
					tipomovimientoLocal.setIsSelected(tipomovimiento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMovimiento(List<TipoMovimiento> tipomovimientosAux) throws Exception {
		//this.tipomovimientosAux=tipomovimientosAux;
		
		for(TipoMovimiento tipomovimientoAux:tipomovimientosAux) {
			if(tipomovimientoAux.getIsChanged()) {
				tipomovimientoAux.setIsChanged(false);
			}		
			
			if(tipomovimientoAux.getIsNew()) {
				tipomovimientoAux.setIsNew(false);
			}	
			
			if(tipomovimientoAux.getIsDeleted()) {
				tipomovimientoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMovimiento(TipoMovimiento tipomovimientoAux) throws Exception {
		//this.tipomovimientoAux=tipomovimientoAux;
		
			if(tipomovimientoAux.getIsChanged()) {
				tipomovimientoAux.setIsChanged(false);
			}		
			
			if(tipomovimientoAux.getIsNew()) {
				tipomovimientoAux.setIsNew(false);
			}	
			
			if(tipomovimientoAux.getIsDeleted()) {
				tipomovimientoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMovimiento tipomovimientoAsignar,TipoMovimiento tipomovimiento) throws Exception {
		tipomovimientoAsignar.setId(tipomovimiento.getId());	
		tipomovimientoAsignar.setVersionRow(tipomovimiento.getVersionRow());	
		tipomovimientoAsignar.setcodigo(tipomovimiento.getcodigo());	
		tipomovimientoAsignar.setnombre(tipomovimiento.getnombre());	
	}
	
	public static void inicializarTipoMovimiento(TipoMovimiento tipomovimiento) throws Exception {
		try {
				tipomovimiento.setId(0L);	
					
				tipomovimiento.setcodigo("");	
				tipomovimiento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMovimiento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimientoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimientoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMovimiento(String sTipo,Row row,Workbook workbook,TipoMovimiento tipomovimiento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimiento.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimiento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMovimiento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMovimiento() {
		return this.sFinalQueryTipoMovimiento;
	}
	
	public void setsFinalQueryTipoMovimiento(String sFinalQueryTipoMovimiento) {
		this.sFinalQueryTipoMovimiento= sFinalQueryTipoMovimiento;
	}
	
	public Border resaltarSeleccionarTipoMovimiento=null;
	
	public Border setResaltarSeleccionarTipoMovimiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomovimientoBeanSwingJInternalFrame.jTtoolBarTipoMovimiento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMovimiento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMovimiento() {
		return this.resaltarSeleccionarTipoMovimiento;
	}
	
	public void setResaltarSeleccionarTipoMovimiento(Border borderResaltarSeleccionarTipoMovimiento) {
		this.resaltarSeleccionarTipoMovimiento= borderResaltarSeleccionarTipoMovimiento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMovimiento=null;
	public Boolean mostraridTipoMovimiento=true;
	public Boolean activaridTipoMovimiento=true;

	public Border resaltarcodigoTipoMovimiento=null;
	public Boolean mostrarcodigoTipoMovimiento=true;
	public Boolean activarcodigoTipoMovimiento=true;

	public Border resaltarnombreTipoMovimiento=null;
	public Boolean mostrarnombreTipoMovimiento=true;
	public Boolean activarnombreTipoMovimiento=true;

	
	

	public Border setResaltaridTipoMovimiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientoBeanSwingJInternalFrame.jTtoolBarTipoMovimiento.setBorder(borderResaltar);
		
		this.resaltaridTipoMovimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMovimiento() {
		return this.resaltaridTipoMovimiento;
	}

	public void setResaltaridTipoMovimiento(Border borderResaltar) {
		this.resaltaridTipoMovimiento= borderResaltar;
	}

	public Boolean getMostraridTipoMovimiento() {
		return this.mostraridTipoMovimiento;
	}

	public void setMostraridTipoMovimiento(Boolean mostraridTipoMovimiento) {
		this.mostraridTipoMovimiento= mostraridTipoMovimiento;
	}

	public Boolean getActivaridTipoMovimiento() {
		return this.activaridTipoMovimiento;
	}

	public void setActivaridTipoMovimiento(Boolean activaridTipoMovimiento) {
		this.activaridTipoMovimiento= activaridTipoMovimiento;
	}

	public Border setResaltarcodigoTipoMovimiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientoBeanSwingJInternalFrame.jTtoolBarTipoMovimiento.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMovimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMovimiento() {
		return this.resaltarcodigoTipoMovimiento;
	}

	public void setResaltarcodigoTipoMovimiento(Border borderResaltar) {
		this.resaltarcodigoTipoMovimiento= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMovimiento() {
		return this.mostrarcodigoTipoMovimiento;
	}

	public void setMostrarcodigoTipoMovimiento(Boolean mostrarcodigoTipoMovimiento) {
		this.mostrarcodigoTipoMovimiento= mostrarcodigoTipoMovimiento;
	}

	public Boolean getActivarcodigoTipoMovimiento() {
		return this.activarcodigoTipoMovimiento;
	}

	public void setActivarcodigoTipoMovimiento(Boolean activarcodigoTipoMovimiento) {
		this.activarcodigoTipoMovimiento= activarcodigoTipoMovimiento;
	}

	public Border setResaltarnombreTipoMovimiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientoBeanSwingJInternalFrame.jTtoolBarTipoMovimiento.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMovimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMovimiento() {
		return this.resaltarnombreTipoMovimiento;
	}

	public void setResaltarnombreTipoMovimiento(Border borderResaltar) {
		this.resaltarnombreTipoMovimiento= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMovimiento() {
		return this.mostrarnombreTipoMovimiento;
	}

	public void setMostrarnombreTipoMovimiento(Boolean mostrarnombreTipoMovimiento) {
		this.mostrarnombreTipoMovimiento= mostrarnombreTipoMovimiento;
	}

	public Boolean getActivarnombreTipoMovimiento() {
		return this.activarnombreTipoMovimiento;
	}

	public void setActivarnombreTipoMovimiento(Boolean activarnombreTipoMovimiento) {
		this.activarnombreTipoMovimiento= activarnombreTipoMovimiento;
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
		
		
		this.setMostraridTipoMovimiento(esInicial);
		this.setMostrarcodigoTipoMovimiento(esInicial);
		this.setMostrarnombreTipoMovimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.ID)) {
				this.setMostraridTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMovimiento(esAsigna);
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
		
		
		this.setActivaridTipoMovimiento(esInicial);
		this.setActivarcodigoTipoMovimiento(esInicial);
		this.setActivarnombreTipoMovimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.ID)) {
				this.setActivaridTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMovimiento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMovimiento(esInicial);
		this.setResaltarcodigoTipoMovimiento(esInicial);
		this.setResaltarnombreTipoMovimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.ID)) {
				this.setResaltaridTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMovimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMovimiento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimientoBeanSwingJInternalFrame tipomovimientoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}