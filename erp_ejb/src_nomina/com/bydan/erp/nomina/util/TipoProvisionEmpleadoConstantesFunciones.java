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


import com.bydan.erp.nomina.util.TipoProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoProvisionEmpleadoParameterGeneral;

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
final public class TipoProvisionEmpleadoConstantesFunciones extends TipoProvisionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProvisionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProvisionEmpleado"+TipoProvisionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProvisionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProvisionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProvisionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProvisionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Provision Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Provision Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Provision Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProvisionEmpleado";
	public static final String OBJECTNAME="tipoprovisionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_provision_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprovisionempleado from "+TipoProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipoprovisionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoProvisionEmpleadoConstantesFuncionesAdditional tipoprovisionempleadoConstantesFuncionesAdditional=null;
	
	public TipoProvisionEmpleadoConstantesFuncionesAdditional getTipoProvisionEmpleadoConstantesFuncionesAdditional() {
		return this.tipoprovisionempleadoConstantesFuncionesAdditional;
	}
	
	public void setTipoProvisionEmpleadoConstantesFuncionesAdditional(TipoProvisionEmpleadoConstantesFuncionesAdditional tipoprovisionempleadoConstantesFuncionesAdditional) {
		try {
			this.tipoprovisionempleadoConstantesFuncionesAdditional=tipoprovisionempleadoConstantesFuncionesAdditional;
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
	
	public static String getTipoProvisionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProvisionEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=TipoProvisionEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProvisionEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoProvisionEmpleadoDescripcion(TipoProvisionEmpleado tipoprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprovisionempleado !=null/* && tipoprovisionempleado.getId()!=0*/) {
			sDescripcion=tipoprovisionempleado.getcodigo();//tipoprovisionempleadotipoprovisionempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProvisionEmpleadoDescripcionDetallado(TipoProvisionEmpleado tipoprovisionempleado) {
		String sDescripcion="";
			
		sDescripcion+=TipoProvisionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=tipoprovisionempleado.getId().toString()+",";
		sDescripcion+=TipoProvisionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprovisionempleado.getVersionRow().toString()+",";
		sDescripcion+=TipoProvisionEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprovisionempleado.getcodigo()+",";
		sDescripcion+=TipoProvisionEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprovisionempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProvisionEmpleadoDescripcion(TipoProvisionEmpleado tipoprovisionempleado,String sValor) throws Exception {			
		if(tipoprovisionempleado !=null) {
			tipoprovisionempleado.setcodigo(sValor);;//tipoprovisionempleadotipoprovisionempleado.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprovisionempleado.setcodigo(tipoprovisionempleado.getcodigo().trim());
		tipoprovisionempleado.setnombre(tipoprovisionempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProvisionEmpleados(List<TipoProvisionEmpleado> tipoprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {
			tipoprovisionempleado.setcodigo(tipoprovisionempleado.getcodigo().trim());
			tipoprovisionempleado.setnombre(tipoprovisionempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprovisionempleado.getConCambioAuxiliar()) {
			tipoprovisionempleado.setIsDeleted(tipoprovisionempleado.getIsDeletedAuxiliar());	
			tipoprovisionempleado.setIsNew(tipoprovisionempleado.getIsNewAuxiliar());	
			tipoprovisionempleado.setIsChanged(tipoprovisionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprovisionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprovisionempleado.setIsDeletedAuxiliar(false);	
			tipoprovisionempleado.setIsNewAuxiliar(false);	
			tipoprovisionempleado.setIsChangedAuxiliar(false);
			
			tipoprovisionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProvisionEmpleados(List<TipoProvisionEmpleado> tipoprovisionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado : tipoprovisionempleados) {
			if(conAsignarBase && tipoprovisionempleado.getConCambioAuxiliar()) {
				tipoprovisionempleado.setIsDeleted(tipoprovisionempleado.getIsDeletedAuxiliar());	
				tipoprovisionempleado.setIsNew(tipoprovisionempleado.getIsNewAuxiliar());	
				tipoprovisionempleado.setIsChanged(tipoprovisionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprovisionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprovisionempleado.setIsDeletedAuxiliar(false);	
				tipoprovisionempleado.setIsNewAuxiliar(false);	
				tipoprovisionempleado.setIsChangedAuxiliar(false);
				
				tipoprovisionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProvisionEmpleados(List<TipoProvisionEmpleado> tipoprovisionempleados,Boolean conEnteros) throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProvisionEmpleado(List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleado tipoprovisionempleadoAux) throws Exception  {
		TipoProvisionEmpleadoConstantesFunciones.InicializarValoresTipoProvisionEmpleado(tipoprovisionempleadoAux,true);
		
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {
			if(tipoprovisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProvisionEmpleadoConstantesFunciones.getArrayColumnasGlobalesTipoProvisionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleado tipoprovisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProvisionEmpleado tipoprovisionempleadoAux: tipoprovisionempleados) {
			if(tipoprovisionempleadoAux!=null && tipoprovisionempleado!=null) {
				if((tipoprovisionempleadoAux.getId()==null && tipoprovisionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprovisionempleadoAux.getId()!=null && tipoprovisionempleado.getId()!=null){
					if(tipoprovisionempleadoAux.getId().equals(tipoprovisionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProvisionEmpleado(List<TipoProvisionEmpleado> tipoprovisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {			
			if(tipoprovisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProvisionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProvisionEmpleadoConstantesFunciones.LABEL_ID, TipoProvisionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProvisionEmpleadoConstantesFunciones.LABEL_VERSIONROW, TipoProvisionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProvisionEmpleadoConstantesFunciones.LABEL_CODIGO, TipoProvisionEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE, TipoProvisionEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProvisionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProvisionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProvisionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProvisionEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProvisionEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProvisionEmpleado() throws Exception  {
		return TipoProvisionEmpleadoConstantesFunciones.getTiposSeleccionarTipoProvisionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProvisionEmpleado(Boolean conFk) throws Exception  {
		return TipoProvisionEmpleadoConstantesFunciones.getTiposSeleccionarTipoProvisionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProvisionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProvisionEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProvisionEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProvisionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleadoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProvisionEmpleado(List<TipoProvisionEmpleado> tipoprovisionempleadosTemp) throws Exception {
		for(TipoProvisionEmpleado tipoprovisionempleadoAux:tipoprovisionempleadosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoProvisionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProvisionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProvisionEmpleado.class)) {
						classes.add(new Classe(ProvisionEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProvisionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProvisionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
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
	public static void actualizarLista(TipoProvisionEmpleado tipoprovisionempleado,List<TipoProvisionEmpleado> tipoprovisionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProvisionEmpleado tipoprovisionempleadoEncontrado=null;
			
			for(TipoProvisionEmpleado tipoprovisionempleadoLocal:tipoprovisionempleados) {
				if(tipoprovisionempleadoLocal.getId().equals(tipoprovisionempleado.getId())) {
					tipoprovisionempleadoEncontrado=tipoprovisionempleadoLocal;
					
					tipoprovisionempleadoLocal.setIsChanged(tipoprovisionempleado.getIsChanged());
					tipoprovisionempleadoLocal.setIsNew(tipoprovisionempleado.getIsNew());
					tipoprovisionempleadoLocal.setIsDeleted(tipoprovisionempleado.getIsDeleted());
					
					tipoprovisionempleadoLocal.setGeneralEntityOriginal(tipoprovisionempleado.getGeneralEntityOriginal());
					
					tipoprovisionempleadoLocal.setId(tipoprovisionempleado.getId());	
					tipoprovisionempleadoLocal.setVersionRow(tipoprovisionempleado.getVersionRow());	
					tipoprovisionempleadoLocal.setcodigo(tipoprovisionempleado.getcodigo());	
					tipoprovisionempleadoLocal.setnombre(tipoprovisionempleado.getnombre());	
					
					
					tipoprovisionempleadoLocal.setProvisionEmpleados(tipoprovisionempleado.getProvisionEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprovisionempleado.getIsDeleted()) {
				if(!existe) {
					tipoprovisionempleados.add(tipoprovisionempleado);
				}
			} else {
				if(tipoprovisionempleadoEncontrado!=null && permiteQuitar)  {
					tipoprovisionempleados.remove(tipoprovisionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProvisionEmpleado tipoprovisionempleado,List<TipoProvisionEmpleado> tipoprovisionempleados) throws Exception {
		try	{			
			for(TipoProvisionEmpleado tipoprovisionempleadoLocal:tipoprovisionempleados) {
				if(tipoprovisionempleadoLocal.getId().equals(tipoprovisionempleado.getId())) {
					tipoprovisionempleadoLocal.setIsSelected(tipoprovisionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProvisionEmpleado(List<TipoProvisionEmpleado> tipoprovisionempleadosAux) throws Exception {
		//this.tipoprovisionempleadosAux=tipoprovisionempleadosAux;
		
		for(TipoProvisionEmpleado tipoprovisionempleadoAux:tipoprovisionempleadosAux) {
			if(tipoprovisionempleadoAux.getIsChanged()) {
				tipoprovisionempleadoAux.setIsChanged(false);
			}		
			
			if(tipoprovisionempleadoAux.getIsNew()) {
				tipoprovisionempleadoAux.setIsNew(false);
			}	
			
			if(tipoprovisionempleadoAux.getIsDeleted()) {
				tipoprovisionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleadoAux) throws Exception {
		//this.tipoprovisionempleadoAux=tipoprovisionempleadoAux;
		
			if(tipoprovisionempleadoAux.getIsChanged()) {
				tipoprovisionempleadoAux.setIsChanged(false);
			}		
			
			if(tipoprovisionempleadoAux.getIsNew()) {
				tipoprovisionempleadoAux.setIsNew(false);
			}	
			
			if(tipoprovisionempleadoAux.getIsDeleted()) {
				tipoprovisionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProvisionEmpleado tipoprovisionempleadoAsignar,TipoProvisionEmpleado tipoprovisionempleado) throws Exception {
		tipoprovisionempleadoAsignar.setId(tipoprovisionempleado.getId());	
		tipoprovisionempleadoAsignar.setVersionRow(tipoprovisionempleado.getVersionRow());	
		tipoprovisionempleadoAsignar.setcodigo(tipoprovisionempleado.getcodigo());	
		tipoprovisionempleadoAsignar.setnombre(tipoprovisionempleado.getnombre());	
	}
	
	public static void inicializarTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado) throws Exception {
		try {
				tipoprovisionempleado.setId(0L);	
					
				tipoprovisionempleado.setcodigo("");	
				tipoprovisionempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProvisionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProvisionEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProvisionEmpleado(String sTipo,Row row,Workbook workbook,TipoProvisionEmpleado tipoprovisionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprovisionempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprovisionempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProvisionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProvisionEmpleado() {
		return this.sFinalQueryTipoProvisionEmpleado;
	}
	
	public void setsFinalQueryTipoProvisionEmpleado(String sFinalQueryTipoProvisionEmpleado) {
		this.sFinalQueryTipoProvisionEmpleado= sFinalQueryTipoProvisionEmpleado;
	}
	
	public Border resaltarSeleccionarTipoProvisionEmpleado=null;
	
	public Border setResaltarSeleccionarTipoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprovisionempleadoBeanSwingJInternalFrame.jTtoolBarTipoProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProvisionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProvisionEmpleado() {
		return this.resaltarSeleccionarTipoProvisionEmpleado;
	}
	
	public void setResaltarSeleccionarTipoProvisionEmpleado(Border borderResaltarSeleccionarTipoProvisionEmpleado) {
		this.resaltarSeleccionarTipoProvisionEmpleado= borderResaltarSeleccionarTipoProvisionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProvisionEmpleado=null;
	public Boolean mostraridTipoProvisionEmpleado=true;
	public Boolean activaridTipoProvisionEmpleado=true;

	public Border resaltarcodigoTipoProvisionEmpleado=null;
	public Boolean mostrarcodigoTipoProvisionEmpleado=true;
	public Boolean activarcodigoTipoProvisionEmpleado=true;

	public Border resaltarnombreTipoProvisionEmpleado=null;
	public Boolean mostrarnombreTipoProvisionEmpleado=true;
	public Boolean activarnombreTipoProvisionEmpleado=true;

	
	

	public Border setResaltaridTipoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprovisionempleadoBeanSwingJInternalFrame.jTtoolBarTipoProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridTipoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProvisionEmpleado() {
		return this.resaltaridTipoProvisionEmpleado;
	}

	public void setResaltaridTipoProvisionEmpleado(Border borderResaltar) {
		this.resaltaridTipoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostraridTipoProvisionEmpleado() {
		return this.mostraridTipoProvisionEmpleado;
	}

	public void setMostraridTipoProvisionEmpleado(Boolean mostraridTipoProvisionEmpleado) {
		this.mostraridTipoProvisionEmpleado= mostraridTipoProvisionEmpleado;
	}

	public Boolean getActivaridTipoProvisionEmpleado() {
		return this.activaridTipoProvisionEmpleado;
	}

	public void setActivaridTipoProvisionEmpleado(Boolean activaridTipoProvisionEmpleado) {
		this.activaridTipoProvisionEmpleado= activaridTipoProvisionEmpleado;
	}

	public Border setResaltarcodigoTipoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprovisionempleadoBeanSwingJInternalFrame.jTtoolBarTipoProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProvisionEmpleado() {
		return this.resaltarcodigoTipoProvisionEmpleado;
	}

	public void setResaltarcodigoTipoProvisionEmpleado(Border borderResaltar) {
		this.resaltarcodigoTipoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProvisionEmpleado() {
		return this.mostrarcodigoTipoProvisionEmpleado;
	}

	public void setMostrarcodigoTipoProvisionEmpleado(Boolean mostrarcodigoTipoProvisionEmpleado) {
		this.mostrarcodigoTipoProvisionEmpleado= mostrarcodigoTipoProvisionEmpleado;
	}

	public Boolean getActivarcodigoTipoProvisionEmpleado() {
		return this.activarcodigoTipoProvisionEmpleado;
	}

	public void setActivarcodigoTipoProvisionEmpleado(Boolean activarcodigoTipoProvisionEmpleado) {
		this.activarcodigoTipoProvisionEmpleado= activarcodigoTipoProvisionEmpleado;
	}

	public Border setResaltarnombreTipoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprovisionempleadoBeanSwingJInternalFrame.jTtoolBarTipoProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProvisionEmpleado() {
		return this.resaltarnombreTipoProvisionEmpleado;
	}

	public void setResaltarnombreTipoProvisionEmpleado(Border borderResaltar) {
		this.resaltarnombreTipoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProvisionEmpleado() {
		return this.mostrarnombreTipoProvisionEmpleado;
	}

	public void setMostrarnombreTipoProvisionEmpleado(Boolean mostrarnombreTipoProvisionEmpleado) {
		this.mostrarnombreTipoProvisionEmpleado= mostrarnombreTipoProvisionEmpleado;
	}

	public Boolean getActivarnombreTipoProvisionEmpleado() {
		return this.activarnombreTipoProvisionEmpleado;
	}

	public void setActivarnombreTipoProvisionEmpleado(Boolean activarnombreTipoProvisionEmpleado) {
		this.activarnombreTipoProvisionEmpleado= activarnombreTipoProvisionEmpleado;
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
		
		
		this.setMostraridTipoProvisionEmpleado(esInicial);
		this.setMostrarcodigoTipoProvisionEmpleado(esInicial);
		this.setMostrarnombreTipoProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProvisionEmpleado(esAsigna);
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
		
		
		this.setActivaridTipoProvisionEmpleado(esInicial);
		this.setActivarcodigoTipoProvisionEmpleado(esInicial);
		this.setActivarnombreTipoProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProvisionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProvisionEmpleado(esInicial);
		this.setResaltarcodigoTipoProvisionEmpleado(esInicial);
		this.setResaltarnombreTipoProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProvisionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProvisionEmpleadoTipoProvisionEmpleado=null;

	public Border getResaltarProvisionEmpleadoTipoProvisionEmpleado() {
		return this.resaltarProvisionEmpleadoTipoProvisionEmpleado;
	}

	public void setResaltarProvisionEmpleadoTipoProvisionEmpleado(Border borderResaltarProvisionEmpleado) {
		if(borderResaltarProvisionEmpleado!=null) {
			this.resaltarProvisionEmpleadoTipoProvisionEmpleado= borderResaltarProvisionEmpleado;
		}
	}

	public Border setResaltarProvisionEmpleadoTipoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarProvisionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprovisionempleadoBeanSwingJInternalFrame.jTtoolBarTipoProvisionEmpleado.setBorder(borderResaltarProvisionEmpleado);
			
		this.resaltarProvisionEmpleadoTipoProvisionEmpleado= borderResaltarProvisionEmpleado;

		 return borderResaltarProvisionEmpleado;
	}



	public Boolean mostrarProvisionEmpleadoTipoProvisionEmpleado=true;

	public Boolean getMostrarProvisionEmpleadoTipoProvisionEmpleado() {
		return this.mostrarProvisionEmpleadoTipoProvisionEmpleado;
	}

	public void setMostrarProvisionEmpleadoTipoProvisionEmpleado(Boolean visibilidadResaltarProvisionEmpleado) {
		this.mostrarProvisionEmpleadoTipoProvisionEmpleado= visibilidadResaltarProvisionEmpleado;
	}



	public Boolean activarProvisionEmpleadoTipoProvisionEmpleado=true;

	public Boolean gethabilitarResaltarProvisionEmpleadoTipoProvisionEmpleado() {
		return this.activarProvisionEmpleadoTipoProvisionEmpleado;
	}

	public void setActivarProvisionEmpleadoTipoProvisionEmpleado(Boolean habilitarResaltarProvisionEmpleado) {
		this.activarProvisionEmpleadoTipoProvisionEmpleado= habilitarResaltarProvisionEmpleado;
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

		this.setMostrarProvisionEmpleadoTipoProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setMostrarProvisionEmpleadoTipoProvisionEmpleado(esAsigna);
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

		this.setActivarProvisionEmpleadoTipoProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setActivarProvisionEmpleadoTipoProvisionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProvisionEmpleadoBeanSwingJInternalFrame tipoprovisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProvisionEmpleadoTipoProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setResaltarProvisionEmpleadoTipoProvisionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}