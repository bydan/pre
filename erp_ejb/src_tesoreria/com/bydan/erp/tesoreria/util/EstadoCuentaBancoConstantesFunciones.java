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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.EstadoCuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoCuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoCuentaBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoCuentaBancoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoCuentaBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoCuentaBanco"+EstadoCuentaBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoCuentaBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoCuentaBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoCuentaBancoConstantesFunciones.SCHEMA+"_"+EstadoCuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoCuentaBancoConstantesFunciones.SCHEMA+"_"+EstadoCuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoCuentaBancoConstantesFunciones.SCHEMA+"_"+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoCuentaBancoConstantesFunciones.SCHEMA+"_"+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoCuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoCuentaBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoCuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoCuentaBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Cuenta Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Cuenta Banco";
	public static final String SCLASSWEBTITULO_LOWER="Estado Cuenta Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoCuentaBanco";
	public static final String OBJECTNAME="estadocuentabanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="estado_cuenta_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadocuentabanco from "+EstadoCuentaBancoConstantesFunciones.SPERSISTENCENAME+" estadocuentabanco";
	public static String QUERYSELECTNATIVE="select "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".id,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".codigo,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".nombre,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".es_defecto from "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME;//+" as "+EstadoCuentaBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoCuentaBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoCuentaBancoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoCuentaBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoCuentaBancoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoCuentaBancoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoCuentaBancoConstantesFunciones.ESDEFECTO)) {sLabelColumna=EstadoCuentaBancoConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(EstadoCuentaBanco estadocuentabanco) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadocuentabanco.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(EstadoCuentaBanco estadocuentabanco) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadocuentabanco.getId(),estadocuentabanco.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getEstadoCuentaBancoDescripcion(EstadoCuentaBanco estadocuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadocuentabanco !=null/* && estadocuentabanco.getId()!=0*/) {
			sDescripcion=estadocuentabanco.getcodigo();//estadocuentabancoestadocuentabanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoCuentaBancoDescripcionDetallado(EstadoCuentaBanco estadocuentabanco) {
		String sDescripcion="";
			
		sDescripcion+=EstadoCuentaBancoConstantesFunciones.ID+"=";
		sDescripcion+=estadocuentabanco.getId().toString()+",";
		sDescripcion+=EstadoCuentaBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadocuentabanco.getVersionRow().toString()+",";
		sDescripcion+=EstadoCuentaBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadocuentabanco.getcodigo()+",";
		sDescripcion+=EstadoCuentaBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadocuentabanco.getnombre()+",";
		sDescripcion+=EstadoCuentaBancoConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=estadocuentabanco.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoCuentaBancoDescripcion(EstadoCuentaBanco estadocuentabanco,String sValor) throws Exception {			
		if(estadocuentabanco !=null) {
			estadocuentabanco.setcodigo(sValor);;//estadocuentabancoestadocuentabanco.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadocuentabanco.setcodigo(estadocuentabanco.getcodigo().trim());
		estadocuentabanco.setnombre(estadocuentabanco.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoCuentaBancos(List<EstadoCuentaBanco> estadocuentabancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoCuentaBanco estadocuentabanco: estadocuentabancos) {
			estadocuentabanco.setcodigo(estadocuentabanco.getcodigo().trim());
			estadocuentabanco.setnombre(estadocuentabanco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadocuentabanco.getConCambioAuxiliar()) {
			estadocuentabanco.setIsDeleted(estadocuentabanco.getIsDeletedAuxiliar());	
			estadocuentabanco.setIsNew(estadocuentabanco.getIsNewAuxiliar());	
			estadocuentabanco.setIsChanged(estadocuentabanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadocuentabanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadocuentabanco.setIsDeletedAuxiliar(false);	
			estadocuentabanco.setIsNewAuxiliar(false);	
			estadocuentabanco.setIsChangedAuxiliar(false);
			
			estadocuentabanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCuentaBancos(List<EstadoCuentaBanco> estadocuentabancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoCuentaBanco estadocuentabanco : estadocuentabancos) {
			if(conAsignarBase && estadocuentabanco.getConCambioAuxiliar()) {
				estadocuentabanco.setIsDeleted(estadocuentabanco.getIsDeletedAuxiliar());	
				estadocuentabanco.setIsNew(estadocuentabanco.getIsNewAuxiliar());	
				estadocuentabanco.setIsChanged(estadocuentabanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadocuentabanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadocuentabanco.setIsDeletedAuxiliar(false);	
				estadocuentabanco.setIsNewAuxiliar(false);	
				estadocuentabanco.setIsChangedAuxiliar(false);
				
				estadocuentabanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoCuentaBancos(List<EstadoCuentaBanco> estadocuentabancos,Boolean conEnteros) throws Exception  {
		
		for(EstadoCuentaBanco estadocuentabanco: estadocuentabancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoCuentaBanco(List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBanco estadocuentabancoAux) throws Exception  {
		EstadoCuentaBancoConstantesFunciones.InicializarValoresEstadoCuentaBanco(estadocuentabancoAux,true);
		
		for(EstadoCuentaBanco estadocuentabanco: estadocuentabancos) {
			if(estadocuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoCuentaBancoConstantesFunciones.getArrayColumnasGlobalesEstadoCuentaBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBanco estadocuentabanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoCuentaBanco estadocuentabancoAux: estadocuentabancos) {
			if(estadocuentabancoAux!=null && estadocuentabanco!=null) {
				if((estadocuentabancoAux.getId()==null && estadocuentabanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadocuentabancoAux.getId()!=null && estadocuentabanco.getId()!=null){
					if(estadocuentabancoAux.getId().equals(estadocuentabanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoCuentaBanco(List<EstadoCuentaBanco> estadocuentabancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoCuentaBanco estadocuentabanco: estadocuentabancos) {			
			if(estadocuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoCuentaBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoCuentaBancoConstantesFunciones.LABEL_ID, EstadoCuentaBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuentaBancoConstantesFunciones.LABEL_VERSIONROW, EstadoCuentaBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuentaBancoConstantesFunciones.LABEL_CODIGO, EstadoCuentaBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuentaBancoConstantesFunciones.LABEL_NOMBRE, EstadoCuentaBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCuentaBancoConstantesFunciones.LABEL_ESDEFECTO, EstadoCuentaBancoConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoCuentaBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoCuentaBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuentaBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuentaBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuentaBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCuentaBancoConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuentaBanco() throws Exception  {
		return EstadoCuentaBancoConstantesFunciones.getTiposSeleccionarEstadoCuentaBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuentaBanco(Boolean conFk) throws Exception  {
		return EstadoCuentaBancoConstantesFunciones.getTiposSeleccionarEstadoCuentaBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCuentaBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCuentaBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoCuentaBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCuentaBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoCuentaBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCuentaBancoConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(EstadoCuentaBancoConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoCuentaBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCuentaBanco(EstadoCuentaBanco estadocuentabancoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCuentaBanco(List<EstadoCuentaBanco> estadocuentabancosTemp) throws Exception {
		for(EstadoCuentaBanco estadocuentabancoAux:estadocuentabancosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCuentaBancoConstantesFunciones.getClassesRelationshipsOfEstadoCuentaBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaBanco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCuentaBancoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoCuentaBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
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
	public static void actualizarLista(EstadoCuentaBanco estadocuentabanco,List<EstadoCuentaBanco> estadocuentabancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoCuentaBanco estadocuentabancoEncontrado=null;
			
			for(EstadoCuentaBanco estadocuentabancoLocal:estadocuentabancos) {
				if(estadocuentabancoLocal.getId().equals(estadocuentabanco.getId())) {
					estadocuentabancoEncontrado=estadocuentabancoLocal;
					
					estadocuentabancoLocal.setIsChanged(estadocuentabanco.getIsChanged());
					estadocuentabancoLocal.setIsNew(estadocuentabanco.getIsNew());
					estadocuentabancoLocal.setIsDeleted(estadocuentabanco.getIsDeleted());
					
					estadocuentabancoLocal.setGeneralEntityOriginal(estadocuentabanco.getGeneralEntityOriginal());
					
					estadocuentabancoLocal.setId(estadocuentabanco.getId());	
					estadocuentabancoLocal.setVersionRow(estadocuentabanco.getVersionRow());	
					estadocuentabancoLocal.setcodigo(estadocuentabanco.getcodigo());	
					estadocuentabancoLocal.setnombre(estadocuentabanco.getnombre());	
					estadocuentabancoLocal.setes_defecto(estadocuentabanco.getes_defecto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadocuentabanco.getIsDeleted()) {
				if(!existe) {
					estadocuentabancos.add(estadocuentabanco);
				}
			} else {
				if(estadocuentabancoEncontrado!=null && permiteQuitar)  {
					estadocuentabancos.remove(estadocuentabancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoCuentaBanco estadocuentabanco,List<EstadoCuentaBanco> estadocuentabancos) throws Exception {
		try	{			
			for(EstadoCuentaBanco estadocuentabancoLocal:estadocuentabancos) {
				if(estadocuentabancoLocal.getId().equals(estadocuentabanco.getId())) {
					estadocuentabancoLocal.setIsSelected(estadocuentabanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoCuentaBanco(List<EstadoCuentaBanco> estadocuentabancosAux) throws Exception {
		//this.estadocuentabancosAux=estadocuentabancosAux;
		
		for(EstadoCuentaBanco estadocuentabancoAux:estadocuentabancosAux) {
			if(estadocuentabancoAux.getIsChanged()) {
				estadocuentabancoAux.setIsChanged(false);
			}		
			
			if(estadocuentabancoAux.getIsNew()) {
				estadocuentabancoAux.setIsNew(false);
			}	
			
			if(estadocuentabancoAux.getIsDeleted()) {
				estadocuentabancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoCuentaBanco(EstadoCuentaBanco estadocuentabancoAux) throws Exception {
		//this.estadocuentabancoAux=estadocuentabancoAux;
		
			if(estadocuentabancoAux.getIsChanged()) {
				estadocuentabancoAux.setIsChanged(false);
			}		
			
			if(estadocuentabancoAux.getIsNew()) {
				estadocuentabancoAux.setIsNew(false);
			}	
			
			if(estadocuentabancoAux.getIsDeleted()) {
				estadocuentabancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoCuentaBanco estadocuentabancoAsignar,EstadoCuentaBanco estadocuentabanco) throws Exception {
		estadocuentabancoAsignar.setId(estadocuentabanco.getId());	
		estadocuentabancoAsignar.setVersionRow(estadocuentabanco.getVersionRow());	
		estadocuentabancoAsignar.setcodigo(estadocuentabanco.getcodigo());	
		estadocuentabancoAsignar.setnombre(estadocuentabanco.getnombre());	
		estadocuentabancoAsignar.setes_defecto(estadocuentabanco.getes_defecto());	
	}
	
	public static void inicializarEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco) throws Exception {
		try {
				estadocuentabanco.setId(0L);	
					
				estadocuentabanco.setcodigo("");	
				estadocuentabanco.setnombre("");	
				estadocuentabanco.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoCuentaBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCuentaBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCuentaBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCuentaBancoConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoCuentaBanco(String sTipo,Row row,Workbook workbook,EstadoCuentaBanco estadocuentabanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocuentabanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocuentabanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadocuentabanco.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoCuentaBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoCuentaBanco() {
		return this.sFinalQueryEstadoCuentaBanco;
	}
	
	public void setsFinalQueryEstadoCuentaBanco(String sFinalQueryEstadoCuentaBanco) {
		this.sFinalQueryEstadoCuentaBanco= sFinalQueryEstadoCuentaBanco;
	}
	
	public Border resaltarSeleccionarEstadoCuentaBanco=null;
	
	public Border setResaltarSeleccionarEstadoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadocuentabancoBeanSwingJInternalFrame.jTtoolBarEstadoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoCuentaBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoCuentaBanco() {
		return this.resaltarSeleccionarEstadoCuentaBanco;
	}
	
	public void setResaltarSeleccionarEstadoCuentaBanco(Border borderResaltarSeleccionarEstadoCuentaBanco) {
		this.resaltarSeleccionarEstadoCuentaBanco= borderResaltarSeleccionarEstadoCuentaBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoCuentaBanco=null;
	public Boolean mostraridEstadoCuentaBanco=true;
	public Boolean activaridEstadoCuentaBanco=true;

	public Border resaltarcodigoEstadoCuentaBanco=null;
	public Boolean mostrarcodigoEstadoCuentaBanco=true;
	public Boolean activarcodigoEstadoCuentaBanco=true;

	public Border resaltarnombreEstadoCuentaBanco=null;
	public Boolean mostrarnombreEstadoCuentaBanco=true;
	public Boolean activarnombreEstadoCuentaBanco=true;

	public Border resaltares_defectoEstadoCuentaBanco=null;
	public Boolean mostrares_defectoEstadoCuentaBanco=true;
	public Boolean activares_defectoEstadoCuentaBanco=true;

	
	

	public Border setResaltaridEstadoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuentabancoBeanSwingJInternalFrame.jTtoolBarEstadoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltaridEstadoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoCuentaBanco() {
		return this.resaltaridEstadoCuentaBanco;
	}

	public void setResaltaridEstadoCuentaBanco(Border borderResaltar) {
		this.resaltaridEstadoCuentaBanco= borderResaltar;
	}

	public Boolean getMostraridEstadoCuentaBanco() {
		return this.mostraridEstadoCuentaBanco;
	}

	public void setMostraridEstadoCuentaBanco(Boolean mostraridEstadoCuentaBanco) {
		this.mostraridEstadoCuentaBanco= mostraridEstadoCuentaBanco;
	}

	public Boolean getActivaridEstadoCuentaBanco() {
		return this.activaridEstadoCuentaBanco;
	}

	public void setActivaridEstadoCuentaBanco(Boolean activaridEstadoCuentaBanco) {
		this.activaridEstadoCuentaBanco= activaridEstadoCuentaBanco;
	}

	public Border setResaltarcodigoEstadoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuentabancoBeanSwingJInternalFrame.jTtoolBarEstadoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoCuentaBanco() {
		return this.resaltarcodigoEstadoCuentaBanco;
	}

	public void setResaltarcodigoEstadoCuentaBanco(Border borderResaltar) {
		this.resaltarcodigoEstadoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoCuentaBanco() {
		return this.mostrarcodigoEstadoCuentaBanco;
	}

	public void setMostrarcodigoEstadoCuentaBanco(Boolean mostrarcodigoEstadoCuentaBanco) {
		this.mostrarcodigoEstadoCuentaBanco= mostrarcodigoEstadoCuentaBanco;
	}

	public Boolean getActivarcodigoEstadoCuentaBanco() {
		return this.activarcodigoEstadoCuentaBanco;
	}

	public void setActivarcodigoEstadoCuentaBanco(Boolean activarcodigoEstadoCuentaBanco) {
		this.activarcodigoEstadoCuentaBanco= activarcodigoEstadoCuentaBanco;
	}

	public Border setResaltarnombreEstadoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuentabancoBeanSwingJInternalFrame.jTtoolBarEstadoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoCuentaBanco() {
		return this.resaltarnombreEstadoCuentaBanco;
	}

	public void setResaltarnombreEstadoCuentaBanco(Border borderResaltar) {
		this.resaltarnombreEstadoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoCuentaBanco() {
		return this.mostrarnombreEstadoCuentaBanco;
	}

	public void setMostrarnombreEstadoCuentaBanco(Boolean mostrarnombreEstadoCuentaBanco) {
		this.mostrarnombreEstadoCuentaBanco= mostrarnombreEstadoCuentaBanco;
	}

	public Boolean getActivarnombreEstadoCuentaBanco() {
		return this.activarnombreEstadoCuentaBanco;
	}

	public void setActivarnombreEstadoCuentaBanco(Boolean activarnombreEstadoCuentaBanco) {
		this.activarnombreEstadoCuentaBanco= activarnombreEstadoCuentaBanco;
	}

	public Border setResaltares_defectoEstadoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocuentabancoBeanSwingJInternalFrame.jTtoolBarEstadoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltares_defectoEstadoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoEstadoCuentaBanco() {
		return this.resaltares_defectoEstadoCuentaBanco;
	}

	public void setResaltares_defectoEstadoCuentaBanco(Border borderResaltar) {
		this.resaltares_defectoEstadoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrares_defectoEstadoCuentaBanco() {
		return this.mostrares_defectoEstadoCuentaBanco;
	}

	public void setMostrares_defectoEstadoCuentaBanco(Boolean mostrares_defectoEstadoCuentaBanco) {
		this.mostrares_defectoEstadoCuentaBanco= mostrares_defectoEstadoCuentaBanco;
	}

	public Boolean getActivares_defectoEstadoCuentaBanco() {
		return this.activares_defectoEstadoCuentaBanco;
	}

	public void setActivares_defectoEstadoCuentaBanco(Boolean activares_defectoEstadoCuentaBanco) {
		this.activares_defectoEstadoCuentaBanco= activares_defectoEstadoCuentaBanco;
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
		
		
		this.setMostraridEstadoCuentaBanco(esInicial);
		this.setMostrarcodigoEstadoCuentaBanco(esInicial);
		this.setMostrarnombreEstadoCuentaBanco(esInicial);
		this.setMostrares_defectoEstadoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ID)) {
				this.setMostraridEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoEstadoCuentaBanco(esAsigna);
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
		
		
		this.setActivaridEstadoCuentaBanco(esInicial);
		this.setActivarcodigoEstadoCuentaBanco(esInicial);
		this.setActivarnombreEstadoCuentaBanco(esInicial);
		this.setActivares_defectoEstadoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ID)) {
				this.setActivaridEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoEstadoCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoCuentaBanco(esInicial);
		this.setResaltarcodigoEstadoCuentaBanco(esInicial);
		this.setResaltarnombreEstadoCuentaBanco(esInicial);
		this.setResaltares_defectoEstadoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ID)) {
				this.setResaltaridEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCuentaBancoConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoEstadoCuentaBanco(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCuentaBancoBeanSwingJInternalFrame estadocuentabancoBeanSwingJInternalFrame*/)throws Exception {	
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