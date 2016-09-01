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


import com.bydan.erp.cartera.util.EstadoGarantiaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoGarantiaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoGarantiaClienteParameterGeneral;

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
final public class EstadoGarantiaClienteConstantesFunciones extends EstadoGarantiaClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoGarantiaCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoGarantiaCliente"+EstadoGarantiaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoGarantiaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoGarantiaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoGarantiaClienteConstantesFunciones.SCHEMA+"_"+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoGarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoGarantiaClienteConstantesFunciones.SCHEMA+"_"+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoGarantiaClienteConstantesFunciones.SCHEMA+"_"+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoGarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoGarantiaClienteConstantesFunciones.SCHEMA+"_"+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoGarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoGarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoGarantiaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoGarantiaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoGarantiaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoGarantiaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Garantia Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Garantia Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Estado Garantia Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoGarantiaCliente";
	public static final String OBJECTNAME="estadogarantiacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="estado_garantia_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadogarantiacliente from "+EstadoGarantiaClienteConstantesFunciones.SPERSISTENCENAME+" estadogarantiacliente";
	public static String QUERYSELECTNATIVE="select "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".id,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME;//+" as "+EstadoGarantiaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoGarantiaClienteConstantesFuncionesAdditional estadogarantiaclienteConstantesFuncionesAdditional=null;
	
	public EstadoGarantiaClienteConstantesFuncionesAdditional getEstadoGarantiaClienteConstantesFuncionesAdditional() {
		return this.estadogarantiaclienteConstantesFuncionesAdditional;
	}
	
	public void setEstadoGarantiaClienteConstantesFuncionesAdditional(EstadoGarantiaClienteConstantesFuncionesAdditional estadogarantiaclienteConstantesFuncionesAdditional) {
		try {
			this.estadogarantiaclienteConstantesFuncionesAdditional=estadogarantiaclienteConstantesFuncionesAdditional;
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
	
	public static String getEstadoGarantiaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoGarantiaClienteConstantesFunciones.CODIGO)) {sLabelColumna=EstadoGarantiaClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoGarantiaClienteConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoGarantiaClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoGarantiaClienteDescripcion(EstadoGarantiaCliente estadogarantiacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadogarantiacliente !=null/* && estadogarantiacliente.getId()!=0*/) {
			sDescripcion=estadogarantiacliente.getcodigo();//estadogarantiaclienteestadogarantiacliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoGarantiaClienteDescripcionDetallado(EstadoGarantiaCliente estadogarantiacliente) {
		String sDescripcion="";
			
		sDescripcion+=EstadoGarantiaClienteConstantesFunciones.ID+"=";
		sDescripcion+=estadogarantiacliente.getId().toString()+",";
		sDescripcion+=EstadoGarantiaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadogarantiacliente.getVersionRow().toString()+",";
		sDescripcion+=EstadoGarantiaClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadogarantiacliente.getcodigo()+",";
		sDescripcion+=EstadoGarantiaClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadogarantiacliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoGarantiaClienteDescripcion(EstadoGarantiaCliente estadogarantiacliente,String sValor) throws Exception {			
		if(estadogarantiacliente !=null) {
			estadogarantiacliente.setcodigo(sValor);;//estadogarantiaclienteestadogarantiacliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadogarantiacliente.setcodigo(estadogarantiacliente.getcodigo().trim());
		estadogarantiacliente.setnombre(estadogarantiacliente.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoGarantiaClientes(List<EstadoGarantiaCliente> estadogarantiaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoGarantiaCliente estadogarantiacliente: estadogarantiaclientes) {
			estadogarantiacliente.setcodigo(estadogarantiacliente.getcodigo().trim());
			estadogarantiacliente.setnombre(estadogarantiacliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadogarantiacliente.getConCambioAuxiliar()) {
			estadogarantiacliente.setIsDeleted(estadogarantiacliente.getIsDeletedAuxiliar());	
			estadogarantiacliente.setIsNew(estadogarantiacliente.getIsNewAuxiliar());	
			estadogarantiacliente.setIsChanged(estadogarantiacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadogarantiacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadogarantiacliente.setIsDeletedAuxiliar(false);	
			estadogarantiacliente.setIsNewAuxiliar(false);	
			estadogarantiacliente.setIsChangedAuxiliar(false);
			
			estadogarantiacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoGarantiaClientes(List<EstadoGarantiaCliente> estadogarantiaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoGarantiaCliente estadogarantiacliente : estadogarantiaclientes) {
			if(conAsignarBase && estadogarantiacliente.getConCambioAuxiliar()) {
				estadogarantiacliente.setIsDeleted(estadogarantiacliente.getIsDeletedAuxiliar());	
				estadogarantiacliente.setIsNew(estadogarantiacliente.getIsNewAuxiliar());	
				estadogarantiacliente.setIsChanged(estadogarantiacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadogarantiacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadogarantiacliente.setIsDeletedAuxiliar(false);	
				estadogarantiacliente.setIsNewAuxiliar(false);	
				estadogarantiacliente.setIsChangedAuxiliar(false);
				
				estadogarantiacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoGarantiaClientes(List<EstadoGarantiaCliente> estadogarantiaclientes,Boolean conEnteros) throws Exception  {
		
		for(EstadoGarantiaCliente estadogarantiacliente: estadogarantiaclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoGarantiaCliente(List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaCliente estadogarantiaclienteAux) throws Exception  {
		EstadoGarantiaClienteConstantesFunciones.InicializarValoresEstadoGarantiaCliente(estadogarantiaclienteAux,true);
		
		for(EstadoGarantiaCliente estadogarantiacliente: estadogarantiaclientes) {
			if(estadogarantiacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoGarantiaClienteConstantesFunciones.getArrayColumnasGlobalesEstadoGarantiaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoGarantiaCliente> estadogarantiaclientes,EstadoGarantiaCliente estadogarantiacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoGarantiaCliente estadogarantiaclienteAux: estadogarantiaclientes) {
			if(estadogarantiaclienteAux!=null && estadogarantiacliente!=null) {
				if((estadogarantiaclienteAux.getId()==null && estadogarantiacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadogarantiaclienteAux.getId()!=null && estadogarantiacliente.getId()!=null){
					if(estadogarantiaclienteAux.getId().equals(estadogarantiacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoGarantiaCliente(List<EstadoGarantiaCliente> estadogarantiaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoGarantiaCliente estadogarantiacliente: estadogarantiaclientes) {			
			if(estadogarantiacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoGarantiaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoGarantiaClienteConstantesFunciones.LABEL_ID, EstadoGarantiaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGarantiaClienteConstantesFunciones.LABEL_VERSIONROW, EstadoGarantiaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGarantiaClienteConstantesFunciones.LABEL_CODIGO, EstadoGarantiaClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGarantiaClienteConstantesFunciones.LABEL_NOMBRE, EstadoGarantiaClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoGarantiaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoGarantiaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGarantiaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGarantiaClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGarantiaClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGarantiaCliente() throws Exception  {
		return EstadoGarantiaClienteConstantesFunciones.getTiposSeleccionarEstadoGarantiaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGarantiaCliente(Boolean conFk) throws Exception  {
		return EstadoGarantiaClienteConstantesFunciones.getTiposSeleccionarEstadoGarantiaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGarantiaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoGarantiaClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoGarantiaClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoGarantiaClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoGarantiaClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoGarantiaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiaclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoGarantiaCliente(List<EstadoGarantiaCliente> estadogarantiaclientesTemp) throws Exception {
		for(EstadoGarantiaCliente estadogarantiaclienteAux:estadogarantiaclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoGarantiaClienteConstantesFunciones.getClassesRelationshipsOfEstadoGarantiaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(GarantiaCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(GarantiaCliente.class)) {
						classes.add(new Classe(GarantiaCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoGarantiaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoGarantiaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
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
	public static void actualizarLista(EstadoGarantiaCliente estadogarantiacliente,List<EstadoGarantiaCliente> estadogarantiaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoGarantiaCliente estadogarantiaclienteEncontrado=null;
			
			for(EstadoGarantiaCliente estadogarantiaclienteLocal:estadogarantiaclientes) {
				if(estadogarantiaclienteLocal.getId().equals(estadogarantiacliente.getId())) {
					estadogarantiaclienteEncontrado=estadogarantiaclienteLocal;
					
					estadogarantiaclienteLocal.setIsChanged(estadogarantiacliente.getIsChanged());
					estadogarantiaclienteLocal.setIsNew(estadogarantiacliente.getIsNew());
					estadogarantiaclienteLocal.setIsDeleted(estadogarantiacliente.getIsDeleted());
					
					estadogarantiaclienteLocal.setGeneralEntityOriginal(estadogarantiacliente.getGeneralEntityOriginal());
					
					estadogarantiaclienteLocal.setId(estadogarantiacliente.getId());	
					estadogarantiaclienteLocal.setVersionRow(estadogarantiacliente.getVersionRow());	
					estadogarantiaclienteLocal.setcodigo(estadogarantiacliente.getcodigo());	
					estadogarantiaclienteLocal.setnombre(estadogarantiacliente.getnombre());	
					
					
					estadogarantiaclienteLocal.setGarantiaClientes(estadogarantiacliente.getGarantiaClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!estadogarantiacliente.getIsDeleted()) {
				if(!existe) {
					estadogarantiaclientes.add(estadogarantiacliente);
				}
			} else {
				if(estadogarantiaclienteEncontrado!=null && permiteQuitar)  {
					estadogarantiaclientes.remove(estadogarantiaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoGarantiaCliente estadogarantiacliente,List<EstadoGarantiaCliente> estadogarantiaclientes) throws Exception {
		try	{			
			for(EstadoGarantiaCliente estadogarantiaclienteLocal:estadogarantiaclientes) {
				if(estadogarantiaclienteLocal.getId().equals(estadogarantiacliente.getId())) {
					estadogarantiaclienteLocal.setIsSelected(estadogarantiacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoGarantiaCliente(List<EstadoGarantiaCliente> estadogarantiaclientesAux) throws Exception {
		//this.estadogarantiaclientesAux=estadogarantiaclientesAux;
		
		for(EstadoGarantiaCliente estadogarantiaclienteAux:estadogarantiaclientesAux) {
			if(estadogarantiaclienteAux.getIsChanged()) {
				estadogarantiaclienteAux.setIsChanged(false);
			}		
			
			if(estadogarantiaclienteAux.getIsNew()) {
				estadogarantiaclienteAux.setIsNew(false);
			}	
			
			if(estadogarantiaclienteAux.getIsDeleted()) {
				estadogarantiaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiaclienteAux) throws Exception {
		//this.estadogarantiaclienteAux=estadogarantiaclienteAux;
		
			if(estadogarantiaclienteAux.getIsChanged()) {
				estadogarantiaclienteAux.setIsChanged(false);
			}		
			
			if(estadogarantiaclienteAux.getIsNew()) {
				estadogarantiaclienteAux.setIsNew(false);
			}	
			
			if(estadogarantiaclienteAux.getIsDeleted()) {
				estadogarantiaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoGarantiaCliente estadogarantiaclienteAsignar,EstadoGarantiaCliente estadogarantiacliente) throws Exception {
		estadogarantiaclienteAsignar.setId(estadogarantiacliente.getId());	
		estadogarantiaclienteAsignar.setVersionRow(estadogarantiacliente.getVersionRow());	
		estadogarantiaclienteAsignar.setcodigo(estadogarantiacliente.getcodigo());	
		estadogarantiaclienteAsignar.setnombre(estadogarantiacliente.getnombre());	
	}
	
	public static void inicializarEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente) throws Exception {
		try {
				estadogarantiacliente.setId(0L);	
					
				estadogarantiacliente.setcodigo("");	
				estadogarantiacliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoGarantiaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoGarantiaClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoGarantiaClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoGarantiaCliente(String sTipo,Row row,Workbook workbook,EstadoGarantiaCliente estadogarantiacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadogarantiacliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadogarantiacliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoGarantiaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoGarantiaCliente() {
		return this.sFinalQueryEstadoGarantiaCliente;
	}
	
	public void setsFinalQueryEstadoGarantiaCliente(String sFinalQueryEstadoGarantiaCliente) {
		this.sFinalQueryEstadoGarantiaCliente= sFinalQueryEstadoGarantiaCliente;
	}
	
	public Border resaltarSeleccionarEstadoGarantiaCliente=null;
	
	public Border setResaltarSeleccionarEstadoGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadogarantiaclienteBeanSwingJInternalFrame.jTtoolBarEstadoGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoGarantiaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoGarantiaCliente() {
		return this.resaltarSeleccionarEstadoGarantiaCliente;
	}
	
	public void setResaltarSeleccionarEstadoGarantiaCliente(Border borderResaltarSeleccionarEstadoGarantiaCliente) {
		this.resaltarSeleccionarEstadoGarantiaCliente= borderResaltarSeleccionarEstadoGarantiaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoGarantiaCliente=null;
	public Boolean mostraridEstadoGarantiaCliente=true;
	public Boolean activaridEstadoGarantiaCliente=true;

	public Border resaltarcodigoEstadoGarantiaCliente=null;
	public Boolean mostrarcodigoEstadoGarantiaCliente=true;
	public Boolean activarcodigoEstadoGarantiaCliente=true;

	public Border resaltarnombreEstadoGarantiaCliente=null;
	public Boolean mostrarnombreEstadoGarantiaCliente=true;
	public Boolean activarnombreEstadoGarantiaCliente=true;

	
	

	public Border setResaltaridEstadoGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogarantiaclienteBeanSwingJInternalFrame.jTtoolBarEstadoGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltaridEstadoGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoGarantiaCliente() {
		return this.resaltaridEstadoGarantiaCliente;
	}

	public void setResaltaridEstadoGarantiaCliente(Border borderResaltar) {
		this.resaltaridEstadoGarantiaCliente= borderResaltar;
	}

	public Boolean getMostraridEstadoGarantiaCliente() {
		return this.mostraridEstadoGarantiaCliente;
	}

	public void setMostraridEstadoGarantiaCliente(Boolean mostraridEstadoGarantiaCliente) {
		this.mostraridEstadoGarantiaCliente= mostraridEstadoGarantiaCliente;
	}

	public Boolean getActivaridEstadoGarantiaCliente() {
		return this.activaridEstadoGarantiaCliente;
	}

	public void setActivaridEstadoGarantiaCliente(Boolean activaridEstadoGarantiaCliente) {
		this.activaridEstadoGarantiaCliente= activaridEstadoGarantiaCliente;
	}

	public Border setResaltarcodigoEstadoGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogarantiaclienteBeanSwingJInternalFrame.jTtoolBarEstadoGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoGarantiaCliente() {
		return this.resaltarcodigoEstadoGarantiaCliente;
	}

	public void setResaltarcodigoEstadoGarantiaCliente(Border borderResaltar) {
		this.resaltarcodigoEstadoGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoGarantiaCliente() {
		return this.mostrarcodigoEstadoGarantiaCliente;
	}

	public void setMostrarcodigoEstadoGarantiaCliente(Boolean mostrarcodigoEstadoGarantiaCliente) {
		this.mostrarcodigoEstadoGarantiaCliente= mostrarcodigoEstadoGarantiaCliente;
	}

	public Boolean getActivarcodigoEstadoGarantiaCliente() {
		return this.activarcodigoEstadoGarantiaCliente;
	}

	public void setActivarcodigoEstadoGarantiaCliente(Boolean activarcodigoEstadoGarantiaCliente) {
		this.activarcodigoEstadoGarantiaCliente= activarcodigoEstadoGarantiaCliente;
	}

	public Border setResaltarnombreEstadoGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogarantiaclienteBeanSwingJInternalFrame.jTtoolBarEstadoGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoGarantiaCliente() {
		return this.resaltarnombreEstadoGarantiaCliente;
	}

	public void setResaltarnombreEstadoGarantiaCliente(Border borderResaltar) {
		this.resaltarnombreEstadoGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoGarantiaCliente() {
		return this.mostrarnombreEstadoGarantiaCliente;
	}

	public void setMostrarnombreEstadoGarantiaCliente(Boolean mostrarnombreEstadoGarantiaCliente) {
		this.mostrarnombreEstadoGarantiaCliente= mostrarnombreEstadoGarantiaCliente;
	}

	public Boolean getActivarnombreEstadoGarantiaCliente() {
		return this.activarnombreEstadoGarantiaCliente;
	}

	public void setActivarnombreEstadoGarantiaCliente(Boolean activarnombreEstadoGarantiaCliente) {
		this.activarnombreEstadoGarantiaCliente= activarnombreEstadoGarantiaCliente;
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
		
		
		this.setMostraridEstadoGarantiaCliente(esInicial);
		this.setMostrarcodigoEstadoGarantiaCliente(esInicial);
		this.setMostrarnombreEstadoGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.ID)) {
				this.setMostraridEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoGarantiaCliente(esAsigna);
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
		
		
		this.setActivaridEstadoGarantiaCliente(esInicial);
		this.setActivarcodigoEstadoGarantiaCliente(esInicial);
		this.setActivarnombreEstadoGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.ID)) {
				this.setActivaridEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoGarantiaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoGarantiaCliente(esInicial);
		this.setResaltarcodigoEstadoGarantiaCliente(esInicial);
		this.setResaltarnombreEstadoGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.ID)) {
				this.setResaltaridEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGarantiaClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoGarantiaCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarGarantiaClienteEstadoGarantiaCliente=null;

	public Border getResaltarGarantiaClienteEstadoGarantiaCliente() {
		return this.resaltarGarantiaClienteEstadoGarantiaCliente;
	}

	public void setResaltarGarantiaClienteEstadoGarantiaCliente(Border borderResaltarGarantiaCliente) {
		if(borderResaltarGarantiaCliente!=null) {
			this.resaltarGarantiaClienteEstadoGarantiaCliente= borderResaltarGarantiaCliente;
		}
	}

	public Border setResaltarGarantiaClienteEstadoGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarGarantiaCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadogarantiaclienteBeanSwingJInternalFrame.jTtoolBarEstadoGarantiaCliente.setBorder(borderResaltarGarantiaCliente);
			
		this.resaltarGarantiaClienteEstadoGarantiaCliente= borderResaltarGarantiaCliente;

		 return borderResaltarGarantiaCliente;
	}



	public Boolean mostrarGarantiaClienteEstadoGarantiaCliente=true;

	public Boolean getMostrarGarantiaClienteEstadoGarantiaCliente() {
		return this.mostrarGarantiaClienteEstadoGarantiaCliente;
	}

	public void setMostrarGarantiaClienteEstadoGarantiaCliente(Boolean visibilidadResaltarGarantiaCliente) {
		this.mostrarGarantiaClienteEstadoGarantiaCliente= visibilidadResaltarGarantiaCliente;
	}



	public Boolean activarGarantiaClienteEstadoGarantiaCliente=true;

	public Boolean gethabilitarResaltarGarantiaClienteEstadoGarantiaCliente() {
		return this.activarGarantiaClienteEstadoGarantiaCliente;
	}

	public void setActivarGarantiaClienteEstadoGarantiaCliente(Boolean habilitarResaltarGarantiaCliente) {
		this.activarGarantiaClienteEstadoGarantiaCliente= habilitarResaltarGarantiaCliente;
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

		this.setMostrarGarantiaClienteEstadoGarantiaCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setMostrarGarantiaClienteEstadoGarantiaCliente(esAsigna);
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

		this.setActivarGarantiaClienteEstadoGarantiaCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setActivarGarantiaClienteEstadoGarantiaCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoGarantiaClienteBeanSwingJInternalFrame estadogarantiaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarGarantiaClienteEstadoGarantiaCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setResaltarGarantiaClienteEstadoGarantiaCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}