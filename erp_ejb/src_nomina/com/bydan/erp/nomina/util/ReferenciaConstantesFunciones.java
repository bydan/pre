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


import com.bydan.erp.nomina.util.ReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.ReferenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ReferenciaParameterGeneral;

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
final public class ReferenciaConstantesFunciones extends ReferenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Referencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Referencia"+ReferenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReferenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReferenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReferenciaConstantesFunciones.SCHEMA+"_"+ReferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReferenciaConstantesFunciones.SCHEMA+"_"+ReferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReferenciaConstantesFunciones.SCHEMA+"_"+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReferenciaConstantesFunciones.SCHEMA+"_"+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReferenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReferenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReferenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReferenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Referencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Referencia";
	public static final String SCLASSWEBTITULO_LOWER="Referencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Referencia";
	public static final String OBJECTNAME="referencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="referencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select referencia from "+ReferenciaConstantesFunciones.SPERSISTENCENAME+" referencia";
	public static String QUERYSELECTNATIVE="select "+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".id,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".version_row,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".id_empleado,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".id_parentezco,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".id_profesion,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".cedula,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".apellido,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".nombre,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".direccion,"+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME+".telefono from "+ReferenciaConstantesFunciones.SCHEMA+"."+ReferenciaConstantesFunciones.TABLENAME;//+" as "+ReferenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReferenciaConstantesFuncionesAdditional referenciaConstantesFuncionesAdditional=null;
	
	public ReferenciaConstantesFuncionesAdditional getReferenciaConstantesFuncionesAdditional() {
		return this.referenciaConstantesFuncionesAdditional;
	}
	
	public void setReferenciaConstantesFuncionesAdditional(ReferenciaConstantesFuncionesAdditional referenciaConstantesFuncionesAdditional) {
		try {
			this.referenciaConstantesFuncionesAdditional=referenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDPARENTEZCO= "id_parentezco";
    public static final String IDPROFESION= "id_profesion";
    public static final String CEDULA= "cedula";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDPARENTEZCO= "Parentezco";
		public static final String LABEL_IDPARENTEZCO_LOWER= "Parentezco";
    	public static final String LABEL_IDPROFESION= "Profesion";
		public static final String LABEL_IDPROFESION_LOWER= "Profesion";
    	public static final String LABEL_CEDULA= "Cedula";
		public static final String LABEL_CEDULA_LOWER= "Cedula";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
	
		
		
		
		
		
		
	public static final String SREGEXCEDULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCEDULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	
	public static String getReferenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.IDPARENTEZCO)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_IDPARENTEZCO;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.IDPROFESION)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_IDPROFESION;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.CEDULA)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_CEDULA;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.APELLIDO)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.NOMBRE)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.DIRECCION)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ReferenciaConstantesFunciones.TELEFONO)) {sLabelColumna=ReferenciaConstantesFunciones.LABEL_TELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getReferenciaDescripcion(Referencia referencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(referencia !=null/* && referencia.getId()!=0*/) {
			sDescripcion=referencia.getnombre();//referenciareferencia.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getReferenciaDescripcionDetallado(Referencia referencia) {
		String sDescripcion="";
			
		sDescripcion+=ReferenciaConstantesFunciones.ID+"=";
		sDescripcion+=referencia.getId().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=referencia.getVersionRow().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=referencia.getid_empresa().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=referencia.getid_empleado().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.IDPARENTEZCO+"=";
		sDescripcion+=referencia.getid_parentezco().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.IDPROFESION+"=";
		sDescripcion+=referencia.getid_profesion().toString()+",";
		sDescripcion+=ReferenciaConstantesFunciones.CEDULA+"=";
		sDescripcion+=referencia.getcedula()+",";
		sDescripcion+=ReferenciaConstantesFunciones.APELLIDO+"=";
		sDescripcion+=referencia.getapellido()+",";
		sDescripcion+=ReferenciaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=referencia.getnombre()+",";
		sDescripcion+=ReferenciaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=referencia.getdireccion()+",";
		sDescripcion+=ReferenciaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=referencia.gettelefono()+",";
			
		return sDescripcion;
	}
	
	public static void setReferenciaDescripcion(Referencia referencia,String sValor) throws Exception {			
		if(referencia !=null) {
			referencia.setnombre(sValor);;//referenciareferencia.getnombre().trim();
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

	public static String getParentezcoDescripcion(Parentezco parentezco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parentezco!=null/*&&parentezco.getId()>0*/) {
			sDescripcion=ParentezcoConstantesFunciones.getParentezcoDescripcion(parentezco);
		}

		return sDescripcion;
	}

	public static String getProfesionDescripcion(Profesion profesion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(profesion!=null/*&&profesion.getId()>0*/) {
			sDescripcion=ProfesionConstantesFunciones.getProfesionDescripcion(profesion);
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
		} else if(sNombreIndice.equals("FK_IdParentezco")) {
			sNombreIndice="Tipo=  Por Parentezco";
		} else if(sNombreIndice.equals("FK_IdProfesion")) {
			sNombreIndice="Tipo=  Por Profesion";
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

	public static String getDetalleIndiceFK_IdParentezco(Long id_parentezco) {
		String sDetalleIndice=" Parametros->";
		if(id_parentezco!=null) {sDetalleIndice+=" Codigo Unico De Parentezco="+id_parentezco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProfesion(Long id_profesion) {
		String sDetalleIndice=" Parametros->";
		if(id_profesion!=null) {sDetalleIndice+=" Codigo Unico De Profesion="+id_profesion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReferencia(Referencia referencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		referencia.setcedula(referencia.getcedula().trim());
		referencia.setapellido(referencia.getapellido().trim());
		referencia.setnombre(referencia.getnombre().trim());
		referencia.setdireccion(referencia.getdireccion().trim());
		referencia.settelefono(referencia.gettelefono().trim());
	}
	
	public static void quitarEspaciosReferencias(List<Referencia> referencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Referencia referencia: referencias) {
			referencia.setcedula(referencia.getcedula().trim());
			referencia.setapellido(referencia.getapellido().trim());
			referencia.setnombre(referencia.getnombre().trim());
			referencia.setdireccion(referencia.getdireccion().trim());
			referencia.settelefono(referencia.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferencia(Referencia referencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && referencia.getConCambioAuxiliar()) {
			referencia.setIsDeleted(referencia.getIsDeletedAuxiliar());	
			referencia.setIsNew(referencia.getIsNewAuxiliar());	
			referencia.setIsChanged(referencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			referencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			referencia.setIsDeletedAuxiliar(false);	
			referencia.setIsNewAuxiliar(false);	
			referencia.setIsChangedAuxiliar(false);
			
			referencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferencias(List<Referencia> referencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Referencia referencia : referencias) {
			if(conAsignarBase && referencia.getConCambioAuxiliar()) {
				referencia.setIsDeleted(referencia.getIsDeletedAuxiliar());	
				referencia.setIsNew(referencia.getIsNewAuxiliar());	
				referencia.setIsChanged(referencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				referencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				referencia.setIsDeletedAuxiliar(false);	
				referencia.setIsNewAuxiliar(false);	
				referencia.setIsChangedAuxiliar(false);
				
				referencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReferencia(Referencia referencia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresReferencias(List<Referencia> referencias,Boolean conEnteros) throws Exception  {
		
		for(Referencia referencia: referencias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaReferencia(List<Referencia> referencias,Referencia referenciaAux) throws Exception  {
		ReferenciaConstantesFunciones.InicializarValoresReferencia(referenciaAux,true);
		
		for(Referencia referencia: referencias) {
			if(referencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReferenciaConstantesFunciones.getArrayColumnasGlobalesReferencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReferencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReferenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReferenciaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Referencia> referencias,Referencia referencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Referencia referenciaAux: referencias) {
			if(referenciaAux!=null && referencia!=null) {
				if((referenciaAux.getId()==null && referencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(referenciaAux.getId()!=null && referencia.getId()!=null){
					if(referenciaAux.getId().equals(referencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReferencia(List<Referencia> referencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Referencia referencia: referencias) {			
			if(referencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReferencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_ID, ReferenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_VERSIONROW, ReferenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_IDEMPRESA, ReferenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_IDEMPLEADO, ReferenciaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_IDPARENTEZCO, ReferenciaConstantesFunciones.IDPARENTEZCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_IDPROFESION, ReferenciaConstantesFunciones.IDPROFESION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_CEDULA, ReferenciaConstantesFunciones.CEDULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_APELLIDO, ReferenciaConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_NOMBRE, ReferenciaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_DIRECCION, ReferenciaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaConstantesFunciones.LABEL_TELEFONO, ReferenciaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReferencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.IDPARENTEZCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.IDPROFESION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.CEDULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferencia() throws Exception  {
		return ReferenciaConstantesFunciones.getTiposSeleccionarReferencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferencia(Boolean conFk) throws Exception  {
		return ReferenciaConstantesFunciones.getTiposSeleccionarReferencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_IDPARENTEZCO);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_IDPARENTEZCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_IDPROFESION);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_IDPROFESION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_CEDULA);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_CEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ReferenciaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReferencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReferencia(Referencia referenciaAux) throws Exception {
		
			referenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciaAux.getEmpresa()));
			referenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(referenciaAux.getEmpleado()));
			referenciaAux.setparentezco_descripcion(ParentezcoConstantesFunciones.getParentezcoDescripcion(referenciaAux.getParentezco()));
			referenciaAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(referenciaAux.getProfesion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReferencia(List<Referencia> referenciasTemp) throws Exception {
		for(Referencia referenciaAux:referenciasTemp) {
			
			referenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciaAux.getEmpresa()));
			referenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(referenciaAux.getEmpleado()));
			referenciaAux.setparentezco_descripcion(ParentezcoConstantesFunciones.getParentezcoDescripcion(referenciaAux.getParentezco()));
			referenciaAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(referenciaAux.getProfesion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Parentezco.class));
				classes.add(new Classe(Profesion.class));
				
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
					if(clas.clas.equals(Parentezco.class)) {
						classes.add(new Classe(Parentezco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Profesion.class)) {
						classes.add(new Classe(Profesion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Parentezco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parentezco.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
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

					if(Parentezco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parentezco.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaConstantesFunciones.getClassesRelationshipsOfReferencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TelefonoReferencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TelefonoReferencia.class)) {
						classes.add(new Classe(TelefonoReferencia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaConstantesFunciones.getClassesRelationshipsFromStringsOfReferencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TelefonoReferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TelefonoReferencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TelefonoReferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TelefonoReferencia.class)); continue;
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
	public static void actualizarLista(Referencia referencia,List<Referencia> referencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Referencia referenciaEncontrado=null;
			
			for(Referencia referenciaLocal:referencias) {
				if(referenciaLocal.getId().equals(referencia.getId())) {
					referenciaEncontrado=referenciaLocal;
					
					referenciaLocal.setIsChanged(referencia.getIsChanged());
					referenciaLocal.setIsNew(referencia.getIsNew());
					referenciaLocal.setIsDeleted(referencia.getIsDeleted());
					
					referenciaLocal.setGeneralEntityOriginal(referencia.getGeneralEntityOriginal());
					
					referenciaLocal.setId(referencia.getId());	
					referenciaLocal.setVersionRow(referencia.getVersionRow());	
					referenciaLocal.setid_empresa(referencia.getid_empresa());	
					referenciaLocal.setid_empleado(referencia.getid_empleado());	
					referenciaLocal.setid_parentezco(referencia.getid_parentezco());	
					referenciaLocal.setid_profesion(referencia.getid_profesion());	
					referenciaLocal.setcedula(referencia.getcedula());	
					referenciaLocal.setapellido(referencia.getapellido());	
					referenciaLocal.setnombre(referencia.getnombre());	
					referenciaLocal.setdireccion(referencia.getdireccion());	
					referenciaLocal.settelefono(referencia.gettelefono());	
					
					
					referenciaLocal.setTelefonoReferencias(referencia.getTelefonoReferencias());
					
					existe=true;
					break;
				}
			}
			
			if(!referencia.getIsDeleted()) {
				if(!existe) {
					referencias.add(referencia);
				}
			} else {
				if(referenciaEncontrado!=null && permiteQuitar)  {
					referencias.remove(referenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Referencia referencia,List<Referencia> referencias) throws Exception {
		try	{			
			for(Referencia referenciaLocal:referencias) {
				if(referenciaLocal.getId().equals(referencia.getId())) {
					referenciaLocal.setIsSelected(referencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReferencia(List<Referencia> referenciasAux) throws Exception {
		//this.referenciasAux=referenciasAux;
		
		for(Referencia referenciaAux:referenciasAux) {
			if(referenciaAux.getIsChanged()) {
				referenciaAux.setIsChanged(false);
			}		
			
			if(referenciaAux.getIsNew()) {
				referenciaAux.setIsNew(false);
			}	
			
			if(referenciaAux.getIsDeleted()) {
				referenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReferencia(Referencia referenciaAux) throws Exception {
		//this.referenciaAux=referenciaAux;
		
			if(referenciaAux.getIsChanged()) {
				referenciaAux.setIsChanged(false);
			}		
			
			if(referenciaAux.getIsNew()) {
				referenciaAux.setIsNew(false);
			}	
			
			if(referenciaAux.getIsDeleted()) {
				referenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Referencia referenciaAsignar,Referencia referencia) throws Exception {
		referenciaAsignar.setId(referencia.getId());	
		referenciaAsignar.setVersionRow(referencia.getVersionRow());	
		referenciaAsignar.setid_empresa(referencia.getid_empresa());
		referenciaAsignar.setempresa_descripcion(referencia.getempresa_descripcion());	
		referenciaAsignar.setid_empleado(referencia.getid_empleado());
		referenciaAsignar.setempleado_descripcion(referencia.getempleado_descripcion());	
		referenciaAsignar.setid_parentezco(referencia.getid_parentezco());
		referenciaAsignar.setparentezco_descripcion(referencia.getparentezco_descripcion());	
		referenciaAsignar.setid_profesion(referencia.getid_profesion());
		referenciaAsignar.setprofesion_descripcion(referencia.getprofesion_descripcion());	
		referenciaAsignar.setcedula(referencia.getcedula());	
		referenciaAsignar.setapellido(referencia.getapellido());	
		referenciaAsignar.setnombre(referencia.getnombre());	
		referenciaAsignar.setdireccion(referencia.getdireccion());	
		referenciaAsignar.settelefono(referencia.gettelefono());	
	}
	
	public static void inicializarReferencia(Referencia referencia) throws Exception {
		try {
				referencia.setId(0L);	
					
				referencia.setid_empresa(-1L);	
				referencia.setid_empleado(-1L);	
				referencia.setid_parentezco(-1L);	
				referencia.setid_profesion(-1L);	
				referencia.setcedula("");	
				referencia.setapellido("");	
				referencia.setnombre("");	
				referencia.setdireccion("");	
				referencia.settelefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReferencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_IDPARENTEZCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_IDPROFESION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_CEDULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReferencia(String sTipo,Row row,Workbook workbook,Referencia referencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getparentezco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getprofesion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getcedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referencia.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReferencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReferencia() {
		return this.sFinalQueryReferencia;
	}
	
	public void setsFinalQueryReferencia(String sFinalQueryReferencia) {
		this.sFinalQueryReferencia= sFinalQueryReferencia;
	}
	
	public Border resaltarSeleccionarReferencia=null;
	
	public Border setResaltarSeleccionarReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReferencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReferencia() {
		return this.resaltarSeleccionarReferencia;
	}
	
	public void setResaltarSeleccionarReferencia(Border borderResaltarSeleccionarReferencia) {
		this.resaltarSeleccionarReferencia= borderResaltarSeleccionarReferencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReferencia=null;
	public Boolean mostraridReferencia=true;
	public Boolean activaridReferencia=true;

	public Border resaltarid_empresaReferencia=null;
	public Boolean mostrarid_empresaReferencia=true;
	public Boolean activarid_empresaReferencia=true;
	public Boolean cargarid_empresaReferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaReferencia=false;//ConEventDepend=true

	public Border resaltarid_empleadoReferencia=null;
	public Boolean mostrarid_empleadoReferencia=true;
	public Boolean activarid_empleadoReferencia=true;
	public Boolean cargarid_empleadoReferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoReferencia=false;//ConEventDepend=true

	public Border resaltarid_parentezcoReferencia=null;
	public Boolean mostrarid_parentezcoReferencia=true;
	public Boolean activarid_parentezcoReferencia=true;
	public Boolean cargarid_parentezcoReferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parentezcoReferencia=false;//ConEventDepend=true

	public Border resaltarid_profesionReferencia=null;
	public Boolean mostrarid_profesionReferencia=true;
	public Boolean activarid_profesionReferencia=true;
	public Boolean cargarid_profesionReferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_profesionReferencia=false;//ConEventDepend=true

	public Border resaltarcedulaReferencia=null;
	public Boolean mostrarcedulaReferencia=true;
	public Boolean activarcedulaReferencia=true;

	public Border resaltarapellidoReferencia=null;
	public Boolean mostrarapellidoReferencia=true;
	public Boolean activarapellidoReferencia=true;

	public Border resaltarnombreReferencia=null;
	public Boolean mostrarnombreReferencia=true;
	public Boolean activarnombreReferencia=true;

	public Border resaltardireccionReferencia=null;
	public Boolean mostrardireccionReferencia=true;
	public Boolean activardireccionReferencia=true;

	public Border resaltartelefonoReferencia=null;
	public Boolean mostrartelefonoReferencia=true;
	public Boolean activartelefonoReferencia=true;

	
	

	public Border setResaltaridReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltaridReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReferencia() {
		return this.resaltaridReferencia;
	}

	public void setResaltaridReferencia(Border borderResaltar) {
		this.resaltaridReferencia= borderResaltar;
	}

	public Boolean getMostraridReferencia() {
		return this.mostraridReferencia;
	}

	public void setMostraridReferencia(Boolean mostraridReferencia) {
		this.mostraridReferencia= mostraridReferencia;
	}

	public Boolean getActivaridReferencia() {
		return this.activaridReferencia;
	}

	public void setActivaridReferencia(Boolean activaridReferencia) {
		this.activaridReferencia= activaridReferencia;
	}

	public Border setResaltarid_empresaReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaReferencia() {
		return this.resaltarid_empresaReferencia;
	}

	public void setResaltarid_empresaReferencia(Border borderResaltar) {
		this.resaltarid_empresaReferencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaReferencia() {
		return this.mostrarid_empresaReferencia;
	}

	public void setMostrarid_empresaReferencia(Boolean mostrarid_empresaReferencia) {
		this.mostrarid_empresaReferencia= mostrarid_empresaReferencia;
	}

	public Boolean getActivarid_empresaReferencia() {
		return this.activarid_empresaReferencia;
	}

	public void setActivarid_empresaReferencia(Boolean activarid_empresaReferencia) {
		this.activarid_empresaReferencia= activarid_empresaReferencia;
	}

	public Boolean getCargarid_empresaReferencia() {
		return this.cargarid_empresaReferencia;
	}

	public void setCargarid_empresaReferencia(Boolean cargarid_empresaReferencia) {
		this.cargarid_empresaReferencia= cargarid_empresaReferencia;
	}

	public Border setResaltarid_empleadoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarid_empleadoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoReferencia() {
		return this.resaltarid_empleadoReferencia;
	}

	public void setResaltarid_empleadoReferencia(Border borderResaltar) {
		this.resaltarid_empleadoReferencia= borderResaltar;
	}

	public Boolean getMostrarid_empleadoReferencia() {
		return this.mostrarid_empleadoReferencia;
	}

	public void setMostrarid_empleadoReferencia(Boolean mostrarid_empleadoReferencia) {
		this.mostrarid_empleadoReferencia= mostrarid_empleadoReferencia;
	}

	public Boolean getActivarid_empleadoReferencia() {
		return this.activarid_empleadoReferencia;
	}

	public void setActivarid_empleadoReferencia(Boolean activarid_empleadoReferencia) {
		this.activarid_empleadoReferencia= activarid_empleadoReferencia;
	}

	public Boolean getCargarid_empleadoReferencia() {
		return this.cargarid_empleadoReferencia;
	}

	public void setCargarid_empleadoReferencia(Boolean cargarid_empleadoReferencia) {
		this.cargarid_empleadoReferencia= cargarid_empleadoReferencia;
	}

	public Border setResaltarid_parentezcoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarid_parentezcoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parentezcoReferencia() {
		return this.resaltarid_parentezcoReferencia;
	}

	public void setResaltarid_parentezcoReferencia(Border borderResaltar) {
		this.resaltarid_parentezcoReferencia= borderResaltar;
	}

	public Boolean getMostrarid_parentezcoReferencia() {
		return this.mostrarid_parentezcoReferencia;
	}

	public void setMostrarid_parentezcoReferencia(Boolean mostrarid_parentezcoReferencia) {
		this.mostrarid_parentezcoReferencia= mostrarid_parentezcoReferencia;
	}

	public Boolean getActivarid_parentezcoReferencia() {
		return this.activarid_parentezcoReferencia;
	}

	public void setActivarid_parentezcoReferencia(Boolean activarid_parentezcoReferencia) {
		this.activarid_parentezcoReferencia= activarid_parentezcoReferencia;
	}

	public Boolean getCargarid_parentezcoReferencia() {
		return this.cargarid_parentezcoReferencia;
	}

	public void setCargarid_parentezcoReferencia(Boolean cargarid_parentezcoReferencia) {
		this.cargarid_parentezcoReferencia= cargarid_parentezcoReferencia;
	}

	public Border setResaltarid_profesionReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarid_profesionReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_profesionReferencia() {
		return this.resaltarid_profesionReferencia;
	}

	public void setResaltarid_profesionReferencia(Border borderResaltar) {
		this.resaltarid_profesionReferencia= borderResaltar;
	}

	public Boolean getMostrarid_profesionReferencia() {
		return this.mostrarid_profesionReferencia;
	}

	public void setMostrarid_profesionReferencia(Boolean mostrarid_profesionReferencia) {
		this.mostrarid_profesionReferencia= mostrarid_profesionReferencia;
	}

	public Boolean getActivarid_profesionReferencia() {
		return this.activarid_profesionReferencia;
	}

	public void setActivarid_profesionReferencia(Boolean activarid_profesionReferencia) {
		this.activarid_profesionReferencia= activarid_profesionReferencia;
	}

	public Boolean getCargarid_profesionReferencia() {
		return this.cargarid_profesionReferencia;
	}

	public void setCargarid_profesionReferencia(Boolean cargarid_profesionReferencia) {
		this.cargarid_profesionReferencia= cargarid_profesionReferencia;
	}

	public Border setResaltarcedulaReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarcedulaReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedulaReferencia() {
		return this.resaltarcedulaReferencia;
	}

	public void setResaltarcedulaReferencia(Border borderResaltar) {
		this.resaltarcedulaReferencia= borderResaltar;
	}

	public Boolean getMostrarcedulaReferencia() {
		return this.mostrarcedulaReferencia;
	}

	public void setMostrarcedulaReferencia(Boolean mostrarcedulaReferencia) {
		this.mostrarcedulaReferencia= mostrarcedulaReferencia;
	}

	public Boolean getActivarcedulaReferencia() {
		return this.activarcedulaReferencia;
	}

	public void setActivarcedulaReferencia(Boolean activarcedulaReferencia) {
		this.activarcedulaReferencia= activarcedulaReferencia;
	}

	public Border setResaltarapellidoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarapellidoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoReferencia() {
		return this.resaltarapellidoReferencia;
	}

	public void setResaltarapellidoReferencia(Border borderResaltar) {
		this.resaltarapellidoReferencia= borderResaltar;
	}

	public Boolean getMostrarapellidoReferencia() {
		return this.mostrarapellidoReferencia;
	}

	public void setMostrarapellidoReferencia(Boolean mostrarapellidoReferencia) {
		this.mostrarapellidoReferencia= mostrarapellidoReferencia;
	}

	public Boolean getActivarapellidoReferencia() {
		return this.activarapellidoReferencia;
	}

	public void setActivarapellidoReferencia(Boolean activarapellidoReferencia) {
		this.activarapellidoReferencia= activarapellidoReferencia;
	}

	public Border setResaltarnombreReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltarnombreReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreReferencia() {
		return this.resaltarnombreReferencia;
	}

	public void setResaltarnombreReferencia(Border borderResaltar) {
		this.resaltarnombreReferencia= borderResaltar;
	}

	public Boolean getMostrarnombreReferencia() {
		return this.mostrarnombreReferencia;
	}

	public void setMostrarnombreReferencia(Boolean mostrarnombreReferencia) {
		this.mostrarnombreReferencia= mostrarnombreReferencia;
	}

	public Boolean getActivarnombreReferencia() {
		return this.activarnombreReferencia;
	}

	public void setActivarnombreReferencia(Boolean activarnombreReferencia) {
		this.activarnombreReferencia= activarnombreReferencia;
	}

	public Border setResaltardireccionReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltardireccionReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionReferencia() {
		return this.resaltardireccionReferencia;
	}

	public void setResaltardireccionReferencia(Border borderResaltar) {
		this.resaltardireccionReferencia= borderResaltar;
	}

	public Boolean getMostrardireccionReferencia() {
		return this.mostrardireccionReferencia;
	}

	public void setMostrardireccionReferencia(Boolean mostrardireccionReferencia) {
		this.mostrardireccionReferencia= mostrardireccionReferencia;
	}

	public Boolean getActivardireccionReferencia() {
		return this.activardireccionReferencia;
	}

	public void setActivardireccionReferencia(Boolean activardireccionReferencia) {
		this.activardireccionReferencia= activardireccionReferencia;
	}

	public Border setResaltartelefonoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltar);
		
		this.resaltartelefonoReferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoReferencia() {
		return this.resaltartelefonoReferencia;
	}

	public void setResaltartelefonoReferencia(Border borderResaltar) {
		this.resaltartelefonoReferencia= borderResaltar;
	}

	public Boolean getMostrartelefonoReferencia() {
		return this.mostrartelefonoReferencia;
	}

	public void setMostrartelefonoReferencia(Boolean mostrartelefonoReferencia) {
		this.mostrartelefonoReferencia= mostrartelefonoReferencia;
	}

	public Boolean getActivartelefonoReferencia() {
		return this.activartelefonoReferencia;
	}

	public void setActivartelefonoReferencia(Boolean activartelefonoReferencia) {
		this.activartelefonoReferencia= activartelefonoReferencia;
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
		
		
		this.setMostraridReferencia(esInicial);
		this.setMostrarid_empresaReferencia(esInicial);
		this.setMostrarid_empleadoReferencia(esInicial);
		this.setMostrarid_parentezcoReferencia(esInicial);
		this.setMostrarid_profesionReferencia(esInicial);
		this.setMostrarcedulaReferencia(esInicial);
		this.setMostrarapellidoReferencia(esInicial);
		this.setMostrarnombreReferencia(esInicial);
		this.setMostrardireccionReferencia(esInicial);
		this.setMostrartelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaConstantesFunciones.ID)) {
				this.setMostraridReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPARENTEZCO)) {
				this.setMostrarid_parentezcoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPROFESION)) {
				this.setMostrarid_profesionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.CEDULA)) {
				this.setMostrarcedulaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoReferencia(esAsigna);
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
		
		
		this.setActivaridReferencia(esInicial);
		this.setActivarid_empresaReferencia(esInicial);
		this.setActivarid_empleadoReferencia(esInicial);
		this.setActivarid_parentezcoReferencia(esInicial);
		this.setActivarid_profesionReferencia(esInicial);
		this.setActivarcedulaReferencia(esInicial);
		this.setActivarapellidoReferencia(esInicial);
		this.setActivarnombreReferencia(esInicial);
		this.setActivardireccionReferencia(esInicial);
		this.setActivartelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaConstantesFunciones.ID)) {
				this.setActivaridReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPARENTEZCO)) {
				this.setActivarid_parentezcoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPROFESION)) {
				this.setActivarid_profesionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.CEDULA)) {
				this.setActivarcedulaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoReferencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReferencia(esInicial);
		this.setResaltarid_empresaReferencia(esInicial);
		this.setResaltarid_empleadoReferencia(esInicial);
		this.setResaltarid_parentezcoReferencia(esInicial);
		this.setResaltarid_profesionReferencia(esInicial);
		this.setResaltarcedulaReferencia(esInicial);
		this.setResaltarapellidoReferencia(esInicial);
		this.setResaltarnombreReferencia(esInicial);
		this.setResaltardireccionReferencia(esInicial);
		this.setResaltartelefonoReferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaConstantesFunciones.ID)) {
				this.setResaltaridReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPARENTEZCO)) {
				this.setResaltarid_parentezcoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.IDPROFESION)) {
				this.setResaltarid_profesionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.CEDULA)) {
				this.setResaltarcedulaReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionReferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoReferencia(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTelefonoReferenciaReferencia=null;

	public Border getResaltarTelefonoReferenciaReferencia() {
		return this.resaltarTelefonoReferenciaReferencia;
	}

	public void setResaltarTelefonoReferenciaReferencia(Border borderResaltarTelefonoReferencia) {
		if(borderResaltarTelefonoReferencia!=null) {
			this.resaltarTelefonoReferenciaReferencia= borderResaltarTelefonoReferencia;
		}
	}

	public Border setResaltarTelefonoReferenciaReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltarTelefonoReferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//referenciaBeanSwingJInternalFrame.jTtoolBarReferencia.setBorder(borderResaltarTelefonoReferencia);
			
		this.resaltarTelefonoReferenciaReferencia= borderResaltarTelefonoReferencia;

		 return borderResaltarTelefonoReferencia;
	}



	public Boolean mostrarTelefonoReferenciaReferencia=true;

	public Boolean getMostrarTelefonoReferenciaReferencia() {
		return this.mostrarTelefonoReferenciaReferencia;
	}

	public void setMostrarTelefonoReferenciaReferencia(Boolean visibilidadResaltarTelefonoReferencia) {
		this.mostrarTelefonoReferenciaReferencia= visibilidadResaltarTelefonoReferencia;
	}



	public Boolean activarTelefonoReferenciaReferencia=true;

	public Boolean gethabilitarResaltarTelefonoReferenciaReferencia() {
		return this.activarTelefonoReferenciaReferencia;
	}

	public void setActivarTelefonoReferenciaReferencia(Boolean habilitarResaltarTelefonoReferencia) {
		this.activarTelefonoReferenciaReferencia= habilitarResaltarTelefonoReferencia;
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

		this.setMostrarTelefonoReferenciaReferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TelefonoReferencia.class)) {
				this.setMostrarTelefonoReferenciaReferencia(esAsigna);
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

		this.setActivarTelefonoReferenciaReferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TelefonoReferencia.class)) {
				this.setActivarTelefonoReferenciaReferencia(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTelefonoReferenciaReferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TelefonoReferencia.class)) {
				this.setResaltarTelefonoReferenciaReferencia(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpleadoReferencia=true;

	public Boolean getMostrarFK_IdEmpleadoReferencia() {
		return this.mostrarFK_IdEmpleadoReferencia;
	}

	public void setMostrarFK_IdEmpleadoReferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoReferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaReferencia=true;

	public Boolean getMostrarFK_IdEmpresaReferencia() {
		return this.mostrarFK_IdEmpresaReferencia;
	}

	public void setMostrarFK_IdEmpresaReferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaReferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParentezcoReferencia=true;

	public Boolean getMostrarFK_IdParentezcoReferencia() {
		return this.mostrarFK_IdParentezcoReferencia;
	}

	public void setMostrarFK_IdParentezcoReferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParentezcoReferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProfesionReferencia=true;

	public Boolean getMostrarFK_IdProfesionReferencia() {
		return this.mostrarFK_IdProfesionReferencia;
	}

	public void setMostrarFK_IdProfesionReferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProfesionReferencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoReferencia=true;

	public Boolean getActivarFK_IdEmpleadoReferencia() {
		return this.activarFK_IdEmpleadoReferencia;
	}

	public void setActivarFK_IdEmpleadoReferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoReferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaReferencia=true;

	public Boolean getActivarFK_IdEmpresaReferencia() {
		return this.activarFK_IdEmpresaReferencia;
	}

	public void setActivarFK_IdEmpresaReferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaReferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdParentezcoReferencia=true;

	public Boolean getActivarFK_IdParentezcoReferencia() {
		return this.activarFK_IdParentezcoReferencia;
	}

	public void setActivarFK_IdParentezcoReferencia(Boolean habilitarResaltar) {
		this.activarFK_IdParentezcoReferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdProfesionReferencia=true;

	public Boolean getActivarFK_IdProfesionReferencia() {
		return this.activarFK_IdProfesionReferencia;
	}

	public void setActivarFK_IdProfesionReferencia(Boolean habilitarResaltar) {
		this.activarFK_IdProfesionReferencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoReferencia=null;

	public Border getResaltarFK_IdEmpleadoReferencia() {
		return this.resaltarFK_IdEmpleadoReferencia;
	}

	public void setResaltarFK_IdEmpleadoReferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoReferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoReferencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaReferencia=null;

	public Border getResaltarFK_IdEmpresaReferencia() {
		return this.resaltarFK_IdEmpresaReferencia;
	}

	public void setResaltarFK_IdEmpresaReferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaReferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaReferencia= borderResaltar;
	}

	public Border resaltarFK_IdParentezcoReferencia=null;

	public Border getResaltarFK_IdParentezcoReferencia() {
		return this.resaltarFK_IdParentezcoReferencia;
	}

	public void setResaltarFK_IdParentezcoReferencia(Border borderResaltar) {
		this.resaltarFK_IdParentezcoReferencia= borderResaltar;
	}

	public void setResaltarFK_IdParentezcoReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParentezcoReferencia= borderResaltar;
	}

	public Border resaltarFK_IdProfesionReferencia=null;

	public Border getResaltarFK_IdProfesionReferencia() {
		return this.resaltarFK_IdProfesionReferencia;
	}

	public void setResaltarFK_IdProfesionReferencia(Border borderResaltar) {
		this.resaltarFK_IdProfesionReferencia= borderResaltar;
	}

	public void setResaltarFK_IdProfesionReferencia(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBeanSwingJInternalFrame referenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProfesionReferencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}