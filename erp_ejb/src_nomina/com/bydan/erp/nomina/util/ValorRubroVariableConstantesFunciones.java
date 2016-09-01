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


import com.bydan.erp.nomina.util.ValorRubroVariableConstantesFunciones;
import com.bydan.erp.nomina.util.ValorRubroVariableParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ValorRubroVariableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ValorRubroVariableConstantesFunciones extends ValorRubroVariableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ValorRubroVariable";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ValorRubroVariable"+ValorRubroVariableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ValorRubroVariableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ValorRubroVariableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ValorRubroVariableConstantesFunciones.SCHEMA+"_"+ValorRubroVariableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ValorRubroVariableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ValorRubroVariableConstantesFunciones.SCHEMA+"_"+ValorRubroVariableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ValorRubroVariableConstantesFunciones.SCHEMA+"_"+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ValorRubroVariableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ValorRubroVariableConstantesFunciones.SCHEMA+"_"+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ValorRubroVariableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ValorRubroVariableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorRubroVariableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ValorRubroVariableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ValorRubroVariableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ValorRubroVariableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ValorRubroVariableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Valor Rubro Variables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Valor Rubro Variable";
	public static final String SCLASSWEBTITULO_LOWER="Valor Rubro Variable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ValorRubroVariable";
	public static final String OBJECTNAME="valorrubrovariable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="valor_rubro_variable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select valorrubrovariable from "+ValorRubroVariableConstantesFunciones.SPERSISTENCENAME+" valorrubrovariable";
	public static String QUERYSELECTNATIVE="select "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".version_row,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_empresa,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_empleado,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_rubro_emplea,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".fecha,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".valor from "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME;//+" as "+ValorRubroVariableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ValorRubroVariableConstantesFuncionesAdditional valorrubrovariableConstantesFuncionesAdditional=null;
	
	public ValorRubroVariableConstantesFuncionesAdditional getValorRubroVariableConstantesFuncionesAdditional() {
		return this.valorrubrovariableConstantesFuncionesAdditional;
	}
	
	public void setValorRubroVariableConstantesFuncionesAdditional(ValorRubroVariableConstantesFuncionesAdditional valorrubrovariableConstantesFuncionesAdditional) {
		try {
			this.valorrubrovariableConstantesFuncionesAdditional=valorrubrovariableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
	
	public static String getValorRubroVariableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ValorRubroVariableConstantesFunciones.IDEMPRESA)) {sLabelColumna=ValorRubroVariableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ValorRubroVariableConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ValorRubroVariableConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=ValorRubroVariableConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(ValorRubroVariableConstantesFunciones.FECHA)) {sLabelColumna=ValorRubroVariableConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ValorRubroVariableConstantesFunciones.VALOR)) {sLabelColumna=ValorRubroVariableConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getValorRubroVariableDescripcion(ValorRubroVariable valorrubrovariable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(valorrubrovariable !=null/* && valorrubrovariable.getId()!=0*/) {
			if(valorrubrovariable.getId()!=null) {
				sDescripcion=valorrubrovariable.getId().toString();
			}//valorrubrovariablevalorrubrovariable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getValorRubroVariableDescripcionDetallado(ValorRubroVariable valorrubrovariable) {
		String sDescripcion="";
			
		sDescripcion+=ValorRubroVariableConstantesFunciones.ID+"=";
		sDescripcion+=valorrubrovariable.getId().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=valorrubrovariable.getVersionRow().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=valorrubrovariable.getid_empresa().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=valorrubrovariable.getid_empleado().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=valorrubrovariable.getid_rubro_emplea().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.FECHA+"=";
		sDescripcion+=valorrubrovariable.getfecha().toString()+",";
		sDescripcion+=ValorRubroVariableConstantesFunciones.VALOR+"=";
		sDescripcion+=valorrubrovariable.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setValorRubroVariableDescripcion(ValorRubroVariable valorrubrovariable,String sValor) throws Exception {			
		if(valorrubrovariable !=null) {
			//valorrubrovariablevalorrubrovariable.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosValorRubroVariable(ValorRubroVariable valorrubrovariable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosValorRubroVariables(List<ValorRubroVariable> valorrubrovariables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ValorRubroVariable valorrubrovariable: valorrubrovariables) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresValorRubroVariable(ValorRubroVariable valorrubrovariable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && valorrubrovariable.getConCambioAuxiliar()) {
			valorrubrovariable.setIsDeleted(valorrubrovariable.getIsDeletedAuxiliar());	
			valorrubrovariable.setIsNew(valorrubrovariable.getIsNewAuxiliar());	
			valorrubrovariable.setIsChanged(valorrubrovariable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			valorrubrovariable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			valorrubrovariable.setIsDeletedAuxiliar(false);	
			valorrubrovariable.setIsNewAuxiliar(false);	
			valorrubrovariable.setIsChangedAuxiliar(false);
			
			valorrubrovariable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresValorRubroVariables(List<ValorRubroVariable> valorrubrovariables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ValorRubroVariable valorrubrovariable : valorrubrovariables) {
			if(conAsignarBase && valorrubrovariable.getConCambioAuxiliar()) {
				valorrubrovariable.setIsDeleted(valorrubrovariable.getIsDeletedAuxiliar());	
				valorrubrovariable.setIsNew(valorrubrovariable.getIsNewAuxiliar());	
				valorrubrovariable.setIsChanged(valorrubrovariable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				valorrubrovariable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				valorrubrovariable.setIsDeletedAuxiliar(false);	
				valorrubrovariable.setIsNewAuxiliar(false);	
				valorrubrovariable.setIsChangedAuxiliar(false);
				
				valorrubrovariable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresValorRubroVariable(ValorRubroVariable valorrubrovariable,Boolean conEnteros) throws Exception  {
		valorrubrovariable.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresValorRubroVariables(List<ValorRubroVariable> valorrubrovariables,Boolean conEnteros) throws Exception  {
		
		for(ValorRubroVariable valorrubrovariable: valorrubrovariables) {
			valorrubrovariable.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaValorRubroVariable(List<ValorRubroVariable> valorrubrovariables,ValorRubroVariable valorrubrovariableAux) throws Exception  {
		ValorRubroVariableConstantesFunciones.InicializarValoresValorRubroVariable(valorrubrovariableAux,true);
		
		for(ValorRubroVariable valorrubrovariable: valorrubrovariables) {
			if(valorrubrovariable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorrubrovariableAux.setvalor(valorrubrovariableAux.getvalor()+valorrubrovariable.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesValorRubroVariable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ValorRubroVariableConstantesFunciones.getArrayColumnasGlobalesValorRubroVariable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesValorRubroVariable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ValorRubroVariableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ValorRubroVariableConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoValorRubroVariable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ValorRubroVariable> valorrubrovariables,ValorRubroVariable valorrubrovariable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ValorRubroVariable valorrubrovariableAux: valorrubrovariables) {
			if(valorrubrovariableAux!=null && valorrubrovariable!=null) {
				if((valorrubrovariableAux.getId()==null && valorrubrovariable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(valorrubrovariableAux.getId()!=null && valorrubrovariable.getId()!=null){
					if(valorrubrovariableAux.getId().equals(valorrubrovariable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaValorRubroVariable(List<ValorRubroVariable> valorrubrovariables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ValorRubroVariable valorrubrovariable: valorrubrovariables) {			
			if(valorrubrovariable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=valorrubrovariable.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ValorRubroVariableConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaValorRubroVariable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_ID, ValorRubroVariableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_VERSIONROW, ValorRubroVariableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_IDEMPRESA, ValorRubroVariableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_IDEMPLEADO, ValorRubroVariableConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_IDRUBROEMPLEA, ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_FECHA, ValorRubroVariableConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorRubroVariableConstantesFunciones.LABEL_VALOR, ValorRubroVariableConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasValorRubroVariable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorRubroVariableConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorRubroVariable() throws Exception  {
		return ValorRubroVariableConstantesFunciones.getTiposSeleccionarValorRubroVariable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorRubroVariable(Boolean conFk) throws Exception  {
		return ValorRubroVariableConstantesFunciones.getTiposSeleccionarValorRubroVariable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorRubroVariable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorRubroVariableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorRubroVariableConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorRubroVariableConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorRubroVariableConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorRubroVariableConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ValorRubroVariableConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesValorRubroVariable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesValorRubroVariable(ValorRubroVariable valorrubrovariableAux) throws Exception {
		
			valorrubrovariableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(valorrubrovariableAux.getEmpresa()));
			valorrubrovariableAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(valorrubrovariableAux.getEmpleado()));
			valorrubrovariableAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(valorrubrovariableAux.getRubroEmplea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesValorRubroVariable(List<ValorRubroVariable> valorrubrovariablesTemp) throws Exception {
		for(ValorRubroVariable valorrubrovariableAux:valorrubrovariablesTemp) {
			
			valorrubrovariableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(valorrubrovariableAux.getEmpresa()));
			valorrubrovariableAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(valorrubrovariableAux.getEmpleado()));
			valorrubrovariableAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(valorrubrovariableAux.getRubroEmplea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfValorRubroVariable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(RubroEmplea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfValorRubroVariable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorRubroVariable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ValorRubroVariableConstantesFunciones.getClassesRelationshipsOfValorRubroVariable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorRubroVariable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfValorRubroVariable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ValorRubroVariableConstantesFunciones.getClassesRelationshipsFromStringsOfValorRubroVariable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfValorRubroVariable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ValorRubroVariable valorrubrovariable,List<ValorRubroVariable> valorrubrovariables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ValorRubroVariable valorrubrovariableEncontrado=null;
			
			for(ValorRubroVariable valorrubrovariableLocal:valorrubrovariables) {
				if(valorrubrovariableLocal.getId().equals(valorrubrovariable.getId())) {
					valorrubrovariableEncontrado=valorrubrovariableLocal;
					
					valorrubrovariableLocal.setIsChanged(valorrubrovariable.getIsChanged());
					valorrubrovariableLocal.setIsNew(valorrubrovariable.getIsNew());
					valorrubrovariableLocal.setIsDeleted(valorrubrovariable.getIsDeleted());
					
					valorrubrovariableLocal.setGeneralEntityOriginal(valorrubrovariable.getGeneralEntityOriginal());
					
					valorrubrovariableLocal.setId(valorrubrovariable.getId());	
					valorrubrovariableLocal.setVersionRow(valorrubrovariable.getVersionRow());	
					valorrubrovariableLocal.setid_empresa(valorrubrovariable.getid_empresa());	
					valorrubrovariableLocal.setid_empleado(valorrubrovariable.getid_empleado());	
					valorrubrovariableLocal.setid_rubro_emplea(valorrubrovariable.getid_rubro_emplea());	
					valorrubrovariableLocal.setfecha(valorrubrovariable.getfecha());	
					valorrubrovariableLocal.setvalor(valorrubrovariable.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!valorrubrovariable.getIsDeleted()) {
				if(!existe) {
					valorrubrovariables.add(valorrubrovariable);
				}
			} else {
				if(valorrubrovariableEncontrado!=null && permiteQuitar)  {
					valorrubrovariables.remove(valorrubrovariableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ValorRubroVariable valorrubrovariable,List<ValorRubroVariable> valorrubrovariables) throws Exception {
		try	{			
			for(ValorRubroVariable valorrubrovariableLocal:valorrubrovariables) {
				if(valorrubrovariableLocal.getId().equals(valorrubrovariable.getId())) {
					valorrubrovariableLocal.setIsSelected(valorrubrovariable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesValorRubroVariable(List<ValorRubroVariable> valorrubrovariablesAux) throws Exception {
		//this.valorrubrovariablesAux=valorrubrovariablesAux;
		
		for(ValorRubroVariable valorrubrovariableAux:valorrubrovariablesAux) {
			if(valorrubrovariableAux.getIsChanged()) {
				valorrubrovariableAux.setIsChanged(false);
			}		
			
			if(valorrubrovariableAux.getIsNew()) {
				valorrubrovariableAux.setIsNew(false);
			}	
			
			if(valorrubrovariableAux.getIsDeleted()) {
				valorrubrovariableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesValorRubroVariable(ValorRubroVariable valorrubrovariableAux) throws Exception {
		//this.valorrubrovariableAux=valorrubrovariableAux;
		
			if(valorrubrovariableAux.getIsChanged()) {
				valorrubrovariableAux.setIsChanged(false);
			}		
			
			if(valorrubrovariableAux.getIsNew()) {
				valorrubrovariableAux.setIsNew(false);
			}	
			
			if(valorrubrovariableAux.getIsDeleted()) {
				valorrubrovariableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ValorRubroVariable valorrubrovariableAsignar,ValorRubroVariable valorrubrovariable) throws Exception {
		valorrubrovariableAsignar.setId(valorrubrovariable.getId());	
		valorrubrovariableAsignar.setVersionRow(valorrubrovariable.getVersionRow());	
		valorrubrovariableAsignar.setid_empresa(valorrubrovariable.getid_empresa());
		valorrubrovariableAsignar.setempresa_descripcion(valorrubrovariable.getempresa_descripcion());	
		valorrubrovariableAsignar.setid_empleado(valorrubrovariable.getid_empleado());
		valorrubrovariableAsignar.setempleado_descripcion(valorrubrovariable.getempleado_descripcion());	
		valorrubrovariableAsignar.setid_rubro_emplea(valorrubrovariable.getid_rubro_emplea());
		valorrubrovariableAsignar.setrubroemplea_descripcion(valorrubrovariable.getrubroemplea_descripcion());	
		valorrubrovariableAsignar.setfecha(valorrubrovariable.getfecha());	
		valorrubrovariableAsignar.setvalor(valorrubrovariable.getvalor());	
	}
	
	public static void inicializarValorRubroVariable(ValorRubroVariable valorrubrovariable) throws Exception {
		try {
				valorrubrovariable.setId(0L);	
					
				valorrubrovariable.setid_empresa(-1L);	
				valorrubrovariable.setid_empleado(-1L);	
				valorrubrovariable.setid_rubro_emplea(-1L);	
				valorrubrovariable.setfecha(new Date());	
				valorrubrovariable.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderValorRubroVariable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorRubroVariableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorRubroVariableConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorRubroVariableConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorRubroVariableConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorRubroVariableConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataValorRubroVariable(String sTipo,Row row,Workbook workbook,ValorRubroVariable valorrubrovariable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(valorrubrovariable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorrubrovariable.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorrubrovariable.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorrubrovariable.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorrubrovariable.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryValorRubroVariable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryValorRubroVariable() {
		return this.sFinalQueryValorRubroVariable;
	}
	
	public void setsFinalQueryValorRubroVariable(String sFinalQueryValorRubroVariable) {
		this.sFinalQueryValorRubroVariable= sFinalQueryValorRubroVariable;
	}
	
	public Border resaltarSeleccionarValorRubroVariable=null;
	
	public Border setResaltarSeleccionarValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarValorRubroVariable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarValorRubroVariable() {
		return this.resaltarSeleccionarValorRubroVariable;
	}
	
	public void setResaltarSeleccionarValorRubroVariable(Border borderResaltarSeleccionarValorRubroVariable) {
		this.resaltarSeleccionarValorRubroVariable= borderResaltarSeleccionarValorRubroVariable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridValorRubroVariable=null;
	public Boolean mostraridValorRubroVariable=true;
	public Boolean activaridValorRubroVariable=true;

	public Border resaltarid_empresaValorRubroVariable=null;
	public Boolean mostrarid_empresaValorRubroVariable=true;
	public Boolean activarid_empresaValorRubroVariable=true;
	public Boolean cargarid_empresaValorRubroVariable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaValorRubroVariable=false;//ConEventDepend=true

	public Border resaltarid_empleadoValorRubroVariable=null;
	public Boolean mostrarid_empleadoValorRubroVariable=true;
	public Boolean activarid_empleadoValorRubroVariable=true;
	public Boolean cargarid_empleadoValorRubroVariable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoValorRubroVariable=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaValorRubroVariable=null;
	public Boolean mostrarid_rubro_empleaValorRubroVariable=true;
	public Boolean activarid_rubro_empleaValorRubroVariable=true;
	public Boolean cargarid_rubro_empleaValorRubroVariable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaValorRubroVariable=false;//ConEventDepend=true

	public Border resaltarfechaValorRubroVariable=null;
	public Boolean mostrarfechaValorRubroVariable=true;
	public Boolean activarfechaValorRubroVariable=false;

	public Border resaltarvalorValorRubroVariable=null;
	public Boolean mostrarvalorValorRubroVariable=true;
	public Boolean activarvalorValorRubroVariable=true;

	
	

	public Border setResaltaridValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltaridValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridValorRubroVariable() {
		return this.resaltaridValorRubroVariable;
	}

	public void setResaltaridValorRubroVariable(Border borderResaltar) {
		this.resaltaridValorRubroVariable= borderResaltar;
	}

	public Boolean getMostraridValorRubroVariable() {
		return this.mostraridValorRubroVariable;
	}

	public void setMostraridValorRubroVariable(Boolean mostraridValorRubroVariable) {
		this.mostraridValorRubroVariable= mostraridValorRubroVariable;
	}

	public Boolean getActivaridValorRubroVariable() {
		return this.activaridValorRubroVariable;
	}

	public void setActivaridValorRubroVariable(Boolean activaridValorRubroVariable) {
		this.activaridValorRubroVariable= activaridValorRubroVariable;
	}

	public Border setResaltarid_empresaValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarid_empresaValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaValorRubroVariable() {
		return this.resaltarid_empresaValorRubroVariable;
	}

	public void setResaltarid_empresaValorRubroVariable(Border borderResaltar) {
		this.resaltarid_empresaValorRubroVariable= borderResaltar;
	}

	public Boolean getMostrarid_empresaValorRubroVariable() {
		return this.mostrarid_empresaValorRubroVariable;
	}

	public void setMostrarid_empresaValorRubroVariable(Boolean mostrarid_empresaValorRubroVariable) {
		this.mostrarid_empresaValorRubroVariable= mostrarid_empresaValorRubroVariable;
	}

	public Boolean getActivarid_empresaValorRubroVariable() {
		return this.activarid_empresaValorRubroVariable;
	}

	public void setActivarid_empresaValorRubroVariable(Boolean activarid_empresaValorRubroVariable) {
		this.activarid_empresaValorRubroVariable= activarid_empresaValorRubroVariable;
	}

	public Boolean getCargarid_empresaValorRubroVariable() {
		return this.cargarid_empresaValorRubroVariable;
	}

	public void setCargarid_empresaValorRubroVariable(Boolean cargarid_empresaValorRubroVariable) {
		this.cargarid_empresaValorRubroVariable= cargarid_empresaValorRubroVariable;
	}

	public Border setResaltarid_empleadoValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarid_empleadoValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoValorRubroVariable() {
		return this.resaltarid_empleadoValorRubroVariable;
	}

	public void setResaltarid_empleadoValorRubroVariable(Border borderResaltar) {
		this.resaltarid_empleadoValorRubroVariable= borderResaltar;
	}

	public Boolean getMostrarid_empleadoValorRubroVariable() {
		return this.mostrarid_empleadoValorRubroVariable;
	}

	public void setMostrarid_empleadoValorRubroVariable(Boolean mostrarid_empleadoValorRubroVariable) {
		this.mostrarid_empleadoValorRubroVariable= mostrarid_empleadoValorRubroVariable;
	}

	public Boolean getActivarid_empleadoValorRubroVariable() {
		return this.activarid_empleadoValorRubroVariable;
	}

	public void setActivarid_empleadoValorRubroVariable(Boolean activarid_empleadoValorRubroVariable) {
		this.activarid_empleadoValorRubroVariable= activarid_empleadoValorRubroVariable;
	}

	public Boolean getCargarid_empleadoValorRubroVariable() {
		return this.cargarid_empleadoValorRubroVariable;
	}

	public void setCargarid_empleadoValorRubroVariable(Boolean cargarid_empleadoValorRubroVariable) {
		this.cargarid_empleadoValorRubroVariable= cargarid_empleadoValorRubroVariable;
	}

	public Border setResaltarid_rubro_empleaValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaValorRubroVariable() {
		return this.resaltarid_rubro_empleaValorRubroVariable;
	}

	public void setResaltarid_rubro_empleaValorRubroVariable(Border borderResaltar) {
		this.resaltarid_rubro_empleaValorRubroVariable= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaValorRubroVariable() {
		return this.mostrarid_rubro_empleaValorRubroVariable;
	}

	public void setMostrarid_rubro_empleaValorRubroVariable(Boolean mostrarid_rubro_empleaValorRubroVariable) {
		this.mostrarid_rubro_empleaValorRubroVariable= mostrarid_rubro_empleaValorRubroVariable;
	}

	public Boolean getActivarid_rubro_empleaValorRubroVariable() {
		return this.activarid_rubro_empleaValorRubroVariable;
	}

	public void setActivarid_rubro_empleaValorRubroVariable(Boolean activarid_rubro_empleaValorRubroVariable) {
		this.activarid_rubro_empleaValorRubroVariable= activarid_rubro_empleaValorRubroVariable;
	}

	public Boolean getCargarid_rubro_empleaValorRubroVariable() {
		return this.cargarid_rubro_empleaValorRubroVariable;
	}

	public void setCargarid_rubro_empleaValorRubroVariable(Boolean cargarid_rubro_empleaValorRubroVariable) {
		this.cargarid_rubro_empleaValorRubroVariable= cargarid_rubro_empleaValorRubroVariable;
	}

	public Border setResaltarfechaValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarfechaValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaValorRubroVariable() {
		return this.resaltarfechaValorRubroVariable;
	}

	public void setResaltarfechaValorRubroVariable(Border borderResaltar) {
		this.resaltarfechaValorRubroVariable= borderResaltar;
	}

	public Boolean getMostrarfechaValorRubroVariable() {
		return this.mostrarfechaValorRubroVariable;
	}

	public void setMostrarfechaValorRubroVariable(Boolean mostrarfechaValorRubroVariable) {
		this.mostrarfechaValorRubroVariable= mostrarfechaValorRubroVariable;
	}

	public Boolean getActivarfechaValorRubroVariable() {
		return this.activarfechaValorRubroVariable;
	}

	public void setActivarfechaValorRubroVariable(Boolean activarfechaValorRubroVariable) {
		this.activarfechaValorRubroVariable= activarfechaValorRubroVariable;
	}

	public Border setResaltarvalorValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorrubrovariableBeanSwingJInternalFrame.jTtoolBarValorRubroVariable.setBorder(borderResaltar);
		
		this.resaltarvalorValorRubroVariable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorValorRubroVariable() {
		return this.resaltarvalorValorRubroVariable;
	}

	public void setResaltarvalorValorRubroVariable(Border borderResaltar) {
		this.resaltarvalorValorRubroVariable= borderResaltar;
	}

	public Boolean getMostrarvalorValorRubroVariable() {
		return this.mostrarvalorValorRubroVariable;
	}

	public void setMostrarvalorValorRubroVariable(Boolean mostrarvalorValorRubroVariable) {
		this.mostrarvalorValorRubroVariable= mostrarvalorValorRubroVariable;
	}

	public Boolean getActivarvalorValorRubroVariable() {
		return this.activarvalorValorRubroVariable;
	}

	public void setActivarvalorValorRubroVariable(Boolean activarvalorValorRubroVariable) {
		this.activarvalorValorRubroVariable= activarvalorValorRubroVariable;
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
		
		
		this.setMostraridValorRubroVariable(esInicial);
		this.setMostrarid_empresaValorRubroVariable(esInicial);
		this.setMostrarid_empleadoValorRubroVariable(esInicial);
		this.setMostrarid_rubro_empleaValorRubroVariable(esInicial);
		this.setMostrarfechaValorRubroVariable(esInicial);
		this.setMostrarvalorValorRubroVariable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.ID)) {
				this.setMostraridValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.FECHA)) {
				this.setMostrarfechaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.VALOR)) {
				this.setMostrarvalorValorRubroVariable(esAsigna);
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
		
		
		this.setActivaridValorRubroVariable(esInicial);
		this.setActivarid_empresaValorRubroVariable(esInicial);
		this.setActivarid_empleadoValorRubroVariable(esInicial);
		this.setActivarid_rubro_empleaValorRubroVariable(esInicial);
		this.setActivarfechaValorRubroVariable(esInicial);
		this.setActivarvalorValorRubroVariable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.ID)) {
				this.setActivaridValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.FECHA)) {
				this.setActivarfechaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.VALOR)) {
				this.setActivarvalorValorRubroVariable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridValorRubroVariable(esInicial);
		this.setResaltarid_empresaValorRubroVariable(esInicial);
		this.setResaltarid_empleadoValorRubroVariable(esInicial);
		this.setResaltarid_rubro_empleaValorRubroVariable(esInicial);
		this.setResaltarfechaValorRubroVariable(esInicial);
		this.setResaltarvalorValorRubroVariable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.ID)) {
				this.setResaltaridValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.FECHA)) {
				this.setResaltarfechaValorRubroVariable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorRubroVariableConstantesFunciones.VALOR)) {
				this.setResaltarvalorValorRubroVariable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoValorRubroVariable=true;

	public Boolean getMostrarFK_IdEmpleadoValorRubroVariable() {
		return this.mostrarFK_IdEmpleadoValorRubroVariable;
	}

	public void setMostrarFK_IdEmpleadoValorRubroVariable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoValorRubroVariable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaValorRubroVariable=true;

	public Boolean getMostrarFK_IdEmpresaValorRubroVariable() {
		return this.mostrarFK_IdEmpresaValorRubroVariable;
	}

	public void setMostrarFK_IdEmpresaValorRubroVariable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaValorRubroVariable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaValorRubroVariable=true;

	public Boolean getMostrarFK_IdRubroEmpleaValorRubroVariable() {
		return this.mostrarFK_IdRubroEmpleaValorRubroVariable;
	}

	public void setMostrarFK_IdRubroEmpleaValorRubroVariable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaValorRubroVariable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoValorRubroVariable=true;

	public Boolean getActivarFK_IdEmpleadoValorRubroVariable() {
		return this.activarFK_IdEmpleadoValorRubroVariable;
	}

	public void setActivarFK_IdEmpleadoValorRubroVariable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoValorRubroVariable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaValorRubroVariable=true;

	public Boolean getActivarFK_IdEmpresaValorRubroVariable() {
		return this.activarFK_IdEmpresaValorRubroVariable;
	}

	public void setActivarFK_IdEmpresaValorRubroVariable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaValorRubroVariable= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaValorRubroVariable=true;

	public Boolean getActivarFK_IdRubroEmpleaValorRubroVariable() {
		return this.activarFK_IdRubroEmpleaValorRubroVariable;
	}

	public void setActivarFK_IdRubroEmpleaValorRubroVariable(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaValorRubroVariable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoValorRubroVariable=null;

	public Border getResaltarFK_IdEmpleadoValorRubroVariable() {
		return this.resaltarFK_IdEmpleadoValorRubroVariable;
	}

	public void setResaltarFK_IdEmpleadoValorRubroVariable(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoValorRubroVariable= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoValorRubroVariable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaValorRubroVariable=null;

	public Border getResaltarFK_IdEmpresaValorRubroVariable() {
		return this.resaltarFK_IdEmpresaValorRubroVariable;
	}

	public void setResaltarFK_IdEmpresaValorRubroVariable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaValorRubroVariable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaValorRubroVariable= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaValorRubroVariable=null;

	public Border getResaltarFK_IdRubroEmpleaValorRubroVariable() {
		return this.resaltarFK_IdRubroEmpleaValorRubroVariable;
	}

	public void setResaltarFK_IdRubroEmpleaValorRubroVariable(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaValorRubroVariable= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaValorRubroVariable(ParametroGeneralUsuario parametroGeneralUsuario/*ValorRubroVariableBeanSwingJInternalFrame valorrubrovariableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaValorRubroVariable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}