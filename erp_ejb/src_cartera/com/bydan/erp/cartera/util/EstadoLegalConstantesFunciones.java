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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.EstadoLegalConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoLegalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoLegalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoLegalConstantesFunciones extends EstadoLegalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoLegal";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoLegal"+EstadoLegalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoLegalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoLegalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoLegalConstantesFunciones.SCHEMA+"_"+EstadoLegalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoLegalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoLegalConstantesFunciones.SCHEMA+"_"+EstadoLegalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoLegalConstantesFunciones.SCHEMA+"_"+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoLegalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoLegalConstantesFunciones.SCHEMA+"_"+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoLegalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoLegalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoLegalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoLegalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoLegalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoLegalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Legales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Legal";
	public static final String SCLASSWEBTITULO_LOWER="Estado Legal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoLegal";
	public static final String OBJECTNAME="estadolegal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="estado_legal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadolegal from "+EstadoLegalConstantesFunciones.SPERSISTENCENAME+" estadolegal";
	public static String QUERYSELECTNATIVE="select "+EstadoLegalConstantesFunciones.SCHEMA+"."+EstadoLegalConstantesFunciones.TABLENAME+".id,"+EstadoLegalConstantesFunciones.SCHEMA+"."+EstadoLegalConstantesFunciones.TABLENAME+".version_row,"+EstadoLegalConstantesFunciones.SCHEMA+"."+EstadoLegalConstantesFunciones.TABLENAME+".codigo,"+EstadoLegalConstantesFunciones.SCHEMA+"."+EstadoLegalConstantesFunciones.TABLENAME+".nombre from "+EstadoLegalConstantesFunciones.SCHEMA+"."+EstadoLegalConstantesFunciones.TABLENAME;//+" as "+EstadoLegalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoLegalConstantesFuncionesAdditional estadolegalConstantesFuncionesAdditional=null;
	
	public EstadoLegalConstantesFuncionesAdditional getEstadoLegalConstantesFuncionesAdditional() {
		return this.estadolegalConstantesFuncionesAdditional;
	}
	
	public void setEstadoLegalConstantesFuncionesAdditional(EstadoLegalConstantesFuncionesAdditional estadolegalConstantesFuncionesAdditional) {
		try {
			this.estadolegalConstantesFuncionesAdditional=estadolegalConstantesFuncionesAdditional;
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
	
	public static String getEstadoLegalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoLegalConstantesFunciones.CODIGO)) {sLabelColumna=EstadoLegalConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoLegalConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoLegalConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoLegalDescripcion(EstadoLegal estadolegal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadolegal !=null/* && estadolegal.getId()!=0*/) {
			sDescripcion=estadolegal.getcodigo();//estadolegalestadolegal.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoLegalDescripcionDetallado(EstadoLegal estadolegal) {
		String sDescripcion="";
			
		sDescripcion+=EstadoLegalConstantesFunciones.ID+"=";
		sDescripcion+=estadolegal.getId().toString()+",";
		sDescripcion+=EstadoLegalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadolegal.getVersionRow().toString()+",";
		sDescripcion+=EstadoLegalConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadolegal.getcodigo()+",";
		sDescripcion+=EstadoLegalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadolegal.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoLegalDescripcion(EstadoLegal estadolegal,String sValor) throws Exception {			
		if(estadolegal !=null) {
			estadolegal.setcodigo(sValor);;//estadolegalestadolegal.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoLegal(EstadoLegal estadolegal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadolegal.setcodigo(estadolegal.getcodigo().trim());
		estadolegal.setnombre(estadolegal.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoLegals(List<EstadoLegal> estadolegals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoLegal estadolegal: estadolegals) {
			estadolegal.setcodigo(estadolegal.getcodigo().trim());
			estadolegal.setnombre(estadolegal.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoLegal(EstadoLegal estadolegal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadolegal.getConCambioAuxiliar()) {
			estadolegal.setIsDeleted(estadolegal.getIsDeletedAuxiliar());	
			estadolegal.setIsNew(estadolegal.getIsNewAuxiliar());	
			estadolegal.setIsChanged(estadolegal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadolegal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadolegal.setIsDeletedAuxiliar(false);	
			estadolegal.setIsNewAuxiliar(false);	
			estadolegal.setIsChangedAuxiliar(false);
			
			estadolegal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoLegals(List<EstadoLegal> estadolegals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoLegal estadolegal : estadolegals) {
			if(conAsignarBase && estadolegal.getConCambioAuxiliar()) {
				estadolegal.setIsDeleted(estadolegal.getIsDeletedAuxiliar());	
				estadolegal.setIsNew(estadolegal.getIsNewAuxiliar());	
				estadolegal.setIsChanged(estadolegal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadolegal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadolegal.setIsDeletedAuxiliar(false);	
				estadolegal.setIsNewAuxiliar(false);	
				estadolegal.setIsChangedAuxiliar(false);
				
				estadolegal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoLegal(EstadoLegal estadolegal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoLegals(List<EstadoLegal> estadolegals,Boolean conEnteros) throws Exception  {
		
		for(EstadoLegal estadolegal: estadolegals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoLegal(List<EstadoLegal> estadolegals,EstadoLegal estadolegalAux) throws Exception  {
		EstadoLegalConstantesFunciones.InicializarValoresEstadoLegal(estadolegalAux,true);
		
		for(EstadoLegal estadolegal: estadolegals) {
			if(estadolegal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoLegal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoLegalConstantesFunciones.getArrayColumnasGlobalesEstadoLegal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoLegal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoLegal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoLegal> estadolegals,EstadoLegal estadolegal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoLegal estadolegalAux: estadolegals) {
			if(estadolegalAux!=null && estadolegal!=null) {
				if((estadolegalAux.getId()==null && estadolegal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadolegalAux.getId()!=null && estadolegal.getId()!=null){
					if(estadolegalAux.getId().equals(estadolegal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoLegal(List<EstadoLegal> estadolegals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoLegal estadolegal: estadolegals) {			
			if(estadolegal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoLegal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoLegalConstantesFunciones.LABEL_ID, EstadoLegalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoLegalConstantesFunciones.LABEL_VERSIONROW, EstadoLegalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoLegalConstantesFunciones.LABEL_CODIGO, EstadoLegalConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoLegalConstantesFunciones.LABEL_NOMBRE, EstadoLegalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoLegal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoLegalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoLegalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoLegalConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoLegalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoLegal() throws Exception  {
		return EstadoLegalConstantesFunciones.getTiposSeleccionarEstadoLegal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoLegal(Boolean conFk) throws Exception  {
		return EstadoLegalConstantesFunciones.getTiposSeleccionarEstadoLegal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoLegal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoLegalConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoLegalConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoLegalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoLegalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoLegal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoLegal(EstadoLegal estadolegalAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoLegal(List<EstadoLegal> estadolegalsTemp) throws Exception {
		for(EstadoLegal estadolegalAux:estadolegalsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoLegalConstantesFunciones.getClassesRelationshipsOfEstadoLegal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoLegalConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoLegal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
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
	public static void actualizarLista(EstadoLegal estadolegal,List<EstadoLegal> estadolegals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoLegal estadolegalEncontrado=null;
			
			for(EstadoLegal estadolegalLocal:estadolegals) {
				if(estadolegalLocal.getId().equals(estadolegal.getId())) {
					estadolegalEncontrado=estadolegalLocal;
					
					estadolegalLocal.setIsChanged(estadolegal.getIsChanged());
					estadolegalLocal.setIsNew(estadolegal.getIsNew());
					estadolegalLocal.setIsDeleted(estadolegal.getIsDeleted());
					
					estadolegalLocal.setGeneralEntityOriginal(estadolegal.getGeneralEntityOriginal());
					
					estadolegalLocal.setId(estadolegal.getId());	
					estadolegalLocal.setVersionRow(estadolegal.getVersionRow());	
					estadolegalLocal.setcodigo(estadolegal.getcodigo());	
					estadolegalLocal.setnombre(estadolegal.getnombre());	
					
					
					estadolegalLocal.setClientes(estadolegal.getClientes());
					estadolegalLocal.setSubClientes(estadolegal.getSubClientes());
					estadolegalLocal.setParametroCarteraDefectos(estadolegal.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadolegal.getIsDeleted()) {
				if(!existe) {
					estadolegals.add(estadolegal);
				}
			} else {
				if(estadolegalEncontrado!=null && permiteQuitar)  {
					estadolegals.remove(estadolegalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoLegal estadolegal,List<EstadoLegal> estadolegals) throws Exception {
		try	{			
			for(EstadoLegal estadolegalLocal:estadolegals) {
				if(estadolegalLocal.getId().equals(estadolegal.getId())) {
					estadolegalLocal.setIsSelected(estadolegal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoLegal(List<EstadoLegal> estadolegalsAux) throws Exception {
		//this.estadolegalsAux=estadolegalsAux;
		
		for(EstadoLegal estadolegalAux:estadolegalsAux) {
			if(estadolegalAux.getIsChanged()) {
				estadolegalAux.setIsChanged(false);
			}		
			
			if(estadolegalAux.getIsNew()) {
				estadolegalAux.setIsNew(false);
			}	
			
			if(estadolegalAux.getIsDeleted()) {
				estadolegalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoLegal(EstadoLegal estadolegalAux) throws Exception {
		//this.estadolegalAux=estadolegalAux;
		
			if(estadolegalAux.getIsChanged()) {
				estadolegalAux.setIsChanged(false);
			}		
			
			if(estadolegalAux.getIsNew()) {
				estadolegalAux.setIsNew(false);
			}	
			
			if(estadolegalAux.getIsDeleted()) {
				estadolegalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoLegal estadolegalAsignar,EstadoLegal estadolegal) throws Exception {
		estadolegalAsignar.setId(estadolegal.getId());	
		estadolegalAsignar.setVersionRow(estadolegal.getVersionRow());	
		estadolegalAsignar.setcodigo(estadolegal.getcodigo());	
		estadolegalAsignar.setnombre(estadolegal.getnombre());	
	}
	
	public static void inicializarEstadoLegal(EstadoLegal estadolegal) throws Exception {
		try {
				estadolegal.setId(0L);	
					
				estadolegal.setcodigo("");	
				estadolegal.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoLegal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoLegalConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoLegalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoLegal(String sTipo,Row row,Workbook workbook,EstadoLegal estadolegal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadolegal.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadolegal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoLegal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoLegal() {
		return this.sFinalQueryEstadoLegal;
	}
	
	public void setsFinalQueryEstadoLegal(String sFinalQueryEstadoLegal) {
		this.sFinalQueryEstadoLegal= sFinalQueryEstadoLegal;
	}
	
	public Border resaltarSeleccionarEstadoLegal=null;
	
	public Border setResaltarSeleccionarEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoLegal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoLegal() {
		return this.resaltarSeleccionarEstadoLegal;
	}
	
	public void setResaltarSeleccionarEstadoLegal(Border borderResaltarSeleccionarEstadoLegal) {
		this.resaltarSeleccionarEstadoLegal= borderResaltarSeleccionarEstadoLegal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoLegal=null;
	public Boolean mostraridEstadoLegal=true;
	public Boolean activaridEstadoLegal=true;

	public Border resaltarcodigoEstadoLegal=null;
	public Boolean mostrarcodigoEstadoLegal=true;
	public Boolean activarcodigoEstadoLegal=true;

	public Border resaltarnombreEstadoLegal=null;
	public Boolean mostrarnombreEstadoLegal=true;
	public Boolean activarnombreEstadoLegal=true;

	
	

	public Border setResaltaridEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltar);
		
		this.resaltaridEstadoLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoLegal() {
		return this.resaltaridEstadoLegal;
	}

	public void setResaltaridEstadoLegal(Border borderResaltar) {
		this.resaltaridEstadoLegal= borderResaltar;
	}

	public Boolean getMostraridEstadoLegal() {
		return this.mostraridEstadoLegal;
	}

	public void setMostraridEstadoLegal(Boolean mostraridEstadoLegal) {
		this.mostraridEstadoLegal= mostraridEstadoLegal;
	}

	public Boolean getActivaridEstadoLegal() {
		return this.activaridEstadoLegal;
	}

	public void setActivaridEstadoLegal(Boolean activaridEstadoLegal) {
		this.activaridEstadoLegal= activaridEstadoLegal;
	}

	public Border setResaltarcodigoEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoLegal() {
		return this.resaltarcodigoEstadoLegal;
	}

	public void setResaltarcodigoEstadoLegal(Border borderResaltar) {
		this.resaltarcodigoEstadoLegal= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoLegal() {
		return this.mostrarcodigoEstadoLegal;
	}

	public void setMostrarcodigoEstadoLegal(Boolean mostrarcodigoEstadoLegal) {
		this.mostrarcodigoEstadoLegal= mostrarcodigoEstadoLegal;
	}

	public Boolean getActivarcodigoEstadoLegal() {
		return this.activarcodigoEstadoLegal;
	}

	public void setActivarcodigoEstadoLegal(Boolean activarcodigoEstadoLegal) {
		this.activarcodigoEstadoLegal= activarcodigoEstadoLegal;
	}

	public Border setResaltarnombreEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoLegal() {
		return this.resaltarnombreEstadoLegal;
	}

	public void setResaltarnombreEstadoLegal(Border borderResaltar) {
		this.resaltarnombreEstadoLegal= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoLegal() {
		return this.mostrarnombreEstadoLegal;
	}

	public void setMostrarnombreEstadoLegal(Boolean mostrarnombreEstadoLegal) {
		this.mostrarnombreEstadoLegal= mostrarnombreEstadoLegal;
	}

	public Boolean getActivarnombreEstadoLegal() {
		return this.activarnombreEstadoLegal;
	}

	public void setActivarnombreEstadoLegal(Boolean activarnombreEstadoLegal) {
		this.activarnombreEstadoLegal= activarnombreEstadoLegal;
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
		
		
		this.setMostraridEstadoLegal(esInicial);
		this.setMostrarcodigoEstadoLegal(esInicial);
		this.setMostrarnombreEstadoLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoLegalConstantesFunciones.ID)) {
				this.setMostraridEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoLegal(esAsigna);
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
		
		
		this.setActivaridEstadoLegal(esInicial);
		this.setActivarcodigoEstadoLegal(esInicial);
		this.setActivarnombreEstadoLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoLegalConstantesFunciones.ID)) {
				this.setActivaridEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoLegal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoLegal(esInicial);
		this.setResaltarcodigoEstadoLegal(esInicial);
		this.setResaltarnombreEstadoLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoLegalConstantesFunciones.ID)) {
				this.setResaltaridEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoLegalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoLegal(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteEstadoLegal=null;

	public Border getResaltarClienteEstadoLegal() {
		return this.resaltarClienteEstadoLegal;
	}

	public void setResaltarClienteEstadoLegal(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteEstadoLegal= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltarCliente);
			
		this.resaltarClienteEstadoLegal= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteEstadoLegal=true;

	public Boolean getMostrarClienteEstadoLegal() {
		return this.mostrarClienteEstadoLegal;
	}

	public void setMostrarClienteEstadoLegal(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteEstadoLegal= visibilidadResaltarCliente;
	}



	public Boolean activarClienteEstadoLegal=true;

	public Boolean gethabilitarResaltarClienteEstadoLegal() {
		return this.activarClienteEstadoLegal;
	}

	public void setActivarClienteEstadoLegal(Boolean habilitarResaltarCliente) {
		this.activarClienteEstadoLegal= habilitarResaltarCliente;
	}


	public Border resaltarSubClienteEstadoLegal=null;

	public Border getResaltarSubClienteEstadoLegal() {
		return this.resaltarSubClienteEstadoLegal;
	}

	public void setResaltarSubClienteEstadoLegal(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteEstadoLegal= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteEstadoLegal= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteEstadoLegal=true;

	public Boolean getMostrarSubClienteEstadoLegal() {
		return this.mostrarSubClienteEstadoLegal;
	}

	public void setMostrarSubClienteEstadoLegal(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteEstadoLegal= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteEstadoLegal=true;

	public Boolean gethabilitarResaltarSubClienteEstadoLegal() {
		return this.activarSubClienteEstadoLegal;
	}

	public void setActivarSubClienteEstadoLegal(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteEstadoLegal= habilitarResaltarSubCliente;
	}


	public Border resaltarParametroCarteraDefectoEstadoLegal=null;

	public Border getResaltarParametroCarteraDefectoEstadoLegal() {
		return this.resaltarParametroCarteraDefectoEstadoLegal;
	}

	public void setResaltarParametroCarteraDefectoEstadoLegal(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoEstadoLegal= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoEstadoLegal(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadolegalBeanSwingJInternalFrame.jTtoolBarEstadoLegal.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoEstadoLegal= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoEstadoLegal=true;

	public Boolean getMostrarParametroCarteraDefectoEstadoLegal() {
		return this.mostrarParametroCarteraDefectoEstadoLegal;
	}

	public void setMostrarParametroCarteraDefectoEstadoLegal(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoEstadoLegal= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoEstadoLegal=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoEstadoLegal() {
		return this.activarParametroCarteraDefectoEstadoLegal;
	}

	public void setActivarParametroCarteraDefectoEstadoLegal(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoEstadoLegal= habilitarResaltarParametroCarteraDefecto;
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

		this.setMostrarClienteEstadoLegal(esInicial);
		this.setMostrarSubClienteEstadoLegal(esInicial);
		this.setMostrarParametroCarteraDefectoEstadoLegal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoEstadoLegal(esAsigna);
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

		this.setActivarClienteEstadoLegal(esInicial);
		this.setActivarSubClienteEstadoLegal(esInicial);
		this.setActivarParametroCarteraDefectoEstadoLegal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoEstadoLegal(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoLegalBeanSwingJInternalFrame estadolegalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteEstadoLegal(esInicial);
		this.setResaltarSubClienteEstadoLegal(esInicial);
		this.setResaltarParametroCarteraDefectoEstadoLegal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteEstadoLegal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoEstadoLegal(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}