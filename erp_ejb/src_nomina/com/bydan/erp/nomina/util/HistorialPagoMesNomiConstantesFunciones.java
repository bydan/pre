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


import com.bydan.erp.nomina.util.HistorialPagoMesNomiConstantesFunciones;
import com.bydan.erp.nomina.util.HistorialPagoMesNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HistorialPagoMesNomiParameterGeneral;

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
final public class HistorialPagoMesNomiConstantesFunciones extends HistorialPagoMesNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialPagoMesNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialPagoMesNomi"+HistorialPagoMesNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialPagoMesNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialPagoMesNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialPagoMesNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialPagoMesNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialPagoMesNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialPagoMesNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialPagoMesNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialPagoMesNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialPagoMesNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialPagoMesNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoMesNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialPagoMesNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialPagoMesNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialPagoMesNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialPagoMesNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Pago Mes Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Historial Pago Mes Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Historial Pago Mes Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialPagoMesNomi";
	public static final String OBJECTNAME="historialpagomesnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="historial_pago_mes_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialpagomesnomi from "+HistorialPagoMesNomiConstantesFunciones.SPERSISTENCENAME+" historialpagomesnomi";
	public static String QUERYSELECTNATIVE="select "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".version_row,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_empresa,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_empleado,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_rubro_emplea,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_anio,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_mes,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".valor from "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoMesNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HistorialPagoMesNomiConstantesFuncionesAdditional historialpagomesnomiConstantesFuncionesAdditional=null;
	
	public HistorialPagoMesNomiConstantesFuncionesAdditional getHistorialPagoMesNomiConstantesFuncionesAdditional() {
		return this.historialpagomesnomiConstantesFuncionesAdditional;
	}
	
	public void setHistorialPagoMesNomiConstantesFuncionesAdditional(HistorialPagoMesNomiConstantesFuncionesAdditional historialpagomesnomiConstantesFuncionesAdditional) {
		try {
			this.historialpagomesnomiConstantesFuncionesAdditional=historialpagomesnomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
	
	public static String getHistorialPagoMesNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.IDANIO)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.IDMES)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(HistorialPagoMesNomiConstantesFunciones.VALOR)) {sLabelColumna=HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getHistorialPagoMesNomiDescripcion(HistorialPagoMesNomi historialpagomesnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialpagomesnomi !=null/* && historialpagomesnomi.getId()!=0*/) {
			if(historialpagomesnomi.getId()!=null) {
				sDescripcion=historialpagomesnomi.getId().toString();
			}//historialpagomesnomihistorialpagomesnomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialPagoMesNomiDescripcionDetallado(HistorialPagoMesNomi historialpagomesnomi) {
		String sDescripcion="";
			
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.ID+"=";
		sDescripcion+=historialpagomesnomi.getId().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialpagomesnomi.getVersionRow().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=historialpagomesnomi.getid_empresa().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=historialpagomesnomi.getid_empleado().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=historialpagomesnomi.getid_rubro_emplea().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.IDANIO+"=";
		sDescripcion+=historialpagomesnomi.getid_anio().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.IDMES+"=";
		sDescripcion+=historialpagomesnomi.getid_mes().toString()+",";
		sDescripcion+=HistorialPagoMesNomiConstantesFunciones.VALOR+"=";
		sDescripcion+=historialpagomesnomi.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialPagoMesNomiDescripcion(HistorialPagoMesNomi historialpagomesnomi,String sValor) throws Exception {			
		if(historialpagomesnomi !=null) {
			//historialpagomesnomihistorialpagomesnomi.getId().toString();
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialPagoMesNomi historialpagomesnomi: historialpagomesnomis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialpagomesnomi.getConCambioAuxiliar()) {
			historialpagomesnomi.setIsDeleted(historialpagomesnomi.getIsDeletedAuxiliar());	
			historialpagomesnomi.setIsNew(historialpagomesnomi.getIsNewAuxiliar());	
			historialpagomesnomi.setIsChanged(historialpagomesnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialpagomesnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialpagomesnomi.setIsDeletedAuxiliar(false);	
			historialpagomesnomi.setIsNewAuxiliar(false);	
			historialpagomesnomi.setIsChangedAuxiliar(false);
			
			historialpagomesnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialPagoMesNomi historialpagomesnomi : historialpagomesnomis) {
			if(conAsignarBase && historialpagomesnomi.getConCambioAuxiliar()) {
				historialpagomesnomi.setIsDeleted(historialpagomesnomi.getIsDeletedAuxiliar());	
				historialpagomesnomi.setIsNew(historialpagomesnomi.getIsNewAuxiliar());	
				historialpagomesnomi.setIsChanged(historialpagomesnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialpagomesnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialpagomesnomi.setIsDeletedAuxiliar(false);	
				historialpagomesnomi.setIsNewAuxiliar(false);	
				historialpagomesnomi.setIsChangedAuxiliar(false);
				
				historialpagomesnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi,Boolean conEnteros) throws Exception  {
		historialpagomesnomi.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis,Boolean conEnteros) throws Exception  {
		
		for(HistorialPagoMesNomi historialpagomesnomi: historialpagomesnomis) {
			historialpagomesnomi.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialPagoMesNomi(List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomi historialpagomesnomiAux) throws Exception  {
		HistorialPagoMesNomiConstantesFunciones.InicializarValoresHistorialPagoMesNomi(historialpagomesnomiAux,true);
		
		for(HistorialPagoMesNomi historialpagomesnomi: historialpagomesnomis) {
			if(historialpagomesnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			historialpagomesnomiAux.setvalor(historialpagomesnomiAux.getvalor()+historialpagomesnomi.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialPagoMesNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialPagoMesNomiConstantesFunciones.getArrayColumnasGlobalesHistorialPagoMesNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialPagoMesNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialPagoMesNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomi historialpagomesnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialPagoMesNomi historialpagomesnomiAux: historialpagomesnomis) {
			if(historialpagomesnomiAux!=null && historialpagomesnomi!=null) {
				if((historialpagomesnomiAux.getId()==null && historialpagomesnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialpagomesnomiAux.getId()!=null && historialpagomesnomi.getId()!=null){
					if(historialpagomesnomiAux.getId().equals(historialpagomesnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialPagoMesNomi(List<HistorialPagoMesNomi> historialpagomesnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(HistorialPagoMesNomi historialpagomesnomi: historialpagomesnomis) {			
			if(historialpagomesnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=historialpagomesnomi.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialPagoMesNomiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialPagoMesNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_ID, HistorialPagoMesNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_VERSIONROW, HistorialPagoMesNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPRESA, HistorialPagoMesNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPLEADO, HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_IDRUBROEMPLEA, HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_IDANIO, HistorialPagoMesNomiConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_IDMES, HistorialPagoMesNomiConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR, HistorialPagoMesNomiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialPagoMesNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoMesNomiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoMesNomi() throws Exception  {
		return HistorialPagoMesNomiConstantesFunciones.getTiposSeleccionarHistorialPagoMesNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoMesNomi(Boolean conFk) throws Exception  {
		return HistorialPagoMesNomiConstantesFunciones.getTiposSeleccionarHistorialPagoMesNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoMesNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialPagoMesNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomiAux) throws Exception {
		
			historialpagomesnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialpagomesnomiAux.getEmpresa()));
			historialpagomesnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(historialpagomesnomiAux.getEmpleado()));
			historialpagomesnomiAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(historialpagomesnomiAux.getRubroEmplea()));
			historialpagomesnomiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(historialpagomesnomiAux.getAnio()));
			historialpagomesnomiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialpagomesnomiAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialPagoMesNomi(List<HistorialPagoMesNomi> historialpagomesnomisTemp) throws Exception {
		for(HistorialPagoMesNomi historialpagomesnomiAux:historialpagomesnomisTemp) {
			
			historialpagomesnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialpagomesnomiAux.getEmpresa()));
			historialpagomesnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(historialpagomesnomiAux.getEmpleado()));
			historialpagomesnomiAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(historialpagomesnomiAux.getRubroEmplea()));
			historialpagomesnomiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(historialpagomesnomiAux.getAnio()));
			historialpagomesnomiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialpagomesnomiAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialPagoMesNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialPagoMesNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoMesNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialPagoMesNomiConstantesFunciones.getClassesRelationshipsOfHistorialPagoMesNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoMesNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialPagoMesNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialPagoMesNomiConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialPagoMesNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialPagoMesNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HistorialPagoMesNomi historialpagomesnomi,List<HistorialPagoMesNomi> historialpagomesnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HistorialPagoMesNomi historialpagomesnomiEncontrado=null;
			
			for(HistorialPagoMesNomi historialpagomesnomiLocal:historialpagomesnomis) {
				if(historialpagomesnomiLocal.getId().equals(historialpagomesnomi.getId())) {
					historialpagomesnomiEncontrado=historialpagomesnomiLocal;
					
					historialpagomesnomiLocal.setIsChanged(historialpagomesnomi.getIsChanged());
					historialpagomesnomiLocal.setIsNew(historialpagomesnomi.getIsNew());
					historialpagomesnomiLocal.setIsDeleted(historialpagomesnomi.getIsDeleted());
					
					historialpagomesnomiLocal.setGeneralEntityOriginal(historialpagomesnomi.getGeneralEntityOriginal());
					
					historialpagomesnomiLocal.setId(historialpagomesnomi.getId());	
					historialpagomesnomiLocal.setVersionRow(historialpagomesnomi.getVersionRow());	
					historialpagomesnomiLocal.setid_empresa(historialpagomesnomi.getid_empresa());	
					historialpagomesnomiLocal.setid_empleado(historialpagomesnomi.getid_empleado());	
					historialpagomesnomiLocal.setid_rubro_emplea(historialpagomesnomi.getid_rubro_emplea());	
					historialpagomesnomiLocal.setid_anio(historialpagomesnomi.getid_anio());	
					historialpagomesnomiLocal.setid_mes(historialpagomesnomi.getid_mes());	
					historialpagomesnomiLocal.setvalor(historialpagomesnomi.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!historialpagomesnomi.getIsDeleted()) {
				if(!existe) {
					historialpagomesnomis.add(historialpagomesnomi);
				}
			} else {
				if(historialpagomesnomiEncontrado!=null && permiteQuitar)  {
					historialpagomesnomis.remove(historialpagomesnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HistorialPagoMesNomi historialpagomesnomi,List<HistorialPagoMesNomi> historialpagomesnomis) throws Exception {
		try	{			
			for(HistorialPagoMesNomi historialpagomesnomiLocal:historialpagomesnomis) {
				if(historialpagomesnomiLocal.getId().equals(historialpagomesnomi.getId())) {
					historialpagomesnomiLocal.setIsSelected(historialpagomesnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialPagoMesNomi(List<HistorialPagoMesNomi> historialpagomesnomisAux) throws Exception {
		//this.historialpagomesnomisAux=historialpagomesnomisAux;
		
		for(HistorialPagoMesNomi historialpagomesnomiAux:historialpagomesnomisAux) {
			if(historialpagomesnomiAux.getIsChanged()) {
				historialpagomesnomiAux.setIsChanged(false);
			}		
			
			if(historialpagomesnomiAux.getIsNew()) {
				historialpagomesnomiAux.setIsNew(false);
			}	
			
			if(historialpagomesnomiAux.getIsDeleted()) {
				historialpagomesnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomiAux) throws Exception {
		//this.historialpagomesnomiAux=historialpagomesnomiAux;
		
			if(historialpagomesnomiAux.getIsChanged()) {
				historialpagomesnomiAux.setIsChanged(false);
			}		
			
			if(historialpagomesnomiAux.getIsNew()) {
				historialpagomesnomiAux.setIsNew(false);
			}	
			
			if(historialpagomesnomiAux.getIsDeleted()) {
				historialpagomesnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialPagoMesNomi historialpagomesnomiAsignar,HistorialPagoMesNomi historialpagomesnomi) throws Exception {
		historialpagomesnomiAsignar.setId(historialpagomesnomi.getId());	
		historialpagomesnomiAsignar.setVersionRow(historialpagomesnomi.getVersionRow());	
		historialpagomesnomiAsignar.setid_empresa(historialpagomesnomi.getid_empresa());
		historialpagomesnomiAsignar.setempresa_descripcion(historialpagomesnomi.getempresa_descripcion());	
		historialpagomesnomiAsignar.setid_empleado(historialpagomesnomi.getid_empleado());
		historialpagomesnomiAsignar.setempleado_descripcion(historialpagomesnomi.getempleado_descripcion());	
		historialpagomesnomiAsignar.setid_rubro_emplea(historialpagomesnomi.getid_rubro_emplea());
		historialpagomesnomiAsignar.setrubroemplea_descripcion(historialpagomesnomi.getrubroemplea_descripcion());	
		historialpagomesnomiAsignar.setid_anio(historialpagomesnomi.getid_anio());
		historialpagomesnomiAsignar.setanio_descripcion(historialpagomesnomi.getanio_descripcion());	
		historialpagomesnomiAsignar.setid_mes(historialpagomesnomi.getid_mes());
		historialpagomesnomiAsignar.setmes_descripcion(historialpagomesnomi.getmes_descripcion());	
		historialpagomesnomiAsignar.setvalor(historialpagomesnomi.getvalor());	
	}
	
	public static void inicializarHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi) throws Exception {
		try {
				historialpagomesnomi.setId(0L);	
					
				historialpagomesnomi.setid_empresa(-1L);	
				historialpagomesnomi.setid_empleado(-1L);	
				historialpagomesnomi.setid_rubro_emplea(-1L);	
				historialpagomesnomi.setid_anio(null);	
				historialpagomesnomi.setid_mes(null);	
				historialpagomesnomi.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialPagoMesNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoMesNomiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialPagoMesNomi(String sTipo,Row row,Workbook workbook,HistorialPagoMesNomi historialpagomesnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagomesnomi.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialPagoMesNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHistorialPagoMesNomi() {
		return this.sFinalQueryHistorialPagoMesNomi;
	}
	
	public void setsFinalQueryHistorialPagoMesNomi(String sFinalQueryHistorialPagoMesNomi) {
		this.sFinalQueryHistorialPagoMesNomi= sFinalQueryHistorialPagoMesNomi;
	}
	
	public Border resaltarSeleccionarHistorialPagoMesNomi=null;
	
	public Border setResaltarSeleccionarHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialPagoMesNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialPagoMesNomi() {
		return this.resaltarSeleccionarHistorialPagoMesNomi;
	}
	
	public void setResaltarSeleccionarHistorialPagoMesNomi(Border borderResaltarSeleccionarHistorialPagoMesNomi) {
		this.resaltarSeleccionarHistorialPagoMesNomi= borderResaltarSeleccionarHistorialPagoMesNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialPagoMesNomi=null;
	public Boolean mostraridHistorialPagoMesNomi=true;
	public Boolean activaridHistorialPagoMesNomi=true;

	public Border resaltarid_empresaHistorialPagoMesNomi=null;
	public Boolean mostrarid_empresaHistorialPagoMesNomi=true;
	public Boolean activarid_empresaHistorialPagoMesNomi=true;
	public Boolean cargarid_empresaHistorialPagoMesNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHistorialPagoMesNomi=false;//ConEventDepend=true

	public Border resaltarid_empleadoHistorialPagoMesNomi=null;
	public Boolean mostrarid_empleadoHistorialPagoMesNomi=true;
	public Boolean activarid_empleadoHistorialPagoMesNomi=true;
	public Boolean cargarid_empleadoHistorialPagoMesNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoHistorialPagoMesNomi=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaHistorialPagoMesNomi=null;
	public Boolean mostrarid_rubro_empleaHistorialPagoMesNomi=true;
	public Boolean activarid_rubro_empleaHistorialPagoMesNomi=true;
	public Boolean cargarid_rubro_empleaHistorialPagoMesNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaHistorialPagoMesNomi=false;//ConEventDepend=true

	public Border resaltarid_anioHistorialPagoMesNomi=null;
	public Boolean mostrarid_anioHistorialPagoMesNomi=true;
	public Boolean activarid_anioHistorialPagoMesNomi=true;
	public Boolean cargarid_anioHistorialPagoMesNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioHistorialPagoMesNomi=false;//ConEventDepend=true

	public Border resaltarid_mesHistorialPagoMesNomi=null;
	public Boolean mostrarid_mesHistorialPagoMesNomi=true;
	public Boolean activarid_mesHistorialPagoMesNomi=true;
	public Boolean cargarid_mesHistorialPagoMesNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesHistorialPagoMesNomi=false;//ConEventDepend=true

	public Border resaltarvalorHistorialPagoMesNomi=null;
	public Boolean mostrarvalorHistorialPagoMesNomi=true;
	public Boolean activarvalorHistorialPagoMesNomi=true;

	
	

	public Border setResaltaridHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltaridHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialPagoMesNomi() {
		return this.resaltaridHistorialPagoMesNomi;
	}

	public void setResaltaridHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltaridHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostraridHistorialPagoMesNomi() {
		return this.mostraridHistorialPagoMesNomi;
	}

	public void setMostraridHistorialPagoMesNomi(Boolean mostraridHistorialPagoMesNomi) {
		this.mostraridHistorialPagoMesNomi= mostraridHistorialPagoMesNomi;
	}

	public Boolean getActivaridHistorialPagoMesNomi() {
		return this.activaridHistorialPagoMesNomi;
	}

	public void setActivaridHistorialPagoMesNomi(Boolean activaridHistorialPagoMesNomi) {
		this.activaridHistorialPagoMesNomi= activaridHistorialPagoMesNomi;
	}

	public Border setResaltarid_empresaHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHistorialPagoMesNomi() {
		return this.resaltarid_empresaHistorialPagoMesNomi;
	}

	public void setResaltarid_empresaHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarid_empresaHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaHistorialPagoMesNomi() {
		return this.mostrarid_empresaHistorialPagoMesNomi;
	}

	public void setMostrarid_empresaHistorialPagoMesNomi(Boolean mostrarid_empresaHistorialPagoMesNomi) {
		this.mostrarid_empresaHistorialPagoMesNomi= mostrarid_empresaHistorialPagoMesNomi;
	}

	public Boolean getActivarid_empresaHistorialPagoMesNomi() {
		return this.activarid_empresaHistorialPagoMesNomi;
	}

	public void setActivarid_empresaHistorialPagoMesNomi(Boolean activarid_empresaHistorialPagoMesNomi) {
		this.activarid_empresaHistorialPagoMesNomi= activarid_empresaHistorialPagoMesNomi;
	}

	public Boolean getCargarid_empresaHistorialPagoMesNomi() {
		return this.cargarid_empresaHistorialPagoMesNomi;
	}

	public void setCargarid_empresaHistorialPagoMesNomi(Boolean cargarid_empresaHistorialPagoMesNomi) {
		this.cargarid_empresaHistorialPagoMesNomi= cargarid_empresaHistorialPagoMesNomi;
	}

	public Border setResaltarid_empleadoHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleadoHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoHistorialPagoMesNomi() {
		return this.resaltarid_empleadoHistorialPagoMesNomi;
	}

	public void setResaltarid_empleadoHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarid_empleadoHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleadoHistorialPagoMesNomi() {
		return this.mostrarid_empleadoHistorialPagoMesNomi;
	}

	public void setMostrarid_empleadoHistorialPagoMesNomi(Boolean mostrarid_empleadoHistorialPagoMesNomi) {
		this.mostrarid_empleadoHistorialPagoMesNomi= mostrarid_empleadoHistorialPagoMesNomi;
	}

	public Boolean getActivarid_empleadoHistorialPagoMesNomi() {
		return this.activarid_empleadoHistorialPagoMesNomi;
	}

	public void setActivarid_empleadoHistorialPagoMesNomi(Boolean activarid_empleadoHistorialPagoMesNomi) {
		this.activarid_empleadoHistorialPagoMesNomi= activarid_empleadoHistorialPagoMesNomi;
	}

	public Boolean getCargarid_empleadoHistorialPagoMesNomi() {
		return this.cargarid_empleadoHistorialPagoMesNomi;
	}

	public void setCargarid_empleadoHistorialPagoMesNomi(Boolean cargarid_empleadoHistorialPagoMesNomi) {
		this.cargarid_empleadoHistorialPagoMesNomi= cargarid_empleadoHistorialPagoMesNomi;
	}

	public Border setResaltarid_rubro_empleaHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaHistorialPagoMesNomi() {
		return this.resaltarid_rubro_empleaHistorialPagoMesNomi;
	}

	public void setResaltarid_rubro_empleaHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarid_rubro_empleaHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaHistorialPagoMesNomi() {
		return this.mostrarid_rubro_empleaHistorialPagoMesNomi;
	}

	public void setMostrarid_rubro_empleaHistorialPagoMesNomi(Boolean mostrarid_rubro_empleaHistorialPagoMesNomi) {
		this.mostrarid_rubro_empleaHistorialPagoMesNomi= mostrarid_rubro_empleaHistorialPagoMesNomi;
	}

	public Boolean getActivarid_rubro_empleaHistorialPagoMesNomi() {
		return this.activarid_rubro_empleaHistorialPagoMesNomi;
	}

	public void setActivarid_rubro_empleaHistorialPagoMesNomi(Boolean activarid_rubro_empleaHistorialPagoMesNomi) {
		this.activarid_rubro_empleaHistorialPagoMesNomi= activarid_rubro_empleaHistorialPagoMesNomi;
	}

	public Boolean getCargarid_rubro_empleaHistorialPagoMesNomi() {
		return this.cargarid_rubro_empleaHistorialPagoMesNomi;
	}

	public void setCargarid_rubro_empleaHistorialPagoMesNomi(Boolean cargarid_rubro_empleaHistorialPagoMesNomi) {
		this.cargarid_rubro_empleaHistorialPagoMesNomi= cargarid_rubro_empleaHistorialPagoMesNomi;
	}

	public Border setResaltarid_anioHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarid_anioHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioHistorialPagoMesNomi() {
		return this.resaltarid_anioHistorialPagoMesNomi;
	}

	public void setResaltarid_anioHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarid_anioHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarid_anioHistorialPagoMesNomi() {
		return this.mostrarid_anioHistorialPagoMesNomi;
	}

	public void setMostrarid_anioHistorialPagoMesNomi(Boolean mostrarid_anioHistorialPagoMesNomi) {
		this.mostrarid_anioHistorialPagoMesNomi= mostrarid_anioHistorialPagoMesNomi;
	}

	public Boolean getActivarid_anioHistorialPagoMesNomi() {
		return this.activarid_anioHistorialPagoMesNomi;
	}

	public void setActivarid_anioHistorialPagoMesNomi(Boolean activarid_anioHistorialPagoMesNomi) {
		this.activarid_anioHistorialPagoMesNomi= activarid_anioHistorialPagoMesNomi;
	}

	public Boolean getCargarid_anioHistorialPagoMesNomi() {
		return this.cargarid_anioHistorialPagoMesNomi;
	}

	public void setCargarid_anioHistorialPagoMesNomi(Boolean cargarid_anioHistorialPagoMesNomi) {
		this.cargarid_anioHistorialPagoMesNomi= cargarid_anioHistorialPagoMesNomi;
	}

	public Border setResaltarid_mesHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarid_mesHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesHistorialPagoMesNomi() {
		return this.resaltarid_mesHistorialPagoMesNomi;
	}

	public void setResaltarid_mesHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarid_mesHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarid_mesHistorialPagoMesNomi() {
		return this.mostrarid_mesHistorialPagoMesNomi;
	}

	public void setMostrarid_mesHistorialPagoMesNomi(Boolean mostrarid_mesHistorialPagoMesNomi) {
		this.mostrarid_mesHistorialPagoMesNomi= mostrarid_mesHistorialPagoMesNomi;
	}

	public Boolean getActivarid_mesHistorialPagoMesNomi() {
		return this.activarid_mesHistorialPagoMesNomi;
	}

	public void setActivarid_mesHistorialPagoMesNomi(Boolean activarid_mesHistorialPagoMesNomi) {
		this.activarid_mesHistorialPagoMesNomi= activarid_mesHistorialPagoMesNomi;
	}

	public Boolean getCargarid_mesHistorialPagoMesNomi() {
		return this.cargarid_mesHistorialPagoMesNomi;
	}

	public void setCargarid_mesHistorialPagoMesNomi(Boolean cargarid_mesHistorialPagoMesNomi) {
		this.cargarid_mesHistorialPagoMesNomi= cargarid_mesHistorialPagoMesNomi;
	}

	public Border setResaltarvalorHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagomesnomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoMesNomi.setBorder(borderResaltar);
		
		this.resaltarvalorHistorialPagoMesNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorHistorialPagoMesNomi() {
		return this.resaltarvalorHistorialPagoMesNomi;
	}

	public void setResaltarvalorHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarvalorHistorialPagoMesNomi= borderResaltar;
	}

	public Boolean getMostrarvalorHistorialPagoMesNomi() {
		return this.mostrarvalorHistorialPagoMesNomi;
	}

	public void setMostrarvalorHistorialPagoMesNomi(Boolean mostrarvalorHistorialPagoMesNomi) {
		this.mostrarvalorHistorialPagoMesNomi= mostrarvalorHistorialPagoMesNomi;
	}

	public Boolean getActivarvalorHistorialPagoMesNomi() {
		return this.activarvalorHistorialPagoMesNomi;
	}

	public void setActivarvalorHistorialPagoMesNomi(Boolean activarvalorHistorialPagoMesNomi) {
		this.activarvalorHistorialPagoMesNomi= activarvalorHistorialPagoMesNomi;
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
		
		
		this.setMostraridHistorialPagoMesNomi(esInicial);
		this.setMostrarid_empresaHistorialPagoMesNomi(esInicial);
		this.setMostrarid_empleadoHistorialPagoMesNomi(esInicial);
		this.setMostrarid_rubro_empleaHistorialPagoMesNomi(esInicial);
		this.setMostrarid_anioHistorialPagoMesNomi(esInicial);
		this.setMostrarid_mesHistorialPagoMesNomi(esInicial);
		this.setMostrarvalorHistorialPagoMesNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.ID)) {
				this.setMostraridHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDMES)) {
				this.setMostrarid_mesHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.VALOR)) {
				this.setMostrarvalorHistorialPagoMesNomi(esAsigna);
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
		
		
		this.setActivaridHistorialPagoMesNomi(esInicial);
		this.setActivarid_empresaHistorialPagoMesNomi(esInicial);
		this.setActivarid_empleadoHistorialPagoMesNomi(esInicial);
		this.setActivarid_rubro_empleaHistorialPagoMesNomi(esInicial);
		this.setActivarid_anioHistorialPagoMesNomi(esInicial);
		this.setActivarid_mesHistorialPagoMesNomi(esInicial);
		this.setActivarvalorHistorialPagoMesNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.ID)) {
				this.setActivaridHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDANIO)) {
				this.setActivarid_anioHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDMES)) {
				this.setActivarid_mesHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.VALOR)) {
				this.setActivarvalorHistorialPagoMesNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialPagoMesNomi(esInicial);
		this.setResaltarid_empresaHistorialPagoMesNomi(esInicial);
		this.setResaltarid_empleadoHistorialPagoMesNomi(esInicial);
		this.setResaltarid_rubro_empleaHistorialPagoMesNomi(esInicial);
		this.setResaltarid_anioHistorialPagoMesNomi(esInicial);
		this.setResaltarid_mesHistorialPagoMesNomi(esInicial);
		this.setResaltarvalorHistorialPagoMesNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.ID)) {
				this.setResaltaridHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.IDMES)) {
				this.setResaltarid_mesHistorialPagoMesNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoMesNomiConstantesFunciones.VALOR)) {
				this.setResaltarvalorHistorialPagoMesNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioHistorialPagoMesNomi=true;

	public Boolean getMostrarFK_IdAnioHistorialPagoMesNomi() {
		return this.mostrarFK_IdAnioHistorialPagoMesNomi;
	}

	public void setMostrarFK_IdAnioHistorialPagoMesNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioHistorialPagoMesNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoHistorialPagoMesNomi=true;

	public Boolean getMostrarFK_IdEmpleadoHistorialPagoMesNomi() {
		return this.mostrarFK_IdEmpleadoHistorialPagoMesNomi;
	}

	public void setMostrarFK_IdEmpleadoHistorialPagoMesNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoHistorialPagoMesNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaHistorialPagoMesNomi=true;

	public Boolean getMostrarFK_IdEmpresaHistorialPagoMesNomi() {
		return this.mostrarFK_IdEmpresaHistorialPagoMesNomi;
	}

	public void setMostrarFK_IdEmpresaHistorialPagoMesNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHistorialPagoMesNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesHistorialPagoMesNomi=true;

	public Boolean getMostrarFK_IdMesHistorialPagoMesNomi() {
		return this.mostrarFK_IdMesHistorialPagoMesNomi;
	}

	public void setMostrarFK_IdMesHistorialPagoMesNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesHistorialPagoMesNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaHistorialPagoMesNomi=true;

	public Boolean getMostrarFK_IdRubroEmpleaHistorialPagoMesNomi() {
		return this.mostrarFK_IdRubroEmpleaHistorialPagoMesNomi;
	}

	public void setMostrarFK_IdRubroEmpleaHistorialPagoMesNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaHistorialPagoMesNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioHistorialPagoMesNomi=true;

	public Boolean getActivarFK_IdAnioHistorialPagoMesNomi() {
		return this.activarFK_IdAnioHistorialPagoMesNomi;
	}

	public void setActivarFK_IdAnioHistorialPagoMesNomi(Boolean habilitarResaltar) {
		this.activarFK_IdAnioHistorialPagoMesNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoHistorialPagoMesNomi=true;

	public Boolean getActivarFK_IdEmpleadoHistorialPagoMesNomi() {
		return this.activarFK_IdEmpleadoHistorialPagoMesNomi;
	}

	public void setActivarFK_IdEmpleadoHistorialPagoMesNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoHistorialPagoMesNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaHistorialPagoMesNomi=true;

	public Boolean getActivarFK_IdEmpresaHistorialPagoMesNomi() {
		return this.activarFK_IdEmpresaHistorialPagoMesNomi;
	}

	public void setActivarFK_IdEmpresaHistorialPagoMesNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHistorialPagoMesNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdMesHistorialPagoMesNomi=true;

	public Boolean getActivarFK_IdMesHistorialPagoMesNomi() {
		return this.activarFK_IdMesHistorialPagoMesNomi;
	}

	public void setActivarFK_IdMesHistorialPagoMesNomi(Boolean habilitarResaltar) {
		this.activarFK_IdMesHistorialPagoMesNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaHistorialPagoMesNomi=true;

	public Boolean getActivarFK_IdRubroEmpleaHistorialPagoMesNomi() {
		return this.activarFK_IdRubroEmpleaHistorialPagoMesNomi;
	}

	public void setActivarFK_IdRubroEmpleaHistorialPagoMesNomi(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaHistorialPagoMesNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioHistorialPagoMesNomi=null;

	public Border getResaltarFK_IdAnioHistorialPagoMesNomi() {
		return this.resaltarFK_IdAnioHistorialPagoMesNomi;
	}

	public void setResaltarFK_IdAnioHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarFK_IdAnioHistorialPagoMesNomi= borderResaltar;
	}

	public void setResaltarFK_IdAnioHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioHistorialPagoMesNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoHistorialPagoMesNomi=null;

	public Border getResaltarFK_IdEmpleadoHistorialPagoMesNomi() {
		return this.resaltarFK_IdEmpleadoHistorialPagoMesNomi;
	}

	public void setResaltarFK_IdEmpleadoHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoHistorialPagoMesNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoHistorialPagoMesNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaHistorialPagoMesNomi=null;

	public Border getResaltarFK_IdEmpresaHistorialPagoMesNomi() {
		return this.resaltarFK_IdEmpresaHistorialPagoMesNomi;
	}

	public void setResaltarFK_IdEmpresaHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHistorialPagoMesNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHistorialPagoMesNomi= borderResaltar;
	}

	public Border resaltarFK_IdMesHistorialPagoMesNomi=null;

	public Border getResaltarFK_IdMesHistorialPagoMesNomi() {
		return this.resaltarFK_IdMesHistorialPagoMesNomi;
	}

	public void setResaltarFK_IdMesHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarFK_IdMesHistorialPagoMesNomi= borderResaltar;
	}

	public void setResaltarFK_IdMesHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesHistorialPagoMesNomi= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaHistorialPagoMesNomi=null;

	public Border getResaltarFK_IdRubroEmpleaHistorialPagoMesNomi() {
		return this.resaltarFK_IdRubroEmpleaHistorialPagoMesNomi;
	}

	public void setResaltarFK_IdRubroEmpleaHistorialPagoMesNomi(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaHistorialPagoMesNomi= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaHistorialPagoMesNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoMesNomiBeanSwingJInternalFrame historialpagomesnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaHistorialPagoMesNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}