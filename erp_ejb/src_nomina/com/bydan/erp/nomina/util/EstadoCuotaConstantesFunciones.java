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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EstadoCuotaConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoCuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoCuotaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoCuotaConstantesFunciones extends EstadoCuotaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoCuota";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoCuota"+EstadoCuotaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoCuotaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoCuotaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoCuotaConstantesFunciones.SCHEMA+"_"+EstadoCuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoCuotaConstantesFunciones.SCHEMA+"_"+EstadoCuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoCuotaConstantesFunciones.SCHEMA+"_"+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoCuotaConstantesFunciones.SCHEMA+"_"+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoCuotaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoCuotaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoCuotaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoCuotaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Cuotas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Cuota";
	public static final String SCLASSWEBTITULO_LOWER="Estado Cuota";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoCuota";
	public static final String OBJECTNAME="estadocuota";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_cuota";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadocuota from "+EstadoCuotaConstantesFunciones.SPERSISTENCENAME+" estadocuota";
	public static String QUERYSELECTNATIVE="select "+EstadoCuotaConstantesFunciones.SCHEMA+"."+EstadoCuotaConstantesFunciones.TABLENAME+".id,"+EstadoCuotaConstantesFunciones.SCHEMA+"."+EstadoCuotaConstantesFunciones.TABLENAME+".version_row,"+EstadoCuotaConstantesFunciones.SCHEMA+"."+EstadoCuotaConstantesFunciones.TABLENAME+".codigo,"+EstadoCuotaConstantesFunciones.SCHEMA+"."+EstadoCuotaConstantesFunciones.TABLENAME+".nombre from "+EstadoCuotaConstantesFunciones.SCHEMA+"."+EstadoCuotaConstantesFunciones.TABLENAME;//+" as "+EstadoCuotaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoCuotaConstantesFuncionesAdditional estadocuotaConstantesFuncionesAdditional=null;
	
	public EstadoCuotaConstantesFuncionesAdditional getEstadoCuotaConstantesFuncionesAdditional() {
		return this.estadocuotaConstantesFuncionesAdditional;
	}
	
	public void setEstadoCuotaConstantesFuncionesAdditional(EstadoCuotaConstantesFuncionesAdditional estadocuotaConstantesFuncionesAdditional) {
		try {
			this.estadocuotaConstantesFuncionesAdditional=estadocuotaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getEstadoCuotaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoCuotaConstantesFunciones.CODIGO)) {sLabelColumna=EstadoCuotaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoCuotaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoCuotaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoCuotaDescripcion(EstadoCuota estadocuota) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadocuota !=null/* && estadocuota.getId()!=0*/) {
			sDescripcion=estadocuota.getcodigo();//estadocuotaestadocuota.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoCuotaDescripcionDetallado(EstadoCuota estadocuota) {
		String sDescripcion="";
			
		sDescripcion+=EstadoCuotaConstantesFunciones.ID+"=";
		sDescripcion+=estadocuota.getId().toString()+",";
		sDescripcion+=EstadoCuotaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadocuota.getVersionRow().toString()+",";
		sDescripcion+=EstadoCuotaConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadocuota.getcodigo()+",";
		sDescripcion+=EstadoCuotaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadocuota.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoCuotaDescripcion(EstadoCuota estadocuota,String sValor) throws Exception {			
		if(estadocuota !=null) {
			estadocuota.setcodigo(sValor);;//estadocuotaestadocuota.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoCuota(EstadoCuota estadocuota,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadocuota.setcodigo(estadocuota.getcodigo().trim());
		estadocuota.setnombre(estadocuota.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoCuotas(List<EstadoCuota> estadocuotas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoCuota estadocuota: estadocuotas) {
			estadocuota.setcodigo(estadocuota.getcodigo().trim());
			estadocuota.setnombre(estadocuota.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCuota(EstadoCuota estadocuota,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadocuota.getConCambioAuxiliar()) {
			estadocuota.setIsDeleted(estadocuota.getIsDeletedAuxiliar());	
			estadocuota.setIsNew(estadocuota.getIsNewAuxiliar());	
			estadocuota.setIsChanged(estadocuota.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadocuota.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadocuota.setIsDeletedAuxiliar(false);	
			estadocuota.setIsNewAuxiliar(false);	
			estadocuota.setIsChangedAuxiliar(false);
			
			estadocuota.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCuotas(List<EstadoCuota> estadocuotas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoCuota estadocuota : estadocuotas) {
			if(conAsignarBase && estadocuota.getConCambioAuxiliar()) {
				estadocuota.setIsDeleted(estadocuota.getIsDeletedAuxiliar());	
				estadocuota.setIsNew(estadocuota.getIsNewAuxiliar());	
				estadocuota.setIsChanged(estadocuota.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadocuota.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadocuota.setIsDeletedAuxiliar(false);	
				estadocuota.setIsNewAuxiliar(false);	
				estadocuota.setIsChangedAuxiliar(false);
				
				estadocuota.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoCuota(EstadoCuota estadocuota,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoCuotas(List<EstadoCuota> estadocuotas,Boolean conEnteros) throws Exception  {
		
		for(EstadoCuota estadocuota: estadocuotas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoCuota(List<EstadoCuota> estadocuotas,EstadoCuota estadocuotaAux) throws Exception  {
		EstadoCuotaConstantesFunciones.InicializarValoresEstadoCuota(estadocuotaAux,true);
		
		for(EstadoCuota estadocuota: estadocuotas) {
			if(estadocuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoCuotaConstantesFunciones.getArrayColumnasGlobalesEstadoCuota(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCuota(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoCuota> estadocuotas,EstadoCuota estadocuota,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoCuota estadocuotaAux: estadocuotas) {
			if(estadocuotaAux!=null && estadocuota!=null) {
				if((estadocuotaAux.getId()==null && estadocuota.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadocuotaAux.getId()!=null && estadocuota.getId()!=null){
					if(estadocuotaAux.getId().equals(estadocuota.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoCuota(List<EstadoCuota> estadocuotas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoCuota estadocuota: estadocuotas) {			
			if(estadocuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoCuota() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoCuotaConstantesFunciones.LABEL_ID, EstadoCuotaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuotaConstantesFunciones.LABEL_VERSIONROW, EstadoCuotaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuotaConstantesFunciones.LABEL_CODIGO, EstadoCuotaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuotaConstantesFunciones.LABEL_NOMBRE, EstadoCuotaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoCuota() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoCuotaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuotaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuotaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuotaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuota() throws Exception  {
		return EstadoCuotaConstantesFunciones.getTiposSeleccionarEstadoCuota(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuota(Boolean conFk) throws Exception  {
		return EstadoCuotaConstantesFunciones.getTiposSeleccionarEstadoCuota(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuota(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCuotaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoCuotaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCuotaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoCuotaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoCuota(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCuota(EstadoCuota estadocuotaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCuota(List<EstadoCuota> estadocuotasTemp) throws Exception {
		for(EstadoCuota estadocuotaAux:estadocuotasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCuotaConstantesFunciones.getClassesRelationshipsOfEstadoCuota(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cuota.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cuota.class)) {
						classes.add(new Classe(Cuota.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCuotaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoCuota(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
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
	public static void actualizarLista(EstadoCuota estadocuota,List<EstadoCuota> estadocuotas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoCuota estadocuotaEncontrado=null;
			
			for(EstadoCuota estadocuotaLocal:estadocuotas) {
				if(estadocuotaLocal.getId().equals(estadocuota.getId())) {
					estadocuotaEncontrado=estadocuotaLocal;
					
					estadocuotaLocal.setIsChanged(estadocuota.getIsChanged());
					estadocuotaLocal.setIsNew(estadocuota.getIsNew());
					estadocuotaLocal.setIsDeleted(estadocuota.getIsDeleted());
					
					estadocuotaLocal.setGeneralEntityOriginal(estadocuota.getGeneralEntityOriginal());
					
					estadocuotaLocal.setId(estadocuota.getId());	
					estadocuotaLocal.setVersionRow(estadocuota.getVersionRow());	
					estadocuotaLocal.setcodigo(estadocuota.getcodigo());	
					estadocuotaLocal.setnombre(estadocuota.getnombre());	
					
					
					estadocuotaLocal.setCuotas(estadocuota.getCuotas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadocuota.getIsDeleted()) {
				if(!existe) {
					estadocuotas.add(estadocuota);
				}
			} else {
				if(estadocuotaEncontrado!=null && permiteQuitar)  {
					estadocuotas.remove(estadocuotaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoCuota estadocuota,List<EstadoCuota> estadocuotas) throws Exception {
		try	{			
			for(EstadoCuota estadocuotaLocal:estadocuotas) {
				if(estadocuotaLocal.getId().equals(estadocuota.getId())) {
					estadocuotaLocal.setIsSelected(estadocuota.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoCuota(List<EstadoCuota> estadocuotasAux) throws Exception {
		//this.estadocuotasAux=estadocuotasAux;
		
		for(EstadoCuota estadocuotaAux:estadocuotasAux) {
			if(estadocuotaAux.getIsChanged()) {
				estadocuotaAux.setIsChanged(false);
			}		
			
			if(estadocuotaAux.getIsNew()) {
				estadocuotaAux.setIsNew(false);
			}	
			
			if(estadocuotaAux.getIsDeleted()) {
				estadocuotaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoCuota(EstadoCuota estadocuotaAux) throws Exception {
		//this.estadocuotaAux=estadocuotaAux;
		
			if(estadocuotaAux.getIsChanged()) {
				estadocuotaAux.setIsChanged(false);
			}		
			
			if(estadocuotaAux.getIsNew()) {
				estadocuotaAux.setIsNew(false);
			}	
			
			if(estadocuotaAux.getIsDeleted()) {
				estadocuotaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoCuota estadocuotaAsignar,EstadoCuota estadocuota) throws Exception {
		estadocuotaAsignar.setId(estadocuota.getId());	
		estadocuotaAsignar.setVersionRow(estadocuota.getVersionRow());	
		estadocuotaAsignar.setcodigo(estadocuota.getcodigo());	
		estadocuotaAsignar.setnombre(estadocuota.getnombre());	
	}
	
	public static void inicializarEstadoCuota(EstadoCuota estadocuota) throws Exception {
		try {
				estadocuota.setId(0L);	
					
				estadocuota.setcodigo("");	
				estadocuota.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoCuota(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCuotaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCuotaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoCuota(String sTipo,Row row,Workbook workbook,EstadoCuota estadocuota,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocuota.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocuota.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoCuota=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoCuota() {
		return this.sFinalQueryEstadoCuota;
	}
	
	public void setsFinalQueryEstadoCuota(String sFinalQueryEstadoCuota) {
		this.sFinalQueryEstadoCuota= sFinalQueryEstadoCuota;
	}
	
	public Border resaltarSeleccionarEstadoCuota=null;
	
	public Border setResaltarSeleccionarEstadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadocuotaBeanSwingJInternalFrame.jTtoolBarEstadoCuota.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoCuota= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoCuota() {
		return this.resaltarSeleccionarEstadoCuota;
	}
	
	public void setResaltarSeleccionarEstadoCuota(Border borderResaltarSeleccionarEstadoCuota) {
		this.resaltarSeleccionarEstadoCuota= borderResaltarSeleccionarEstadoCuota;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoCuota=null;
	public Boolean mostraridEstadoCuota=true;
	public Boolean activaridEstadoCuota=true;

	public Border resaltarcodigoEstadoCuota=null;
	public Boolean mostrarcodigoEstadoCuota=true;
	public Boolean activarcodigoEstadoCuota=true;

	public Border resaltarnombreEstadoCuota=null;
	public Boolean mostrarnombreEstadoCuota=true;
	public Boolean activarnombreEstadoCuota=true;

	
	

	public Border setResaltaridEstadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuotaBeanSwingJInternalFrame.jTtoolBarEstadoCuota.setBorder(borderResaltar);
		
		this.resaltaridEstadoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoCuota() {
		return this.resaltaridEstadoCuota;
	}

	public void setResaltaridEstadoCuota(Border borderResaltar) {
		this.resaltaridEstadoCuota= borderResaltar;
	}

	public Boolean getMostraridEstadoCuota() {
		return this.mostraridEstadoCuota;
	}

	public void setMostraridEstadoCuota(Boolean mostraridEstadoCuota) {
		this.mostraridEstadoCuota= mostraridEstadoCuota;
	}

	public Boolean getActivaridEstadoCuota() {
		return this.activaridEstadoCuota;
	}

	public void setActivaridEstadoCuota(Boolean activaridEstadoCuota) {
		this.activaridEstadoCuota= activaridEstadoCuota;
	}

	public Border setResaltarcodigoEstadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuotaBeanSwingJInternalFrame.jTtoolBarEstadoCuota.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoCuota() {
		return this.resaltarcodigoEstadoCuota;
	}

	public void setResaltarcodigoEstadoCuota(Border borderResaltar) {
		this.resaltarcodigoEstadoCuota= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoCuota() {
		return this.mostrarcodigoEstadoCuota;
	}

	public void setMostrarcodigoEstadoCuota(Boolean mostrarcodigoEstadoCuota) {
		this.mostrarcodigoEstadoCuota= mostrarcodigoEstadoCuota;
	}

	public Boolean getActivarcodigoEstadoCuota() {
		return this.activarcodigoEstadoCuota;
	}

	public void setActivarcodigoEstadoCuota(Boolean activarcodigoEstadoCuota) {
		this.activarcodigoEstadoCuota= activarcodigoEstadoCuota;
	}

	public Border setResaltarnombreEstadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuotaBeanSwingJInternalFrame.jTtoolBarEstadoCuota.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoCuota() {
		return this.resaltarnombreEstadoCuota;
	}

	public void setResaltarnombreEstadoCuota(Border borderResaltar) {
		this.resaltarnombreEstadoCuota= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoCuota() {
		return this.mostrarnombreEstadoCuota;
	}

	public void setMostrarnombreEstadoCuota(Boolean mostrarnombreEstadoCuota) {
		this.mostrarnombreEstadoCuota= mostrarnombreEstadoCuota;
	}

	public Boolean getActivarnombreEstadoCuota() {
		return this.activarnombreEstadoCuota;
	}

	public void setActivarnombreEstadoCuota(Boolean activarnombreEstadoCuota) {
		this.activarnombreEstadoCuota= activarnombreEstadoCuota;
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
		
		
		this.setMostraridEstadoCuota(esInicial);
		this.setMostrarcodigoEstadoCuota(esInicial);
		this.setMostrarnombreEstadoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.ID)) {
				this.setMostraridEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoCuota(esAsigna);
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
		
		
		this.setActivaridEstadoCuota(esInicial);
		this.setActivarcodigoEstadoCuota(esInicial);
		this.setActivarnombreEstadoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.ID)) {
				this.setActivaridEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoCuota(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoCuota(esInicial);
		this.setResaltarcodigoEstadoCuota(esInicial);
		this.setResaltarnombreEstadoCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.ID)) {
				this.setResaltaridEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuotaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoCuota(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuotaEstadoCuota=null;

	public Border getResaltarCuotaEstadoCuota() {
		return this.resaltarCuotaEstadoCuota;
	}

	public void setResaltarCuotaEstadoCuota(Border borderResaltarCuota) {
		if(borderResaltarCuota!=null) {
			this.resaltarCuotaEstadoCuota= borderResaltarCuota;
		}
	}

	public Border setResaltarCuotaEstadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/) {
		Border borderResaltarCuota=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocuotaBeanSwingJInternalFrame.jTtoolBarEstadoCuota.setBorder(borderResaltarCuota);
			
		this.resaltarCuotaEstadoCuota= borderResaltarCuota;

		 return borderResaltarCuota;
	}



	public Boolean mostrarCuotaEstadoCuota=true;

	public Boolean getMostrarCuotaEstadoCuota() {
		return this.mostrarCuotaEstadoCuota;
	}

	public void setMostrarCuotaEstadoCuota(Boolean visibilidadResaltarCuota) {
		this.mostrarCuotaEstadoCuota= visibilidadResaltarCuota;
	}



	public Boolean activarCuotaEstadoCuota=true;

	public Boolean gethabilitarResaltarCuotaEstadoCuota() {
		return this.activarCuotaEstadoCuota;
	}

	public void setActivarCuotaEstadoCuota(Boolean habilitarResaltarCuota) {
		this.activarCuotaEstadoCuota= habilitarResaltarCuota;
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

		this.setMostrarCuotaEstadoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cuota.class)) {
				this.setMostrarCuotaEstadoCuota(esAsigna);
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

		this.setActivarCuotaEstadoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cuota.class)) {
				this.setActivarCuotaEstadoCuota(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCuotaBeanSwingJInternalFrame estadocuotaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuotaEstadoCuota(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cuota.class)) {
				this.setResaltarCuotaEstadoCuota(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}