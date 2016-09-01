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


import com.bydan.erp.nomina.util.VacacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.VacacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VacacionEmpleadoParameterGeneral;

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
final public class VacacionEmpleadoConstantesFunciones extends VacacionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VacacionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VacacionEmpleado"+VacacionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VacacionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VacacionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VacacionEmpleadoConstantesFunciones.SCHEMA+"_"+VacacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VacacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VacacionEmpleadoConstantesFunciones.SCHEMA+"_"+VacacionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VacacionEmpleadoConstantesFunciones.SCHEMA+"_"+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VacacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VacacionEmpleadoConstantesFunciones.SCHEMA+"_"+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VacacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VacacionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VacacionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VacacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VacacionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VacacionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VacacionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vacacion Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vacacion Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Vacacion Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VacacionEmpleado";
	public static final String OBJECTNAME="vacacionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="vacacion_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vacacionempleado from "+VacacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" vacacionempleado";
	public static String QUERYSELECTNATIVE="select "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_anio_periodo1,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_anio_periodo2,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".numero_veces,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".fecha_estimada,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_vacaciones,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_tomados,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_pagados,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_adicionales from "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+VacacionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VacacionEmpleadoConstantesFuncionesAdditional vacacionempleadoConstantesFuncionesAdditional=null;
	
	public VacacionEmpleadoConstantesFuncionesAdditional getVacacionEmpleadoConstantesFuncionesAdditional() {
		return this.vacacionempleadoConstantesFuncionesAdditional;
	}
	
	public void setVacacionEmpleadoConstantesFuncionesAdditional(VacacionEmpleadoConstantesFuncionesAdditional vacacionempleadoConstantesFuncionesAdditional) {
		try {
			this.vacacionempleadoConstantesFuncionesAdditional=vacacionempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDANIOPERIODO1= "id_anio_periodo1";
    public static final String IDANIOPERIODO2= "id_anio_periodo2";
    public static final String NUMEROVECES= "numero_veces";
    public static final String FECHAESTIMADA= "fecha_estimada";
    public static final String HORASVACACIONES= "horas_vacaciones";
    public static final String HORASTOMADOS= "horas_tomados";
    public static final String HORASPAGADOS= "horas_pagados";
    public static final String HORASADICIONALES= "horas_adicionales";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDANIOPERIODO1= "Anio Periodo1";
		public static final String LABEL_IDANIOPERIODO1_LOWER= "Anio Periodo1";
    	public static final String LABEL_IDANIOPERIODO2= "Anio Periodo2";
		public static final String LABEL_IDANIOPERIODO2_LOWER= "Anio Periodo2";
    	public static final String LABEL_NUMEROVECES= "Numero Veces";
		public static final String LABEL_NUMEROVECES_LOWER= "Numero Veces";
    	public static final String LABEL_FECHAESTIMADA= "Fecha Estimada";
		public static final String LABEL_FECHAESTIMADA_LOWER= "Fecha Estimada";
    	public static final String LABEL_HORASVACACIONES= "Horas Vacaciones";
		public static final String LABEL_HORASVACACIONES_LOWER= "Horas Vacaciones";
    	public static final String LABEL_HORASTOMADOS= "Horas Tomados";
		public static final String LABEL_HORASTOMADOS_LOWER= "Horas Tomados";
    	public static final String LABEL_HORASPAGADOS= "Horas Pagados";
		public static final String LABEL_HORASPAGADOS_LOWER= "Horas Pagados";
    	public static final String LABEL_HORASADICIONALES= "Horas Adicionales";
		public static final String LABEL_HORASADICIONALES_LOWER= "Horas Adicionales";
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getVacacionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO1;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO2;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.NUMEROVECES)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_NUMEROVECES;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.FECHAESTIMADA)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_FECHAESTIMADA;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.HORASVACACIONES)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.HORASTOMADOS)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.HORASPAGADOS)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS;}
		if(sNombreColumna.equals(VacacionEmpleadoConstantesFunciones.HORASADICIONALES)) {sLabelColumna=VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVacacionEmpleadoDescripcion(VacacionEmpleado vacacionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vacacionempleado !=null/* && vacacionempleado.getId()!=0*/) {
			if(vacacionempleado.getId()!=null) {
				sDescripcion=vacacionempleado.getId().toString();
			}//vacacionempleadovacacionempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVacacionEmpleadoDescripcionDetallado(VacacionEmpleado vacacionempleado) {
		String sDescripcion="";
			
		sDescripcion+=VacacionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=vacacionempleado.getId().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vacacionempleado.getVersionRow().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vacacionempleado.getid_empresa().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=vacacionempleado.getid_empleado().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1+"=";
		sDescripcion+=vacacionempleado.getid_anio_periodo1().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2+"=";
		sDescripcion+=vacacionempleado.getid_anio_periodo2().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.NUMEROVECES+"=";
		sDescripcion+=vacacionempleado.getnumero_veces().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.FECHAESTIMADA+"=";
		sDescripcion+=vacacionempleado.getfecha_estimada().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.HORASVACACIONES+"=";
		sDescripcion+=vacacionempleado.gethoras_vacaciones().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.HORASTOMADOS+"=";
		sDescripcion+=vacacionempleado.gethoras_tomados().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.HORASPAGADOS+"=";
		sDescripcion+=vacacionempleado.gethoras_pagados().toString()+",";
		sDescripcion+=VacacionEmpleadoConstantesFunciones.HORASADICIONALES+"=";
		sDescripcion+=vacacionempleado.gethoras_adicionales().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVacacionEmpleadoDescripcion(VacacionEmpleado vacacionempleado,String sValor) throws Exception {			
		if(vacacionempleado !=null) {
			//vacacionempleadovacacionempleado.getId().toString();
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

	public static String getAnioPeriodo1Descripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getAnioPeriodo2Descripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnioPeriodo1")) {
			sNombreIndice="Tipo=  Por Anio Periodo1";
		} else if(sNombreIndice.equals("FK_IdAnioPeriodo2")) {
			sNombreIndice="Tipo=  Por Anio Periodo2";
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

	public static String getDetalleIndiceFK_IdAnioPeriodo1(Long id_anio_periodo1) {
		String sDetalleIndice=" Parametros->";
		if(id_anio_periodo1!=null) {sDetalleIndice+=" Codigo Unico De Anio Periodo1="+id_anio_periodo1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnioPeriodo2(Long id_anio_periodo2) {
		String sDetalleIndice=" Parametros->";
		if(id_anio_periodo2!=null) {sDetalleIndice+=" Codigo Unico De Anio Periodo2="+id_anio_periodo2.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosVacacionEmpleado(VacacionEmpleado vacacionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosVacacionEmpleados(List<VacacionEmpleado> vacacionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VacacionEmpleado vacacionempleado: vacacionempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVacacionEmpleado(VacacionEmpleado vacacionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vacacionempleado.getConCambioAuxiliar()) {
			vacacionempleado.setIsDeleted(vacacionempleado.getIsDeletedAuxiliar());	
			vacacionempleado.setIsNew(vacacionempleado.getIsNewAuxiliar());	
			vacacionempleado.setIsChanged(vacacionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vacacionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vacacionempleado.setIsDeletedAuxiliar(false);	
			vacacionempleado.setIsNewAuxiliar(false);	
			vacacionempleado.setIsChangedAuxiliar(false);
			
			vacacionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVacacionEmpleados(List<VacacionEmpleado> vacacionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VacacionEmpleado vacacionempleado : vacacionempleados) {
			if(conAsignarBase && vacacionempleado.getConCambioAuxiliar()) {
				vacacionempleado.setIsDeleted(vacacionempleado.getIsDeletedAuxiliar());	
				vacacionempleado.setIsNew(vacacionempleado.getIsNewAuxiliar());	
				vacacionempleado.setIsChanged(vacacionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vacacionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vacacionempleado.setIsDeletedAuxiliar(false);	
				vacacionempleado.setIsNewAuxiliar(false);	
				vacacionempleado.setIsChangedAuxiliar(false);
				
				vacacionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVacacionEmpleado(VacacionEmpleado vacacionempleado,Boolean conEnteros) throws Exception  {
		vacacionempleado.sethoras_vacaciones(0.0);
		vacacionempleado.sethoras_tomados(0.0);
		vacacionempleado.sethoras_pagados(0.0);
		vacacionempleado.sethoras_adicionales(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			vacacionempleado.setnumero_veces(0);
		}
	}		
	
	public static void InicializarValoresVacacionEmpleados(List<VacacionEmpleado> vacacionempleados,Boolean conEnteros) throws Exception  {
		
		for(VacacionEmpleado vacacionempleado: vacacionempleados) {
			vacacionempleado.sethoras_vacaciones(0.0);
			vacacionempleado.sethoras_tomados(0.0);
			vacacionempleado.sethoras_pagados(0.0);
			vacacionempleado.sethoras_adicionales(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				vacacionempleado.setnumero_veces(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaVacacionEmpleado(List<VacacionEmpleado> vacacionempleados,VacacionEmpleado vacacionempleadoAux) throws Exception  {
		VacacionEmpleadoConstantesFunciones.InicializarValoresVacacionEmpleado(vacacionempleadoAux,true);
		
		for(VacacionEmpleado vacacionempleado: vacacionempleados) {
			if(vacacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vacacionempleadoAux.setnumero_veces(vacacionempleadoAux.getnumero_veces()+vacacionempleado.getnumero_veces());			
			vacacionempleadoAux.sethoras_vacaciones(vacacionempleadoAux.gethoras_vacaciones()+vacacionempleado.gethoras_vacaciones());			
			vacacionempleadoAux.sethoras_tomados(vacacionempleadoAux.gethoras_tomados()+vacacionempleado.gethoras_tomados());			
			vacacionempleadoAux.sethoras_pagados(vacacionempleadoAux.gethoras_pagados()+vacacionempleado.gethoras_pagados());			
			vacacionempleadoAux.sethoras_adicionales(vacacionempleadoAux.gethoras_adicionales()+vacacionempleado.gethoras_adicionales());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVacacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VacacionEmpleadoConstantesFunciones.getArrayColumnasGlobalesVacacionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVacacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VacacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VacacionEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVacacionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VacacionEmpleado> vacacionempleados,VacacionEmpleado vacacionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VacacionEmpleado vacacionempleadoAux: vacacionempleados) {
			if(vacacionempleadoAux!=null && vacacionempleado!=null) {
				if((vacacionempleadoAux.getId()==null && vacacionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vacacionempleadoAux.getId()!=null && vacacionempleado.getId()!=null){
					if(vacacionempleadoAux.getId().equals(vacacionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVacacionEmpleado(List<VacacionEmpleado> vacacionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double horas_vacacionesTotal=0.0;
		Double horas_tomadosTotal=0.0;
		Double horas_pagadosTotal=0.0;
		Double horas_adicionalesTotal=0.0;
	
		for(VacacionEmpleado vacacionempleado: vacacionempleados) {			
			if(vacacionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			horas_vacacionesTotal+=vacacionempleado.gethoras_vacaciones();
			horas_tomadosTotal+=vacacionempleado.gethoras_tomados();
			horas_pagadosTotal+=vacacionempleado.gethoras_pagados();
			horas_adicionalesTotal+=vacacionempleado.gethoras_adicionales();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VacacionEmpleadoConstantesFunciones.HORASVACACIONES);
		datoGeneral.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES);
		datoGeneral.setdValorDouble(horas_vacacionesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VacacionEmpleadoConstantesFunciones.HORASTOMADOS);
		datoGeneral.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS);
		datoGeneral.setdValorDouble(horas_tomadosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VacacionEmpleadoConstantesFunciones.HORASPAGADOS);
		datoGeneral.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS);
		datoGeneral.setdValorDouble(horas_pagadosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VacacionEmpleadoConstantesFunciones.HORASADICIONALES);
		datoGeneral.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES);
		datoGeneral.setdValorDouble(horas_adicionalesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVacacionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_ID, VacacionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_VERSIONROW, VacacionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, VacacionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, VacacionEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO1, VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO2, VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_NUMEROVECES, VacacionEmpleadoConstantesFunciones.NUMEROVECES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_FECHAESTIMADA, VacacionEmpleadoConstantesFunciones.FECHAESTIMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES, VacacionEmpleadoConstantesFunciones.HORASVACACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS, VacacionEmpleadoConstantesFunciones.HORASTOMADOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS, VacacionEmpleadoConstantesFunciones.HORASPAGADOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES, VacacionEmpleadoConstantesFunciones.HORASADICIONALES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVacacionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.NUMEROVECES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.FECHAESTIMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.HORASVACACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.HORASTOMADOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.HORASPAGADOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VacacionEmpleadoConstantesFunciones.HORASADICIONALES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVacacionEmpleado() throws Exception  {
		return VacacionEmpleadoConstantesFunciones.getTiposSeleccionarVacacionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVacacionEmpleado(Boolean conFk) throws Exception  {
		return VacacionEmpleadoConstantesFunciones.getTiposSeleccionarVacacionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVacacionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO1);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO2);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_NUMEROVECES);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_NUMEROVECES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_FECHAESTIMADA);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_FECHAESTIMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES);
			reporte.setsDescripcion(VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVacacionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVacacionEmpleado(VacacionEmpleado vacacionempleadoAux) throws Exception {
		
			vacacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vacacionempleadoAux.getEmpresa()));
			vacacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vacacionempleadoAux.getEmpleado()));
			vacacionempleadoAux.setanioperiodo1_descripcion(AnioConstantesFunciones.getAnioDescripcion(vacacionempleadoAux.getAnioPeriodo1()));
			vacacionempleadoAux.setanioperiodo2_descripcion(AnioConstantesFunciones.getAnioDescripcion(vacacionempleadoAux.getAnioPeriodo2()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVacacionEmpleado(List<VacacionEmpleado> vacacionempleadosTemp) throws Exception {
		for(VacacionEmpleado vacacionempleadoAux:vacacionempleadosTemp) {
			
			vacacionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vacacionempleadoAux.getEmpresa()));
			vacacionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(vacacionempleadoAux.getEmpleado()));
			vacacionempleadoAux.setanioperiodo1_descripcion(AnioConstantesFunciones.getAnioDescripcion(vacacionempleadoAux.getAnioPeriodo1()));
			vacacionempleadoAux.setanioperiodo2_descripcion(AnioConstantesFunciones.getAnioDescripcion(vacacionempleadoAux.getAnioPeriodo2()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVacacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Anio.class));
				
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVacacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVacacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VacacionEmpleadoConstantesFunciones.getClassesRelationshipsOfVacacionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVacacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVacacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VacacionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfVacacionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVacacionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VacacionEmpleado vacacionempleado,List<VacacionEmpleado> vacacionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VacacionEmpleado vacacionempleadoEncontrado=null;
			
			for(VacacionEmpleado vacacionempleadoLocal:vacacionempleados) {
				if(vacacionempleadoLocal.getId().equals(vacacionempleado.getId())) {
					vacacionempleadoEncontrado=vacacionempleadoLocal;
					
					vacacionempleadoLocal.setIsChanged(vacacionempleado.getIsChanged());
					vacacionempleadoLocal.setIsNew(vacacionempleado.getIsNew());
					vacacionempleadoLocal.setIsDeleted(vacacionempleado.getIsDeleted());
					
					vacacionempleadoLocal.setGeneralEntityOriginal(vacacionempleado.getGeneralEntityOriginal());
					
					vacacionempleadoLocal.setId(vacacionempleado.getId());	
					vacacionempleadoLocal.setVersionRow(vacacionempleado.getVersionRow());	
					vacacionempleadoLocal.setid_empresa(vacacionempleado.getid_empresa());	
					vacacionempleadoLocal.setid_empleado(vacacionempleado.getid_empleado());	
					vacacionempleadoLocal.setid_anio_periodo1(vacacionempleado.getid_anio_periodo1());	
					vacacionempleadoLocal.setid_anio_periodo2(vacacionempleado.getid_anio_periodo2());	
					vacacionempleadoLocal.setnumero_veces(vacacionempleado.getnumero_veces());	
					vacacionempleadoLocal.setfecha_estimada(vacacionempleado.getfecha_estimada());	
					vacacionempleadoLocal.sethoras_vacaciones(vacacionempleado.gethoras_vacaciones());	
					vacacionempleadoLocal.sethoras_tomados(vacacionempleado.gethoras_tomados());	
					vacacionempleadoLocal.sethoras_pagados(vacacionempleado.gethoras_pagados());	
					vacacionempleadoLocal.sethoras_adicionales(vacacionempleado.gethoras_adicionales());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!vacacionempleado.getIsDeleted()) {
				if(!existe) {
					vacacionempleados.add(vacacionempleado);
				}
			} else {
				if(vacacionempleadoEncontrado!=null && permiteQuitar)  {
					vacacionempleados.remove(vacacionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VacacionEmpleado vacacionempleado,List<VacacionEmpleado> vacacionempleados) throws Exception {
		try	{			
			for(VacacionEmpleado vacacionempleadoLocal:vacacionempleados) {
				if(vacacionempleadoLocal.getId().equals(vacacionempleado.getId())) {
					vacacionempleadoLocal.setIsSelected(vacacionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVacacionEmpleado(List<VacacionEmpleado> vacacionempleadosAux) throws Exception {
		//this.vacacionempleadosAux=vacacionempleadosAux;
		
		for(VacacionEmpleado vacacionempleadoAux:vacacionempleadosAux) {
			if(vacacionempleadoAux.getIsChanged()) {
				vacacionempleadoAux.setIsChanged(false);
			}		
			
			if(vacacionempleadoAux.getIsNew()) {
				vacacionempleadoAux.setIsNew(false);
			}	
			
			if(vacacionempleadoAux.getIsDeleted()) {
				vacacionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVacacionEmpleado(VacacionEmpleado vacacionempleadoAux) throws Exception {
		//this.vacacionempleadoAux=vacacionempleadoAux;
		
			if(vacacionempleadoAux.getIsChanged()) {
				vacacionempleadoAux.setIsChanged(false);
			}		
			
			if(vacacionempleadoAux.getIsNew()) {
				vacacionempleadoAux.setIsNew(false);
			}	
			
			if(vacacionempleadoAux.getIsDeleted()) {
				vacacionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VacacionEmpleado vacacionempleadoAsignar,VacacionEmpleado vacacionempleado) throws Exception {
		vacacionempleadoAsignar.setId(vacacionempleado.getId());	
		vacacionempleadoAsignar.setVersionRow(vacacionempleado.getVersionRow());	
		vacacionempleadoAsignar.setid_empresa(vacacionempleado.getid_empresa());
		vacacionempleadoAsignar.setempresa_descripcion(vacacionempleado.getempresa_descripcion());	
		vacacionempleadoAsignar.setid_empleado(vacacionempleado.getid_empleado());
		vacacionempleadoAsignar.setempleado_descripcion(vacacionempleado.getempleado_descripcion());	
		vacacionempleadoAsignar.setid_anio_periodo1(vacacionempleado.getid_anio_periodo1());
		vacacionempleadoAsignar.setanioperiodo1_descripcion(vacacionempleado.getanioperiodo1_descripcion());	
		vacacionempleadoAsignar.setid_anio_periodo2(vacacionempleado.getid_anio_periodo2());
		vacacionempleadoAsignar.setanioperiodo2_descripcion(vacacionempleado.getanioperiodo2_descripcion());	
		vacacionempleadoAsignar.setnumero_veces(vacacionempleado.getnumero_veces());	
		vacacionempleadoAsignar.setfecha_estimada(vacacionempleado.getfecha_estimada());	
		vacacionempleadoAsignar.sethoras_vacaciones(vacacionempleado.gethoras_vacaciones());	
		vacacionempleadoAsignar.sethoras_tomados(vacacionempleado.gethoras_tomados());	
		vacacionempleadoAsignar.sethoras_pagados(vacacionempleado.gethoras_pagados());	
		vacacionempleadoAsignar.sethoras_adicionales(vacacionempleado.gethoras_adicionales());	
	}
	
	public static void inicializarVacacionEmpleado(VacacionEmpleado vacacionempleado) throws Exception {
		try {
				vacacionempleado.setId(0L);	
					
				vacacionempleado.setid_empresa(-1L);	
				vacacionempleado.setid_empleado(-1L);	
				vacacionempleado.setid_anio_periodo1(-1L);	
				vacacionempleado.setid_anio_periodo2(-1L);	
				vacacionempleado.setnumero_veces(0);	
				vacacionempleado.setfecha_estimada(new Date());	
				vacacionempleado.sethoras_vacaciones(0.0);	
				vacacionempleado.sethoras_tomados(0.0);	
				vacacionempleado.sethoras_pagados(0.0);	
				vacacionempleado.sethoras_adicionales(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVacacionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_IDANIOPERIODO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_NUMEROVECES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_FECHAESTIMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_HORASVACACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_HORASTOMADOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_HORASPAGADOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VacacionEmpleadoConstantesFunciones.LABEL_HORASADICIONALES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVacacionEmpleado(String sTipo,Row row,Workbook workbook,VacacionEmpleado vacacionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getanioperiodo1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getanioperiodo2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getnumero_veces());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.getfecha_estimada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.gethoras_vacaciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.gethoras_tomados());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.gethoras_pagados());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vacacionempleado.gethoras_adicionales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVacacionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVacacionEmpleado() {
		return this.sFinalQueryVacacionEmpleado;
	}
	
	public void setsFinalQueryVacacionEmpleado(String sFinalQueryVacacionEmpleado) {
		this.sFinalQueryVacacionEmpleado= sFinalQueryVacacionEmpleado;
	}
	
	public Border resaltarSeleccionarVacacionEmpleado=null;
	
	public Border setResaltarSeleccionarVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVacacionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVacacionEmpleado() {
		return this.resaltarSeleccionarVacacionEmpleado;
	}
	
	public void setResaltarSeleccionarVacacionEmpleado(Border borderResaltarSeleccionarVacacionEmpleado) {
		this.resaltarSeleccionarVacacionEmpleado= borderResaltarSeleccionarVacacionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVacacionEmpleado=null;
	public Boolean mostraridVacacionEmpleado=true;
	public Boolean activaridVacacionEmpleado=true;

	public Border resaltarid_empresaVacacionEmpleado=null;
	public Boolean mostrarid_empresaVacacionEmpleado=true;
	public Boolean activarid_empresaVacacionEmpleado=true;
	public Boolean cargarid_empresaVacacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVacacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoVacacionEmpleado=null;
	public Boolean mostrarid_empleadoVacacionEmpleado=true;
	public Boolean activarid_empleadoVacacionEmpleado=true;
	public Boolean cargarid_empleadoVacacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoVacacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_anio_periodo1VacacionEmpleado=null;
	public Boolean mostrarid_anio_periodo1VacacionEmpleado=true;
	public Boolean activarid_anio_periodo1VacacionEmpleado=true;
	public Boolean cargarid_anio_periodo1VacacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anio_periodo1VacacionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_anio_periodo2VacacionEmpleado=null;
	public Boolean mostrarid_anio_periodo2VacacionEmpleado=true;
	public Boolean activarid_anio_periodo2VacacionEmpleado=true;
	public Boolean cargarid_anio_periodo2VacacionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anio_periodo2VacacionEmpleado=false;//ConEventDepend=true

	public Border resaltarnumero_vecesVacacionEmpleado=null;
	public Boolean mostrarnumero_vecesVacacionEmpleado=true;
	public Boolean activarnumero_vecesVacacionEmpleado=true;

	public Border resaltarfecha_estimadaVacacionEmpleado=null;
	public Boolean mostrarfecha_estimadaVacacionEmpleado=true;
	public Boolean activarfecha_estimadaVacacionEmpleado=false;

	public Border resaltarhoras_vacacionesVacacionEmpleado=null;
	public Boolean mostrarhoras_vacacionesVacacionEmpleado=true;
	public Boolean activarhoras_vacacionesVacacionEmpleado=true;

	public Border resaltarhoras_tomadosVacacionEmpleado=null;
	public Boolean mostrarhoras_tomadosVacacionEmpleado=true;
	public Boolean activarhoras_tomadosVacacionEmpleado=true;

	public Border resaltarhoras_pagadosVacacionEmpleado=null;
	public Boolean mostrarhoras_pagadosVacacionEmpleado=true;
	public Boolean activarhoras_pagadosVacacionEmpleado=true;

	public Border resaltarhoras_adicionalesVacacionEmpleado=null;
	public Boolean mostrarhoras_adicionalesVacacionEmpleado=true;
	public Boolean activarhoras_adicionalesVacacionEmpleado=true;

	
	

	public Border setResaltaridVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVacacionEmpleado() {
		return this.resaltaridVacacionEmpleado;
	}

	public void setResaltaridVacacionEmpleado(Border borderResaltar) {
		this.resaltaridVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostraridVacacionEmpleado() {
		return this.mostraridVacacionEmpleado;
	}

	public void setMostraridVacacionEmpleado(Boolean mostraridVacacionEmpleado) {
		this.mostraridVacacionEmpleado= mostraridVacacionEmpleado;
	}

	public Boolean getActivaridVacacionEmpleado() {
		return this.activaridVacacionEmpleado;
	}

	public void setActivaridVacacionEmpleado(Boolean activaridVacacionEmpleado) {
		this.activaridVacacionEmpleado= activaridVacacionEmpleado;
	}

	public Border setResaltarid_empresaVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVacacionEmpleado() {
		return this.resaltarid_empresaVacacionEmpleado;
	}

	public void setResaltarid_empresaVacacionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaVacacionEmpleado() {
		return this.mostrarid_empresaVacacionEmpleado;
	}

	public void setMostrarid_empresaVacacionEmpleado(Boolean mostrarid_empresaVacacionEmpleado) {
		this.mostrarid_empresaVacacionEmpleado= mostrarid_empresaVacacionEmpleado;
	}

	public Boolean getActivarid_empresaVacacionEmpleado() {
		return this.activarid_empresaVacacionEmpleado;
	}

	public void setActivarid_empresaVacacionEmpleado(Boolean activarid_empresaVacacionEmpleado) {
		this.activarid_empresaVacacionEmpleado= activarid_empresaVacacionEmpleado;
	}

	public Boolean getCargarid_empresaVacacionEmpleado() {
		return this.cargarid_empresaVacacionEmpleado;
	}

	public void setCargarid_empresaVacacionEmpleado(Boolean cargarid_empresaVacacionEmpleado) {
		this.cargarid_empresaVacacionEmpleado= cargarid_empresaVacacionEmpleado;
	}

	public Border setResaltarid_empleadoVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoVacacionEmpleado() {
		return this.resaltarid_empleadoVacacionEmpleado;
	}

	public void setResaltarid_empleadoVacacionEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoVacacionEmpleado() {
		return this.mostrarid_empleadoVacacionEmpleado;
	}

	public void setMostrarid_empleadoVacacionEmpleado(Boolean mostrarid_empleadoVacacionEmpleado) {
		this.mostrarid_empleadoVacacionEmpleado= mostrarid_empleadoVacacionEmpleado;
	}

	public Boolean getActivarid_empleadoVacacionEmpleado() {
		return this.activarid_empleadoVacacionEmpleado;
	}

	public void setActivarid_empleadoVacacionEmpleado(Boolean activarid_empleadoVacacionEmpleado) {
		this.activarid_empleadoVacacionEmpleado= activarid_empleadoVacacionEmpleado;
	}

	public Boolean getCargarid_empleadoVacacionEmpleado() {
		return this.cargarid_empleadoVacacionEmpleado;
	}

	public void setCargarid_empleadoVacacionEmpleado(Boolean cargarid_empleadoVacacionEmpleado) {
		this.cargarid_empleadoVacacionEmpleado= cargarid_empleadoVacacionEmpleado;
	}

	public Border setResaltarid_anio_periodo1VacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anio_periodo1VacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anio_periodo1VacacionEmpleado() {
		return this.resaltarid_anio_periodo1VacacionEmpleado;
	}

	public void setResaltarid_anio_periodo1VacacionEmpleado(Border borderResaltar) {
		this.resaltarid_anio_periodo1VacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anio_periodo1VacacionEmpleado() {
		return this.mostrarid_anio_periodo1VacacionEmpleado;
	}

	public void setMostrarid_anio_periodo1VacacionEmpleado(Boolean mostrarid_anio_periodo1VacacionEmpleado) {
		this.mostrarid_anio_periodo1VacacionEmpleado= mostrarid_anio_periodo1VacacionEmpleado;
	}

	public Boolean getActivarid_anio_periodo1VacacionEmpleado() {
		return this.activarid_anio_periodo1VacacionEmpleado;
	}

	public void setActivarid_anio_periodo1VacacionEmpleado(Boolean activarid_anio_periodo1VacacionEmpleado) {
		this.activarid_anio_periodo1VacacionEmpleado= activarid_anio_periodo1VacacionEmpleado;
	}

	public Boolean getCargarid_anio_periodo1VacacionEmpleado() {
		return this.cargarid_anio_periodo1VacacionEmpleado;
	}

	public void setCargarid_anio_periodo1VacacionEmpleado(Boolean cargarid_anio_periodo1VacacionEmpleado) {
		this.cargarid_anio_periodo1VacacionEmpleado= cargarid_anio_periodo1VacacionEmpleado;
	}

	public Border setResaltarid_anio_periodo2VacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anio_periodo2VacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anio_periodo2VacacionEmpleado() {
		return this.resaltarid_anio_periodo2VacacionEmpleado;
	}

	public void setResaltarid_anio_periodo2VacacionEmpleado(Border borderResaltar) {
		this.resaltarid_anio_periodo2VacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anio_periodo2VacacionEmpleado() {
		return this.mostrarid_anio_periodo2VacacionEmpleado;
	}

	public void setMostrarid_anio_periodo2VacacionEmpleado(Boolean mostrarid_anio_periodo2VacacionEmpleado) {
		this.mostrarid_anio_periodo2VacacionEmpleado= mostrarid_anio_periodo2VacacionEmpleado;
	}

	public Boolean getActivarid_anio_periodo2VacacionEmpleado() {
		return this.activarid_anio_periodo2VacacionEmpleado;
	}

	public void setActivarid_anio_periodo2VacacionEmpleado(Boolean activarid_anio_periodo2VacacionEmpleado) {
		this.activarid_anio_periodo2VacacionEmpleado= activarid_anio_periodo2VacacionEmpleado;
	}

	public Boolean getCargarid_anio_periodo2VacacionEmpleado() {
		return this.cargarid_anio_periodo2VacacionEmpleado;
	}

	public void setCargarid_anio_periodo2VacacionEmpleado(Boolean cargarid_anio_periodo2VacacionEmpleado) {
		this.cargarid_anio_periodo2VacacionEmpleado= cargarid_anio_periodo2VacacionEmpleado;
	}

	public Border setResaltarnumero_vecesVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_vecesVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_vecesVacacionEmpleado() {
		return this.resaltarnumero_vecesVacacionEmpleado;
	}

	public void setResaltarnumero_vecesVacacionEmpleado(Border borderResaltar) {
		this.resaltarnumero_vecesVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_vecesVacacionEmpleado() {
		return this.mostrarnumero_vecesVacacionEmpleado;
	}

	public void setMostrarnumero_vecesVacacionEmpleado(Boolean mostrarnumero_vecesVacacionEmpleado) {
		this.mostrarnumero_vecesVacacionEmpleado= mostrarnumero_vecesVacacionEmpleado;
	}

	public Boolean getActivarnumero_vecesVacacionEmpleado() {
		return this.activarnumero_vecesVacacionEmpleado;
	}

	public void setActivarnumero_vecesVacacionEmpleado(Boolean activarnumero_vecesVacacionEmpleado) {
		this.activarnumero_vecesVacacionEmpleado= activarnumero_vecesVacacionEmpleado;
	}

	public Border setResaltarfecha_estimadaVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_estimadaVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_estimadaVacacionEmpleado() {
		return this.resaltarfecha_estimadaVacacionEmpleado;
	}

	public void setResaltarfecha_estimadaVacacionEmpleado(Border borderResaltar) {
		this.resaltarfecha_estimadaVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_estimadaVacacionEmpleado() {
		return this.mostrarfecha_estimadaVacacionEmpleado;
	}

	public void setMostrarfecha_estimadaVacacionEmpleado(Boolean mostrarfecha_estimadaVacacionEmpleado) {
		this.mostrarfecha_estimadaVacacionEmpleado= mostrarfecha_estimadaVacacionEmpleado;
	}

	public Boolean getActivarfecha_estimadaVacacionEmpleado() {
		return this.activarfecha_estimadaVacacionEmpleado;
	}

	public void setActivarfecha_estimadaVacacionEmpleado(Boolean activarfecha_estimadaVacacionEmpleado) {
		this.activarfecha_estimadaVacacionEmpleado= activarfecha_estimadaVacacionEmpleado;
	}

	public Border setResaltarhoras_vacacionesVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarhoras_vacacionesVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_vacacionesVacacionEmpleado() {
		return this.resaltarhoras_vacacionesVacacionEmpleado;
	}

	public void setResaltarhoras_vacacionesVacacionEmpleado(Border borderResaltar) {
		this.resaltarhoras_vacacionesVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarhoras_vacacionesVacacionEmpleado() {
		return this.mostrarhoras_vacacionesVacacionEmpleado;
	}

	public void setMostrarhoras_vacacionesVacacionEmpleado(Boolean mostrarhoras_vacacionesVacacionEmpleado) {
		this.mostrarhoras_vacacionesVacacionEmpleado= mostrarhoras_vacacionesVacacionEmpleado;
	}

	public Boolean getActivarhoras_vacacionesVacacionEmpleado() {
		return this.activarhoras_vacacionesVacacionEmpleado;
	}

	public void setActivarhoras_vacacionesVacacionEmpleado(Boolean activarhoras_vacacionesVacacionEmpleado) {
		this.activarhoras_vacacionesVacacionEmpleado= activarhoras_vacacionesVacacionEmpleado;
	}

	public Border setResaltarhoras_tomadosVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarhoras_tomadosVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_tomadosVacacionEmpleado() {
		return this.resaltarhoras_tomadosVacacionEmpleado;
	}

	public void setResaltarhoras_tomadosVacacionEmpleado(Border borderResaltar) {
		this.resaltarhoras_tomadosVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarhoras_tomadosVacacionEmpleado() {
		return this.mostrarhoras_tomadosVacacionEmpleado;
	}

	public void setMostrarhoras_tomadosVacacionEmpleado(Boolean mostrarhoras_tomadosVacacionEmpleado) {
		this.mostrarhoras_tomadosVacacionEmpleado= mostrarhoras_tomadosVacacionEmpleado;
	}

	public Boolean getActivarhoras_tomadosVacacionEmpleado() {
		return this.activarhoras_tomadosVacacionEmpleado;
	}

	public void setActivarhoras_tomadosVacacionEmpleado(Boolean activarhoras_tomadosVacacionEmpleado) {
		this.activarhoras_tomadosVacacionEmpleado= activarhoras_tomadosVacacionEmpleado;
	}

	public Border setResaltarhoras_pagadosVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarhoras_pagadosVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_pagadosVacacionEmpleado() {
		return this.resaltarhoras_pagadosVacacionEmpleado;
	}

	public void setResaltarhoras_pagadosVacacionEmpleado(Border borderResaltar) {
		this.resaltarhoras_pagadosVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarhoras_pagadosVacacionEmpleado() {
		return this.mostrarhoras_pagadosVacacionEmpleado;
	}

	public void setMostrarhoras_pagadosVacacionEmpleado(Boolean mostrarhoras_pagadosVacacionEmpleado) {
		this.mostrarhoras_pagadosVacacionEmpleado= mostrarhoras_pagadosVacacionEmpleado;
	}

	public Boolean getActivarhoras_pagadosVacacionEmpleado() {
		return this.activarhoras_pagadosVacacionEmpleado;
	}

	public void setActivarhoras_pagadosVacacionEmpleado(Boolean activarhoras_pagadosVacacionEmpleado) {
		this.activarhoras_pagadosVacacionEmpleado= activarhoras_pagadosVacacionEmpleado;
	}

	public Border setResaltarhoras_adicionalesVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vacacionempleadoBeanSwingJInternalFrame.jTtoolBarVacacionEmpleado.setBorder(borderResaltar);
		
		this.resaltarhoras_adicionalesVacacionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_adicionalesVacacionEmpleado() {
		return this.resaltarhoras_adicionalesVacacionEmpleado;
	}

	public void setResaltarhoras_adicionalesVacacionEmpleado(Border borderResaltar) {
		this.resaltarhoras_adicionalesVacacionEmpleado= borderResaltar;
	}

	public Boolean getMostrarhoras_adicionalesVacacionEmpleado() {
		return this.mostrarhoras_adicionalesVacacionEmpleado;
	}

	public void setMostrarhoras_adicionalesVacacionEmpleado(Boolean mostrarhoras_adicionalesVacacionEmpleado) {
		this.mostrarhoras_adicionalesVacacionEmpleado= mostrarhoras_adicionalesVacacionEmpleado;
	}

	public Boolean getActivarhoras_adicionalesVacacionEmpleado() {
		return this.activarhoras_adicionalesVacacionEmpleado;
	}

	public void setActivarhoras_adicionalesVacacionEmpleado(Boolean activarhoras_adicionalesVacacionEmpleado) {
		this.activarhoras_adicionalesVacacionEmpleado= activarhoras_adicionalesVacacionEmpleado;
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
		
		
		this.setMostraridVacacionEmpleado(esInicial);
		this.setMostrarid_empresaVacacionEmpleado(esInicial);
		this.setMostrarid_empleadoVacacionEmpleado(esInicial);
		this.setMostrarid_anio_periodo1VacacionEmpleado(esInicial);
		this.setMostrarid_anio_periodo2VacacionEmpleado(esInicial);
		this.setMostrarnumero_vecesVacacionEmpleado(esInicial);
		this.setMostrarfecha_estimadaVacacionEmpleado(esInicial);
		this.setMostrarhoras_vacacionesVacacionEmpleado(esInicial);
		this.setMostrarhoras_tomadosVacacionEmpleado(esInicial);
		this.setMostrarhoras_pagadosVacacionEmpleado(esInicial);
		this.setMostrarhoras_adicionalesVacacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1)) {
				this.setMostrarid_anio_periodo1VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2)) {
				this.setMostrarid_anio_periodo2VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.NUMEROVECES)) {
				this.setMostrarnumero_vecesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.FECHAESTIMADA)) {
				this.setMostrarfecha_estimadaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASVACACIONES)) {
				this.setMostrarhoras_vacacionesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASTOMADOS)) {
				this.setMostrarhoras_tomadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASPAGADOS)) {
				this.setMostrarhoras_pagadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASADICIONALES)) {
				this.setMostrarhoras_adicionalesVacacionEmpleado(esAsigna);
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
		
		
		this.setActivaridVacacionEmpleado(esInicial);
		this.setActivarid_empresaVacacionEmpleado(esInicial);
		this.setActivarid_empleadoVacacionEmpleado(esInicial);
		this.setActivarid_anio_periodo1VacacionEmpleado(esInicial);
		this.setActivarid_anio_periodo2VacacionEmpleado(esInicial);
		this.setActivarnumero_vecesVacacionEmpleado(esInicial);
		this.setActivarfecha_estimadaVacacionEmpleado(esInicial);
		this.setActivarhoras_vacacionesVacacionEmpleado(esInicial);
		this.setActivarhoras_tomadosVacacionEmpleado(esInicial);
		this.setActivarhoras_pagadosVacacionEmpleado(esInicial);
		this.setActivarhoras_adicionalesVacacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1)) {
				this.setActivarid_anio_periodo1VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2)) {
				this.setActivarid_anio_periodo2VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.NUMEROVECES)) {
				this.setActivarnumero_vecesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.FECHAESTIMADA)) {
				this.setActivarfecha_estimadaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASVACACIONES)) {
				this.setActivarhoras_vacacionesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASTOMADOS)) {
				this.setActivarhoras_tomadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASPAGADOS)) {
				this.setActivarhoras_pagadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASADICIONALES)) {
				this.setActivarhoras_adicionalesVacacionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVacacionEmpleado(esInicial);
		this.setResaltarid_empresaVacacionEmpleado(esInicial);
		this.setResaltarid_empleadoVacacionEmpleado(esInicial);
		this.setResaltarid_anio_periodo1VacacionEmpleado(esInicial);
		this.setResaltarid_anio_periodo2VacacionEmpleado(esInicial);
		this.setResaltarnumero_vecesVacacionEmpleado(esInicial);
		this.setResaltarfecha_estimadaVacacionEmpleado(esInicial);
		this.setResaltarhoras_vacacionesVacacionEmpleado(esInicial);
		this.setResaltarhoras_tomadosVacacionEmpleado(esInicial);
		this.setResaltarhoras_pagadosVacacionEmpleado(esInicial);
		this.setResaltarhoras_adicionalesVacacionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1)) {
				this.setResaltarid_anio_periodo1VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2)) {
				this.setResaltarid_anio_periodo2VacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.NUMEROVECES)) {
				this.setResaltarnumero_vecesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.FECHAESTIMADA)) {
				this.setResaltarfecha_estimadaVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASVACACIONES)) {
				this.setResaltarhoras_vacacionesVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASTOMADOS)) {
				this.setResaltarhoras_tomadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASPAGADOS)) {
				this.setResaltarhoras_pagadosVacacionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(VacacionEmpleadoConstantesFunciones.HORASADICIONALES)) {
				this.setResaltarhoras_adicionalesVacacionEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioPeriodo1VacacionEmpleado=true;

	public Boolean getMostrarFK_IdAnioPeriodo1VacacionEmpleado() {
		return this.mostrarFK_IdAnioPeriodo1VacacionEmpleado;
	}

	public void setMostrarFK_IdAnioPeriodo1VacacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioPeriodo1VacacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAnioPeriodo2VacacionEmpleado=true;

	public Boolean getMostrarFK_IdAnioPeriodo2VacacionEmpleado() {
		return this.mostrarFK_IdAnioPeriodo2VacacionEmpleado;
	}

	public void setMostrarFK_IdAnioPeriodo2VacacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioPeriodo2VacacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoVacacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoVacacionEmpleado() {
		return this.mostrarFK_IdEmpleadoVacacionEmpleado;
	}

	public void setMostrarFK_IdEmpleadoVacacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoVacacionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVacacionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaVacacionEmpleado() {
		return this.mostrarFK_IdEmpresaVacacionEmpleado;
	}

	public void setMostrarFK_IdEmpresaVacacionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVacacionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioPeriodo1VacacionEmpleado=true;

	public Boolean getActivarFK_IdAnioPeriodo1VacacionEmpleado() {
		return this.activarFK_IdAnioPeriodo1VacacionEmpleado;
	}

	public void setActivarFK_IdAnioPeriodo1VacacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioPeriodo1VacacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdAnioPeriodo2VacacionEmpleado=true;

	public Boolean getActivarFK_IdAnioPeriodo2VacacionEmpleado() {
		return this.activarFK_IdAnioPeriodo2VacacionEmpleado;
	}

	public void setActivarFK_IdAnioPeriodo2VacacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioPeriodo2VacacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoVacacionEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoVacacionEmpleado() {
		return this.activarFK_IdEmpleadoVacacionEmpleado;
	}

	public void setActivarFK_IdEmpleadoVacacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoVacacionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVacacionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaVacacionEmpleado() {
		return this.activarFK_IdEmpresaVacacionEmpleado;
	}

	public void setActivarFK_IdEmpresaVacacionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVacacionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioPeriodo1VacacionEmpleado=null;

	public Border getResaltarFK_IdAnioPeriodo1VacacionEmpleado() {
		return this.resaltarFK_IdAnioPeriodo1VacacionEmpleado;
	}

	public void setResaltarFK_IdAnioPeriodo1VacacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioPeriodo1VacacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioPeriodo1VacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioPeriodo1VacacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdAnioPeriodo2VacacionEmpleado=null;

	public Border getResaltarFK_IdAnioPeriodo2VacacionEmpleado() {
		return this.resaltarFK_IdAnioPeriodo2VacacionEmpleado;
	}

	public void setResaltarFK_IdAnioPeriodo2VacacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioPeriodo2VacacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioPeriodo2VacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioPeriodo2VacacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoVacacionEmpleado=null;

	public Border getResaltarFK_IdEmpleadoVacacionEmpleado() {
		return this.resaltarFK_IdEmpleadoVacacionEmpleado;
	}

	public void setResaltarFK_IdEmpleadoVacacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoVacacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoVacacionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVacacionEmpleado=null;

	public Border getResaltarFK_IdEmpresaVacacionEmpleado() {
		return this.resaltarFK_IdEmpresaVacacionEmpleado;
	}

	public void setResaltarFK_IdEmpresaVacacionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVacacionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVacacionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*VacacionEmpleadoBeanSwingJInternalFrame vacacionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVacacionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}