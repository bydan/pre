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


import com.bydan.erp.nomina.util.TurnoConstantesFunciones;
import com.bydan.erp.nomina.util.TurnoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TurnoParameterGeneral;

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
final public class TurnoConstantesFunciones extends TurnoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Turno";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Turno"+TurnoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TurnoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TurnoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TurnoConstantesFunciones.SCHEMA+"_"+TurnoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TurnoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TurnoConstantesFunciones.SCHEMA+"_"+TurnoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TurnoConstantesFunciones.SCHEMA+"_"+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TurnoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TurnoConstantesFunciones.SCHEMA+"_"+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TurnoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TurnoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TurnoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TurnoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TurnoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TurnoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Turnos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Turno";
	public static final String SCLASSWEBTITULO_LOWER="Turno";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Turno";
	public static final String OBJECTNAME="turno";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="turno";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select turno from "+TurnoConstantesFunciones.SPERSISTENCENAME+" turno";
	public static String QUERYSELECTNATIVE="select "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".id,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".version_row,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".id_empresa,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_entrada,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_durante_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_durante_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso25,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida25,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso50,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida50,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso100,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida100,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso200,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida200 from "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME;//+" as "+TurnoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TurnoConstantesFuncionesAdditional turnoConstantesFuncionesAdditional=null;
	
	public TurnoConstantesFuncionesAdditional getTurnoConstantesFuncionesAdditional() {
		return this.turnoConstantesFuncionesAdditional;
	}
	
	public void setTurnoConstantesFuncionesAdditional(TurnoConstantesFuncionesAdditional turnoConstantesFuncionesAdditional) {
		try {
			this.turnoConstantesFuncionesAdditional=turnoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String HORAENTRADA= "hora_entrada";
    public static final String HORASALIDA= "hora_salida";
    public static final String HORAINGRESORECESO= "hora_ingreso_receso";
    public static final String HORASALIDARECESO= "hora_salida_receso";
    public static final String HORADURANTERECESO= "hora_durante_receso";
    public static final String HORAINGRESOALMUERZO= "hora_ingreso_almuerzo";
    public static final String HORASALIDAALMUERZO= "hora_salida_almuerzo";
    public static final String HORADURANTEALMUERZO= "hora_durante_almuerzo";
    public static final String HORAINGRESO25= "hora_ingreso25";
    public static final String HORASALIDA25= "hora_salida25";
    public static final String HORAINGRESO50= "hora_ingreso50";
    public static final String HORASALIDA50= "hora_salida50";
    public static final String HORAINGRESO100= "hora_ingreso100";
    public static final String HORASALIDA100= "hora_salida100";
    public static final String HORAINGRESO200= "hora_ingreso200";
    public static final String HORASALIDA200= "hora_salida200";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_HORAENTRADA= "Hora Entrada";
		public static final String LABEL_HORAENTRADA_LOWER= "Hora Entrada";
    	public static final String LABEL_HORASALIDA= "Hora Salida";
		public static final String LABEL_HORASALIDA_LOWER= "Hora Salida";
    	public static final String LABEL_HORAINGRESORECESO= "Hora Ingreso Receso";
		public static final String LABEL_HORAINGRESORECESO_LOWER= "Hora Ingreso Receso";
    	public static final String LABEL_HORASALIDARECESO= "Hora Salida Receso";
		public static final String LABEL_HORASALIDARECESO_LOWER= "Hora Salida Receso";
    	public static final String LABEL_HORADURANTERECESO= "Hora Durante Receso";
		public static final String LABEL_HORADURANTERECESO_LOWER= "Hora Durante Receso";
    	public static final String LABEL_HORAINGRESOALMUERZO= "Hora Ingreso Almuerzo";
		public static final String LABEL_HORAINGRESOALMUERZO_LOWER= "Hora Ingreso Almuerzo";
    	public static final String LABEL_HORASALIDAALMUERZO= "Hora Salida Almuerzo";
		public static final String LABEL_HORASALIDAALMUERZO_LOWER= "Hora Salida Almuerzo";
    	public static final String LABEL_HORADURANTEALMUERZO= "Hora Durante Almuerzo";
		public static final String LABEL_HORADURANTEALMUERZO_LOWER= "Hora Durante Almuerzo";
    	public static final String LABEL_HORAINGRESO25= "Hora Ingreso25";
		public static final String LABEL_HORAINGRESO25_LOWER= "Hora Ingreso25";
    	public static final String LABEL_HORASALIDA25= "Hora Salida25";
		public static final String LABEL_HORASALIDA25_LOWER= "Hora Salida25";
    	public static final String LABEL_HORAINGRESO50= "Hora Ingreso50";
		public static final String LABEL_HORAINGRESO50_LOWER= "Hora Ingreso50";
    	public static final String LABEL_HORASALIDA50= "Hora Salida50";
		public static final String LABEL_HORASALIDA50_LOWER= "Hora Salida50";
    	public static final String LABEL_HORAINGRESO100= "Hora Ingreso100";
		public static final String LABEL_HORAINGRESO100_LOWER= "Hora Ingreso100";
    	public static final String LABEL_HORASALIDA100= "Hora Salida100";
		public static final String LABEL_HORASALIDA100_LOWER= "Hora Salida100";
    	public static final String LABEL_HORAINGRESO200= "Hora Ingreso200";
		public static final String LABEL_HORAINGRESO200_LOWER= "Hora Ingreso200";
    	public static final String LABEL_HORASALIDA200= "Hora Salida200";
		public static final String LABEL_HORASALIDA200_LOWER= "Hora Salida200";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getTurnoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TurnoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TurnoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAENTRADA)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAENTRADA;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDA)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDA;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESORECESO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESORECESO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDARECESO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDARECESO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORADURANTERECESO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORADURANTERECESO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESOALMUERZO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESOALMUERZO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDAALMUERZO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDAALMUERZO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORADURANTEALMUERZO)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORADURANTEALMUERZO;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESO25)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESO25;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDA25)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDA25;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESO50)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESO50;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDA50)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDA50;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESO100)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESO100;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDA100)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDA100;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORAINGRESO200)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORAINGRESO200;}
		if(sNombreColumna.equals(TurnoConstantesFunciones.HORASALIDA200)) {sLabelColumna=TurnoConstantesFunciones.LABEL_HORASALIDA200;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTurnoDescripcion(Turno turno) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(turno !=null/* && turno.getId()!=0*/) {
			if(turno.getId()!=null) {
				sDescripcion=turno.getId().toString();
			}//turnoturno.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTurnoDescripcionDetallado(Turno turno) {
		String sDescripcion="";
			
		sDescripcion+=TurnoConstantesFunciones.ID+"=";
		sDescripcion+=turno.getId().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=turno.getVersionRow().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=turno.getid_empresa().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAENTRADA+"=";
		sDescripcion+=turno.gethora_entrada().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDA+"=";
		sDescripcion+=turno.gethora_salida().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESORECESO+"=";
		sDescripcion+=turno.gethora_ingreso_receso().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDARECESO+"=";
		sDescripcion+=turno.gethora_salida_receso().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORADURANTERECESO+"=";
		sDescripcion+=turno.gethora_durante_receso().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESOALMUERZO+"=";
		sDescripcion+=turno.gethora_ingreso_almuerzo().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDAALMUERZO+"=";
		sDescripcion+=turno.gethora_salida_almuerzo().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORADURANTEALMUERZO+"=";
		sDescripcion+=turno.gethora_durante_almuerzo().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESO25+"=";
		sDescripcion+=turno.gethora_ingreso25().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDA25+"=";
		sDescripcion+=turno.gethora_salida25().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESO50+"=";
		sDescripcion+=turno.gethora_ingreso50().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDA50+"=";
		sDescripcion+=turno.gethora_salida50().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESO100+"=";
		sDescripcion+=turno.gethora_ingreso100().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDA100+"=";
		sDescripcion+=turno.gethora_salida100().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORAINGRESO200+"=";
		sDescripcion+=turno.gethora_ingreso200().toString()+",";
		sDescripcion+=TurnoConstantesFunciones.HORASALIDA200+"=";
		sDescripcion+=turno.gethora_salida200().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTurnoDescripcion(Turno turno,String sValor) throws Exception {			
		if(turno !=null) {
			//turnoturno.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTurno(Turno turno,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTurnos(List<Turno> turnos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Turno turno: turnos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTurno(Turno turno,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && turno.getConCambioAuxiliar()) {
			turno.setIsDeleted(turno.getIsDeletedAuxiliar());	
			turno.setIsNew(turno.getIsNewAuxiliar());	
			turno.setIsChanged(turno.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			turno.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			turno.setIsDeletedAuxiliar(false);	
			turno.setIsNewAuxiliar(false);	
			turno.setIsChangedAuxiliar(false);
			
			turno.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTurnos(List<Turno> turnos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Turno turno : turnos) {
			if(conAsignarBase && turno.getConCambioAuxiliar()) {
				turno.setIsDeleted(turno.getIsDeletedAuxiliar());	
				turno.setIsNew(turno.getIsNewAuxiliar());	
				turno.setIsChanged(turno.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				turno.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				turno.setIsDeletedAuxiliar(false);	
				turno.setIsNewAuxiliar(false);	
				turno.setIsChangedAuxiliar(false);
				
				turno.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTurno(Turno turno,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTurnos(List<Turno> turnos,Boolean conEnteros) throws Exception  {
		
		for(Turno turno: turnos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTurno(List<Turno> turnos,Turno turnoAux) throws Exception  {
		TurnoConstantesFunciones.InicializarValoresTurno(turnoAux,true);
		
		for(Turno turno: turnos) {
			if(turno.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTurno(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TurnoConstantesFunciones.getArrayColumnasGlobalesTurno(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTurno(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TurnoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TurnoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTurno(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Turno> turnos,Turno turno,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Turno turnoAux: turnos) {
			if(turnoAux!=null && turno!=null) {
				if((turnoAux.getId()==null && turno.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(turnoAux.getId()!=null && turno.getId()!=null){
					if(turnoAux.getId().equals(turno.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTurno(List<Turno> turnos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Turno turno: turnos) {			
			if(turno.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTurno() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_ID, TurnoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_VERSIONROW, TurnoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_IDEMPRESA, TurnoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAENTRADA, TurnoConstantesFunciones.HORAENTRADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDA, TurnoConstantesFunciones.HORASALIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESORECESO, TurnoConstantesFunciones.HORAINGRESORECESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDARECESO, TurnoConstantesFunciones.HORASALIDARECESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORADURANTERECESO, TurnoConstantesFunciones.HORADURANTERECESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESOALMUERZO, TurnoConstantesFunciones.HORAINGRESOALMUERZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDAALMUERZO, TurnoConstantesFunciones.HORASALIDAALMUERZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORADURANTEALMUERZO, TurnoConstantesFunciones.HORADURANTEALMUERZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESO25, TurnoConstantesFunciones.HORAINGRESO25,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDA25, TurnoConstantesFunciones.HORASALIDA25,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESO50, TurnoConstantesFunciones.HORAINGRESO50,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDA50, TurnoConstantesFunciones.HORASALIDA50,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESO100, TurnoConstantesFunciones.HORAINGRESO100,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDA100, TurnoConstantesFunciones.HORASALIDA100,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORAINGRESO200, TurnoConstantesFunciones.HORAINGRESO200,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TurnoConstantesFunciones.LABEL_HORASALIDA200, TurnoConstantesFunciones.HORASALIDA200,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTurno() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAENTRADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESORECESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDARECESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORADURANTERECESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESOALMUERZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDAALMUERZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORADURANTEALMUERZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESO25;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDA25;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESO50;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDA50;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESO100;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDA100;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORAINGRESO200;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TurnoConstantesFunciones.HORASALIDA200;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurno() throws Exception  {
		return TurnoConstantesFunciones.getTiposSeleccionarTurno(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurno(Boolean conFk) throws Exception  {
		return TurnoConstantesFunciones.getTiposSeleccionarTurno(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTurno(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TurnoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAENTRADA);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAENTRADA);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDA);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDA);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESORECESO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESORECESO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDARECESO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDARECESO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORADURANTERECESO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORADURANTERECESO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESOALMUERZO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESOALMUERZO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDAALMUERZO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDAALMUERZO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORADURANTEALMUERZO);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORADURANTEALMUERZO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESO25);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESO25);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDA25);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDA25);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESO50);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESO50);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDA50);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDA50);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESO100);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESO100);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDA100);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDA100);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORAINGRESO200);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORAINGRESO200);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(TurnoConstantesFunciones.LABEL_HORASALIDA200);
		reporte.setsDescripcion(TurnoConstantesFunciones.LABEL_HORASALIDA200);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTurno(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTurno(Turno turnoAux) throws Exception {
		
			turnoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(turnoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTurno(List<Turno> turnosTemp) throws Exception {
		for(Turno turnoAux:turnosTemp) {
			
			turnoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(turnoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TurnoConstantesFunciones.getClassesRelationshipsOfTurno(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TurnoConstantesFunciones.getClassesRelationshipsFromStringsOfTurno(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Turno turno,List<Turno> turnos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Turno turnoEncontrado=null;
			
			for(Turno turnoLocal:turnos) {
				if(turnoLocal.getId().equals(turno.getId())) {
					turnoEncontrado=turnoLocal;
					
					turnoLocal.setIsChanged(turno.getIsChanged());
					turnoLocal.setIsNew(turno.getIsNew());
					turnoLocal.setIsDeleted(turno.getIsDeleted());
					
					turnoLocal.setGeneralEntityOriginal(turno.getGeneralEntityOriginal());
					
					turnoLocal.setId(turno.getId());	
					turnoLocal.setVersionRow(turno.getVersionRow());	
					turnoLocal.setid_empresa(turno.getid_empresa());	
					turnoLocal.sethora_entrada(turno.gethora_entrada());	
					turnoLocal.sethora_salida(turno.gethora_salida());	
					turnoLocal.sethora_ingreso_receso(turno.gethora_ingreso_receso());	
					turnoLocal.sethora_salida_receso(turno.gethora_salida_receso());	
					turnoLocal.sethora_durante_receso(turno.gethora_durante_receso());	
					turnoLocal.sethora_ingreso_almuerzo(turno.gethora_ingreso_almuerzo());	
					turnoLocal.sethora_salida_almuerzo(turno.gethora_salida_almuerzo());	
					turnoLocal.sethora_durante_almuerzo(turno.gethora_durante_almuerzo());	
					turnoLocal.sethora_ingreso25(turno.gethora_ingreso25());	
					turnoLocal.sethora_salida25(turno.gethora_salida25());	
					turnoLocal.sethora_ingreso50(turno.gethora_ingreso50());	
					turnoLocal.sethora_salida50(turno.gethora_salida50());	
					turnoLocal.sethora_ingreso100(turno.gethora_ingreso100());	
					turnoLocal.sethora_salida100(turno.gethora_salida100());	
					turnoLocal.sethora_ingreso200(turno.gethora_ingreso200());	
					turnoLocal.sethora_salida200(turno.gethora_salida200());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!turno.getIsDeleted()) {
				if(!existe) {
					turnos.add(turno);
				}
			} else {
				if(turnoEncontrado!=null && permiteQuitar)  {
					turnos.remove(turnoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Turno turno,List<Turno> turnos) throws Exception {
		try	{			
			for(Turno turnoLocal:turnos) {
				if(turnoLocal.getId().equals(turno.getId())) {
					turnoLocal.setIsSelected(turno.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTurno(List<Turno> turnosAux) throws Exception {
		//this.turnosAux=turnosAux;
		
		for(Turno turnoAux:turnosAux) {
			if(turnoAux.getIsChanged()) {
				turnoAux.setIsChanged(false);
			}		
			
			if(turnoAux.getIsNew()) {
				turnoAux.setIsNew(false);
			}	
			
			if(turnoAux.getIsDeleted()) {
				turnoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTurno(Turno turnoAux) throws Exception {
		//this.turnoAux=turnoAux;
		
			if(turnoAux.getIsChanged()) {
				turnoAux.setIsChanged(false);
			}		
			
			if(turnoAux.getIsNew()) {
				turnoAux.setIsNew(false);
			}	
			
			if(turnoAux.getIsDeleted()) {
				turnoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Turno turnoAsignar,Turno turno) throws Exception {
		turnoAsignar.setId(turno.getId());	
		turnoAsignar.setVersionRow(turno.getVersionRow());	
		turnoAsignar.setid_empresa(turno.getid_empresa());
		turnoAsignar.setempresa_descripcion(turno.getempresa_descripcion());	
		turnoAsignar.sethora_entrada(turno.gethora_entrada());	
		turnoAsignar.sethora_salida(turno.gethora_salida());	
		turnoAsignar.sethora_ingreso_receso(turno.gethora_ingreso_receso());	
		turnoAsignar.sethora_salida_receso(turno.gethora_salida_receso());	
		turnoAsignar.sethora_durante_receso(turno.gethora_durante_receso());	
		turnoAsignar.sethora_ingreso_almuerzo(turno.gethora_ingreso_almuerzo());	
		turnoAsignar.sethora_salida_almuerzo(turno.gethora_salida_almuerzo());	
		turnoAsignar.sethora_durante_almuerzo(turno.gethora_durante_almuerzo());	
		turnoAsignar.sethora_ingreso25(turno.gethora_ingreso25());	
		turnoAsignar.sethora_salida25(turno.gethora_salida25());	
		turnoAsignar.sethora_ingreso50(turno.gethora_ingreso50());	
		turnoAsignar.sethora_salida50(turno.gethora_salida50());	
		turnoAsignar.sethora_ingreso100(turno.gethora_ingreso100());	
		turnoAsignar.sethora_salida100(turno.gethora_salida100());	
		turnoAsignar.sethora_ingreso200(turno.gethora_ingreso200());	
		turnoAsignar.sethora_salida200(turno.gethora_salida200());	
	}
	
	public static void inicializarTurno(Turno turno) throws Exception {
		try {
				turno.setId(0L);	
					
				turno.setid_empresa(-1L);	
				turno.sethora_entrada(new Time((new Date()).getTime()));	
				turno.sethora_salida(new Time((new Date()).getTime()));	
				turno.sethora_ingreso_receso(new Time((new Date()).getTime()));	
				turno.sethora_salida_receso(new Time((new Date()).getTime()));	
				turno.sethora_durante_receso(new Time((new Date()).getTime()));	
				turno.sethora_ingreso_almuerzo(new Time((new Date()).getTime()));	
				turno.sethora_salida_almuerzo(new Time((new Date()).getTime()));	
				turno.sethora_durante_almuerzo(new Time((new Date()).getTime()));	
				turno.sethora_ingreso25(new Time((new Date()).getTime()));	
				turno.sethora_salida25(new Time((new Date()).getTime()));	
				turno.sethora_ingreso50(new Time((new Date()).getTime()));	
				turno.sethora_salida50(new Time((new Date()).getTime()));	
				turno.sethora_ingreso100(new Time((new Date()).getTime()));	
				turno.sethora_salida100(new Time((new Date()).getTime()));	
				turno.sethora_ingreso200(new Time((new Date()).getTime()));	
				turno.sethora_salida200(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTurno(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAENTRADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESORECESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDARECESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORADURANTERECESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESOALMUERZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDAALMUERZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORADURANTEALMUERZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESO25);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDA25);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESO50);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDA50);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESO100);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDA100);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORAINGRESO200);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TurnoConstantesFunciones.LABEL_HORASALIDA200);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTurno(String sTipo,Row row,Workbook workbook,Turno turno,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_entrada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso_receso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida_receso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_durante_receso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso_almuerzo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida_almuerzo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_durante_almuerzo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso25());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida25());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso50());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida50());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso100());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida100());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_ingreso200());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(turno.gethora_salida200());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTurno=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTurno() {
		return this.sFinalQueryTurno;
	}
	
	public void setsFinalQueryTurno(String sFinalQueryTurno) {
		this.sFinalQueryTurno= sFinalQueryTurno;
	}
	
	public Border resaltarSeleccionarTurno=null;
	
	public Border setResaltarSeleccionarTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTurno= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTurno() {
		return this.resaltarSeleccionarTurno;
	}
	
	public void setResaltarSeleccionarTurno(Border borderResaltarSeleccionarTurno) {
		this.resaltarSeleccionarTurno= borderResaltarSeleccionarTurno;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTurno=null;
	public Boolean mostraridTurno=true;
	public Boolean activaridTurno=true;

	public Border resaltarid_empresaTurno=null;
	public Boolean mostrarid_empresaTurno=true;
	public Boolean activarid_empresaTurno=true;
	public Boolean cargarid_empresaTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTurno=false;//ConEventDepend=true

	public Border resaltarhora_entradaTurno=null;
	public Boolean mostrarhora_entradaTurno=true;
	public Boolean activarhora_entradaTurno=true;

	public Border resaltarhora_salidaTurno=null;
	public Boolean mostrarhora_salidaTurno=true;
	public Boolean activarhora_salidaTurno=true;

	public Border resaltarhora_ingreso_recesoTurno=null;
	public Boolean mostrarhora_ingreso_recesoTurno=true;
	public Boolean activarhora_ingreso_recesoTurno=true;

	public Border resaltarhora_salida_recesoTurno=null;
	public Boolean mostrarhora_salida_recesoTurno=true;
	public Boolean activarhora_salida_recesoTurno=true;

	public Border resaltarhora_durante_recesoTurno=null;
	public Boolean mostrarhora_durante_recesoTurno=true;
	public Boolean activarhora_durante_recesoTurno=true;

	public Border resaltarhora_ingreso_almuerzoTurno=null;
	public Boolean mostrarhora_ingreso_almuerzoTurno=true;
	public Boolean activarhora_ingreso_almuerzoTurno=true;

	public Border resaltarhora_salida_almuerzoTurno=null;
	public Boolean mostrarhora_salida_almuerzoTurno=true;
	public Boolean activarhora_salida_almuerzoTurno=true;

	public Border resaltarhora_durante_almuerzoTurno=null;
	public Boolean mostrarhora_durante_almuerzoTurno=true;
	public Boolean activarhora_durante_almuerzoTurno=true;

	public Border resaltarhora_ingreso25Turno=null;
	public Boolean mostrarhora_ingreso25Turno=true;
	public Boolean activarhora_ingreso25Turno=true;

	public Border resaltarhora_salida25Turno=null;
	public Boolean mostrarhora_salida25Turno=true;
	public Boolean activarhora_salida25Turno=true;

	public Border resaltarhora_ingreso50Turno=null;
	public Boolean mostrarhora_ingreso50Turno=true;
	public Boolean activarhora_ingreso50Turno=true;

	public Border resaltarhora_salida50Turno=null;
	public Boolean mostrarhora_salida50Turno=true;
	public Boolean activarhora_salida50Turno=true;

	public Border resaltarhora_ingreso100Turno=null;
	public Boolean mostrarhora_ingreso100Turno=true;
	public Boolean activarhora_ingreso100Turno=true;

	public Border resaltarhora_salida100Turno=null;
	public Boolean mostrarhora_salida100Turno=true;
	public Boolean activarhora_salida100Turno=true;

	public Border resaltarhora_ingreso200Turno=null;
	public Boolean mostrarhora_ingreso200Turno=true;
	public Boolean activarhora_ingreso200Turno=true;

	public Border resaltarhora_salida200Turno=null;
	public Boolean mostrarhora_salida200Turno=true;
	public Boolean activarhora_salida200Turno=true;

	
	

	public Border setResaltaridTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltaridTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTurno() {
		return this.resaltaridTurno;
	}

	public void setResaltaridTurno(Border borderResaltar) {
		this.resaltaridTurno= borderResaltar;
	}

	public Boolean getMostraridTurno() {
		return this.mostraridTurno;
	}

	public void setMostraridTurno(Boolean mostraridTurno) {
		this.mostraridTurno= mostraridTurno;
	}

	public Boolean getActivaridTurno() {
		return this.activaridTurno;
	}

	public void setActivaridTurno(Boolean activaridTurno) {
		this.activaridTurno= activaridTurno;
	}

	public Border setResaltarid_empresaTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarid_empresaTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTurno() {
		return this.resaltarid_empresaTurno;
	}

	public void setResaltarid_empresaTurno(Border borderResaltar) {
		this.resaltarid_empresaTurno= borderResaltar;
	}

	public Boolean getMostrarid_empresaTurno() {
		return this.mostrarid_empresaTurno;
	}

	public void setMostrarid_empresaTurno(Boolean mostrarid_empresaTurno) {
		this.mostrarid_empresaTurno= mostrarid_empresaTurno;
	}

	public Boolean getActivarid_empresaTurno() {
		return this.activarid_empresaTurno;
	}

	public void setActivarid_empresaTurno(Boolean activarid_empresaTurno) {
		this.activarid_empresaTurno= activarid_empresaTurno;
	}

	public Boolean getCargarid_empresaTurno() {
		return this.cargarid_empresaTurno;
	}

	public void setCargarid_empresaTurno(Boolean cargarid_empresaTurno) {
		this.cargarid_empresaTurno= cargarid_empresaTurno;
	}

	public Border setResaltarhora_entradaTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_entradaTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_entradaTurno() {
		return this.resaltarhora_entradaTurno;
	}

	public void setResaltarhora_entradaTurno(Border borderResaltar) {
		this.resaltarhora_entradaTurno= borderResaltar;
	}

	public Boolean getMostrarhora_entradaTurno() {
		return this.mostrarhora_entradaTurno;
	}

	public void setMostrarhora_entradaTurno(Boolean mostrarhora_entradaTurno) {
		this.mostrarhora_entradaTurno= mostrarhora_entradaTurno;
	}

	public Boolean getActivarhora_entradaTurno() {
		return this.activarhora_entradaTurno;
	}

	public void setActivarhora_entradaTurno(Boolean activarhora_entradaTurno) {
		this.activarhora_entradaTurno= activarhora_entradaTurno;
	}

	public Border setResaltarhora_salidaTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salidaTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salidaTurno() {
		return this.resaltarhora_salidaTurno;
	}

	public void setResaltarhora_salidaTurno(Border borderResaltar) {
		this.resaltarhora_salidaTurno= borderResaltar;
	}

	public Boolean getMostrarhora_salidaTurno() {
		return this.mostrarhora_salidaTurno;
	}

	public void setMostrarhora_salidaTurno(Boolean mostrarhora_salidaTurno) {
		this.mostrarhora_salidaTurno= mostrarhora_salidaTurno;
	}

	public Boolean getActivarhora_salidaTurno() {
		return this.activarhora_salidaTurno;
	}

	public void setActivarhora_salidaTurno(Boolean activarhora_salidaTurno) {
		this.activarhora_salidaTurno= activarhora_salidaTurno;
	}

	public Border setResaltarhora_ingreso_recesoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso_recesoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso_recesoTurno() {
		return this.resaltarhora_ingreso_recesoTurno;
	}

	public void setResaltarhora_ingreso_recesoTurno(Border borderResaltar) {
		this.resaltarhora_ingreso_recesoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso_recesoTurno() {
		return this.mostrarhora_ingreso_recesoTurno;
	}

	public void setMostrarhora_ingreso_recesoTurno(Boolean mostrarhora_ingreso_recesoTurno) {
		this.mostrarhora_ingreso_recesoTurno= mostrarhora_ingreso_recesoTurno;
	}

	public Boolean getActivarhora_ingreso_recesoTurno() {
		return this.activarhora_ingreso_recesoTurno;
	}

	public void setActivarhora_ingreso_recesoTurno(Boolean activarhora_ingreso_recesoTurno) {
		this.activarhora_ingreso_recesoTurno= activarhora_ingreso_recesoTurno;
	}

	public Border setResaltarhora_salida_recesoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida_recesoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida_recesoTurno() {
		return this.resaltarhora_salida_recesoTurno;
	}

	public void setResaltarhora_salida_recesoTurno(Border borderResaltar) {
		this.resaltarhora_salida_recesoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_salida_recesoTurno() {
		return this.mostrarhora_salida_recesoTurno;
	}

	public void setMostrarhora_salida_recesoTurno(Boolean mostrarhora_salida_recesoTurno) {
		this.mostrarhora_salida_recesoTurno= mostrarhora_salida_recesoTurno;
	}

	public Boolean getActivarhora_salida_recesoTurno() {
		return this.activarhora_salida_recesoTurno;
	}

	public void setActivarhora_salida_recesoTurno(Boolean activarhora_salida_recesoTurno) {
		this.activarhora_salida_recesoTurno= activarhora_salida_recesoTurno;
	}

	public Border setResaltarhora_durante_recesoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_durante_recesoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_durante_recesoTurno() {
		return this.resaltarhora_durante_recesoTurno;
	}

	public void setResaltarhora_durante_recesoTurno(Border borderResaltar) {
		this.resaltarhora_durante_recesoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_durante_recesoTurno() {
		return this.mostrarhora_durante_recesoTurno;
	}

	public void setMostrarhora_durante_recesoTurno(Boolean mostrarhora_durante_recesoTurno) {
		this.mostrarhora_durante_recesoTurno= mostrarhora_durante_recesoTurno;
	}

	public Boolean getActivarhora_durante_recesoTurno() {
		return this.activarhora_durante_recesoTurno;
	}

	public void setActivarhora_durante_recesoTurno(Boolean activarhora_durante_recesoTurno) {
		this.activarhora_durante_recesoTurno= activarhora_durante_recesoTurno;
	}

	public Border setResaltarhora_ingreso_almuerzoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso_almuerzoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso_almuerzoTurno() {
		return this.resaltarhora_ingreso_almuerzoTurno;
	}

	public void setResaltarhora_ingreso_almuerzoTurno(Border borderResaltar) {
		this.resaltarhora_ingreso_almuerzoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso_almuerzoTurno() {
		return this.mostrarhora_ingreso_almuerzoTurno;
	}

	public void setMostrarhora_ingreso_almuerzoTurno(Boolean mostrarhora_ingreso_almuerzoTurno) {
		this.mostrarhora_ingreso_almuerzoTurno= mostrarhora_ingreso_almuerzoTurno;
	}

	public Boolean getActivarhora_ingreso_almuerzoTurno() {
		return this.activarhora_ingreso_almuerzoTurno;
	}

	public void setActivarhora_ingreso_almuerzoTurno(Boolean activarhora_ingreso_almuerzoTurno) {
		this.activarhora_ingreso_almuerzoTurno= activarhora_ingreso_almuerzoTurno;
	}

	public Border setResaltarhora_salida_almuerzoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida_almuerzoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida_almuerzoTurno() {
		return this.resaltarhora_salida_almuerzoTurno;
	}

	public void setResaltarhora_salida_almuerzoTurno(Border borderResaltar) {
		this.resaltarhora_salida_almuerzoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_salida_almuerzoTurno() {
		return this.mostrarhora_salida_almuerzoTurno;
	}

	public void setMostrarhora_salida_almuerzoTurno(Boolean mostrarhora_salida_almuerzoTurno) {
		this.mostrarhora_salida_almuerzoTurno= mostrarhora_salida_almuerzoTurno;
	}

	public Boolean getActivarhora_salida_almuerzoTurno() {
		return this.activarhora_salida_almuerzoTurno;
	}

	public void setActivarhora_salida_almuerzoTurno(Boolean activarhora_salida_almuerzoTurno) {
		this.activarhora_salida_almuerzoTurno= activarhora_salida_almuerzoTurno;
	}

	public Border setResaltarhora_durante_almuerzoTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_durante_almuerzoTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_durante_almuerzoTurno() {
		return this.resaltarhora_durante_almuerzoTurno;
	}

	public void setResaltarhora_durante_almuerzoTurno(Border borderResaltar) {
		this.resaltarhora_durante_almuerzoTurno= borderResaltar;
	}

	public Boolean getMostrarhora_durante_almuerzoTurno() {
		return this.mostrarhora_durante_almuerzoTurno;
	}

	public void setMostrarhora_durante_almuerzoTurno(Boolean mostrarhora_durante_almuerzoTurno) {
		this.mostrarhora_durante_almuerzoTurno= mostrarhora_durante_almuerzoTurno;
	}

	public Boolean getActivarhora_durante_almuerzoTurno() {
		return this.activarhora_durante_almuerzoTurno;
	}

	public void setActivarhora_durante_almuerzoTurno(Boolean activarhora_durante_almuerzoTurno) {
		this.activarhora_durante_almuerzoTurno= activarhora_durante_almuerzoTurno;
	}

	public Border setResaltarhora_ingreso25Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso25Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso25Turno() {
		return this.resaltarhora_ingreso25Turno;
	}

	public void setResaltarhora_ingreso25Turno(Border borderResaltar) {
		this.resaltarhora_ingreso25Turno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso25Turno() {
		return this.mostrarhora_ingreso25Turno;
	}

	public void setMostrarhora_ingreso25Turno(Boolean mostrarhora_ingreso25Turno) {
		this.mostrarhora_ingreso25Turno= mostrarhora_ingreso25Turno;
	}

	public Boolean getActivarhora_ingreso25Turno() {
		return this.activarhora_ingreso25Turno;
	}

	public void setActivarhora_ingreso25Turno(Boolean activarhora_ingreso25Turno) {
		this.activarhora_ingreso25Turno= activarhora_ingreso25Turno;
	}

	public Border setResaltarhora_salida25Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida25Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida25Turno() {
		return this.resaltarhora_salida25Turno;
	}

	public void setResaltarhora_salida25Turno(Border borderResaltar) {
		this.resaltarhora_salida25Turno= borderResaltar;
	}

	public Boolean getMostrarhora_salida25Turno() {
		return this.mostrarhora_salida25Turno;
	}

	public void setMostrarhora_salida25Turno(Boolean mostrarhora_salida25Turno) {
		this.mostrarhora_salida25Turno= mostrarhora_salida25Turno;
	}

	public Boolean getActivarhora_salida25Turno() {
		return this.activarhora_salida25Turno;
	}

	public void setActivarhora_salida25Turno(Boolean activarhora_salida25Turno) {
		this.activarhora_salida25Turno= activarhora_salida25Turno;
	}

	public Border setResaltarhora_ingreso50Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso50Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso50Turno() {
		return this.resaltarhora_ingreso50Turno;
	}

	public void setResaltarhora_ingreso50Turno(Border borderResaltar) {
		this.resaltarhora_ingreso50Turno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso50Turno() {
		return this.mostrarhora_ingreso50Turno;
	}

	public void setMostrarhora_ingreso50Turno(Boolean mostrarhora_ingreso50Turno) {
		this.mostrarhora_ingreso50Turno= mostrarhora_ingreso50Turno;
	}

	public Boolean getActivarhora_ingreso50Turno() {
		return this.activarhora_ingreso50Turno;
	}

	public void setActivarhora_ingreso50Turno(Boolean activarhora_ingreso50Turno) {
		this.activarhora_ingreso50Turno= activarhora_ingreso50Turno;
	}

	public Border setResaltarhora_salida50Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida50Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida50Turno() {
		return this.resaltarhora_salida50Turno;
	}

	public void setResaltarhora_salida50Turno(Border borderResaltar) {
		this.resaltarhora_salida50Turno= borderResaltar;
	}

	public Boolean getMostrarhora_salida50Turno() {
		return this.mostrarhora_salida50Turno;
	}

	public void setMostrarhora_salida50Turno(Boolean mostrarhora_salida50Turno) {
		this.mostrarhora_salida50Turno= mostrarhora_salida50Turno;
	}

	public Boolean getActivarhora_salida50Turno() {
		return this.activarhora_salida50Turno;
	}

	public void setActivarhora_salida50Turno(Boolean activarhora_salida50Turno) {
		this.activarhora_salida50Turno= activarhora_salida50Turno;
	}

	public Border setResaltarhora_ingreso100Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso100Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso100Turno() {
		return this.resaltarhora_ingreso100Turno;
	}

	public void setResaltarhora_ingreso100Turno(Border borderResaltar) {
		this.resaltarhora_ingreso100Turno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso100Turno() {
		return this.mostrarhora_ingreso100Turno;
	}

	public void setMostrarhora_ingreso100Turno(Boolean mostrarhora_ingreso100Turno) {
		this.mostrarhora_ingreso100Turno= mostrarhora_ingreso100Turno;
	}

	public Boolean getActivarhora_ingreso100Turno() {
		return this.activarhora_ingreso100Turno;
	}

	public void setActivarhora_ingreso100Turno(Boolean activarhora_ingreso100Turno) {
		this.activarhora_ingreso100Turno= activarhora_ingreso100Turno;
	}

	public Border setResaltarhora_salida100Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida100Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida100Turno() {
		return this.resaltarhora_salida100Turno;
	}

	public void setResaltarhora_salida100Turno(Border borderResaltar) {
		this.resaltarhora_salida100Turno= borderResaltar;
	}

	public Boolean getMostrarhora_salida100Turno() {
		return this.mostrarhora_salida100Turno;
	}

	public void setMostrarhora_salida100Turno(Boolean mostrarhora_salida100Turno) {
		this.mostrarhora_salida100Turno= mostrarhora_salida100Turno;
	}

	public Boolean getActivarhora_salida100Turno() {
		return this.activarhora_salida100Turno;
	}

	public void setActivarhora_salida100Turno(Boolean activarhora_salida100Turno) {
		this.activarhora_salida100Turno= activarhora_salida100Turno;
	}

	public Border setResaltarhora_ingreso200Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_ingreso200Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_ingreso200Turno() {
		return this.resaltarhora_ingreso200Turno;
	}

	public void setResaltarhora_ingreso200Turno(Border borderResaltar) {
		this.resaltarhora_ingreso200Turno= borderResaltar;
	}

	public Boolean getMostrarhora_ingreso200Turno() {
		return this.mostrarhora_ingreso200Turno;
	}

	public void setMostrarhora_ingreso200Turno(Boolean mostrarhora_ingreso200Turno) {
		this.mostrarhora_ingreso200Turno= mostrarhora_ingreso200Turno;
	}

	public Boolean getActivarhora_ingreso200Turno() {
		return this.activarhora_ingreso200Turno;
	}

	public void setActivarhora_ingreso200Turno(Boolean activarhora_ingreso200Turno) {
		this.activarhora_ingreso200Turno= activarhora_ingreso200Turno;
	}

	public Border setResaltarhora_salida200Turno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//turnoBeanSwingJInternalFrame.jTtoolBarTurno.setBorder(borderResaltar);
		
		this.resaltarhora_salida200Turno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_salida200Turno() {
		return this.resaltarhora_salida200Turno;
	}

	public void setResaltarhora_salida200Turno(Border borderResaltar) {
		this.resaltarhora_salida200Turno= borderResaltar;
	}

	public Boolean getMostrarhora_salida200Turno() {
		return this.mostrarhora_salida200Turno;
	}

	public void setMostrarhora_salida200Turno(Boolean mostrarhora_salida200Turno) {
		this.mostrarhora_salida200Turno= mostrarhora_salida200Turno;
	}

	public Boolean getActivarhora_salida200Turno() {
		return this.activarhora_salida200Turno;
	}

	public void setActivarhora_salida200Turno(Boolean activarhora_salida200Turno) {
		this.activarhora_salida200Turno= activarhora_salida200Turno;
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
		
		
		this.setMostraridTurno(esInicial);
		this.setMostrarid_empresaTurno(esInicial);
		this.setMostrarhora_entradaTurno(esInicial);
		this.setMostrarhora_salidaTurno(esInicial);
		this.setMostrarhora_ingreso_recesoTurno(esInicial);
		this.setMostrarhora_salida_recesoTurno(esInicial);
		this.setMostrarhora_durante_recesoTurno(esInicial);
		this.setMostrarhora_ingreso_almuerzoTurno(esInicial);
		this.setMostrarhora_salida_almuerzoTurno(esInicial);
		this.setMostrarhora_durante_almuerzoTurno(esInicial);
		this.setMostrarhora_ingreso25Turno(esInicial);
		this.setMostrarhora_salida25Turno(esInicial);
		this.setMostrarhora_ingreso50Turno(esInicial);
		this.setMostrarhora_salida50Turno(esInicial);
		this.setMostrarhora_ingreso100Turno(esInicial);
		this.setMostrarhora_salida100Turno(esInicial);
		this.setMostrarhora_ingreso200Turno(esInicial);
		this.setMostrarhora_salida200Turno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoConstantesFunciones.ID)) {
				this.setMostraridTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAENTRADA)) {
				this.setMostrarhora_entradaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA)) {
				this.setMostrarhora_salidaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESORECESO)) {
				this.setMostrarhora_ingreso_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDARECESO)) {
				this.setMostrarhora_salida_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTERECESO)) {
				this.setMostrarhora_durante_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESOALMUERZO)) {
				this.setMostrarhora_ingreso_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDAALMUERZO)) {
				this.setMostrarhora_salida_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTEALMUERZO)) {
				this.setMostrarhora_durante_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO25)) {
				this.setMostrarhora_ingreso25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA25)) {
				this.setMostrarhora_salida25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO50)) {
				this.setMostrarhora_ingreso50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA50)) {
				this.setMostrarhora_salida50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO100)) {
				this.setMostrarhora_ingreso100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA100)) {
				this.setMostrarhora_salida100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO200)) {
				this.setMostrarhora_ingreso200Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA200)) {
				this.setMostrarhora_salida200Turno(esAsigna);
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
		
		
		this.setActivaridTurno(esInicial);
		this.setActivarid_empresaTurno(esInicial);
		this.setActivarhora_entradaTurno(esInicial);
		this.setActivarhora_salidaTurno(esInicial);
		this.setActivarhora_ingreso_recesoTurno(esInicial);
		this.setActivarhora_salida_recesoTurno(esInicial);
		this.setActivarhora_durante_recesoTurno(esInicial);
		this.setActivarhora_ingreso_almuerzoTurno(esInicial);
		this.setActivarhora_salida_almuerzoTurno(esInicial);
		this.setActivarhora_durante_almuerzoTurno(esInicial);
		this.setActivarhora_ingreso25Turno(esInicial);
		this.setActivarhora_salida25Turno(esInicial);
		this.setActivarhora_ingreso50Turno(esInicial);
		this.setActivarhora_salida50Turno(esInicial);
		this.setActivarhora_ingreso100Turno(esInicial);
		this.setActivarhora_salida100Turno(esInicial);
		this.setActivarhora_ingreso200Turno(esInicial);
		this.setActivarhora_salida200Turno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoConstantesFunciones.ID)) {
				this.setActivaridTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAENTRADA)) {
				this.setActivarhora_entradaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA)) {
				this.setActivarhora_salidaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESORECESO)) {
				this.setActivarhora_ingreso_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDARECESO)) {
				this.setActivarhora_salida_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTERECESO)) {
				this.setActivarhora_durante_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESOALMUERZO)) {
				this.setActivarhora_ingreso_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDAALMUERZO)) {
				this.setActivarhora_salida_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTEALMUERZO)) {
				this.setActivarhora_durante_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO25)) {
				this.setActivarhora_ingreso25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA25)) {
				this.setActivarhora_salida25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO50)) {
				this.setActivarhora_ingreso50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA50)) {
				this.setActivarhora_salida50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO100)) {
				this.setActivarhora_ingreso100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA100)) {
				this.setActivarhora_salida100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO200)) {
				this.setActivarhora_ingreso200Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA200)) {
				this.setActivarhora_salida200Turno(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTurno(esInicial);
		this.setResaltarid_empresaTurno(esInicial);
		this.setResaltarhora_entradaTurno(esInicial);
		this.setResaltarhora_salidaTurno(esInicial);
		this.setResaltarhora_ingreso_recesoTurno(esInicial);
		this.setResaltarhora_salida_recesoTurno(esInicial);
		this.setResaltarhora_durante_recesoTurno(esInicial);
		this.setResaltarhora_ingreso_almuerzoTurno(esInicial);
		this.setResaltarhora_salida_almuerzoTurno(esInicial);
		this.setResaltarhora_durante_almuerzoTurno(esInicial);
		this.setResaltarhora_ingreso25Turno(esInicial);
		this.setResaltarhora_salida25Turno(esInicial);
		this.setResaltarhora_ingreso50Turno(esInicial);
		this.setResaltarhora_salida50Turno(esInicial);
		this.setResaltarhora_ingreso100Turno(esInicial);
		this.setResaltarhora_salida100Turno(esInicial);
		this.setResaltarhora_ingreso200Turno(esInicial);
		this.setResaltarhora_salida200Turno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TurnoConstantesFunciones.ID)) {
				this.setResaltaridTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAENTRADA)) {
				this.setResaltarhora_entradaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA)) {
				this.setResaltarhora_salidaTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESORECESO)) {
				this.setResaltarhora_ingreso_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDARECESO)) {
				this.setResaltarhora_salida_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTERECESO)) {
				this.setResaltarhora_durante_recesoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESOALMUERZO)) {
				this.setResaltarhora_ingreso_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDAALMUERZO)) {
				this.setResaltarhora_salida_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORADURANTEALMUERZO)) {
				this.setResaltarhora_durante_almuerzoTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO25)) {
				this.setResaltarhora_ingreso25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA25)) {
				this.setResaltarhora_salida25Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO50)) {
				this.setResaltarhora_ingreso50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA50)) {
				this.setResaltarhora_salida50Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO100)) {
				this.setResaltarhora_ingreso100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA100)) {
				this.setResaltarhora_salida100Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORAINGRESO200)) {
				this.setResaltarhora_ingreso200Turno(esAsigna);
				continue;
			}

			if(campo.clase.equals(TurnoConstantesFunciones.HORASALIDA200)) {
				this.setResaltarhora_salida200Turno(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTurno=true;

	public Boolean getMostrarFK_IdEmpresaTurno() {
		return this.mostrarFK_IdEmpresaTurno;
	}

	public void setMostrarFK_IdEmpresaTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTurno= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTurno=true;

	public Boolean getActivarFK_IdEmpresaTurno() {
		return this.activarFK_IdEmpresaTurno;
	}

	public void setActivarFK_IdEmpresaTurno(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTurno= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTurno=null;

	public Border getResaltarFK_IdEmpresaTurno() {
		return this.resaltarFK_IdEmpresaTurno;
	}

	public void setResaltarFK_IdEmpresaTurno(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTurno= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTurno(ParametroGeneralUsuario parametroGeneralUsuario/*TurnoBeanSwingJInternalFrame turnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTurno= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}