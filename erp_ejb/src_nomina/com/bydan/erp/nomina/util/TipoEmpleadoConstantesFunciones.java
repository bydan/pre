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


import com.bydan.erp.nomina.util.TipoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoEmpleadoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEmpleado"+TipoEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEmpleadoConstantesFunciones.SCHEMA+"_"+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEmpleado";
	public static final String OBJECTNAME="tipoempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoempleado from "+TipoEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipoempleado";
	public static String QUERYSELECTNATIVE="select "+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoEmpleadoConstantesFunciones.SCHEMA+"."+TipoEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=TipoEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoEmpleadoDescripcion(TipoEmpleado tipoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoempleado !=null/* && tipoempleado.getId()!=0*/) {
			sDescripcion=tipoempleado.getcodigo();//tipoempleadotipoempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEmpleadoDescripcionDetallado(TipoEmpleado tipoempleado) {
		String sDescripcion="";
			
		sDescripcion+=TipoEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=tipoempleado.getId().toString()+",";
		sDescripcion+=TipoEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoempleado.getVersionRow().toString()+",";
		sDescripcion+=TipoEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoempleado.getid_empresa().toString()+",";
		sDescripcion+=TipoEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoempleado.getcodigo()+",";
		sDescripcion+=TipoEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEmpleadoDescripcion(TipoEmpleado tipoempleado,String sValor) throws Exception {			
		if(tipoempleado !=null) {
			tipoempleado.setcodigo(sValor);;//tipoempleadotipoempleado.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoEmpleado(TipoEmpleado tipoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoempleado.setcodigo(tipoempleado.getcodigo().trim());
		tipoempleado.setnombre(tipoempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEmpleados(List<TipoEmpleado> tipoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEmpleado tipoempleado: tipoempleados) {
			tipoempleado.setcodigo(tipoempleado.getcodigo().trim());
			tipoempleado.setnombre(tipoempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEmpleado(TipoEmpleado tipoempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoempleado.getConCambioAuxiliar()) {
			tipoempleado.setIsDeleted(tipoempleado.getIsDeletedAuxiliar());	
			tipoempleado.setIsNew(tipoempleado.getIsNewAuxiliar());	
			tipoempleado.setIsChanged(tipoempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoempleado.setIsDeletedAuxiliar(false);	
			tipoempleado.setIsNewAuxiliar(false);	
			tipoempleado.setIsChangedAuxiliar(false);
			
			tipoempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEmpleados(List<TipoEmpleado> tipoempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEmpleado tipoempleado : tipoempleados) {
			if(conAsignarBase && tipoempleado.getConCambioAuxiliar()) {
				tipoempleado.setIsDeleted(tipoempleado.getIsDeletedAuxiliar());	
				tipoempleado.setIsNew(tipoempleado.getIsNewAuxiliar());	
				tipoempleado.setIsChanged(tipoempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoempleado.setIsDeletedAuxiliar(false);	
				tipoempleado.setIsNewAuxiliar(false);	
				tipoempleado.setIsChangedAuxiliar(false);
				
				tipoempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEmpleado(TipoEmpleado tipoempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEmpleados(List<TipoEmpleado> tipoempleados,Boolean conEnteros) throws Exception  {
		
		for(TipoEmpleado tipoempleado: tipoempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEmpleado(List<TipoEmpleado> tipoempleados,TipoEmpleado tipoempleadoAux) throws Exception  {
		TipoEmpleadoConstantesFunciones.InicializarValoresTipoEmpleado(tipoempleadoAux,true);
		
		for(TipoEmpleado tipoempleado: tipoempleados) {
			if(tipoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEmpleadoConstantesFunciones.getArrayColumnasGlobalesTipoEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEmpleado> tipoempleados,TipoEmpleado tipoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEmpleado tipoempleadoAux: tipoempleados) {
			if(tipoempleadoAux!=null && tipoempleado!=null) {
				if((tipoempleadoAux.getId()==null && tipoempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoempleadoAux.getId()!=null && tipoempleado.getId()!=null){
					if(tipoempleadoAux.getId().equals(tipoempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEmpleado(List<TipoEmpleado> tipoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEmpleado tipoempleado: tipoempleados) {			
			if(tipoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEmpleadoConstantesFunciones.LABEL_ID, TipoEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpleadoConstantesFunciones.LABEL_VERSIONROW, TipoEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpleadoConstantesFunciones.LABEL_IDEMPRESA, TipoEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpleadoConstantesFunciones.LABEL_CODIGO, TipoEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEmpleadoConstantesFunciones.LABEL_NOMBRE, TipoEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpleado() throws Exception  {
		return TipoEmpleadoConstantesFunciones.getTiposSeleccionarTipoEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpleado(Boolean conFk) throws Exception  {
		return TipoEmpleadoConstantesFunciones.getTiposSeleccionarTipoEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEmpleado(TipoEmpleado tipoempleadoAux) throws Exception {
		
			tipoempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoempleadoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEmpleado(List<TipoEmpleado> tipoempleadosTemp) throws Exception {
		for(TipoEmpleado tipoempleadoAux:tipoempleadosTemp) {
			
			tipoempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoempleadoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	public static void actualizarLista(TipoEmpleado tipoempleado,List<TipoEmpleado> tipoempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEmpleado tipoempleadoEncontrado=null;
			
			for(TipoEmpleado tipoempleadoLocal:tipoempleados) {
				if(tipoempleadoLocal.getId().equals(tipoempleado.getId())) {
					tipoempleadoEncontrado=tipoempleadoLocal;
					
					tipoempleadoLocal.setIsChanged(tipoempleado.getIsChanged());
					tipoempleadoLocal.setIsNew(tipoempleado.getIsNew());
					tipoempleadoLocal.setIsDeleted(tipoempleado.getIsDeleted());
					
					tipoempleadoLocal.setGeneralEntityOriginal(tipoempleado.getGeneralEntityOriginal());
					
					tipoempleadoLocal.setId(tipoempleado.getId());	
					tipoempleadoLocal.setVersionRow(tipoempleado.getVersionRow());	
					tipoempleadoLocal.setid_empresa(tipoempleado.getid_empresa());	
					tipoempleadoLocal.setcodigo(tipoempleado.getcodigo());	
					tipoempleadoLocal.setnombre(tipoempleado.getnombre());	
					
					
					tipoempleadoLocal.setEmpleados(tipoempleado.getEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoempleado.getIsDeleted()) {
				if(!existe) {
					tipoempleados.add(tipoempleado);
				}
			} else {
				if(tipoempleadoEncontrado!=null && permiteQuitar)  {
					tipoempleados.remove(tipoempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEmpleado tipoempleado,List<TipoEmpleado> tipoempleados) throws Exception {
		try	{			
			for(TipoEmpleado tipoempleadoLocal:tipoempleados) {
				if(tipoempleadoLocal.getId().equals(tipoempleado.getId())) {
					tipoempleadoLocal.setIsSelected(tipoempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEmpleado(List<TipoEmpleado> tipoempleadosAux) throws Exception {
		//this.tipoempleadosAux=tipoempleadosAux;
		
		for(TipoEmpleado tipoempleadoAux:tipoempleadosAux) {
			if(tipoempleadoAux.getIsChanged()) {
				tipoempleadoAux.setIsChanged(false);
			}		
			
			if(tipoempleadoAux.getIsNew()) {
				tipoempleadoAux.setIsNew(false);
			}	
			
			if(tipoempleadoAux.getIsDeleted()) {
				tipoempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEmpleado(TipoEmpleado tipoempleadoAux) throws Exception {
		//this.tipoempleadoAux=tipoempleadoAux;
		
			if(tipoempleadoAux.getIsChanged()) {
				tipoempleadoAux.setIsChanged(false);
			}		
			
			if(tipoempleadoAux.getIsNew()) {
				tipoempleadoAux.setIsNew(false);
			}	
			
			if(tipoempleadoAux.getIsDeleted()) {
				tipoempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEmpleado tipoempleadoAsignar,TipoEmpleado tipoempleado) throws Exception {
		tipoempleadoAsignar.setId(tipoempleado.getId());	
		tipoempleadoAsignar.setVersionRow(tipoempleado.getVersionRow());	
		tipoempleadoAsignar.setid_empresa(tipoempleado.getid_empresa());
		tipoempleadoAsignar.setempresa_descripcion(tipoempleado.getempresa_descripcion());	
		tipoempleadoAsignar.setcodigo(tipoempleado.getcodigo());	
		tipoempleadoAsignar.setnombre(tipoempleado.getnombre());	
	}
	
	public static void inicializarTipoEmpleado(TipoEmpleado tipoempleado) throws Exception {
		try {
				tipoempleado.setId(0L);	
					
				tipoempleado.setid_empresa(-1L);	
				tipoempleado.setcodigo("");	
				tipoempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEmpleado(String sTipo,Row row,Workbook workbook,TipoEmpleado tipoempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEmpleado() {
		return this.sFinalQueryTipoEmpleado;
	}
	
	public void setsFinalQueryTipoEmpleado(String sFinalQueryTipoEmpleado) {
		this.sFinalQueryTipoEmpleado= sFinalQueryTipoEmpleado;
	}
	
	public Border resaltarSeleccionarTipoEmpleado=null;
	
	public Border setResaltarSeleccionarTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEmpleado() {
		return this.resaltarSeleccionarTipoEmpleado;
	}
	
	public void setResaltarSeleccionarTipoEmpleado(Border borderResaltarSeleccionarTipoEmpleado) {
		this.resaltarSeleccionarTipoEmpleado= borderResaltarSeleccionarTipoEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEmpleado=null;
	public Boolean mostraridTipoEmpleado=true;
	public Boolean activaridTipoEmpleado=true;

	public Border resaltarid_empresaTipoEmpleado=null;
	public Boolean mostrarid_empresaTipoEmpleado=true;
	public Boolean activarid_empresaTipoEmpleado=true;
	public Boolean cargarid_empresaTipoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoEmpleado=false;//ConEventDepend=true

	public Border resaltarcodigoTipoEmpleado=null;
	public Boolean mostrarcodigoTipoEmpleado=true;
	public Boolean activarcodigoTipoEmpleado=true;

	public Border resaltarnombreTipoEmpleado=null;
	public Boolean mostrarnombreTipoEmpleado=true;
	public Boolean activarnombreTipoEmpleado=true;

	
	

	public Border setResaltaridTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltar);
		
		this.resaltaridTipoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEmpleado() {
		return this.resaltaridTipoEmpleado;
	}

	public void setResaltaridTipoEmpleado(Border borderResaltar) {
		this.resaltaridTipoEmpleado= borderResaltar;
	}

	public Boolean getMostraridTipoEmpleado() {
		return this.mostraridTipoEmpleado;
	}

	public void setMostraridTipoEmpleado(Boolean mostraridTipoEmpleado) {
		this.mostraridTipoEmpleado= mostraridTipoEmpleado;
	}

	public Boolean getActivaridTipoEmpleado() {
		return this.activaridTipoEmpleado;
	}

	public void setActivaridTipoEmpleado(Boolean activaridTipoEmpleado) {
		this.activaridTipoEmpleado= activaridTipoEmpleado;
	}

	public Border setResaltarid_empresaTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoEmpleado() {
		return this.resaltarid_empresaTipoEmpleado;
	}

	public void setResaltarid_empresaTipoEmpleado(Border borderResaltar) {
		this.resaltarid_empresaTipoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoEmpleado() {
		return this.mostrarid_empresaTipoEmpleado;
	}

	public void setMostrarid_empresaTipoEmpleado(Boolean mostrarid_empresaTipoEmpleado) {
		this.mostrarid_empresaTipoEmpleado= mostrarid_empresaTipoEmpleado;
	}

	public Boolean getActivarid_empresaTipoEmpleado() {
		return this.activarid_empresaTipoEmpleado;
	}

	public void setActivarid_empresaTipoEmpleado(Boolean activarid_empresaTipoEmpleado) {
		this.activarid_empresaTipoEmpleado= activarid_empresaTipoEmpleado;
	}

	public Boolean getCargarid_empresaTipoEmpleado() {
		return this.cargarid_empresaTipoEmpleado;
	}

	public void setCargarid_empresaTipoEmpleado(Boolean cargarid_empresaTipoEmpleado) {
		this.cargarid_empresaTipoEmpleado= cargarid_empresaTipoEmpleado;
	}

	public Border setResaltarcodigoTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoEmpleado() {
		return this.resaltarcodigoTipoEmpleado;
	}

	public void setResaltarcodigoTipoEmpleado(Border borderResaltar) {
		this.resaltarcodigoTipoEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoEmpleado() {
		return this.mostrarcodigoTipoEmpleado;
	}

	public void setMostrarcodigoTipoEmpleado(Boolean mostrarcodigoTipoEmpleado) {
		this.mostrarcodigoTipoEmpleado= mostrarcodigoTipoEmpleado;
	}

	public Boolean getActivarcodigoTipoEmpleado() {
		return this.activarcodigoTipoEmpleado;
	}

	public void setActivarcodigoTipoEmpleado(Boolean activarcodigoTipoEmpleado) {
		this.activarcodigoTipoEmpleado= activarcodigoTipoEmpleado;
	}

	public Border setResaltarnombreTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEmpleado() {
		return this.resaltarnombreTipoEmpleado;
	}

	public void setResaltarnombreTipoEmpleado(Border borderResaltar) {
		this.resaltarnombreTipoEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEmpleado() {
		return this.mostrarnombreTipoEmpleado;
	}

	public void setMostrarnombreTipoEmpleado(Boolean mostrarnombreTipoEmpleado) {
		this.mostrarnombreTipoEmpleado= mostrarnombreTipoEmpleado;
	}

	public Boolean getActivarnombreTipoEmpleado() {
		return this.activarnombreTipoEmpleado;
	}

	public void setActivarnombreTipoEmpleado(Boolean activarnombreTipoEmpleado) {
		this.activarnombreTipoEmpleado= activarnombreTipoEmpleado;
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
		
		
		this.setMostraridTipoEmpleado(esInicial);
		this.setMostrarid_empresaTipoEmpleado(esInicial);
		this.setMostrarcodigoTipoEmpleado(esInicial);
		this.setMostrarnombreTipoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.ID)) {
				this.setMostraridTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEmpleado(esAsigna);
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
		
		
		this.setActivaridTipoEmpleado(esInicial);
		this.setActivarid_empresaTipoEmpleado(esInicial);
		this.setActivarcodigoTipoEmpleado(esInicial);
		this.setActivarnombreTipoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.ID)) {
				this.setActivaridTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEmpleado(esInicial);
		this.setResaltarid_empresaTipoEmpleado(esInicial);
		this.setResaltarcodigoTipoEmpleado(esInicial);
		this.setResaltarnombreTipoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoTipoEmpleado=null;

	public Border getResaltarEmpleadoTipoEmpleado() {
		return this.resaltarEmpleadoTipoEmpleado;
	}

	public void setResaltarEmpleadoTipoEmpleado(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoTipoEmpleado= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoempleadoBeanSwingJInternalFrame.jTtoolBarTipoEmpleado.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoTipoEmpleado= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoTipoEmpleado=true;

	public Boolean getMostrarEmpleadoTipoEmpleado() {
		return this.mostrarEmpleadoTipoEmpleado;
	}

	public void setMostrarEmpleadoTipoEmpleado(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoTipoEmpleado= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoTipoEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoTipoEmpleado() {
		return this.activarEmpleadoTipoEmpleado;
	}

	public void setActivarEmpleadoTipoEmpleado(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoTipoEmpleado= habilitarResaltarEmpleado;
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

		this.setMostrarEmpleadoTipoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoTipoEmpleado(esAsigna);
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

		this.setActivarEmpleadoTipoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoTipoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoTipoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoTipoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaTipoEmpleado() {
		return this.mostrarFK_IdEmpresaTipoEmpleado;
	}

	public void setMostrarFK_IdEmpresaTipoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoEmpleado=true;

	public Boolean getActivarFK_IdEmpresaTipoEmpleado() {
		return this.activarFK_IdEmpresaTipoEmpleado;
	}

	public void setActivarFK_IdEmpresaTipoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoEmpleado=null;

	public Border getResaltarFK_IdEmpresaTipoEmpleado() {
		return this.resaltarFK_IdEmpresaTipoEmpleado;
	}

	public void setResaltarFK_IdEmpresaTipoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEmpleadoBeanSwingJInternalFrame tipoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}