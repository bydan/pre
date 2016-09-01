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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.EstadoDepreActiConstantesFunciones;
import com.bydan.erp.activosfijos.util.EstadoDepreActiParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.EstadoDepreActiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDepreActiConstantesFunciones extends EstadoDepreActiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDepreActi";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDepreActi"+EstadoDepreActiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDepreActiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDepreActiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDepreActiConstantesFunciones.SCHEMA+"_"+EstadoDepreActiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDepreActiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDepreActiConstantesFunciones.SCHEMA+"_"+EstadoDepreActiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDepreActiConstantesFunciones.SCHEMA+"_"+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDepreActiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDepreActiConstantesFunciones.SCHEMA+"_"+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDepreActiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDepreActiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDepreActiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDepreActiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDepreActiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDepreActiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDepreActiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Depre Actis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Depre Acti";
	public static final String SCLASSWEBTITULO_LOWER="Estado Depre Acti";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDepreActi";
	public static final String OBJECTNAME="estadodepreacti";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="estado_depre_acti";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodepreacti from "+EstadoDepreActiConstantesFunciones.SPERSISTENCENAME+" estadodepreacti";
	public static String QUERYSELECTNATIVE="select "+EstadoDepreActiConstantesFunciones.SCHEMA+"."+EstadoDepreActiConstantesFunciones.TABLENAME+".id,"+EstadoDepreActiConstantesFunciones.SCHEMA+"."+EstadoDepreActiConstantesFunciones.TABLENAME+".version_row,"+EstadoDepreActiConstantesFunciones.SCHEMA+"."+EstadoDepreActiConstantesFunciones.TABLENAME+".codigo,"+EstadoDepreActiConstantesFunciones.SCHEMA+"."+EstadoDepreActiConstantesFunciones.TABLENAME+".nombre from "+EstadoDepreActiConstantesFunciones.SCHEMA+"."+EstadoDepreActiConstantesFunciones.TABLENAME;//+" as "+EstadoDepreActiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDepreActiConstantesFuncionesAdditional estadodepreactiConstantesFuncionesAdditional=null;
	
	public EstadoDepreActiConstantesFuncionesAdditional getEstadoDepreActiConstantesFuncionesAdditional() {
		return this.estadodepreactiConstantesFuncionesAdditional;
	}
	
	public void setEstadoDepreActiConstantesFuncionesAdditional(EstadoDepreActiConstantesFuncionesAdditional estadodepreactiConstantesFuncionesAdditional) {
		try {
			this.estadodepreactiConstantesFuncionesAdditional=estadodepreactiConstantesFuncionesAdditional;
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
	
	public static String getEstadoDepreActiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDepreActiConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDepreActiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDepreActiConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDepreActiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDepreActiDescripcion(EstadoDepreActi estadodepreacti) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodepreacti !=null/* && estadodepreacti.getId()!=0*/) {
			sDescripcion=estadodepreacti.getcodigo();//estadodepreactiestadodepreacti.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDepreActiDescripcionDetallado(EstadoDepreActi estadodepreacti) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDepreActiConstantesFunciones.ID+"=";
		sDescripcion+=estadodepreacti.getId().toString()+",";
		sDescripcion+=EstadoDepreActiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodepreacti.getVersionRow().toString()+",";
		sDescripcion+=EstadoDepreActiConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodepreacti.getcodigo()+",";
		sDescripcion+=EstadoDepreActiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodepreacti.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDepreActiDescripcion(EstadoDepreActi estadodepreacti,String sValor) throws Exception {			
		if(estadodepreacti !=null) {
			estadodepreacti.setcodigo(sValor);;//estadodepreactiestadodepreacti.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDepreActi(EstadoDepreActi estadodepreacti,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodepreacti.setcodigo(estadodepreacti.getcodigo().trim());
		estadodepreacti.setnombre(estadodepreacti.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDepreActis(List<EstadoDepreActi> estadodepreactis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDepreActi estadodepreacti: estadodepreactis) {
			estadodepreacti.setcodigo(estadodepreacti.getcodigo().trim());
			estadodepreacti.setnombre(estadodepreacti.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDepreActi(EstadoDepreActi estadodepreacti,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodepreacti.getConCambioAuxiliar()) {
			estadodepreacti.setIsDeleted(estadodepreacti.getIsDeletedAuxiliar());	
			estadodepreacti.setIsNew(estadodepreacti.getIsNewAuxiliar());	
			estadodepreacti.setIsChanged(estadodepreacti.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodepreacti.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodepreacti.setIsDeletedAuxiliar(false);	
			estadodepreacti.setIsNewAuxiliar(false);	
			estadodepreacti.setIsChangedAuxiliar(false);
			
			estadodepreacti.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDepreActis(List<EstadoDepreActi> estadodepreactis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDepreActi estadodepreacti : estadodepreactis) {
			if(conAsignarBase && estadodepreacti.getConCambioAuxiliar()) {
				estadodepreacti.setIsDeleted(estadodepreacti.getIsDeletedAuxiliar());	
				estadodepreacti.setIsNew(estadodepreacti.getIsNewAuxiliar());	
				estadodepreacti.setIsChanged(estadodepreacti.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodepreacti.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodepreacti.setIsDeletedAuxiliar(false);	
				estadodepreacti.setIsNewAuxiliar(false);	
				estadodepreacti.setIsChangedAuxiliar(false);
				
				estadodepreacti.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDepreActi(EstadoDepreActi estadodepreacti,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDepreActis(List<EstadoDepreActi> estadodepreactis,Boolean conEnteros) throws Exception  {
		
		for(EstadoDepreActi estadodepreacti: estadodepreactis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDepreActi(List<EstadoDepreActi> estadodepreactis,EstadoDepreActi estadodepreactiAux) throws Exception  {
		EstadoDepreActiConstantesFunciones.InicializarValoresEstadoDepreActi(estadodepreactiAux,true);
		
		for(EstadoDepreActi estadodepreacti: estadodepreactis) {
			if(estadodepreacti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDepreActi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDepreActiConstantesFunciones.getArrayColumnasGlobalesEstadoDepreActi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDepreActi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDepreActi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDepreActi> estadodepreactis,EstadoDepreActi estadodepreacti,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDepreActi estadodepreactiAux: estadodepreactis) {
			if(estadodepreactiAux!=null && estadodepreacti!=null) {
				if((estadodepreactiAux.getId()==null && estadodepreacti.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodepreactiAux.getId()!=null && estadodepreacti.getId()!=null){
					if(estadodepreactiAux.getId().equals(estadodepreacti.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDepreActi(List<EstadoDepreActi> estadodepreactis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDepreActi estadodepreacti: estadodepreactis) {			
			if(estadodepreacti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDepreActi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDepreActiConstantesFunciones.LABEL_ID, EstadoDepreActiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDepreActiConstantesFunciones.LABEL_VERSIONROW, EstadoDepreActiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDepreActiConstantesFunciones.LABEL_CODIGO, EstadoDepreActiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDepreActiConstantesFunciones.LABEL_NOMBRE, EstadoDepreActiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDepreActi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDepreActiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDepreActiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDepreActiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDepreActiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDepreActi() throws Exception  {
		return EstadoDepreActiConstantesFunciones.getTiposSeleccionarEstadoDepreActi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDepreActi(Boolean conFk) throws Exception  {
		return EstadoDepreActiConstantesFunciones.getTiposSeleccionarEstadoDepreActi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDepreActi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDepreActiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDepreActiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDepreActiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDepreActiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDepreActi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDepreActi(EstadoDepreActi estadodepreactiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDepreActi(List<EstadoDepreActi> estadodepreactisTemp) throws Exception {
		for(EstadoDepreActi estadodepreactiAux:estadodepreactisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDepreActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDepreActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDepreActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDepreActiConstantesFunciones.getClassesRelationshipsOfEstadoDepreActi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDepreActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DepreciacionActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DepreciacionActivoFijo.class)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDepreActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDepreActiConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDepreActi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDepreActi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
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
	public static void actualizarLista(EstadoDepreActi estadodepreacti,List<EstadoDepreActi> estadodepreactis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDepreActi estadodepreactiEncontrado=null;
			
			for(EstadoDepreActi estadodepreactiLocal:estadodepreactis) {
				if(estadodepreactiLocal.getId().equals(estadodepreacti.getId())) {
					estadodepreactiEncontrado=estadodepreactiLocal;
					
					estadodepreactiLocal.setIsChanged(estadodepreacti.getIsChanged());
					estadodepreactiLocal.setIsNew(estadodepreacti.getIsNew());
					estadodepreactiLocal.setIsDeleted(estadodepreacti.getIsDeleted());
					
					estadodepreactiLocal.setGeneralEntityOriginal(estadodepreacti.getGeneralEntityOriginal());
					
					estadodepreactiLocal.setId(estadodepreacti.getId());	
					estadodepreactiLocal.setVersionRow(estadodepreacti.getVersionRow());	
					estadodepreactiLocal.setcodigo(estadodepreacti.getcodigo());	
					estadodepreactiLocal.setnombre(estadodepreacti.getnombre());	
					
					
					estadodepreactiLocal.setDepreciacionActivoFijos(estadodepreacti.getDepreciacionActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodepreacti.getIsDeleted()) {
				if(!existe) {
					estadodepreactis.add(estadodepreacti);
				}
			} else {
				if(estadodepreactiEncontrado!=null && permiteQuitar)  {
					estadodepreactis.remove(estadodepreactiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDepreActi estadodepreacti,List<EstadoDepreActi> estadodepreactis) throws Exception {
		try	{			
			for(EstadoDepreActi estadodepreactiLocal:estadodepreactis) {
				if(estadodepreactiLocal.getId().equals(estadodepreacti.getId())) {
					estadodepreactiLocal.setIsSelected(estadodepreacti.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDepreActi(List<EstadoDepreActi> estadodepreactisAux) throws Exception {
		//this.estadodepreactisAux=estadodepreactisAux;
		
		for(EstadoDepreActi estadodepreactiAux:estadodepreactisAux) {
			if(estadodepreactiAux.getIsChanged()) {
				estadodepreactiAux.setIsChanged(false);
			}		
			
			if(estadodepreactiAux.getIsNew()) {
				estadodepreactiAux.setIsNew(false);
			}	
			
			if(estadodepreactiAux.getIsDeleted()) {
				estadodepreactiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDepreActi(EstadoDepreActi estadodepreactiAux) throws Exception {
		//this.estadodepreactiAux=estadodepreactiAux;
		
			if(estadodepreactiAux.getIsChanged()) {
				estadodepreactiAux.setIsChanged(false);
			}		
			
			if(estadodepreactiAux.getIsNew()) {
				estadodepreactiAux.setIsNew(false);
			}	
			
			if(estadodepreactiAux.getIsDeleted()) {
				estadodepreactiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDepreActi estadodepreactiAsignar,EstadoDepreActi estadodepreacti) throws Exception {
		estadodepreactiAsignar.setId(estadodepreacti.getId());	
		estadodepreactiAsignar.setVersionRow(estadodepreacti.getVersionRow());	
		estadodepreactiAsignar.setcodigo(estadodepreacti.getcodigo());	
		estadodepreactiAsignar.setnombre(estadodepreacti.getnombre());	
	}
	
	public static void inicializarEstadoDepreActi(EstadoDepreActi estadodepreacti) throws Exception {
		try {
				estadodepreacti.setId(0L);	
					
				estadodepreacti.setcodigo("");	
				estadodepreacti.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDepreActi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDepreActiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDepreActiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDepreActi(String sTipo,Row row,Workbook workbook,EstadoDepreActi estadodepreacti,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodepreacti.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodepreacti.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDepreActi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDepreActi() {
		return this.sFinalQueryEstadoDepreActi;
	}
	
	public void setsFinalQueryEstadoDepreActi(String sFinalQueryEstadoDepreActi) {
		this.sFinalQueryEstadoDepreActi= sFinalQueryEstadoDepreActi;
	}
	
	public Border resaltarSeleccionarEstadoDepreActi=null;
	
	public Border setResaltarSeleccionarEstadoDepreActi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodepreactiBeanSwingJInternalFrame.jTtoolBarEstadoDepreActi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDepreActi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDepreActi() {
		return this.resaltarSeleccionarEstadoDepreActi;
	}
	
	public void setResaltarSeleccionarEstadoDepreActi(Border borderResaltarSeleccionarEstadoDepreActi) {
		this.resaltarSeleccionarEstadoDepreActi= borderResaltarSeleccionarEstadoDepreActi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDepreActi=null;
	public Boolean mostraridEstadoDepreActi=true;
	public Boolean activaridEstadoDepreActi=true;

	public Border resaltarcodigoEstadoDepreActi=null;
	public Boolean mostrarcodigoEstadoDepreActi=true;
	public Boolean activarcodigoEstadoDepreActi=true;

	public Border resaltarnombreEstadoDepreActi=null;
	public Boolean mostrarnombreEstadoDepreActi=true;
	public Boolean activarnombreEstadoDepreActi=true;

	
	

	public Border setResaltaridEstadoDepreActi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodepreactiBeanSwingJInternalFrame.jTtoolBarEstadoDepreActi.setBorder(borderResaltar);
		
		this.resaltaridEstadoDepreActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDepreActi() {
		return this.resaltaridEstadoDepreActi;
	}

	public void setResaltaridEstadoDepreActi(Border borderResaltar) {
		this.resaltaridEstadoDepreActi= borderResaltar;
	}

	public Boolean getMostraridEstadoDepreActi() {
		return this.mostraridEstadoDepreActi;
	}

	public void setMostraridEstadoDepreActi(Boolean mostraridEstadoDepreActi) {
		this.mostraridEstadoDepreActi= mostraridEstadoDepreActi;
	}

	public Boolean getActivaridEstadoDepreActi() {
		return this.activaridEstadoDepreActi;
	}

	public void setActivaridEstadoDepreActi(Boolean activaridEstadoDepreActi) {
		this.activaridEstadoDepreActi= activaridEstadoDepreActi;
	}

	public Border setResaltarcodigoEstadoDepreActi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodepreactiBeanSwingJInternalFrame.jTtoolBarEstadoDepreActi.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDepreActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDepreActi() {
		return this.resaltarcodigoEstadoDepreActi;
	}

	public void setResaltarcodigoEstadoDepreActi(Border borderResaltar) {
		this.resaltarcodigoEstadoDepreActi= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDepreActi() {
		return this.mostrarcodigoEstadoDepreActi;
	}

	public void setMostrarcodigoEstadoDepreActi(Boolean mostrarcodigoEstadoDepreActi) {
		this.mostrarcodigoEstadoDepreActi= mostrarcodigoEstadoDepreActi;
	}

	public Boolean getActivarcodigoEstadoDepreActi() {
		return this.activarcodigoEstadoDepreActi;
	}

	public void setActivarcodigoEstadoDepreActi(Boolean activarcodigoEstadoDepreActi) {
		this.activarcodigoEstadoDepreActi= activarcodigoEstadoDepreActi;
	}

	public Border setResaltarnombreEstadoDepreActi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodepreactiBeanSwingJInternalFrame.jTtoolBarEstadoDepreActi.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDepreActi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDepreActi() {
		return this.resaltarnombreEstadoDepreActi;
	}

	public void setResaltarnombreEstadoDepreActi(Border borderResaltar) {
		this.resaltarnombreEstadoDepreActi= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDepreActi() {
		return this.mostrarnombreEstadoDepreActi;
	}

	public void setMostrarnombreEstadoDepreActi(Boolean mostrarnombreEstadoDepreActi) {
		this.mostrarnombreEstadoDepreActi= mostrarnombreEstadoDepreActi;
	}

	public Boolean getActivarnombreEstadoDepreActi() {
		return this.activarnombreEstadoDepreActi;
	}

	public void setActivarnombreEstadoDepreActi(Boolean activarnombreEstadoDepreActi) {
		this.activarnombreEstadoDepreActi= activarnombreEstadoDepreActi;
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
		
		
		this.setMostraridEstadoDepreActi(esInicial);
		this.setMostrarcodigoEstadoDepreActi(esInicial);
		this.setMostrarnombreEstadoDepreActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.ID)) {
				this.setMostraridEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDepreActi(esAsigna);
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
		
		
		this.setActivaridEstadoDepreActi(esInicial);
		this.setActivarcodigoEstadoDepreActi(esInicial);
		this.setActivarnombreEstadoDepreActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.ID)) {
				this.setActivaridEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDepreActi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDepreActi(esInicial);
		this.setResaltarcodigoEstadoDepreActi(esInicial);
		this.setResaltarnombreEstadoDepreActi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.ID)) {
				this.setResaltaridEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDepreActi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDepreActiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDepreActi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDepreciacionActivoFijoEstadoDepreActi=null;

	public Border getResaltarDepreciacionActivoFijoEstadoDepreActi() {
		return this.resaltarDepreciacionActivoFijoEstadoDepreActi;
	}

	public void setResaltarDepreciacionActivoFijoEstadoDepreActi(Border borderResaltarDepreciacionActivoFijo) {
		if(borderResaltarDepreciacionActivoFijo!=null) {
			this.resaltarDepreciacionActivoFijoEstadoDepreActi= borderResaltarDepreciacionActivoFijo;
		}
	}

	public Border setResaltarDepreciacionActivoFijoEstadoDepreActi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/) {
		Border borderResaltarDepreciacionActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodepreactiBeanSwingJInternalFrame.jTtoolBarEstadoDepreActi.setBorder(borderResaltarDepreciacionActivoFijo);
			
		this.resaltarDepreciacionActivoFijoEstadoDepreActi= borderResaltarDepreciacionActivoFijo;

		 return borderResaltarDepreciacionActivoFijo;
	}



	public Boolean mostrarDepreciacionActivoFijoEstadoDepreActi=true;

	public Boolean getMostrarDepreciacionActivoFijoEstadoDepreActi() {
		return this.mostrarDepreciacionActivoFijoEstadoDepreActi;
	}

	public void setMostrarDepreciacionActivoFijoEstadoDepreActi(Boolean visibilidadResaltarDepreciacionActivoFijo) {
		this.mostrarDepreciacionActivoFijoEstadoDepreActi= visibilidadResaltarDepreciacionActivoFijo;
	}



	public Boolean activarDepreciacionActivoFijoEstadoDepreActi=true;

	public Boolean gethabilitarResaltarDepreciacionActivoFijoEstadoDepreActi() {
		return this.activarDepreciacionActivoFijoEstadoDepreActi;
	}

	public void setActivarDepreciacionActivoFijoEstadoDepreActi(Boolean habilitarResaltarDepreciacionActivoFijo) {
		this.activarDepreciacionActivoFijoEstadoDepreActi= habilitarResaltarDepreciacionActivoFijo;
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

		this.setMostrarDepreciacionActivoFijoEstadoDepreActi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setMostrarDepreciacionActivoFijoEstadoDepreActi(esAsigna);
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

		this.setActivarDepreciacionActivoFijoEstadoDepreActi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setActivarDepreciacionActivoFijoEstadoDepreActi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDepreActiBeanSwingJInternalFrame estadodepreactiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDepreciacionActivoFijoEstadoDepreActi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setResaltarDepreciacionActivoFijoEstadoDepreActi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}