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


import com.bydan.erp.cartera.util.EstadoPoliticasClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoPoliticasClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoPoliticasClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoPoliticasClienteConstantesFunciones extends EstadoPoliticasClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPoliticasCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPoliticasCliente"+EstadoPoliticasClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPoliticasClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPoliticasClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPoliticasClienteConstantesFunciones.SCHEMA+"_"+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPoliticasClienteConstantesFunciones.SCHEMA+"_"+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPoliticasClienteConstantesFunciones.SCHEMA+"_"+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPoliticasClienteConstantesFunciones.SCHEMA+"_"+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPoliticasClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPoliticasClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPoliticasClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPoliticasClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Politicas Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Politicas Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Estado Politicas Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPoliticasCliente";
	public static final String OBJECTNAME="estadopoliticascliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="estado_politicas_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadopoliticascliente from "+EstadoPoliticasClienteConstantesFunciones.SPERSISTENCENAME+" estadopoliticascliente";
	public static String QUERYSELECTNATIVE="select "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".id,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME;//+" as "+EstadoPoliticasClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoPoliticasClienteConstantesFuncionesAdditional estadopoliticasclienteConstantesFuncionesAdditional=null;
	
	public EstadoPoliticasClienteConstantesFuncionesAdditional getEstadoPoliticasClienteConstantesFuncionesAdditional() {
		return this.estadopoliticasclienteConstantesFuncionesAdditional;
	}
	
	public void setEstadoPoliticasClienteConstantesFuncionesAdditional(EstadoPoliticasClienteConstantesFuncionesAdditional estadopoliticasclienteConstantesFuncionesAdditional) {
		try {
			this.estadopoliticasclienteConstantesFuncionesAdditional=estadopoliticasclienteConstantesFuncionesAdditional;
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
	
	public static String getEstadoPoliticasClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPoliticasClienteConstantesFunciones.CODIGO)) {sLabelColumna=EstadoPoliticasClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoPoliticasClienteConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPoliticasClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoPoliticasClienteDescripcion(EstadoPoliticasCliente estadopoliticascliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadopoliticascliente !=null/* && estadopoliticascliente.getId()!=0*/) {
			sDescripcion=estadopoliticascliente.getcodigo();//estadopoliticasclienteestadopoliticascliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPoliticasClienteDescripcionDetallado(EstadoPoliticasCliente estadopoliticascliente) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPoliticasClienteConstantesFunciones.ID+"=";
		sDescripcion+=estadopoliticascliente.getId().toString()+",";
		sDescripcion+=EstadoPoliticasClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadopoliticascliente.getVersionRow().toString()+",";
		sDescripcion+=EstadoPoliticasClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadopoliticascliente.getcodigo()+",";
		sDescripcion+=EstadoPoliticasClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadopoliticascliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPoliticasClienteDescripcion(EstadoPoliticasCliente estadopoliticascliente,String sValor) throws Exception {			
		if(estadopoliticascliente !=null) {
			estadopoliticascliente.setcodigo(sValor);;//estadopoliticasclienteestadopoliticascliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadopoliticascliente.setcodigo(estadopoliticascliente.getcodigo().trim());
		estadopoliticascliente.setnombre(estadopoliticascliente.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPoliticasClientes(List<EstadoPoliticasCliente> estadopoliticasclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPoliticasCliente estadopoliticascliente: estadopoliticasclientes) {
			estadopoliticascliente.setcodigo(estadopoliticascliente.getcodigo().trim());
			estadopoliticascliente.setnombre(estadopoliticascliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadopoliticascliente.getConCambioAuxiliar()) {
			estadopoliticascliente.setIsDeleted(estadopoliticascliente.getIsDeletedAuxiliar());	
			estadopoliticascliente.setIsNew(estadopoliticascliente.getIsNewAuxiliar());	
			estadopoliticascliente.setIsChanged(estadopoliticascliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadopoliticascliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadopoliticascliente.setIsDeletedAuxiliar(false);	
			estadopoliticascliente.setIsNewAuxiliar(false);	
			estadopoliticascliente.setIsChangedAuxiliar(false);
			
			estadopoliticascliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPoliticasClientes(List<EstadoPoliticasCliente> estadopoliticasclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPoliticasCliente estadopoliticascliente : estadopoliticasclientes) {
			if(conAsignarBase && estadopoliticascliente.getConCambioAuxiliar()) {
				estadopoliticascliente.setIsDeleted(estadopoliticascliente.getIsDeletedAuxiliar());	
				estadopoliticascliente.setIsNew(estadopoliticascliente.getIsNewAuxiliar());	
				estadopoliticascliente.setIsChanged(estadopoliticascliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadopoliticascliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadopoliticascliente.setIsDeletedAuxiliar(false);	
				estadopoliticascliente.setIsNewAuxiliar(false);	
				estadopoliticascliente.setIsChangedAuxiliar(false);
				
				estadopoliticascliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPoliticasClientes(List<EstadoPoliticasCliente> estadopoliticasclientes,Boolean conEnteros) throws Exception  {
		
		for(EstadoPoliticasCliente estadopoliticascliente: estadopoliticasclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPoliticasCliente(List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasCliente estadopoliticasclienteAux) throws Exception  {
		EstadoPoliticasClienteConstantesFunciones.InicializarValoresEstadoPoliticasCliente(estadopoliticasclienteAux,true);
		
		for(EstadoPoliticasCliente estadopoliticascliente: estadopoliticasclientes) {
			if(estadopoliticascliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPoliticasClienteConstantesFunciones.getArrayColumnasGlobalesEstadoPoliticasCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPoliticasCliente> estadopoliticasclientes,EstadoPoliticasCliente estadopoliticascliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPoliticasCliente estadopoliticasclienteAux: estadopoliticasclientes) {
			if(estadopoliticasclienteAux!=null && estadopoliticascliente!=null) {
				if((estadopoliticasclienteAux.getId()==null && estadopoliticascliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadopoliticasclienteAux.getId()!=null && estadopoliticascliente.getId()!=null){
					if(estadopoliticasclienteAux.getId().equals(estadopoliticascliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPoliticasCliente(List<EstadoPoliticasCliente> estadopoliticasclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPoliticasCliente estadopoliticascliente: estadopoliticasclientes) {			
			if(estadopoliticascliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPoliticasCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPoliticasClienteConstantesFunciones.LABEL_ID, EstadoPoliticasClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPoliticasClienteConstantesFunciones.LABEL_VERSIONROW, EstadoPoliticasClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPoliticasClienteConstantesFunciones.LABEL_CODIGO, EstadoPoliticasClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPoliticasClienteConstantesFunciones.LABEL_NOMBRE, EstadoPoliticasClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPoliticasCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPoliticasClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPoliticasClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPoliticasClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPoliticasClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPoliticasCliente() throws Exception  {
		return EstadoPoliticasClienteConstantesFunciones.getTiposSeleccionarEstadoPoliticasCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPoliticasCliente(Boolean conFk) throws Exception  {
		return EstadoPoliticasClienteConstantesFunciones.getTiposSeleccionarEstadoPoliticasCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPoliticasCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPoliticasClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoPoliticasClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPoliticasClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPoliticasClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPoliticasCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticasclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPoliticasCliente(List<EstadoPoliticasCliente> estadopoliticasclientesTemp) throws Exception {
		for(EstadoPoliticasCliente estadopoliticasclienteAux:estadopoliticasclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPoliticasClienteConstantesFunciones.getClassesRelationshipsOfEstadoPoliticasCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PoliticasCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPoliticasClienteConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPoliticasCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
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
	public static void actualizarLista(EstadoPoliticasCliente estadopoliticascliente,List<EstadoPoliticasCliente> estadopoliticasclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPoliticasCliente estadopoliticasclienteEncontrado=null;
			
			for(EstadoPoliticasCliente estadopoliticasclienteLocal:estadopoliticasclientes) {
				if(estadopoliticasclienteLocal.getId().equals(estadopoliticascliente.getId())) {
					estadopoliticasclienteEncontrado=estadopoliticasclienteLocal;
					
					estadopoliticasclienteLocal.setIsChanged(estadopoliticascliente.getIsChanged());
					estadopoliticasclienteLocal.setIsNew(estadopoliticascliente.getIsNew());
					estadopoliticasclienteLocal.setIsDeleted(estadopoliticascliente.getIsDeleted());
					
					estadopoliticasclienteLocal.setGeneralEntityOriginal(estadopoliticascliente.getGeneralEntityOriginal());
					
					estadopoliticasclienteLocal.setId(estadopoliticascliente.getId());	
					estadopoliticasclienteLocal.setVersionRow(estadopoliticascliente.getVersionRow());	
					estadopoliticasclienteLocal.setcodigo(estadopoliticascliente.getcodigo());	
					estadopoliticasclienteLocal.setnombre(estadopoliticascliente.getnombre());	
					
					
					estadopoliticasclienteLocal.setPoliticasClientes(estadopoliticascliente.getPoliticasClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!estadopoliticascliente.getIsDeleted()) {
				if(!existe) {
					estadopoliticasclientes.add(estadopoliticascliente);
				}
			} else {
				if(estadopoliticasclienteEncontrado!=null && permiteQuitar)  {
					estadopoliticasclientes.remove(estadopoliticasclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPoliticasCliente estadopoliticascliente,List<EstadoPoliticasCliente> estadopoliticasclientes) throws Exception {
		try	{			
			for(EstadoPoliticasCliente estadopoliticasclienteLocal:estadopoliticasclientes) {
				if(estadopoliticasclienteLocal.getId().equals(estadopoliticascliente.getId())) {
					estadopoliticasclienteLocal.setIsSelected(estadopoliticascliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPoliticasCliente(List<EstadoPoliticasCliente> estadopoliticasclientesAux) throws Exception {
		//this.estadopoliticasclientesAux=estadopoliticasclientesAux;
		
		for(EstadoPoliticasCliente estadopoliticasclienteAux:estadopoliticasclientesAux) {
			if(estadopoliticasclienteAux.getIsChanged()) {
				estadopoliticasclienteAux.setIsChanged(false);
			}		
			
			if(estadopoliticasclienteAux.getIsNew()) {
				estadopoliticasclienteAux.setIsNew(false);
			}	
			
			if(estadopoliticasclienteAux.getIsDeleted()) {
				estadopoliticasclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticasclienteAux) throws Exception {
		//this.estadopoliticasclienteAux=estadopoliticasclienteAux;
		
			if(estadopoliticasclienteAux.getIsChanged()) {
				estadopoliticasclienteAux.setIsChanged(false);
			}		
			
			if(estadopoliticasclienteAux.getIsNew()) {
				estadopoliticasclienteAux.setIsNew(false);
			}	
			
			if(estadopoliticasclienteAux.getIsDeleted()) {
				estadopoliticasclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPoliticasCliente estadopoliticasclienteAsignar,EstadoPoliticasCliente estadopoliticascliente) throws Exception {
		estadopoliticasclienteAsignar.setId(estadopoliticascliente.getId());	
		estadopoliticasclienteAsignar.setVersionRow(estadopoliticascliente.getVersionRow());	
		estadopoliticasclienteAsignar.setcodigo(estadopoliticascliente.getcodigo());	
		estadopoliticasclienteAsignar.setnombre(estadopoliticascliente.getnombre());	
	}
	
	public static void inicializarEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente) throws Exception {
		try {
				estadopoliticascliente.setId(0L);	
					
				estadopoliticascliente.setcodigo("");	
				estadopoliticascliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPoliticasCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPoliticasClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPoliticasClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPoliticasCliente(String sTipo,Row row,Workbook workbook,EstadoPoliticasCliente estadopoliticascliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopoliticascliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopoliticascliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPoliticasCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPoliticasCliente() {
		return this.sFinalQueryEstadoPoliticasCliente;
	}
	
	public void setsFinalQueryEstadoPoliticasCliente(String sFinalQueryEstadoPoliticasCliente) {
		this.sFinalQueryEstadoPoliticasCliente= sFinalQueryEstadoPoliticasCliente;
	}
	
	public Border resaltarSeleccionarEstadoPoliticasCliente=null;
	
	public Border setResaltarSeleccionarEstadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadopoliticasclienteBeanSwingJInternalFrame.jTtoolBarEstadoPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPoliticasCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPoliticasCliente() {
		return this.resaltarSeleccionarEstadoPoliticasCliente;
	}
	
	public void setResaltarSeleccionarEstadoPoliticasCliente(Border borderResaltarSeleccionarEstadoPoliticasCliente) {
		this.resaltarSeleccionarEstadoPoliticasCliente= borderResaltarSeleccionarEstadoPoliticasCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPoliticasCliente=null;
	public Boolean mostraridEstadoPoliticasCliente=true;
	public Boolean activaridEstadoPoliticasCliente=true;

	public Border resaltarcodigoEstadoPoliticasCliente=null;
	public Boolean mostrarcodigoEstadoPoliticasCliente=true;
	public Boolean activarcodigoEstadoPoliticasCliente=true;

	public Border resaltarnombreEstadoPoliticasCliente=null;
	public Boolean mostrarnombreEstadoPoliticasCliente=true;
	public Boolean activarnombreEstadoPoliticasCliente=true;

	
	

	public Border setResaltaridEstadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopoliticasclienteBeanSwingJInternalFrame.jTtoolBarEstadoPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltaridEstadoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPoliticasCliente() {
		return this.resaltaridEstadoPoliticasCliente;
	}

	public void setResaltaridEstadoPoliticasCliente(Border borderResaltar) {
		this.resaltaridEstadoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostraridEstadoPoliticasCliente() {
		return this.mostraridEstadoPoliticasCliente;
	}

	public void setMostraridEstadoPoliticasCliente(Boolean mostraridEstadoPoliticasCliente) {
		this.mostraridEstadoPoliticasCliente= mostraridEstadoPoliticasCliente;
	}

	public Boolean getActivaridEstadoPoliticasCliente() {
		return this.activaridEstadoPoliticasCliente;
	}

	public void setActivaridEstadoPoliticasCliente(Boolean activaridEstadoPoliticasCliente) {
		this.activaridEstadoPoliticasCliente= activaridEstadoPoliticasCliente;
	}

	public Border setResaltarcodigoEstadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopoliticasclienteBeanSwingJInternalFrame.jTtoolBarEstadoPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoPoliticasCliente() {
		return this.resaltarcodigoEstadoPoliticasCliente;
	}

	public void setResaltarcodigoEstadoPoliticasCliente(Border borderResaltar) {
		this.resaltarcodigoEstadoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoPoliticasCliente() {
		return this.mostrarcodigoEstadoPoliticasCliente;
	}

	public void setMostrarcodigoEstadoPoliticasCliente(Boolean mostrarcodigoEstadoPoliticasCliente) {
		this.mostrarcodigoEstadoPoliticasCliente= mostrarcodigoEstadoPoliticasCliente;
	}

	public Boolean getActivarcodigoEstadoPoliticasCliente() {
		return this.activarcodigoEstadoPoliticasCliente;
	}

	public void setActivarcodigoEstadoPoliticasCliente(Boolean activarcodigoEstadoPoliticasCliente) {
		this.activarcodigoEstadoPoliticasCliente= activarcodigoEstadoPoliticasCliente;
	}

	public Border setResaltarnombreEstadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopoliticasclienteBeanSwingJInternalFrame.jTtoolBarEstadoPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPoliticasCliente() {
		return this.resaltarnombreEstadoPoliticasCliente;
	}

	public void setResaltarnombreEstadoPoliticasCliente(Border borderResaltar) {
		this.resaltarnombreEstadoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPoliticasCliente() {
		return this.mostrarnombreEstadoPoliticasCliente;
	}

	public void setMostrarnombreEstadoPoliticasCliente(Boolean mostrarnombreEstadoPoliticasCliente) {
		this.mostrarnombreEstadoPoliticasCliente= mostrarnombreEstadoPoliticasCliente;
	}

	public Boolean getActivarnombreEstadoPoliticasCliente() {
		return this.activarnombreEstadoPoliticasCliente;
	}

	public void setActivarnombreEstadoPoliticasCliente(Boolean activarnombreEstadoPoliticasCliente) {
		this.activarnombreEstadoPoliticasCliente= activarnombreEstadoPoliticasCliente;
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
		
		
		this.setMostraridEstadoPoliticasCliente(esInicial);
		this.setMostrarcodigoEstadoPoliticasCliente(esInicial);
		this.setMostrarnombreEstadoPoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.ID)) {
				this.setMostraridEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPoliticasCliente(esAsigna);
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
		
		
		this.setActivaridEstadoPoliticasCliente(esInicial);
		this.setActivarcodigoEstadoPoliticasCliente(esInicial);
		this.setActivarnombreEstadoPoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.ID)) {
				this.setActivaridEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPoliticasCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPoliticasCliente(esInicial);
		this.setResaltarcodigoEstadoPoliticasCliente(esInicial);
		this.setResaltarnombreEstadoPoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.ID)) {
				this.setResaltaridEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPoliticasClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPoliticasCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPoliticasClienteEstadoPoliticasCliente=null;

	public Border getResaltarPoliticasClienteEstadoPoliticasCliente() {
		return this.resaltarPoliticasClienteEstadoPoliticasCliente;
	}

	public void setResaltarPoliticasClienteEstadoPoliticasCliente(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteEstadoPoliticasCliente= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteEstadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadopoliticasclienteBeanSwingJInternalFrame.jTtoolBarEstadoPoliticasCliente.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteEstadoPoliticasCliente= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteEstadoPoliticasCliente=true;

	public Boolean getMostrarPoliticasClienteEstadoPoliticasCliente() {
		return this.mostrarPoliticasClienteEstadoPoliticasCliente;
	}

	public void setMostrarPoliticasClienteEstadoPoliticasCliente(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteEstadoPoliticasCliente= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteEstadoPoliticasCliente=true;

	public Boolean gethabilitarResaltarPoliticasClienteEstadoPoliticasCliente() {
		return this.activarPoliticasClienteEstadoPoliticasCliente;
	}

	public void setActivarPoliticasClienteEstadoPoliticasCliente(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteEstadoPoliticasCliente= habilitarResaltarPoliticasCliente;
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

		this.setMostrarPoliticasClienteEstadoPoliticasCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteEstadoPoliticasCliente(esAsigna);
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

		this.setActivarPoliticasClienteEstadoPoliticasCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteEstadoPoliticasCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPoliticasClienteBeanSwingJInternalFrame estadopoliticasclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPoliticasClienteEstadoPoliticasCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteEstadoPoliticasCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}