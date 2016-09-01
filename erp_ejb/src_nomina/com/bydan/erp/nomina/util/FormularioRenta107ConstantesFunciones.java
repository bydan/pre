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


import com.bydan.erp.nomina.util.FormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.FormularioRenta107ParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormularioRenta107ParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormularioRenta107ConstantesFunciones extends FormularioRenta107ConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormularioRenta107";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormularioRenta107"+FormularioRenta107ConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormularioRenta107HomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormularioRenta107HomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormularioRenta107ConstantesFunciones.SCHEMA+"_"+FormularioRenta107ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormularioRenta107ConstantesFunciones.SCHEMA+"_"+FormularioRenta107ConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormularioRenta107ConstantesFunciones.SCHEMA+"_"+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormularioRenta107ConstantesFunciones.SCHEMA+"_"+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRenta107HomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRenta107ConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormularioRenta107ConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormularioRenta107ConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormularioRenta107ConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormularioRenta107ConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formulario Renta107es";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Formulario Renta107";
	public static final String SCLASSWEBTITULO_LOWER="Formulario Renta107";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormularioRenta107";
	public static final String OBJECTNAME="formulariorenta107";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="formulario_renta107";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formulariorenta107 from "+FormularioRenta107ConstantesFunciones.SPERSISTENCENAME+" formulariorenta107";
	public static String QUERYSELECTNATIVE="select "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".version_row,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_empleado,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".fecha_entrega,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".fecha_generacion from "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+FormularioRenta107ConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormularioRenta107ConstantesFuncionesAdditional formulariorenta107ConstantesFuncionesAdditional=null;
	
	public FormularioRenta107ConstantesFuncionesAdditional getFormularioRenta107ConstantesFuncionesAdditional() {
		return this.formulariorenta107ConstantesFuncionesAdditional;
	}
	
	public void setFormularioRenta107ConstantesFuncionesAdditional(FormularioRenta107ConstantesFuncionesAdditional formulariorenta107ConstantesFuncionesAdditional) {
		try {
			this.formulariorenta107ConstantesFuncionesAdditional=formulariorenta107ConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String FECHAGENERACION= "fecha_generacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_FECHAGENERACION= "Fecha Generacion";
		public static final String LABEL_FECHAGENERACION_LOWER= "Fecha Generacion";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getFormularioRenta107LabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.IDEMPLEADO)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.FECHAENTREGA)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(FormularioRenta107ConstantesFunciones.FECHAGENERACION)) {sLabelColumna=FormularioRenta107ConstantesFunciones.LABEL_FECHAGENERACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getFormularioRenta107Descripcion(FormularioRenta107 formulariorenta107) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formulariorenta107 !=null/* && formulariorenta107.getId()!=0*/) {
			if(formulariorenta107.getId()!=null) {
				sDescripcion=formulariorenta107.getId().toString();
			}//formulariorenta107formulariorenta107.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormularioRenta107DescripcionDetallado(FormularioRenta107 formulariorenta107) {
		String sDescripcion="";
			
		sDescripcion+=FormularioRenta107ConstantesFunciones.ID+"=";
		sDescripcion+=formulariorenta107.getId().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formulariorenta107.getVersionRow().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formulariorenta107.getid_empresa().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=formulariorenta107.getid_empleado().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formulariorenta107.getid_ejercicio().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=formulariorenta107.getnumero_pre_impreso()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=formulariorenta107.getfecha_entrega().toString()+",";
		sDescripcion+=FormularioRenta107ConstantesFunciones.FECHAGENERACION+"=";
		sDescripcion+=formulariorenta107.getfecha_generacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormularioRenta107Descripcion(FormularioRenta107 formulariorenta107,String sValor) throws Exception {			
		if(formulariorenta107 !=null) {
			//formulariorenta107formulariorenta107.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosFormularioRenta107(FormularioRenta107 formulariorenta107,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formulariorenta107.setnumero_pre_impreso(formulariorenta107.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFormularioRenta107s(List<FormularioRenta107> formulariorenta107s,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormularioRenta107 formulariorenta107: formulariorenta107s) {
			formulariorenta107.setnumero_pre_impreso(formulariorenta107.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRenta107(FormularioRenta107 formulariorenta107,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formulariorenta107.getConCambioAuxiliar()) {
			formulariorenta107.setIsDeleted(formulariorenta107.getIsDeletedAuxiliar());	
			formulariorenta107.setIsNew(formulariorenta107.getIsNewAuxiliar());	
			formulariorenta107.setIsChanged(formulariorenta107.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formulariorenta107.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formulariorenta107.setIsDeletedAuxiliar(false);	
			formulariorenta107.setIsNewAuxiliar(false);	
			formulariorenta107.setIsChangedAuxiliar(false);
			
			formulariorenta107.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRenta107s(List<FormularioRenta107> formulariorenta107s,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormularioRenta107 formulariorenta107 : formulariorenta107s) {
			if(conAsignarBase && formulariorenta107.getConCambioAuxiliar()) {
				formulariorenta107.setIsDeleted(formulariorenta107.getIsDeletedAuxiliar());	
				formulariorenta107.setIsNew(formulariorenta107.getIsNewAuxiliar());	
				formulariorenta107.setIsChanged(formulariorenta107.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formulariorenta107.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formulariorenta107.setIsDeletedAuxiliar(false);	
				formulariorenta107.setIsNewAuxiliar(false);	
				formulariorenta107.setIsChangedAuxiliar(false);
				
				formulariorenta107.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormularioRenta107(FormularioRenta107 formulariorenta107,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormularioRenta107s(List<FormularioRenta107> formulariorenta107s,Boolean conEnteros) throws Exception  {
		
		for(FormularioRenta107 formulariorenta107: formulariorenta107s) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormularioRenta107(List<FormularioRenta107> formulariorenta107s,FormularioRenta107 formulariorenta107Aux) throws Exception  {
		FormularioRenta107ConstantesFunciones.InicializarValoresFormularioRenta107(formulariorenta107Aux,true);
		
		for(FormularioRenta107 formulariorenta107: formulariorenta107s) {
			if(formulariorenta107.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormularioRenta107ConstantesFunciones.getArrayColumnasGlobalesFormularioRenta107(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRenta107ConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRenta107ConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormularioRenta107(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormularioRenta107> formulariorenta107s,FormularioRenta107 formulariorenta107,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormularioRenta107 formulariorenta107Aux: formulariorenta107s) {
			if(formulariorenta107Aux!=null && formulariorenta107!=null) {
				if((formulariorenta107Aux.getId()==null && formulariorenta107.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formulariorenta107Aux.getId()!=null && formulariorenta107.getId()!=null){
					if(formulariorenta107Aux.getId().equals(formulariorenta107.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormularioRenta107(List<FormularioRenta107> formulariorenta107s) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FormularioRenta107 formulariorenta107: formulariorenta107s) {			
			if(formulariorenta107.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormularioRenta107() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_ID, FormularioRenta107ConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_VERSIONROW, FormularioRenta107ConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA, FormularioRenta107ConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO, FormularioRenta107ConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO, FormularioRenta107ConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_NUMEROPREIMPRESO, FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_FECHAENTREGA, FormularioRenta107ConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRenta107ConstantesFunciones.LABEL_FECHAGENERACION, FormularioRenta107ConstantesFunciones.FECHAGENERACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormularioRenta107() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRenta107ConstantesFunciones.FECHAGENERACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta107() throws Exception  {
		return FormularioRenta107ConstantesFunciones.getTiposSeleccionarFormularioRenta107(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta107(Boolean conFk) throws Exception  {
		return FormularioRenta107ConstantesFunciones.getTiposSeleccionarFormularioRenta107(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta107(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRenta107ConstantesFunciones.LABEL_FECHAGENERACION);
			reporte.setsDescripcion(FormularioRenta107ConstantesFunciones.LABEL_FECHAGENERACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormularioRenta107(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRenta107(FormularioRenta107 formulariorenta107Aux) throws Exception {
		
			formulariorenta107Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorenta107Aux.getEmpresa()));
			formulariorenta107Aux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(formulariorenta107Aux.getEmpleado()));
			formulariorenta107Aux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorenta107Aux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRenta107(List<FormularioRenta107> formulariorenta107sTemp) throws Exception {
		for(FormularioRenta107 formulariorenta107Aux:formulariorenta107sTemp) {
			
			formulariorenta107Aux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorenta107Aux.getEmpresa()));
			formulariorenta107Aux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(formulariorenta107Aux.getEmpleado()));
			formulariorenta107Aux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorenta107Aux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Ejercicio.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRenta107ConstantesFunciones.getClassesRelationshipsOfFormularioRenta107(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleFormularioRenta107.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleFormularioRenta107.class)) {
						classes.add(new Classe(DetalleFormularioRenta107.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRenta107ConstantesFunciones.getClassesRelationshipsFromStringsOfFormularioRenta107(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRenta107(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFormularioRenta107.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFormularioRenta107.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFormularioRenta107.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFormularioRenta107.class)); continue;
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
	public static void actualizarLista(FormularioRenta107 formulariorenta107,List<FormularioRenta107> formulariorenta107s,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormularioRenta107 formulariorenta107Encontrado=null;
			
			for(FormularioRenta107 formulariorenta107Local:formulariorenta107s) {
				if(formulariorenta107Local.getId().equals(formulariorenta107.getId())) {
					formulariorenta107Encontrado=formulariorenta107Local;
					
					formulariorenta107Local.setIsChanged(formulariorenta107.getIsChanged());
					formulariorenta107Local.setIsNew(formulariorenta107.getIsNew());
					formulariorenta107Local.setIsDeleted(formulariorenta107.getIsDeleted());
					
					formulariorenta107Local.setGeneralEntityOriginal(formulariorenta107.getGeneralEntityOriginal());
					
					formulariorenta107Local.setId(formulariorenta107.getId());	
					formulariorenta107Local.setVersionRow(formulariorenta107.getVersionRow());	
					formulariorenta107Local.setid_empresa(formulariorenta107.getid_empresa());	
					formulariorenta107Local.setid_empleado(formulariorenta107.getid_empleado());	
					formulariorenta107Local.setid_ejercicio(formulariorenta107.getid_ejercicio());	
					formulariorenta107Local.setnumero_pre_impreso(formulariorenta107.getnumero_pre_impreso());	
					formulariorenta107Local.setfecha_entrega(formulariorenta107.getfecha_entrega());	
					formulariorenta107Local.setfecha_generacion(formulariorenta107.getfecha_generacion());	
					
					
					formulariorenta107Local.setDetalleFormularioRenta107s(formulariorenta107.getDetalleFormularioRenta107s());
					
					existe=true;
					break;
				}
			}
			
			if(!formulariorenta107.getIsDeleted()) {
				if(!existe) {
					formulariorenta107s.add(formulariorenta107);
				}
			} else {
				if(formulariorenta107Encontrado!=null && permiteQuitar)  {
					formulariorenta107s.remove(formulariorenta107Encontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormularioRenta107 formulariorenta107,List<FormularioRenta107> formulariorenta107s) throws Exception {
		try	{			
			for(FormularioRenta107 formulariorenta107Local:formulariorenta107s) {
				if(formulariorenta107Local.getId().equals(formulariorenta107.getId())) {
					formulariorenta107Local.setIsSelected(formulariorenta107.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormularioRenta107(List<FormularioRenta107> formulariorenta107sAux) throws Exception {
		//this.formulariorenta107sAux=formulariorenta107sAux;
		
		for(FormularioRenta107 formulariorenta107Aux:formulariorenta107sAux) {
			if(formulariorenta107Aux.getIsChanged()) {
				formulariorenta107Aux.setIsChanged(false);
			}		
			
			if(formulariorenta107Aux.getIsNew()) {
				formulariorenta107Aux.setIsNew(false);
			}	
			
			if(formulariorenta107Aux.getIsDeleted()) {
				formulariorenta107Aux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormularioRenta107(FormularioRenta107 formulariorenta107Aux) throws Exception {
		//this.formulariorenta107Aux=formulariorenta107Aux;
		
			if(formulariorenta107Aux.getIsChanged()) {
				formulariorenta107Aux.setIsChanged(false);
			}		
			
			if(formulariorenta107Aux.getIsNew()) {
				formulariorenta107Aux.setIsNew(false);
			}	
			
			if(formulariorenta107Aux.getIsDeleted()) {
				formulariorenta107Aux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormularioRenta107 formulariorenta107Asignar,FormularioRenta107 formulariorenta107) throws Exception {
		formulariorenta107Asignar.setId(formulariorenta107.getId());	
		formulariorenta107Asignar.setVersionRow(formulariorenta107.getVersionRow());	
		formulariorenta107Asignar.setid_empresa(formulariorenta107.getid_empresa());
		formulariorenta107Asignar.setempresa_descripcion(formulariorenta107.getempresa_descripcion());	
		formulariorenta107Asignar.setid_empleado(formulariorenta107.getid_empleado());
		formulariorenta107Asignar.setempleado_descripcion(formulariorenta107.getempleado_descripcion());	
		formulariorenta107Asignar.setid_ejercicio(formulariorenta107.getid_ejercicio());
		formulariorenta107Asignar.setejercicio_descripcion(formulariorenta107.getejercicio_descripcion());	
		formulariorenta107Asignar.setnumero_pre_impreso(formulariorenta107.getnumero_pre_impreso());	
		formulariorenta107Asignar.setfecha_entrega(formulariorenta107.getfecha_entrega());	
		formulariorenta107Asignar.setfecha_generacion(formulariorenta107.getfecha_generacion());	
	}
	
	public static void inicializarFormularioRenta107(FormularioRenta107 formulariorenta107) throws Exception {
		try {
				formulariorenta107.setId(0L);	
					
				formulariorenta107.setid_empresa(-1L);	
				formulariorenta107.setid_empleado(-1L);	
				formulariorenta107.setid_ejercicio(-1L);	
				formulariorenta107.setnumero_pre_impreso("");	
				formulariorenta107.setfecha_entrega(new Date());	
				formulariorenta107.setfecha_generacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormularioRenta107(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRenta107ConstantesFunciones.LABEL_FECHAGENERACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormularioRenta107(String sTipo,Row row,Workbook workbook,FormularioRenta107 formulariorenta107,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta107.getfecha_generacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormularioRenta107=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormularioRenta107() {
		return this.sFinalQueryFormularioRenta107;
	}
	
	public void setsFinalQueryFormularioRenta107(String sFinalQueryFormularioRenta107) {
		this.sFinalQueryFormularioRenta107= sFinalQueryFormularioRenta107;
	}
	
	public Border resaltarSeleccionarFormularioRenta107=null;
	
	public Border setResaltarSeleccionarFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormularioRenta107= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormularioRenta107() {
		return this.resaltarSeleccionarFormularioRenta107;
	}
	
	public void setResaltarSeleccionarFormularioRenta107(Border borderResaltarSeleccionarFormularioRenta107) {
		this.resaltarSeleccionarFormularioRenta107= borderResaltarSeleccionarFormularioRenta107;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormularioRenta107=null;
	public Boolean mostraridFormularioRenta107=true;
	public Boolean activaridFormularioRenta107=true;

	public Border resaltarid_empresaFormularioRenta107=null;
	public Boolean mostrarid_empresaFormularioRenta107=true;
	public Boolean activarid_empresaFormularioRenta107=true;
	public Boolean cargarid_empresaFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarid_empleadoFormularioRenta107=null;
	public Boolean mostrarid_empleadoFormularioRenta107=true;
	public Boolean activarid_empleadoFormularioRenta107=true;
	public Boolean cargarid_empleadoFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormularioRenta107=null;
	public Boolean mostrarid_ejercicioFormularioRenta107=true;
	public Boolean activarid_ejercicioFormularioRenta107=true;
	public Boolean cargarid_ejercicioFormularioRenta107=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormularioRenta107=false;//ConEventDepend=true

	public Border resaltarnumero_pre_impresoFormularioRenta107=null;
	public Boolean mostrarnumero_pre_impresoFormularioRenta107=true;
	public Boolean activarnumero_pre_impresoFormularioRenta107=true;

	public Border resaltarfecha_entregaFormularioRenta107=null;
	public Boolean mostrarfecha_entregaFormularioRenta107=true;
	public Boolean activarfecha_entregaFormularioRenta107=false;

	public Border resaltarfecha_generacionFormularioRenta107=null;
	public Boolean mostrarfecha_generacionFormularioRenta107=true;
	public Boolean activarfecha_generacionFormularioRenta107=false;

	
	

	public Border setResaltaridFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltaridFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormularioRenta107() {
		return this.resaltaridFormularioRenta107;
	}

	public void setResaltaridFormularioRenta107(Border borderResaltar) {
		this.resaltaridFormularioRenta107= borderResaltar;
	}

	public Boolean getMostraridFormularioRenta107() {
		return this.mostraridFormularioRenta107;
	}

	public void setMostraridFormularioRenta107(Boolean mostraridFormularioRenta107) {
		this.mostraridFormularioRenta107= mostraridFormularioRenta107;
	}

	public Boolean getActivaridFormularioRenta107() {
		return this.activaridFormularioRenta107;
	}

	public void setActivaridFormularioRenta107(Boolean activaridFormularioRenta107) {
		this.activaridFormularioRenta107= activaridFormularioRenta107;
	}

	public Border setResaltarid_empresaFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormularioRenta107() {
		return this.resaltarid_empresaFormularioRenta107;
	}

	public void setResaltarid_empresaFormularioRenta107(Border borderResaltar) {
		this.resaltarid_empresaFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormularioRenta107() {
		return this.mostrarid_empresaFormularioRenta107;
	}

	public void setMostrarid_empresaFormularioRenta107(Boolean mostrarid_empresaFormularioRenta107) {
		this.mostrarid_empresaFormularioRenta107= mostrarid_empresaFormularioRenta107;
	}

	public Boolean getActivarid_empresaFormularioRenta107() {
		return this.activarid_empresaFormularioRenta107;
	}

	public void setActivarid_empresaFormularioRenta107(Boolean activarid_empresaFormularioRenta107) {
		this.activarid_empresaFormularioRenta107= activarid_empresaFormularioRenta107;
	}

	public Boolean getCargarid_empresaFormularioRenta107() {
		return this.cargarid_empresaFormularioRenta107;
	}

	public void setCargarid_empresaFormularioRenta107(Boolean cargarid_empresaFormularioRenta107) {
		this.cargarid_empresaFormularioRenta107= cargarid_empresaFormularioRenta107;
	}

	public Border setResaltarid_empleadoFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_empleadoFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoFormularioRenta107() {
		return this.resaltarid_empleadoFormularioRenta107;
	}

	public void setResaltarid_empleadoFormularioRenta107(Border borderResaltar) {
		this.resaltarid_empleadoFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_empleadoFormularioRenta107() {
		return this.mostrarid_empleadoFormularioRenta107;
	}

	public void setMostrarid_empleadoFormularioRenta107(Boolean mostrarid_empleadoFormularioRenta107) {
		this.mostrarid_empleadoFormularioRenta107= mostrarid_empleadoFormularioRenta107;
	}

	public Boolean getActivarid_empleadoFormularioRenta107() {
		return this.activarid_empleadoFormularioRenta107;
	}

	public void setActivarid_empleadoFormularioRenta107(Boolean activarid_empleadoFormularioRenta107) {
		this.activarid_empleadoFormularioRenta107= activarid_empleadoFormularioRenta107;
	}

	public Boolean getCargarid_empleadoFormularioRenta107() {
		return this.cargarid_empleadoFormularioRenta107;
	}

	public void setCargarid_empleadoFormularioRenta107(Boolean cargarid_empleadoFormularioRenta107) {
		this.cargarid_empleadoFormularioRenta107= cargarid_empleadoFormularioRenta107;
	}

	public Border setResaltarid_ejercicioFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormularioRenta107() {
		return this.resaltarid_ejercicioFormularioRenta107;
	}

	public void setResaltarid_ejercicioFormularioRenta107(Border borderResaltar) {
		this.resaltarid_ejercicioFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormularioRenta107() {
		return this.mostrarid_ejercicioFormularioRenta107;
	}

	public void setMostrarid_ejercicioFormularioRenta107(Boolean mostrarid_ejercicioFormularioRenta107) {
		this.mostrarid_ejercicioFormularioRenta107= mostrarid_ejercicioFormularioRenta107;
	}

	public Boolean getActivarid_ejercicioFormularioRenta107() {
		return this.activarid_ejercicioFormularioRenta107;
	}

	public void setActivarid_ejercicioFormularioRenta107(Boolean activarid_ejercicioFormularioRenta107) {
		this.activarid_ejercicioFormularioRenta107= activarid_ejercicioFormularioRenta107;
	}

	public Boolean getCargarid_ejercicioFormularioRenta107() {
		return this.cargarid_ejercicioFormularioRenta107;
	}

	public void setCargarid_ejercicioFormularioRenta107(Boolean cargarid_ejercicioFormularioRenta107) {
		this.cargarid_ejercicioFormularioRenta107= cargarid_ejercicioFormularioRenta107;
	}

	public Border setResaltarnumero_pre_impresoFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoFormularioRenta107() {
		return this.resaltarnumero_pre_impresoFormularioRenta107;
	}

	public void setResaltarnumero_pre_impresoFormularioRenta107(Border borderResaltar) {
		this.resaltarnumero_pre_impresoFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoFormularioRenta107() {
		return this.mostrarnumero_pre_impresoFormularioRenta107;
	}

	public void setMostrarnumero_pre_impresoFormularioRenta107(Boolean mostrarnumero_pre_impresoFormularioRenta107) {
		this.mostrarnumero_pre_impresoFormularioRenta107= mostrarnumero_pre_impresoFormularioRenta107;
	}

	public Boolean getActivarnumero_pre_impresoFormularioRenta107() {
		return this.activarnumero_pre_impresoFormularioRenta107;
	}

	public void setActivarnumero_pre_impresoFormularioRenta107(Boolean activarnumero_pre_impresoFormularioRenta107) {
		this.activarnumero_pre_impresoFormularioRenta107= activarnumero_pre_impresoFormularioRenta107;
	}

	public Border setResaltarfecha_entregaFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaFormularioRenta107() {
		return this.resaltarfecha_entregaFormularioRenta107;
	}

	public void setResaltarfecha_entregaFormularioRenta107(Border borderResaltar) {
		this.resaltarfecha_entregaFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaFormularioRenta107() {
		return this.mostrarfecha_entregaFormularioRenta107;
	}

	public void setMostrarfecha_entregaFormularioRenta107(Boolean mostrarfecha_entregaFormularioRenta107) {
		this.mostrarfecha_entregaFormularioRenta107= mostrarfecha_entregaFormularioRenta107;
	}

	public Boolean getActivarfecha_entregaFormularioRenta107() {
		return this.activarfecha_entregaFormularioRenta107;
	}

	public void setActivarfecha_entregaFormularioRenta107(Boolean activarfecha_entregaFormularioRenta107) {
		this.activarfecha_entregaFormularioRenta107= activarfecha_entregaFormularioRenta107;
	}

	public Border setResaltarfecha_generacionFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltar);
		
		this.resaltarfecha_generacionFormularioRenta107= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_generacionFormularioRenta107() {
		return this.resaltarfecha_generacionFormularioRenta107;
	}

	public void setResaltarfecha_generacionFormularioRenta107(Border borderResaltar) {
		this.resaltarfecha_generacionFormularioRenta107= borderResaltar;
	}

	public Boolean getMostrarfecha_generacionFormularioRenta107() {
		return this.mostrarfecha_generacionFormularioRenta107;
	}

	public void setMostrarfecha_generacionFormularioRenta107(Boolean mostrarfecha_generacionFormularioRenta107) {
		this.mostrarfecha_generacionFormularioRenta107= mostrarfecha_generacionFormularioRenta107;
	}

	public Boolean getActivarfecha_generacionFormularioRenta107() {
		return this.activarfecha_generacionFormularioRenta107;
	}

	public void setActivarfecha_generacionFormularioRenta107(Boolean activarfecha_generacionFormularioRenta107) {
		this.activarfecha_generacionFormularioRenta107= activarfecha_generacionFormularioRenta107;
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
		
		
		this.setMostraridFormularioRenta107(esInicial);
		this.setMostrarid_empresaFormularioRenta107(esInicial);
		this.setMostrarid_empleadoFormularioRenta107(esInicial);
		this.setMostrarid_ejercicioFormularioRenta107(esInicial);
		this.setMostrarnumero_pre_impresoFormularioRenta107(esInicial);
		this.setMostrarfecha_entregaFormularioRenta107(esInicial);
		this.setMostrarfecha_generacionFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.ID)) {
				this.setMostraridFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAGENERACION)) {
				this.setMostrarfecha_generacionFormularioRenta107(esAsigna);
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
		
		
		this.setActivaridFormularioRenta107(esInicial);
		this.setActivarid_empresaFormularioRenta107(esInicial);
		this.setActivarid_empleadoFormularioRenta107(esInicial);
		this.setActivarid_ejercicioFormularioRenta107(esInicial);
		this.setActivarnumero_pre_impresoFormularioRenta107(esInicial);
		this.setActivarfecha_entregaFormularioRenta107(esInicial);
		this.setActivarfecha_generacionFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.ID)) {
				this.setActivaridFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAGENERACION)) {
				this.setActivarfecha_generacionFormularioRenta107(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormularioRenta107(esInicial);
		this.setResaltarid_empresaFormularioRenta107(esInicial);
		this.setResaltarid_empleadoFormularioRenta107(esInicial);
		this.setResaltarid_ejercicioFormularioRenta107(esInicial);
		this.setResaltarnumero_pre_impresoFormularioRenta107(esInicial);
		this.setResaltarfecha_entregaFormularioRenta107(esInicial);
		this.setResaltarfecha_generacionFormularioRenta107(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.ID)) {
				this.setResaltaridFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaFormularioRenta107(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRenta107ConstantesFunciones.FECHAGENERACION)) {
				this.setResaltarfecha_generacionFormularioRenta107(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleFormularioRenta107FormularioRenta107=null;

	public Border getResaltarDetalleFormularioRenta107FormularioRenta107() {
		return this.resaltarDetalleFormularioRenta107FormularioRenta107;
	}

	public void setResaltarDetalleFormularioRenta107FormularioRenta107(Border borderResaltarDetalleFormularioRenta107) {
		if(borderResaltarDetalleFormularioRenta107!=null) {
			this.resaltarDetalleFormularioRenta107FormularioRenta107= borderResaltarDetalleFormularioRenta107;
		}
	}

	public Border setResaltarDetalleFormularioRenta107FormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleFormularioRenta107=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//formulariorenta107BeanSwingJInternalFrame.jTtoolBarFormularioRenta107.setBorder(borderResaltarDetalleFormularioRenta107);
			
		this.resaltarDetalleFormularioRenta107FormularioRenta107= borderResaltarDetalleFormularioRenta107;

		 return borderResaltarDetalleFormularioRenta107;
	}



	public Boolean mostrarDetalleFormularioRenta107FormularioRenta107=true;

	public Boolean getMostrarDetalleFormularioRenta107FormularioRenta107() {
		return this.mostrarDetalleFormularioRenta107FormularioRenta107;
	}

	public void setMostrarDetalleFormularioRenta107FormularioRenta107(Boolean visibilidadResaltarDetalleFormularioRenta107) {
		this.mostrarDetalleFormularioRenta107FormularioRenta107= visibilidadResaltarDetalleFormularioRenta107;
	}



	public Boolean activarDetalleFormularioRenta107FormularioRenta107=true;

	public Boolean gethabilitarResaltarDetalleFormularioRenta107FormularioRenta107() {
		return this.activarDetalleFormularioRenta107FormularioRenta107;
	}

	public void setActivarDetalleFormularioRenta107FormularioRenta107(Boolean habilitarResaltarDetalleFormularioRenta107) {
		this.activarDetalleFormularioRenta107FormularioRenta107= habilitarResaltarDetalleFormularioRenta107;
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

		this.setMostrarDetalleFormularioRenta107FormularioRenta107(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFormularioRenta107.class)) {
				this.setMostrarDetalleFormularioRenta107FormularioRenta107(esAsigna);
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

		this.setActivarDetalleFormularioRenta107FormularioRenta107(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFormularioRenta107.class)) {
				this.setActivarDetalleFormularioRenta107FormularioRenta107(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleFormularioRenta107FormularioRenta107(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFormularioRenta107.class)) {
				this.setResaltarDetalleFormularioRenta107FormularioRenta107(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioFormularioRenta107=true;

	public Boolean getMostrarFK_IdEjercicioFormularioRenta107() {
		return this.mostrarFK_IdEjercicioFormularioRenta107;
	}

	public void setMostrarFK_IdEjercicioFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormularioRenta107= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoFormularioRenta107=true;

	public Boolean getMostrarFK_IdEmpleadoFormularioRenta107() {
		return this.mostrarFK_IdEmpleadoFormularioRenta107;
	}

	public void setMostrarFK_IdEmpleadoFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoFormularioRenta107= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormularioRenta107=true;

	public Boolean getMostrarFK_IdEmpresaFormularioRenta107() {
		return this.mostrarFK_IdEmpresaFormularioRenta107;
	}

	public void setMostrarFK_IdEmpresaFormularioRenta107(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormularioRenta107= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioFormularioRenta107=true;

	public Boolean getActivarFK_IdEjercicioFormularioRenta107() {
		return this.activarFK_IdEjercicioFormularioRenta107;
	}

	public void setActivarFK_IdEjercicioFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormularioRenta107= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoFormularioRenta107=true;

	public Boolean getActivarFK_IdEmpleadoFormularioRenta107() {
		return this.activarFK_IdEmpleadoFormularioRenta107;
	}

	public void setActivarFK_IdEmpleadoFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoFormularioRenta107= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormularioRenta107=true;

	public Boolean getActivarFK_IdEmpresaFormularioRenta107() {
		return this.activarFK_IdEmpresaFormularioRenta107;
	}

	public void setActivarFK_IdEmpresaFormularioRenta107(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormularioRenta107= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioFormularioRenta107=null;

	public Border getResaltarFK_IdEjercicioFormularioRenta107() {
		return this.resaltarFK_IdEjercicioFormularioRenta107;
	}

	public void setResaltarFK_IdEjercicioFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormularioRenta107= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoFormularioRenta107=null;

	public Border getResaltarFK_IdEmpleadoFormularioRenta107() {
		return this.resaltarFK_IdEmpleadoFormularioRenta107;
	}

	public void setResaltarFK_IdEmpleadoFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoFormularioRenta107= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormularioRenta107=null;

	public Border getResaltarFK_IdEmpresaFormularioRenta107() {
		return this.resaltarFK_IdEmpresaFormularioRenta107;
	}

	public void setResaltarFK_IdEmpresaFormularioRenta107(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormularioRenta107= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormularioRenta107(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRenta107BeanSwingJInternalFrame formulariorenta107BeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormularioRenta107= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}