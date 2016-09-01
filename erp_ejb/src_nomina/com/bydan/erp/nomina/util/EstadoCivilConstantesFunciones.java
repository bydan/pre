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


import com.bydan.erp.nomina.util.EstadoCivilConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoCivilParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoCivilParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoCivilConstantesFunciones extends EstadoCivilConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoCivil";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoCivil"+EstadoCivilConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoCivilHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoCivilHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoCivilConstantesFunciones.SCHEMA+"_"+EstadoCivilConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCivilHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoCivilConstantesFunciones.SCHEMA+"_"+EstadoCivilConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoCivilConstantesFunciones.SCHEMA+"_"+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoCivilHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoCivilConstantesFunciones.SCHEMA+"_"+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCivilHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoCivilHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoCivilConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoCivilConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoCivilConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoCivilConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoCivilConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Civiles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Civil";
	public static final String SCLASSWEBTITULO_LOWER="Estado Civil";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoCivil";
	public static final String OBJECTNAME="estadocivil";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_civil";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadocivil from "+EstadoCivilConstantesFunciones.SPERSISTENCENAME+" estadocivil";
	public static String QUERYSELECTNATIVE="select "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".id,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".version_row,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".codigo,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".nombre from "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME;//+" as "+EstadoCivilConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoCivilConstantesFuncionesAdditional estadocivilConstantesFuncionesAdditional=null;
	
	public EstadoCivilConstantesFuncionesAdditional getEstadoCivilConstantesFuncionesAdditional() {
		return this.estadocivilConstantesFuncionesAdditional;
	}
	
	public void setEstadoCivilConstantesFuncionesAdditional(EstadoCivilConstantesFuncionesAdditional estadocivilConstantesFuncionesAdditional) {
		try {
			this.estadocivilConstantesFuncionesAdditional=estadocivilConstantesFuncionesAdditional;
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
	
	public static String getEstadoCivilLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoCivilConstantesFunciones.CODIGO)) {sLabelColumna=EstadoCivilConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoCivilConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoCivilConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoCivilDescripcion(EstadoCivil estadocivil) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadocivil !=null/* && estadocivil.getId()!=0*/) {
			sDescripcion=estadocivil.getcodigo();//estadocivilestadocivil.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoCivilDescripcionDetallado(EstadoCivil estadocivil) {
		String sDescripcion="";
			
		sDescripcion+=EstadoCivilConstantesFunciones.ID+"=";
		sDescripcion+=estadocivil.getId().toString()+",";
		sDescripcion+=EstadoCivilConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadocivil.getVersionRow().toString()+",";
		sDescripcion+=EstadoCivilConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadocivil.getcodigo()+",";
		sDescripcion+=EstadoCivilConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadocivil.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoCivilDescripcion(EstadoCivil estadocivil,String sValor) throws Exception {			
		if(estadocivil !=null) {
			estadocivil.setcodigo(sValor);;//estadocivilestadocivil.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoCivil(EstadoCivil estadocivil,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadocivil.setcodigo(estadocivil.getcodigo().trim());
		estadocivil.setnombre(estadocivil.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoCivils(List<EstadoCivil> estadocivils,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoCivil estadocivil: estadocivils) {
			estadocivil.setcodigo(estadocivil.getcodigo().trim());
			estadocivil.setnombre(estadocivil.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCivil(EstadoCivil estadocivil,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadocivil.getConCambioAuxiliar()) {
			estadocivil.setIsDeleted(estadocivil.getIsDeletedAuxiliar());	
			estadocivil.setIsNew(estadocivil.getIsNewAuxiliar());	
			estadocivil.setIsChanged(estadocivil.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadocivil.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadocivil.setIsDeletedAuxiliar(false);	
			estadocivil.setIsNewAuxiliar(false);	
			estadocivil.setIsChangedAuxiliar(false);
			
			estadocivil.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCivils(List<EstadoCivil> estadocivils,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoCivil estadocivil : estadocivils) {
			if(conAsignarBase && estadocivil.getConCambioAuxiliar()) {
				estadocivil.setIsDeleted(estadocivil.getIsDeletedAuxiliar());	
				estadocivil.setIsNew(estadocivil.getIsNewAuxiliar());	
				estadocivil.setIsChanged(estadocivil.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadocivil.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadocivil.setIsDeletedAuxiliar(false);	
				estadocivil.setIsNewAuxiliar(false);	
				estadocivil.setIsChangedAuxiliar(false);
				
				estadocivil.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoCivil(EstadoCivil estadocivil,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoCivils(List<EstadoCivil> estadocivils,Boolean conEnteros) throws Exception  {
		
		for(EstadoCivil estadocivil: estadocivils) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoCivil(List<EstadoCivil> estadocivils,EstadoCivil estadocivilAux) throws Exception  {
		EstadoCivilConstantesFunciones.InicializarValoresEstadoCivil(estadocivilAux,true);
		
		for(EstadoCivil estadocivil: estadocivils) {
			if(estadocivil.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCivil(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoCivilConstantesFunciones.getArrayColumnasGlobalesEstadoCivil(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCivil(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoCivil(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoCivil> estadocivils,EstadoCivil estadocivil,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoCivil estadocivilAux: estadocivils) {
			if(estadocivilAux!=null && estadocivil!=null) {
				if((estadocivilAux.getId()==null && estadocivil.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadocivilAux.getId()!=null && estadocivil.getId()!=null){
					if(estadocivilAux.getId().equals(estadocivil.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoCivil(List<EstadoCivil> estadocivils) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoCivil estadocivil: estadocivils) {			
			if(estadocivil.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoCivil() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoCivilConstantesFunciones.LABEL_ID, EstadoCivilConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCivilConstantesFunciones.LABEL_VERSIONROW, EstadoCivilConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCivilConstantesFunciones.LABEL_CODIGO, EstadoCivilConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoCivilConstantesFunciones.LABEL_NOMBRE, EstadoCivilConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoCivil() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoCivilConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCivilConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCivilConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoCivilConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCivil() throws Exception  {
		return EstadoCivilConstantesFunciones.getTiposSeleccionarEstadoCivil(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCivil(Boolean conFk) throws Exception  {
		return EstadoCivilConstantesFunciones.getTiposSeleccionarEstadoCivil(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCivil(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCivilConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoCivilConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoCivilConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoCivilConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoCivil(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCivil(EstadoCivil estadocivilAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCivil(List<EstadoCivil> estadocivilsTemp) throws Exception {
		for(EstadoCivil estadocivilAux:estadocivilsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCivil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoCivil(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCivil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCivilConstantesFunciones.getClassesRelationshipsOfEstadoCivil(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCivil(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(CargaFamiliar_NM.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				classes.add(new Classe(CargaFamiliar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar_NM.class)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar.class)) {
						classes.add(new Classe(CargaFamiliar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCivil(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoCivilConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoCivil(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCivil(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
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
	public static void actualizarLista(EstadoCivil estadocivil,List<EstadoCivil> estadocivils,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoCivil estadocivilEncontrado=null;
			
			for(EstadoCivil estadocivilLocal:estadocivils) {
				if(estadocivilLocal.getId().equals(estadocivil.getId())) {
					estadocivilEncontrado=estadocivilLocal;
					
					estadocivilLocal.setIsChanged(estadocivil.getIsChanged());
					estadocivilLocal.setIsNew(estadocivil.getIsNew());
					estadocivilLocal.setIsDeleted(estadocivil.getIsDeleted());
					
					estadocivilLocal.setGeneralEntityOriginal(estadocivil.getGeneralEntityOriginal());
					
					estadocivilLocal.setId(estadocivil.getId());	
					estadocivilLocal.setVersionRow(estadocivil.getVersionRow());	
					estadocivilLocal.setcodigo(estadocivil.getcodigo());	
					estadocivilLocal.setnombre(estadocivil.getnombre());	
					
					
					estadocivilLocal.setClientes(estadocivil.getClientes());
					estadocivilLocal.setCargaFamiliar_NMs(estadocivil.getCargaFamiliar_NMs());
					estadocivilLocal.setSubClientes(estadocivil.getSubClientes());
					estadocivilLocal.setEmpleados(estadocivil.getEmpleados());
					estadocivilLocal.setParametroCarteraDefectos(estadocivil.getParametroCarteraDefectos());
					estadocivilLocal.setCargaFamiliars(estadocivil.getCargaFamiliars());
					
					existe=true;
					break;
				}
			}
			
			if(!estadocivil.getIsDeleted()) {
				if(!existe) {
					estadocivils.add(estadocivil);
				}
			} else {
				if(estadocivilEncontrado!=null && permiteQuitar)  {
					estadocivils.remove(estadocivilEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoCivil estadocivil,List<EstadoCivil> estadocivils) throws Exception {
		try	{			
			for(EstadoCivil estadocivilLocal:estadocivils) {
				if(estadocivilLocal.getId().equals(estadocivil.getId())) {
					estadocivilLocal.setIsSelected(estadocivil.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoCivil(List<EstadoCivil> estadocivilsAux) throws Exception {
		//this.estadocivilsAux=estadocivilsAux;
		
		for(EstadoCivil estadocivilAux:estadocivilsAux) {
			if(estadocivilAux.getIsChanged()) {
				estadocivilAux.setIsChanged(false);
			}		
			
			if(estadocivilAux.getIsNew()) {
				estadocivilAux.setIsNew(false);
			}	
			
			if(estadocivilAux.getIsDeleted()) {
				estadocivilAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoCivil(EstadoCivil estadocivilAux) throws Exception {
		//this.estadocivilAux=estadocivilAux;
		
			if(estadocivilAux.getIsChanged()) {
				estadocivilAux.setIsChanged(false);
			}		
			
			if(estadocivilAux.getIsNew()) {
				estadocivilAux.setIsNew(false);
			}	
			
			if(estadocivilAux.getIsDeleted()) {
				estadocivilAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoCivil estadocivilAsignar,EstadoCivil estadocivil) throws Exception {
		estadocivilAsignar.setId(estadocivil.getId());	
		estadocivilAsignar.setVersionRow(estadocivil.getVersionRow());	
		estadocivilAsignar.setcodigo(estadocivil.getcodigo());	
		estadocivilAsignar.setnombre(estadocivil.getnombre());	
	}
	
	public static void inicializarEstadoCivil(EstadoCivil estadocivil) throws Exception {
		try {
				estadocivil.setId(0L);	
					
				estadocivil.setcodigo("");	
				estadocivil.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoCivil(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCivilConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoCivilConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoCivil(String sTipo,Row row,Workbook workbook,EstadoCivil estadocivil,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocivil.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocivil.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoCivil=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoCivil() {
		return this.sFinalQueryEstadoCivil;
	}
	
	public void setsFinalQueryEstadoCivil(String sFinalQueryEstadoCivil) {
		this.sFinalQueryEstadoCivil= sFinalQueryEstadoCivil;
	}
	
	public Border resaltarSeleccionarEstadoCivil=null;
	
	public Border setResaltarSeleccionarEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoCivil= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoCivil() {
		return this.resaltarSeleccionarEstadoCivil;
	}
	
	public void setResaltarSeleccionarEstadoCivil(Border borderResaltarSeleccionarEstadoCivil) {
		this.resaltarSeleccionarEstadoCivil= borderResaltarSeleccionarEstadoCivil;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoCivil=null;
	public Boolean mostraridEstadoCivil=true;
	public Boolean activaridEstadoCivil=true;

	public Border resaltarcodigoEstadoCivil=null;
	public Boolean mostrarcodigoEstadoCivil=true;
	public Boolean activarcodigoEstadoCivil=true;

	public Border resaltarnombreEstadoCivil=null;
	public Boolean mostrarnombreEstadoCivil=true;
	public Boolean activarnombreEstadoCivil=true;

	
	

	public Border setResaltaridEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltar);
		
		this.resaltaridEstadoCivil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoCivil() {
		return this.resaltaridEstadoCivil;
	}

	public void setResaltaridEstadoCivil(Border borderResaltar) {
		this.resaltaridEstadoCivil= borderResaltar;
	}

	public Boolean getMostraridEstadoCivil() {
		return this.mostraridEstadoCivil;
	}

	public void setMostraridEstadoCivil(Boolean mostraridEstadoCivil) {
		this.mostraridEstadoCivil= mostraridEstadoCivil;
	}

	public Boolean getActivaridEstadoCivil() {
		return this.activaridEstadoCivil;
	}

	public void setActivaridEstadoCivil(Boolean activaridEstadoCivil) {
		this.activaridEstadoCivil= activaridEstadoCivil;
	}

	public Border setResaltarcodigoEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoCivil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoCivil() {
		return this.resaltarcodigoEstadoCivil;
	}

	public void setResaltarcodigoEstadoCivil(Border borderResaltar) {
		this.resaltarcodigoEstadoCivil= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoCivil() {
		return this.mostrarcodigoEstadoCivil;
	}

	public void setMostrarcodigoEstadoCivil(Boolean mostrarcodigoEstadoCivil) {
		this.mostrarcodigoEstadoCivil= mostrarcodigoEstadoCivil;
	}

	public Boolean getActivarcodigoEstadoCivil() {
		return this.activarcodigoEstadoCivil;
	}

	public void setActivarcodigoEstadoCivil(Boolean activarcodigoEstadoCivil) {
		this.activarcodigoEstadoCivil= activarcodigoEstadoCivil;
	}

	public Border setResaltarnombreEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoCivil= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoCivil() {
		return this.resaltarnombreEstadoCivil;
	}

	public void setResaltarnombreEstadoCivil(Border borderResaltar) {
		this.resaltarnombreEstadoCivil= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoCivil() {
		return this.mostrarnombreEstadoCivil;
	}

	public void setMostrarnombreEstadoCivil(Boolean mostrarnombreEstadoCivil) {
		this.mostrarnombreEstadoCivil= mostrarnombreEstadoCivil;
	}

	public Boolean getActivarnombreEstadoCivil() {
		return this.activarnombreEstadoCivil;
	}

	public void setActivarnombreEstadoCivil(Boolean activarnombreEstadoCivil) {
		this.activarnombreEstadoCivil= activarnombreEstadoCivil;
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
		
		
		this.setMostraridEstadoCivil(esInicial);
		this.setMostrarcodigoEstadoCivil(esInicial);
		this.setMostrarnombreEstadoCivil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCivilConstantesFunciones.ID)) {
				this.setMostraridEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoCivil(esAsigna);
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
		
		
		this.setActivaridEstadoCivil(esInicial);
		this.setActivarcodigoEstadoCivil(esInicial);
		this.setActivarnombreEstadoCivil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCivilConstantesFunciones.ID)) {
				this.setActivaridEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoCivil(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoCivil(esInicial);
		this.setResaltarcodigoEstadoCivil(esInicial);
		this.setResaltarnombreEstadoCivil(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoCivilConstantesFunciones.ID)) {
				this.setResaltaridEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoCivil(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoCivilConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoCivil(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteEstadoCivil=null;

	public Border getResaltarClienteEstadoCivil() {
		return this.resaltarClienteEstadoCivil;
	}

	public void setResaltarClienteEstadoCivil(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteEstadoCivil= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarCliente);
			
		this.resaltarClienteEstadoCivil= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteEstadoCivil=true;

	public Boolean getMostrarClienteEstadoCivil() {
		return this.mostrarClienteEstadoCivil;
	}

	public void setMostrarClienteEstadoCivil(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteEstadoCivil= visibilidadResaltarCliente;
	}



	public Boolean activarClienteEstadoCivil=true;

	public Boolean gethabilitarResaltarClienteEstadoCivil() {
		return this.activarClienteEstadoCivil;
	}

	public void setActivarClienteEstadoCivil(Boolean habilitarResaltarCliente) {
		this.activarClienteEstadoCivil= habilitarResaltarCliente;
	}


	public Border resaltarCargaFamiliar_NMEstadoCivil=null;

	public Border getResaltarCargaFamiliar_NMEstadoCivil() {
		return this.resaltarCargaFamiliar_NMEstadoCivil;
	}

	public void setResaltarCargaFamiliar_NMEstadoCivil(Border borderResaltarCargaFamiliar_NM) {
		if(borderResaltarCargaFamiliar_NM!=null) {
			this.resaltarCargaFamiliar_NMEstadoCivil= borderResaltarCargaFamiliar_NM;
		}
	}

	public Border setResaltarCargaFamiliar_NMEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar_NM=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarCargaFamiliar_NM);
			
		this.resaltarCargaFamiliar_NMEstadoCivil= borderResaltarCargaFamiliar_NM;

		 return borderResaltarCargaFamiliar_NM;
	}



	public Boolean mostrarCargaFamiliar_NMEstadoCivil=true;

	public Boolean getMostrarCargaFamiliar_NMEstadoCivil() {
		return this.mostrarCargaFamiliar_NMEstadoCivil;
	}

	public void setMostrarCargaFamiliar_NMEstadoCivil(Boolean visibilidadResaltarCargaFamiliar_NM) {
		this.mostrarCargaFamiliar_NMEstadoCivil= visibilidadResaltarCargaFamiliar_NM;
	}



	public Boolean activarCargaFamiliar_NMEstadoCivil=true;

	public Boolean gethabilitarResaltarCargaFamiliar_NMEstadoCivil() {
		return this.activarCargaFamiliar_NMEstadoCivil;
	}

	public void setActivarCargaFamiliar_NMEstadoCivil(Boolean habilitarResaltarCargaFamiliar_NM) {
		this.activarCargaFamiliar_NMEstadoCivil= habilitarResaltarCargaFamiliar_NM;
	}


	public Border resaltarSubClienteEstadoCivil=null;

	public Border getResaltarSubClienteEstadoCivil() {
		return this.resaltarSubClienteEstadoCivil;
	}

	public void setResaltarSubClienteEstadoCivil(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteEstadoCivil= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteEstadoCivil= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteEstadoCivil=true;

	public Boolean getMostrarSubClienteEstadoCivil() {
		return this.mostrarSubClienteEstadoCivil;
	}

	public void setMostrarSubClienteEstadoCivil(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteEstadoCivil= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteEstadoCivil=true;

	public Boolean gethabilitarResaltarSubClienteEstadoCivil() {
		return this.activarSubClienteEstadoCivil;
	}

	public void setActivarSubClienteEstadoCivil(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteEstadoCivil= habilitarResaltarSubCliente;
	}


	public Border resaltarEmpleadoEstadoCivil=null;

	public Border getResaltarEmpleadoEstadoCivil() {
		return this.resaltarEmpleadoEstadoCivil;
	}

	public void setResaltarEmpleadoEstadoCivil(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoEstadoCivil= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoEstadoCivil= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoEstadoCivil=true;

	public Boolean getMostrarEmpleadoEstadoCivil() {
		return this.mostrarEmpleadoEstadoCivil;
	}

	public void setMostrarEmpleadoEstadoCivil(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoEstadoCivil= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoEstadoCivil=true;

	public Boolean gethabilitarResaltarEmpleadoEstadoCivil() {
		return this.activarEmpleadoEstadoCivil;
	}

	public void setActivarEmpleadoEstadoCivil(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoEstadoCivil= habilitarResaltarEmpleado;
	}


	public Border resaltarParametroCarteraDefectoEstadoCivil=null;

	public Border getResaltarParametroCarteraDefectoEstadoCivil() {
		return this.resaltarParametroCarteraDefectoEstadoCivil;
	}

	public void setResaltarParametroCarteraDefectoEstadoCivil(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoEstadoCivil= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoEstadoCivil= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoEstadoCivil=true;

	public Boolean getMostrarParametroCarteraDefectoEstadoCivil() {
		return this.mostrarParametroCarteraDefectoEstadoCivil;
	}

	public void setMostrarParametroCarteraDefectoEstadoCivil(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoEstadoCivil= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoEstadoCivil=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoEstadoCivil() {
		return this.activarParametroCarteraDefectoEstadoCivil;
	}

	public void setActivarParametroCarteraDefectoEstadoCivil(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoEstadoCivil= habilitarResaltarParametroCarteraDefecto;
	}


	public Border resaltarCargaFamiliarEstadoCivil=null;

	public Border getResaltarCargaFamiliarEstadoCivil() {
		return this.resaltarCargaFamiliarEstadoCivil;
	}

	public void setResaltarCargaFamiliarEstadoCivil(Border borderResaltarCargaFamiliar) {
		if(borderResaltarCargaFamiliar!=null) {
			this.resaltarCargaFamiliarEstadoCivil= borderResaltarCargaFamiliar;
		}
	}

	public Border setResaltarCargaFamiliarEstadoCivil(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadocivilBeanSwingJInternalFrame.jTtoolBarEstadoCivil.setBorder(borderResaltarCargaFamiliar);
			
		this.resaltarCargaFamiliarEstadoCivil= borderResaltarCargaFamiliar;

		 return borderResaltarCargaFamiliar;
	}



	public Boolean mostrarCargaFamiliarEstadoCivil=true;

	public Boolean getMostrarCargaFamiliarEstadoCivil() {
		return this.mostrarCargaFamiliarEstadoCivil;
	}

	public void setMostrarCargaFamiliarEstadoCivil(Boolean visibilidadResaltarCargaFamiliar) {
		this.mostrarCargaFamiliarEstadoCivil= visibilidadResaltarCargaFamiliar;
	}



	public Boolean activarCargaFamiliarEstadoCivil=true;

	public Boolean gethabilitarResaltarCargaFamiliarEstadoCivil() {
		return this.activarCargaFamiliarEstadoCivil;
	}

	public void setActivarCargaFamiliarEstadoCivil(Boolean habilitarResaltarCargaFamiliar) {
		this.activarCargaFamiliarEstadoCivil= habilitarResaltarCargaFamiliar;
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

		this.setMostrarClienteEstadoCivil(esInicial);
		this.setMostrarCargaFamiliar_NMEstadoCivil(esInicial);
		this.setMostrarSubClienteEstadoCivil(esInicial);
		this.setMostrarEmpleadoEstadoCivil(esInicial);
		this.setMostrarParametroCarteraDefectoEstadoCivil(esInicial);
		this.setMostrarCargaFamiliarEstadoCivil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setMostrarCargaFamiliar_NMEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setMostrarCargaFamiliarEstadoCivil(esAsigna);
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

		this.setActivarClienteEstadoCivil(esInicial);
		this.setActivarCargaFamiliar_NMEstadoCivil(esInicial);
		this.setActivarSubClienteEstadoCivil(esInicial);
		this.setActivarEmpleadoEstadoCivil(esInicial);
		this.setActivarParametroCarteraDefectoEstadoCivil(esInicial);
		this.setActivarCargaFamiliarEstadoCivil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setActivarCargaFamiliar_NMEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setActivarCargaFamiliarEstadoCivil(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoCivilBeanSwingJInternalFrame estadocivilBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteEstadoCivil(esInicial);
		this.setResaltarCargaFamiliar_NMEstadoCivil(esInicial);
		this.setResaltarSubClienteEstadoCivil(esInicial);
		this.setResaltarEmpleadoEstadoCivil(esInicial);
		this.setResaltarParametroCarteraDefectoEstadoCivil(esInicial);
		this.setResaltarCargaFamiliarEstadoCivil(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setResaltarCargaFamiliar_NMEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoEstadoCivil(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setResaltarCargaFamiliarEstadoCivil(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}