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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.PresuAsignacionConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuAsignacionParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuAsignacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuAsignacionConstantesFunciones extends PresuAsignacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresuAsignacion";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuAsignacion"+PresuAsignacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuAsignacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuAsignacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuAsignacionConstantesFunciones.SCHEMA+"_"+PresuAsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuAsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuAsignacionConstantesFunciones.SCHEMA+"_"+PresuAsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuAsignacionConstantesFunciones.SCHEMA+"_"+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuAsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuAsignacionConstantesFunciones.SCHEMA+"_"+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuAsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuAsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuAsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuAsignacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuAsignacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuAsignacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuAsignacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asignacion Presupuestoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Asignacion Presupuesto";
	public static final String SCLASSWEBTITULO_LOWER="Presu Asignacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuAsignacion";
	public static final String OBJECTNAME="presuasignacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_asignacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presuasignacion from "+PresuAsignacionConstantesFunciones.SPERSISTENCENAME+" presuasignacion";
	public static String QUERYSELECTNATIVE="select "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".version_row,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_presu_proyecto_cuenta,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_empleado,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".codigo_secuencial,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".valor,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".fecha,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".descripcion from "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME;//+" as "+PresuAsignacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuAsignacionConstantesFuncionesAdditional presuasignacionConstantesFuncionesAdditional=null;
	
	public PresuAsignacionConstantesFuncionesAdditional getPresuAsignacionConstantesFuncionesAdditional() {
		return this.presuasignacionConstantesFuncionesAdditional;
	}
	
	public void setPresuAsignacionConstantesFuncionesAdditional(PresuAsignacionConstantesFuncionesAdditional presuasignacionConstantesFuncionesAdditional) {
		try {
			this.presuasignacionConstantesFuncionesAdditional=presuasignacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRESUPROYECTOCUENTA= "id_presu_proyecto_cuenta";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String CODIGOSECUENCIAL= "codigo_secuencial";
    public static final String VALOR= "valor";
    public static final String FECHA= "fecha";
    public static final String IDPRESUESTADO= "id_presu_estado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRESUPROYECTOCUENTA= "Proyecto Cuenta";
		public static final String LABEL_IDPRESUPROYECTOCUENTA_LOWER= "Presu Proyecto Cuenta";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_CODIGOSECUENCIAL= "Codigo Secuencial";
		public static final String LABEL_CODIGOSECUENCIAL_LOWER= "Codigo Secuencial";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDPRESUESTADO= "Estado";
		public static final String LABEL_IDPRESUESTADO_LOWER= "Presu Estado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresuAsignacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_IDPRESUPROYECTOCUENTA;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_CODIGOSECUENCIAL;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.VALOR)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.FECHA)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.IDPRESUESTADO)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_IDPRESUESTADO;}
		if(sNombreColumna.equals(PresuAsignacionConstantesFunciones.DESCRIPCION)) {sLabelColumna=PresuAsignacionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getPresuAsignacionDescripcion(PresuAsignacion presuasignacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presuasignacion !=null/* && presuasignacion.getId()!=0*/) {
			if(presuasignacion.getId()!=null) {
				sDescripcion=presuasignacion.getId().toString();
			}//presuasignacionpresuasignacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuAsignacionDescripcionDetallado(PresuAsignacion presuasignacion) {
		String sDescripcion="";
			
		sDescripcion+=PresuAsignacionConstantesFunciones.ID+"=";
		sDescripcion+=presuasignacion.getId().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presuasignacion.getVersionRow().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA+"=";
		sDescripcion+=presuasignacion.getid_presu_proyecto_cuenta().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=presuasignacion.getid_empleado().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL+"=";
		sDescripcion+=presuasignacion.getcodigo_secuencial().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.VALOR+"=";
		sDescripcion+=presuasignacion.getvalor().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.FECHA+"=";
		sDescripcion+=presuasignacion.getfecha().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.IDPRESUESTADO+"=";
		sDescripcion+=presuasignacion.getid_presu_estado().toString()+",";
		sDescripcion+=PresuAsignacionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=presuasignacion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuAsignacionDescripcion(PresuAsignacion presuasignacion,String sValor) throws Exception {			
		if(presuasignacion !=null) {
			//presuasignacionpresuasignacion.getId().toString();
		}		
	}
	
		

	public static String getPresuProyectoCuentaDescripcion(PresuProyectoCuenta presuproyectocuenta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuproyectocuenta!=null/*&&presuproyectocuenta.getId()>0*/) {
			sDescripcion=PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaDescripcion(presuproyectocuenta);
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

	public static String getPresuEstadoDescripcion(PresuEstado presuestado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuestado!=null/*&&presuestado.getId()>0*/) {
			sDescripcion=PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuestado);
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
		} else if(sNombreIndice.equals("FK_IdPresuEstado")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdPresuProyectoCuenta")) {
			sNombreIndice="Tipo=  Por Proyecto Cuenta";
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

	public static String getDetalleIndiceFK_IdPresuEstado(Long id_presu_estado) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_estado!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_presu_estado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuProyectoCuenta(Long id_presu_proyecto_cuenta) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_proyecto_cuenta!=null) {sDetalleIndice+=" Codigo Unico De Proyecto Cuenta="+id_presu_proyecto_cuenta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresuAsignacion(PresuAsignacion presuasignacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presuasignacion.setdescripcion(presuasignacion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPresuAsignacions(List<PresuAsignacion> presuasignacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuAsignacion presuasignacion: presuasignacions) {
			presuasignacion.setdescripcion(presuasignacion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuAsignacion(PresuAsignacion presuasignacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presuasignacion.getConCambioAuxiliar()) {
			presuasignacion.setIsDeleted(presuasignacion.getIsDeletedAuxiliar());	
			presuasignacion.setIsNew(presuasignacion.getIsNewAuxiliar());	
			presuasignacion.setIsChanged(presuasignacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presuasignacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presuasignacion.setIsDeletedAuxiliar(false);	
			presuasignacion.setIsNewAuxiliar(false);	
			presuasignacion.setIsChangedAuxiliar(false);
			
			presuasignacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuAsignacions(List<PresuAsignacion> presuasignacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuAsignacion presuasignacion : presuasignacions) {
			if(conAsignarBase && presuasignacion.getConCambioAuxiliar()) {
				presuasignacion.setIsDeleted(presuasignacion.getIsDeletedAuxiliar());	
				presuasignacion.setIsNew(presuasignacion.getIsNewAuxiliar());	
				presuasignacion.setIsChanged(presuasignacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presuasignacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presuasignacion.setIsDeletedAuxiliar(false);	
				presuasignacion.setIsNewAuxiliar(false);	
				presuasignacion.setIsChangedAuxiliar(false);
				
				presuasignacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuAsignacion(PresuAsignacion presuasignacion,Boolean conEnteros) throws Exception  {
		presuasignacion.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			presuasignacion.setcodigo_secuencial(0L);
		}
	}		
	
	public static void InicializarValoresPresuAsignacions(List<PresuAsignacion> presuasignacions,Boolean conEnteros) throws Exception  {
		
		for(PresuAsignacion presuasignacion: presuasignacions) {
			presuasignacion.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				presuasignacion.setcodigo_secuencial(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuAsignacion(List<PresuAsignacion> presuasignacions,PresuAsignacion presuasignacionAux) throws Exception  {
		PresuAsignacionConstantesFunciones.InicializarValoresPresuAsignacion(presuasignacionAux,true);
		
		for(PresuAsignacion presuasignacion: presuasignacions) {
			if(presuasignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presuasignacionAux.setcodigo_secuencial(presuasignacionAux.getcodigo_secuencial()+presuasignacion.getcodigo_secuencial());			
			presuasignacionAux.setvalor(presuasignacionAux.getvalor()+presuasignacion.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuAsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuAsignacionConstantesFunciones.getArrayColumnasGlobalesPresuAsignacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuAsignacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuAsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuAsignacion> presuasignacions,PresuAsignacion presuasignacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuAsignacion presuasignacionAux: presuasignacions) {
			if(presuasignacionAux!=null && presuasignacion!=null) {
				if((presuasignacionAux.getId()==null && presuasignacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presuasignacionAux.getId()!=null && presuasignacion.getId()!=null){
					if(presuasignacionAux.getId().equals(presuasignacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuAsignacion(List<PresuAsignacion> presuasignacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PresuAsignacion presuasignacion: presuasignacions) {			
			if(presuasignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presuasignacion.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresuAsignacionConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuAsignacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_ID, PresuAsignacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_VERSIONROW, PresuAsignacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_IDPRESUPROYECTOCUENTA, PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_IDEMPLEADO, PresuAsignacionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_CODIGOSECUENCIAL, PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_VALOR, PresuAsignacionConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_FECHA, PresuAsignacionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_IDPRESUESTADO, PresuAsignacionConstantesFunciones.IDPRESUESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuAsignacionConstantesFunciones.LABEL_DESCRIPCION, PresuAsignacionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuAsignacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.IDPRESUESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuAsignacionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuAsignacion() throws Exception  {
		return PresuAsignacionConstantesFunciones.getTiposSeleccionarPresuAsignacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuAsignacion(Boolean conFk) throws Exception  {
		return PresuAsignacionConstantesFunciones.getTiposSeleccionarPresuAsignacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuAsignacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_IDPRESUPROYECTOCUENTA);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_IDPRESUPROYECTOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_CODIGOSECUENCIAL);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_CODIGOSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_IDPRESUESTADO);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_IDPRESUESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuAsignacionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PresuAsignacionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuAsignacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuAsignacion(PresuAsignacion presuasignacionAux) throws Exception {
		
			presuasignacionAux.setpresuproyectocuenta_descripcion(PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaDescripcion(presuasignacionAux.getPresuProyectoCuenta()));
			presuasignacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presuasignacionAux.getEmpleado()));
			presuasignacionAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuasignacionAux.getPresuEstado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuAsignacion(List<PresuAsignacion> presuasignacionsTemp) throws Exception {
		for(PresuAsignacion presuasignacionAux:presuasignacionsTemp) {
			
			presuasignacionAux.setpresuproyectocuenta_descripcion(PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaDescripcion(presuasignacionAux.getPresuProyectoCuenta()));
			presuasignacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presuasignacionAux.getEmpleado()));
			presuasignacionAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuasignacionAux.getPresuEstado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuAsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuProyectoCuenta.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(PresuEstado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyectoCuenta.class)) {
						classes.add(new Classe(PresuProyectoCuenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuEstado.class)) {
						classes.add(new Classe(PresuEstado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuAsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuAsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuAsignacionConstantesFunciones.getClassesRelationshipsOfPresuAsignacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuAsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuAsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuAsignacionConstantesFunciones.getClassesRelationshipsFromStringsOfPresuAsignacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuAsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresuAsignacion presuasignacion,List<PresuAsignacion> presuasignacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuAsignacion presuasignacionEncontrado=null;
			
			for(PresuAsignacion presuasignacionLocal:presuasignacions) {
				if(presuasignacionLocal.getId().equals(presuasignacion.getId())) {
					presuasignacionEncontrado=presuasignacionLocal;
					
					presuasignacionLocal.setIsChanged(presuasignacion.getIsChanged());
					presuasignacionLocal.setIsNew(presuasignacion.getIsNew());
					presuasignacionLocal.setIsDeleted(presuasignacion.getIsDeleted());
					
					presuasignacionLocal.setGeneralEntityOriginal(presuasignacion.getGeneralEntityOriginal());
					
					presuasignacionLocal.setId(presuasignacion.getId());	
					presuasignacionLocal.setVersionRow(presuasignacion.getVersionRow());	
					presuasignacionLocal.setid_presu_proyecto_cuenta(presuasignacion.getid_presu_proyecto_cuenta());	
					presuasignacionLocal.setid_empleado(presuasignacion.getid_empleado());	
					presuasignacionLocal.setcodigo_secuencial(presuasignacion.getcodigo_secuencial());	
					presuasignacionLocal.setvalor(presuasignacion.getvalor());	
					presuasignacionLocal.setfecha(presuasignacion.getfecha());	
					presuasignacionLocal.setid_presu_estado(presuasignacion.getid_presu_estado());	
					presuasignacionLocal.setdescripcion(presuasignacion.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presuasignacion.getIsDeleted()) {
				if(!existe) {
					presuasignacions.add(presuasignacion);
				}
			} else {
				if(presuasignacionEncontrado!=null && permiteQuitar)  {
					presuasignacions.remove(presuasignacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuAsignacion presuasignacion,List<PresuAsignacion> presuasignacions) throws Exception {
		try	{			
			for(PresuAsignacion presuasignacionLocal:presuasignacions) {
				if(presuasignacionLocal.getId().equals(presuasignacion.getId())) {
					presuasignacionLocal.setIsSelected(presuasignacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuAsignacion(List<PresuAsignacion> presuasignacionsAux) throws Exception {
		//this.presuasignacionsAux=presuasignacionsAux;
		
		for(PresuAsignacion presuasignacionAux:presuasignacionsAux) {
			if(presuasignacionAux.getIsChanged()) {
				presuasignacionAux.setIsChanged(false);
			}		
			
			if(presuasignacionAux.getIsNew()) {
				presuasignacionAux.setIsNew(false);
			}	
			
			if(presuasignacionAux.getIsDeleted()) {
				presuasignacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuAsignacion(PresuAsignacion presuasignacionAux) throws Exception {
		//this.presuasignacionAux=presuasignacionAux;
		
			if(presuasignacionAux.getIsChanged()) {
				presuasignacionAux.setIsChanged(false);
			}		
			
			if(presuasignacionAux.getIsNew()) {
				presuasignacionAux.setIsNew(false);
			}	
			
			if(presuasignacionAux.getIsDeleted()) {
				presuasignacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuAsignacion presuasignacionAsignar,PresuAsignacion presuasignacion) throws Exception {
		presuasignacionAsignar.setId(presuasignacion.getId());	
		presuasignacionAsignar.setVersionRow(presuasignacion.getVersionRow());	
		presuasignacionAsignar.setid_presu_proyecto_cuenta(presuasignacion.getid_presu_proyecto_cuenta());
		presuasignacionAsignar.setpresuproyectocuenta_descripcion(presuasignacion.getpresuproyectocuenta_descripcion());	
		presuasignacionAsignar.setid_empleado(presuasignacion.getid_empleado());
		presuasignacionAsignar.setempleado_descripcion(presuasignacion.getempleado_descripcion());	
		presuasignacionAsignar.setcodigo_secuencial(presuasignacion.getcodigo_secuencial());	
		presuasignacionAsignar.setvalor(presuasignacion.getvalor());	
		presuasignacionAsignar.setfecha(presuasignacion.getfecha());	
		presuasignacionAsignar.setid_presu_estado(presuasignacion.getid_presu_estado());
		presuasignacionAsignar.setpresuestado_descripcion(presuasignacion.getpresuestado_descripcion());	
		presuasignacionAsignar.setdescripcion(presuasignacion.getdescripcion());	
	}
	
	public static void inicializarPresuAsignacion(PresuAsignacion presuasignacion) throws Exception {
		try {
				presuasignacion.setId(0L);	
					
				presuasignacion.setid_presu_proyecto_cuenta(-1L);	
				presuasignacion.setid_empleado(-1L);	
				presuasignacion.setcodigo_secuencial(0L);	
				presuasignacion.setvalor(0.0);	
				presuasignacion.setfecha(new Date());	
				presuasignacion.setid_presu_estado(-1L);	
				presuasignacion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuAsignacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_IDPRESUPROYECTOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_CODIGOSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_IDPRESUESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuAsignacionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuAsignacion(String sTipo,Row row,Workbook workbook,PresuAsignacion presuasignacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getpresuproyectocuenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getcodigo_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getpresuestado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuasignacion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuAsignacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuAsignacion() {
		return this.sFinalQueryPresuAsignacion;
	}
	
	public void setsFinalQueryPresuAsignacion(String sFinalQueryPresuAsignacion) {
		this.sFinalQueryPresuAsignacion= sFinalQueryPresuAsignacion;
	}
	
	public Border resaltarSeleccionarPresuAsignacion=null;
	
	public Border setResaltarSeleccionarPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuAsignacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuAsignacion() {
		return this.resaltarSeleccionarPresuAsignacion;
	}
	
	public void setResaltarSeleccionarPresuAsignacion(Border borderResaltarSeleccionarPresuAsignacion) {
		this.resaltarSeleccionarPresuAsignacion= borderResaltarSeleccionarPresuAsignacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuAsignacion=null;
	public Boolean mostraridPresuAsignacion=true;
	public Boolean activaridPresuAsignacion=true;

	public Border resaltarid_presu_proyecto_cuentaPresuAsignacion=null;
	public Boolean mostrarid_presu_proyecto_cuentaPresuAsignacion=true;
	public Boolean activarid_presu_proyecto_cuentaPresuAsignacion=true;
	public Boolean cargarid_presu_proyecto_cuentaPresuAsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_proyecto_cuentaPresuAsignacion=false;//ConEventDepend=true

	public Border resaltarid_empleadoPresuAsignacion=null;
	public Boolean mostrarid_empleadoPresuAsignacion=true;
	public Boolean activarid_empleadoPresuAsignacion=true;
	public Boolean cargarid_empleadoPresuAsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPresuAsignacion=false;//ConEventDepend=true

	public Border resaltarcodigo_secuencialPresuAsignacion=null;
	public Boolean mostrarcodigo_secuencialPresuAsignacion=true;
	public Boolean activarcodigo_secuencialPresuAsignacion=true;

	public Border resaltarvalorPresuAsignacion=null;
	public Boolean mostrarvalorPresuAsignacion=true;
	public Boolean activarvalorPresuAsignacion=true;

	public Border resaltarfechaPresuAsignacion=null;
	public Boolean mostrarfechaPresuAsignacion=true;
	public Boolean activarfechaPresuAsignacion=false;

	public Border resaltarid_presu_estadoPresuAsignacion=null;
	public Boolean mostrarid_presu_estadoPresuAsignacion=true;
	public Boolean activarid_presu_estadoPresuAsignacion=true;
	public Boolean cargarid_presu_estadoPresuAsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_estadoPresuAsignacion=false;//ConEventDepend=true

	public Border resaltardescripcionPresuAsignacion=null;
	public Boolean mostrardescripcionPresuAsignacion=true;
	public Boolean activardescripcionPresuAsignacion=true;

	
	

	public Border setResaltaridPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltaridPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuAsignacion() {
		return this.resaltaridPresuAsignacion;
	}

	public void setResaltaridPresuAsignacion(Border borderResaltar) {
		this.resaltaridPresuAsignacion= borderResaltar;
	}

	public Boolean getMostraridPresuAsignacion() {
		return this.mostraridPresuAsignacion;
	}

	public void setMostraridPresuAsignacion(Boolean mostraridPresuAsignacion) {
		this.mostraridPresuAsignacion= mostraridPresuAsignacion;
	}

	public Boolean getActivaridPresuAsignacion() {
		return this.activaridPresuAsignacion;
	}

	public void setActivaridPresuAsignacion(Boolean activaridPresuAsignacion) {
		this.activaridPresuAsignacion= activaridPresuAsignacion;
	}

	public Border setResaltarid_presu_proyecto_cuentaPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarid_presu_proyecto_cuentaPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_proyecto_cuentaPresuAsignacion() {
		return this.resaltarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public void setResaltarid_presu_proyecto_cuentaPresuAsignacion(Border borderResaltar) {
		this.resaltarid_presu_proyecto_cuentaPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarid_presu_proyecto_cuentaPresuAsignacion() {
		return this.mostrarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public void setMostrarid_presu_proyecto_cuentaPresuAsignacion(Boolean mostrarid_presu_proyecto_cuentaPresuAsignacion) {
		this.mostrarid_presu_proyecto_cuentaPresuAsignacion= mostrarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public Boolean getActivarid_presu_proyecto_cuentaPresuAsignacion() {
		return this.activarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public void setActivarid_presu_proyecto_cuentaPresuAsignacion(Boolean activarid_presu_proyecto_cuentaPresuAsignacion) {
		this.activarid_presu_proyecto_cuentaPresuAsignacion= activarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public Boolean getCargarid_presu_proyecto_cuentaPresuAsignacion() {
		return this.cargarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public void setCargarid_presu_proyecto_cuentaPresuAsignacion(Boolean cargarid_presu_proyecto_cuentaPresuAsignacion) {
		this.cargarid_presu_proyecto_cuentaPresuAsignacion= cargarid_presu_proyecto_cuentaPresuAsignacion;
	}

	public Border setResaltarid_empleadoPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPresuAsignacion() {
		return this.resaltarid_empleadoPresuAsignacion;
	}

	public void setResaltarid_empleadoPresuAsignacion(Border borderResaltar) {
		this.resaltarid_empleadoPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPresuAsignacion() {
		return this.mostrarid_empleadoPresuAsignacion;
	}

	public void setMostrarid_empleadoPresuAsignacion(Boolean mostrarid_empleadoPresuAsignacion) {
		this.mostrarid_empleadoPresuAsignacion= mostrarid_empleadoPresuAsignacion;
	}

	public Boolean getActivarid_empleadoPresuAsignacion() {
		return this.activarid_empleadoPresuAsignacion;
	}

	public void setActivarid_empleadoPresuAsignacion(Boolean activarid_empleadoPresuAsignacion) {
		this.activarid_empleadoPresuAsignacion= activarid_empleadoPresuAsignacion;
	}

	public Boolean getCargarid_empleadoPresuAsignacion() {
		return this.cargarid_empleadoPresuAsignacion;
	}

	public void setCargarid_empleadoPresuAsignacion(Boolean cargarid_empleadoPresuAsignacion) {
		this.cargarid_empleadoPresuAsignacion= cargarid_empleadoPresuAsignacion;
	}

	public Border setResaltarcodigo_secuencialPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarcodigo_secuencialPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_secuencialPresuAsignacion() {
		return this.resaltarcodigo_secuencialPresuAsignacion;
	}

	public void setResaltarcodigo_secuencialPresuAsignacion(Border borderResaltar) {
		this.resaltarcodigo_secuencialPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarcodigo_secuencialPresuAsignacion() {
		return this.mostrarcodigo_secuencialPresuAsignacion;
	}

	public void setMostrarcodigo_secuencialPresuAsignacion(Boolean mostrarcodigo_secuencialPresuAsignacion) {
		this.mostrarcodigo_secuencialPresuAsignacion= mostrarcodigo_secuencialPresuAsignacion;
	}

	public Boolean getActivarcodigo_secuencialPresuAsignacion() {
		return this.activarcodigo_secuencialPresuAsignacion;
	}

	public void setActivarcodigo_secuencialPresuAsignacion(Boolean activarcodigo_secuencialPresuAsignacion) {
		this.activarcodigo_secuencialPresuAsignacion= activarcodigo_secuencialPresuAsignacion;
	}

	public Border setResaltarvalorPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarvalorPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresuAsignacion() {
		return this.resaltarvalorPresuAsignacion;
	}

	public void setResaltarvalorPresuAsignacion(Border borderResaltar) {
		this.resaltarvalorPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarvalorPresuAsignacion() {
		return this.mostrarvalorPresuAsignacion;
	}

	public void setMostrarvalorPresuAsignacion(Boolean mostrarvalorPresuAsignacion) {
		this.mostrarvalorPresuAsignacion= mostrarvalorPresuAsignacion;
	}

	public Boolean getActivarvalorPresuAsignacion() {
		return this.activarvalorPresuAsignacion;
	}

	public void setActivarvalorPresuAsignacion(Boolean activarvalorPresuAsignacion) {
		this.activarvalorPresuAsignacion= activarvalorPresuAsignacion;
	}

	public Border setResaltarfechaPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarfechaPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPresuAsignacion() {
		return this.resaltarfechaPresuAsignacion;
	}

	public void setResaltarfechaPresuAsignacion(Border borderResaltar) {
		this.resaltarfechaPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarfechaPresuAsignacion() {
		return this.mostrarfechaPresuAsignacion;
	}

	public void setMostrarfechaPresuAsignacion(Boolean mostrarfechaPresuAsignacion) {
		this.mostrarfechaPresuAsignacion= mostrarfechaPresuAsignacion;
	}

	public Boolean getActivarfechaPresuAsignacion() {
		return this.activarfechaPresuAsignacion;
	}

	public void setActivarfechaPresuAsignacion(Boolean activarfechaPresuAsignacion) {
		this.activarfechaPresuAsignacion= activarfechaPresuAsignacion;
	}

	public Border setResaltarid_presu_estadoPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltarid_presu_estadoPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_estadoPresuAsignacion() {
		return this.resaltarid_presu_estadoPresuAsignacion;
	}

	public void setResaltarid_presu_estadoPresuAsignacion(Border borderResaltar) {
		this.resaltarid_presu_estadoPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrarid_presu_estadoPresuAsignacion() {
		return this.mostrarid_presu_estadoPresuAsignacion;
	}

	public void setMostrarid_presu_estadoPresuAsignacion(Boolean mostrarid_presu_estadoPresuAsignacion) {
		this.mostrarid_presu_estadoPresuAsignacion= mostrarid_presu_estadoPresuAsignacion;
	}

	public Boolean getActivarid_presu_estadoPresuAsignacion() {
		return this.activarid_presu_estadoPresuAsignacion;
	}

	public void setActivarid_presu_estadoPresuAsignacion(Boolean activarid_presu_estadoPresuAsignacion) {
		this.activarid_presu_estadoPresuAsignacion= activarid_presu_estadoPresuAsignacion;
	}

	public Boolean getCargarid_presu_estadoPresuAsignacion() {
		return this.cargarid_presu_estadoPresuAsignacion;
	}

	public void setCargarid_presu_estadoPresuAsignacion(Boolean cargarid_presu_estadoPresuAsignacion) {
		this.cargarid_presu_estadoPresuAsignacion= cargarid_presu_estadoPresuAsignacion;
	}

	public Border setResaltardescripcionPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuasignacionBeanSwingJInternalFrame.jTtoolBarPresuAsignacion.setBorder(borderResaltar);
		
		this.resaltardescripcionPresuAsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPresuAsignacion() {
		return this.resaltardescripcionPresuAsignacion;
	}

	public void setResaltardescripcionPresuAsignacion(Border borderResaltar) {
		this.resaltardescripcionPresuAsignacion= borderResaltar;
	}

	public Boolean getMostrardescripcionPresuAsignacion() {
		return this.mostrardescripcionPresuAsignacion;
	}

	public void setMostrardescripcionPresuAsignacion(Boolean mostrardescripcionPresuAsignacion) {
		this.mostrardescripcionPresuAsignacion= mostrardescripcionPresuAsignacion;
	}

	public Boolean getActivardescripcionPresuAsignacion() {
		return this.activardescripcionPresuAsignacion;
	}

	public void setActivardescripcionPresuAsignacion(Boolean activardescripcionPresuAsignacion) {
		this.activardescripcionPresuAsignacion= activardescripcionPresuAsignacion;
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
		
		
		this.setMostraridPresuAsignacion(esInicial);
		this.setMostrarid_presu_proyecto_cuentaPresuAsignacion(esInicial);
		this.setMostrarid_empleadoPresuAsignacion(esInicial);
		this.setMostrarcodigo_secuencialPresuAsignacion(esInicial);
		this.setMostrarvalorPresuAsignacion(esInicial);
		this.setMostrarfechaPresuAsignacion(esInicial);
		this.setMostrarid_presu_estadoPresuAsignacion(esInicial);
		this.setMostrardescripcionPresuAsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.ID)) {
				this.setMostraridPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA)) {
				this.setMostrarid_presu_proyecto_cuentaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL)) {
				this.setMostrarcodigo_secuencialPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.FECHA)) {
				this.setMostrarfechaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUESTADO)) {
				this.setMostrarid_presu_estadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPresuAsignacion(esAsigna);
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
		
		
		this.setActivaridPresuAsignacion(esInicial);
		this.setActivarid_presu_proyecto_cuentaPresuAsignacion(esInicial);
		this.setActivarid_empleadoPresuAsignacion(esInicial);
		this.setActivarcodigo_secuencialPresuAsignacion(esInicial);
		this.setActivarvalorPresuAsignacion(esInicial);
		this.setActivarfechaPresuAsignacion(esInicial);
		this.setActivarid_presu_estadoPresuAsignacion(esInicial);
		this.setActivardescripcionPresuAsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.ID)) {
				this.setActivaridPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA)) {
				this.setActivarid_presu_proyecto_cuentaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL)) {
				this.setActivarcodigo_secuencialPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.VALOR)) {
				this.setActivarvalorPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.FECHA)) {
				this.setActivarfechaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUESTADO)) {
				this.setActivarid_presu_estadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPresuAsignacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuAsignacion(esInicial);
		this.setResaltarid_presu_proyecto_cuentaPresuAsignacion(esInicial);
		this.setResaltarid_empleadoPresuAsignacion(esInicial);
		this.setResaltarcodigo_secuencialPresuAsignacion(esInicial);
		this.setResaltarvalorPresuAsignacion(esInicial);
		this.setResaltarfechaPresuAsignacion(esInicial);
		this.setResaltarid_presu_estadoPresuAsignacion(esInicial);
		this.setResaltardescripcionPresuAsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.ID)) {
				this.setResaltaridPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA)) {
				this.setResaltarid_presu_proyecto_cuentaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL)) {
				this.setResaltarcodigo_secuencialPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.FECHA)) {
				this.setResaltarfechaPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.IDPRESUESTADO)) {
				this.setResaltarid_presu_estadoPresuAsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuAsignacionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPresuAsignacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoPresuAsignacion=true;

	public Boolean getMostrarFK_IdEmpleadoPresuAsignacion() {
		return this.mostrarFK_IdEmpleadoPresuAsignacion;
	}

	public void setMostrarFK_IdEmpleadoPresuAsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPresuAsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuEstadoPresuAsignacion=true;

	public Boolean getMostrarFK_IdPresuEstadoPresuAsignacion() {
		return this.mostrarFK_IdPresuEstadoPresuAsignacion;
	}

	public void setMostrarFK_IdPresuEstadoPresuAsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuEstadoPresuAsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuProyectoCuentaPresuAsignacion=true;

	public Boolean getMostrarFK_IdPresuProyectoCuentaPresuAsignacion() {
		return this.mostrarFK_IdPresuProyectoCuentaPresuAsignacion;
	}

	public void setMostrarFK_IdPresuProyectoCuentaPresuAsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuProyectoCuentaPresuAsignacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoPresuAsignacion=true;

	public Boolean getActivarFK_IdEmpleadoPresuAsignacion() {
		return this.activarFK_IdEmpleadoPresuAsignacion;
	}

	public void setActivarFK_IdEmpleadoPresuAsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPresuAsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuEstadoPresuAsignacion=true;

	public Boolean getActivarFK_IdPresuEstadoPresuAsignacion() {
		return this.activarFK_IdPresuEstadoPresuAsignacion;
	}

	public void setActivarFK_IdPresuEstadoPresuAsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdPresuEstadoPresuAsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuProyectoCuentaPresuAsignacion=true;

	public Boolean getActivarFK_IdPresuProyectoCuentaPresuAsignacion() {
		return this.activarFK_IdPresuProyectoCuentaPresuAsignacion;
	}

	public void setActivarFK_IdPresuProyectoCuentaPresuAsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdPresuProyectoCuentaPresuAsignacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoPresuAsignacion=null;

	public Border getResaltarFK_IdEmpleadoPresuAsignacion() {
		return this.resaltarFK_IdEmpleadoPresuAsignacion;
	}

	public void setResaltarFK_IdEmpleadoPresuAsignacion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPresuAsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPresuAsignacion= borderResaltar;
	}

	public Border resaltarFK_IdPresuEstadoPresuAsignacion=null;

	public Border getResaltarFK_IdPresuEstadoPresuAsignacion() {
		return this.resaltarFK_IdPresuEstadoPresuAsignacion;
	}

	public void setResaltarFK_IdPresuEstadoPresuAsignacion(Border borderResaltar) {
		this.resaltarFK_IdPresuEstadoPresuAsignacion= borderResaltar;
	}

	public void setResaltarFK_IdPresuEstadoPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuEstadoPresuAsignacion= borderResaltar;
	}

	public Border resaltarFK_IdPresuProyectoCuentaPresuAsignacion=null;

	public Border getResaltarFK_IdPresuProyectoCuentaPresuAsignacion() {
		return this.resaltarFK_IdPresuProyectoCuentaPresuAsignacion;
	}

	public void setResaltarFK_IdPresuProyectoCuentaPresuAsignacion(Border borderResaltar) {
		this.resaltarFK_IdPresuProyectoCuentaPresuAsignacion= borderResaltar;
	}

	public void setResaltarFK_IdPresuProyectoCuentaPresuAsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*PresuAsignacionBeanSwingJInternalFrame presuasignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuProyectoCuentaPresuAsignacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}