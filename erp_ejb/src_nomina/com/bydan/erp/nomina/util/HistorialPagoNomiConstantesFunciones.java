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


import com.bydan.erp.nomina.util.HistorialPagoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.HistorialPagoNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HistorialPagoNomiParameterGeneral;

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
final public class HistorialPagoNomiConstantesFunciones extends HistorialPagoNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialPagoNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialPagoNomi"+HistorialPagoNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialPagoNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialPagoNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialPagoNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialPagoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialPagoNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialPagoNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialPagoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialPagoNomiConstantesFunciones.SCHEMA+"_"+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialPagoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialPagoNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialPagoNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialPagoNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialPagoNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialPagoNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialPagoNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Pago Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Historial Pago Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Historial Pago Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialPagoNomi";
	public static final String OBJECTNAME="historialpagonomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="historial_pago_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialpagonomi from "+HistorialPagoNomiConstantesFunciones.SPERSISTENCENAME+" historialpagonomi";
	public static String QUERYSELECTNATIVE="select "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".version_row,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_empresa,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_estructura,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_empleado,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_rubro_emplea,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_mes,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".valor,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".fecha,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".fecha_liquidacion from "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HistorialPagoNomiConstantesFuncionesAdditional historialpagonomiConstantesFuncionesAdditional=null;
	
	public HistorialPagoNomiConstantesFuncionesAdditional getHistorialPagoNomiConstantesFuncionesAdditional() {
		return this.historialpagonomiConstantesFuncionesAdditional;
	}
	
	public void setHistorialPagoNomiConstantesFuncionesAdditional(HistorialPagoNomiConstantesFuncionesAdditional historialpagonomiConstantesFuncionesAdditional) {
		try {
			this.historialpagonomiConstantesFuncionesAdditional=historialpagonomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDMES= "id_mes";
    public static final String VALOR= "valor";
    public static final String FECHA= "fecha";
    public static final String FECHALIQUIDACION= "fecha_liquidacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHALIQUIDACION= "Fecha Liquacion";
		public static final String LABEL_FECHALIQUIDACION_LOWER= "Fecha Liquidacion";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getHistorialPagoNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.IDEMPLEADO)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.IDMES)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.VALOR)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.FECHA)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION)) {sLabelColumna=HistorialPagoNomiConstantesFunciones.LABEL_FECHALIQUIDACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getHistorialPagoNomiDescripcion(HistorialPagoNomi historialpagonomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialpagonomi !=null/* && historialpagonomi.getId()!=0*/) {
			if(historialpagonomi.getId()!=null) {
				sDescripcion=historialpagonomi.getId().toString();
			}//historialpagonomihistorialpagonomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialPagoNomiDescripcionDetallado(HistorialPagoNomi historialpagonomi) {
		String sDescripcion="";
			
		sDescripcion+=HistorialPagoNomiConstantesFunciones.ID+"=";
		sDescripcion+=historialpagonomi.getId().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialpagonomi.getVersionRow().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=historialpagonomi.getid_empresa().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=historialpagonomi.getid_estructura().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=historialpagonomi.getid_empleado().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=historialpagonomi.getid_rubro_emplea().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.IDMES+"=";
		sDescripcion+=historialpagonomi.getid_mes().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.VALOR+"=";
		sDescripcion+=historialpagonomi.getvalor().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.FECHA+"=";
		sDescripcion+=historialpagonomi.getfecha().toString()+",";
		sDescripcion+=HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION+"=";
		sDescripcion+=historialpagonomi.getfecha_liquidacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialPagoNomiDescripcion(HistorialPagoNomi historialpagonomi,String sValor) throws Exception {			
		if(historialpagonomi !=null) {
			//historialpagonomihistorialpagonomi.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosHistorialPagoNomi(HistorialPagoNomi historialpagonomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialPagoNomi(HistorialPagoNomi historialpagonomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialpagonomi.getConCambioAuxiliar()) {
			historialpagonomi.setIsDeleted(historialpagonomi.getIsDeletedAuxiliar());	
			historialpagonomi.setIsNew(historialpagonomi.getIsNewAuxiliar());	
			historialpagonomi.setIsChanged(historialpagonomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialpagonomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialpagonomi.setIsDeletedAuxiliar(false);	
			historialpagonomi.setIsNewAuxiliar(false);	
			historialpagonomi.setIsChangedAuxiliar(false);
			
			historialpagonomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi : historialpagonomis) {
			if(conAsignarBase && historialpagonomi.getConCambioAuxiliar()) {
				historialpagonomi.setIsDeleted(historialpagonomi.getIsDeletedAuxiliar());	
				historialpagonomi.setIsNew(historialpagonomi.getIsNewAuxiliar());	
				historialpagonomi.setIsChanged(historialpagonomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialpagonomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialpagonomi.setIsDeletedAuxiliar(false);	
				historialpagonomi.setIsNewAuxiliar(false);	
				historialpagonomi.setIsChangedAuxiliar(false);
				
				historialpagonomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialPagoNomi(HistorialPagoNomi historialpagonomi,Boolean conEnteros) throws Exception  {
		historialpagonomi.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis,Boolean conEnteros) throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {
			historialpagonomi.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialPagoNomi(List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomi historialpagonomiAux) throws Exception  {
		HistorialPagoNomiConstantesFunciones.InicializarValoresHistorialPagoNomi(historialpagonomiAux,true);
		
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {
			if(historialpagonomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			historialpagonomiAux.setvalor(historialpagonomiAux.getvalor()+historialpagonomi.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialPagoNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialPagoNomiConstantesFunciones.getArrayColumnasGlobalesHistorialPagoNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialPagoNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialPagoNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialPagoNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialPagoNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialPagoNomi> historialpagonomis,HistorialPagoNomi historialpagonomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialPagoNomi historialpagonomiAux: historialpagonomis) {
			if(historialpagonomiAux!=null && historialpagonomi!=null) {
				if((historialpagonomiAux.getId()==null && historialpagonomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialpagonomiAux.getId()!=null && historialpagonomi.getId()!=null){
					if(historialpagonomiAux.getId().equals(historialpagonomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialPagoNomi(List<HistorialPagoNomi> historialpagonomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(HistorialPagoNomi historialpagonomi: historialpagonomis) {			
			if(historialpagonomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=historialpagonomi.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialPagoNomiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialPagoNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_ID, HistorialPagoNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_VERSIONROW, HistorialPagoNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_IDEMPRESA, HistorialPagoNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_IDESTRUCTURA, HistorialPagoNomiConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_IDEMPLEADO, HistorialPagoNomiConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_IDRUBROEMPLEA, HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_IDMES, HistorialPagoNomiConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_VALOR, HistorialPagoNomiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_FECHA, HistorialPagoNomiConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialPagoNomiConstantesFunciones.LABEL_FECHALIQUIDACION, HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialPagoNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoNomi() throws Exception  {
		return HistorialPagoNomiConstantesFunciones.getTiposSeleccionarHistorialPagoNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoNomi(Boolean conFk) throws Exception  {
		return HistorialPagoNomiConstantesFunciones.getTiposSeleccionarHistorialPagoNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialPagoNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialPagoNomiConstantesFunciones.LABEL_FECHALIQUIDACION);
			reporte.setsDescripcion(HistorialPagoNomiConstantesFunciones.LABEL_FECHALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialPagoNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialPagoNomi(HistorialPagoNomi historialpagonomiAux) throws Exception {
		
			historialpagonomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialpagonomiAux.getEmpresa()));
			historialpagonomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(historialpagonomiAux.getEstructura()));
			historialpagonomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(historialpagonomiAux.getEmpleado()));
			historialpagonomiAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(historialpagonomiAux.getRubroEmplea()));
			historialpagonomiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialpagonomiAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialPagoNomi(List<HistorialPagoNomi> historialpagonomisTemp) throws Exception {
		for(HistorialPagoNomi historialpagonomiAux:historialpagonomisTemp) {
			
			historialpagonomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialpagonomiAux.getEmpresa()));
			historialpagonomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(historialpagonomiAux.getEstructura()));
			historialpagonomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(historialpagonomiAux.getEmpleado()));
			historialpagonomiAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(historialpagonomiAux.getRubroEmplea()));
			historialpagonomiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(historialpagonomiAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialPagoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialPagoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialPagoNomiConstantesFunciones.getClassesRelationshipsOfHistorialPagoNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialPagoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialPagoNomiConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialPagoNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialPagoNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HistorialPagoNomi historialpagonomi,List<HistorialPagoNomi> historialpagonomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HistorialPagoNomi historialpagonomiEncontrado=null;
			
			for(HistorialPagoNomi historialpagonomiLocal:historialpagonomis) {
				if(historialpagonomiLocal.getId().equals(historialpagonomi.getId())) {
					historialpagonomiEncontrado=historialpagonomiLocal;
					
					historialpagonomiLocal.setIsChanged(historialpagonomi.getIsChanged());
					historialpagonomiLocal.setIsNew(historialpagonomi.getIsNew());
					historialpagonomiLocal.setIsDeleted(historialpagonomi.getIsDeleted());
					
					historialpagonomiLocal.setGeneralEntityOriginal(historialpagonomi.getGeneralEntityOriginal());
					
					historialpagonomiLocal.setId(historialpagonomi.getId());	
					historialpagonomiLocal.setVersionRow(historialpagonomi.getVersionRow());	
					historialpagonomiLocal.setid_empresa(historialpagonomi.getid_empresa());	
					historialpagonomiLocal.setid_estructura(historialpagonomi.getid_estructura());	
					historialpagonomiLocal.setid_empleado(historialpagonomi.getid_empleado());	
					historialpagonomiLocal.setid_rubro_emplea(historialpagonomi.getid_rubro_emplea());	
					historialpagonomiLocal.setid_mes(historialpagonomi.getid_mes());	
					historialpagonomiLocal.setvalor(historialpagonomi.getvalor());	
					historialpagonomiLocal.setfecha(historialpagonomi.getfecha());	
					historialpagonomiLocal.setfecha_liquidacion(historialpagonomi.getfecha_liquidacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!historialpagonomi.getIsDeleted()) {
				if(!existe) {
					historialpagonomis.add(historialpagonomi);
				}
			} else {
				if(historialpagonomiEncontrado!=null && permiteQuitar)  {
					historialpagonomis.remove(historialpagonomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HistorialPagoNomi historialpagonomi,List<HistorialPagoNomi> historialpagonomis) throws Exception {
		try	{			
			for(HistorialPagoNomi historialpagonomiLocal:historialpagonomis) {
				if(historialpagonomiLocal.getId().equals(historialpagonomi.getId())) {
					historialpagonomiLocal.setIsSelected(historialpagonomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialPagoNomi(List<HistorialPagoNomi> historialpagonomisAux) throws Exception {
		//this.historialpagonomisAux=historialpagonomisAux;
		
		for(HistorialPagoNomi historialpagonomiAux:historialpagonomisAux) {
			if(historialpagonomiAux.getIsChanged()) {
				historialpagonomiAux.setIsChanged(false);
			}		
			
			if(historialpagonomiAux.getIsNew()) {
				historialpagonomiAux.setIsNew(false);
			}	
			
			if(historialpagonomiAux.getIsDeleted()) {
				historialpagonomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialPagoNomi(HistorialPagoNomi historialpagonomiAux) throws Exception {
		//this.historialpagonomiAux=historialpagonomiAux;
		
			if(historialpagonomiAux.getIsChanged()) {
				historialpagonomiAux.setIsChanged(false);
			}		
			
			if(historialpagonomiAux.getIsNew()) {
				historialpagonomiAux.setIsNew(false);
			}	
			
			if(historialpagonomiAux.getIsDeleted()) {
				historialpagonomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialPagoNomi historialpagonomiAsignar,HistorialPagoNomi historialpagonomi) throws Exception {
		historialpagonomiAsignar.setId(historialpagonomi.getId());	
		historialpagonomiAsignar.setVersionRow(historialpagonomi.getVersionRow());	
		historialpagonomiAsignar.setid_empresa(historialpagonomi.getid_empresa());
		historialpagonomiAsignar.setempresa_descripcion(historialpagonomi.getempresa_descripcion());	
		historialpagonomiAsignar.setid_estructura(historialpagonomi.getid_estructura());
		historialpagonomiAsignar.setestructura_descripcion(historialpagonomi.getestructura_descripcion());	
		historialpagonomiAsignar.setid_empleado(historialpagonomi.getid_empleado());
		historialpagonomiAsignar.setempleado_descripcion(historialpagonomi.getempleado_descripcion());	
		historialpagonomiAsignar.setid_rubro_emplea(historialpagonomi.getid_rubro_emplea());
		historialpagonomiAsignar.setrubroemplea_descripcion(historialpagonomi.getrubroemplea_descripcion());	
		historialpagonomiAsignar.setid_mes(historialpagonomi.getid_mes());
		historialpagonomiAsignar.setmes_descripcion(historialpagonomi.getmes_descripcion());	
		historialpagonomiAsignar.setvalor(historialpagonomi.getvalor());	
		historialpagonomiAsignar.setfecha(historialpagonomi.getfecha());	
		historialpagonomiAsignar.setfecha_liquidacion(historialpagonomi.getfecha_liquidacion());	
	}
	
	public static void inicializarHistorialPagoNomi(HistorialPagoNomi historialpagonomi) throws Exception {
		try {
				historialpagonomi.setId(0L);	
					
				historialpagonomi.setid_empresa(-1L);	
				historialpagonomi.setid_estructura(-1L);	
				historialpagonomi.setid_empleado(-1L);	
				historialpagonomi.setid_rubro_emplea(-1L);	
				historialpagonomi.setid_mes(null);	
				historialpagonomi.setvalor(0.0);	
				historialpagonomi.setfecha(new Date());	
				historialpagonomi.setfecha_liquidacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialPagoNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialPagoNomiConstantesFunciones.LABEL_FECHALIQUIDACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialPagoNomi(String sTipo,Row row,Workbook workbook,HistorialPagoNomi historialpagonomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialpagonomi.getfecha_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialPagoNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHistorialPagoNomi() {
		return this.sFinalQueryHistorialPagoNomi;
	}
	
	public void setsFinalQueryHistorialPagoNomi(String sFinalQueryHistorialPagoNomi) {
		this.sFinalQueryHistorialPagoNomi= sFinalQueryHistorialPagoNomi;
	}
	
	public Border resaltarSeleccionarHistorialPagoNomi=null;
	
	public Border setResaltarSeleccionarHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialPagoNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialPagoNomi() {
		return this.resaltarSeleccionarHistorialPagoNomi;
	}
	
	public void setResaltarSeleccionarHistorialPagoNomi(Border borderResaltarSeleccionarHistorialPagoNomi) {
		this.resaltarSeleccionarHistorialPagoNomi= borderResaltarSeleccionarHistorialPagoNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialPagoNomi=null;
	public Boolean mostraridHistorialPagoNomi=true;
	public Boolean activaridHistorialPagoNomi=true;

	public Border resaltarid_empresaHistorialPagoNomi=null;
	public Boolean mostrarid_empresaHistorialPagoNomi=true;
	public Boolean activarid_empresaHistorialPagoNomi=true;
	public Boolean cargarid_empresaHistorialPagoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHistorialPagoNomi=false;//ConEventDepend=true

	public Border resaltarid_estructuraHistorialPagoNomi=null;
	public Boolean mostrarid_estructuraHistorialPagoNomi=true;
	public Boolean activarid_estructuraHistorialPagoNomi=true;
	public Boolean cargarid_estructuraHistorialPagoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraHistorialPagoNomi=false;//ConEventDepend=true

	public Border resaltarid_empleadoHistorialPagoNomi=null;
	public Boolean mostrarid_empleadoHistorialPagoNomi=true;
	public Boolean activarid_empleadoHistorialPagoNomi=true;
	public Boolean cargarid_empleadoHistorialPagoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoHistorialPagoNomi=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaHistorialPagoNomi=null;
	public Boolean mostrarid_rubro_empleaHistorialPagoNomi=true;
	public Boolean activarid_rubro_empleaHistorialPagoNomi=true;
	public Boolean cargarid_rubro_empleaHistorialPagoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaHistorialPagoNomi=false;//ConEventDepend=true

	public Border resaltarid_mesHistorialPagoNomi=null;
	public Boolean mostrarid_mesHistorialPagoNomi=true;
	public Boolean activarid_mesHistorialPagoNomi=true;
	public Boolean cargarid_mesHistorialPagoNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesHistorialPagoNomi=false;//ConEventDepend=true

	public Border resaltarvalorHistorialPagoNomi=null;
	public Boolean mostrarvalorHistorialPagoNomi=true;
	public Boolean activarvalorHistorialPagoNomi=true;

	public Border resaltarfechaHistorialPagoNomi=null;
	public Boolean mostrarfechaHistorialPagoNomi=true;
	public Boolean activarfechaHistorialPagoNomi=false;

	public Border resaltarfecha_liquidacionHistorialPagoNomi=null;
	public Boolean mostrarfecha_liquidacionHistorialPagoNomi=true;
	public Boolean activarfecha_liquidacionHistorialPagoNomi=false;

	
	

	public Border setResaltaridHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltaridHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialPagoNomi() {
		return this.resaltaridHistorialPagoNomi;
	}

	public void setResaltaridHistorialPagoNomi(Border borderResaltar) {
		this.resaltaridHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostraridHistorialPagoNomi() {
		return this.mostraridHistorialPagoNomi;
	}

	public void setMostraridHistorialPagoNomi(Boolean mostraridHistorialPagoNomi) {
		this.mostraridHistorialPagoNomi= mostraridHistorialPagoNomi;
	}

	public Boolean getActivaridHistorialPagoNomi() {
		return this.activaridHistorialPagoNomi;
	}

	public void setActivaridHistorialPagoNomi(Boolean activaridHistorialPagoNomi) {
		this.activaridHistorialPagoNomi= activaridHistorialPagoNomi;
	}

	public Border setResaltarid_empresaHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHistorialPagoNomi() {
		return this.resaltarid_empresaHistorialPagoNomi;
	}

	public void setResaltarid_empresaHistorialPagoNomi(Border borderResaltar) {
		this.resaltarid_empresaHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaHistorialPagoNomi() {
		return this.mostrarid_empresaHistorialPagoNomi;
	}

	public void setMostrarid_empresaHistorialPagoNomi(Boolean mostrarid_empresaHistorialPagoNomi) {
		this.mostrarid_empresaHistorialPagoNomi= mostrarid_empresaHistorialPagoNomi;
	}

	public Boolean getActivarid_empresaHistorialPagoNomi() {
		return this.activarid_empresaHistorialPagoNomi;
	}

	public void setActivarid_empresaHistorialPagoNomi(Boolean activarid_empresaHistorialPagoNomi) {
		this.activarid_empresaHistorialPagoNomi= activarid_empresaHistorialPagoNomi;
	}

	public Boolean getCargarid_empresaHistorialPagoNomi() {
		return this.cargarid_empresaHistorialPagoNomi;
	}

	public void setCargarid_empresaHistorialPagoNomi(Boolean cargarid_empresaHistorialPagoNomi) {
		this.cargarid_empresaHistorialPagoNomi= cargarid_empresaHistorialPagoNomi;
	}

	public Border setResaltarid_estructuraHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarid_estructuraHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraHistorialPagoNomi() {
		return this.resaltarid_estructuraHistorialPagoNomi;
	}

	public void setResaltarid_estructuraHistorialPagoNomi(Border borderResaltar) {
		this.resaltarid_estructuraHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarid_estructuraHistorialPagoNomi() {
		return this.mostrarid_estructuraHistorialPagoNomi;
	}

	public void setMostrarid_estructuraHistorialPagoNomi(Boolean mostrarid_estructuraHistorialPagoNomi) {
		this.mostrarid_estructuraHistorialPagoNomi= mostrarid_estructuraHistorialPagoNomi;
	}

	public Boolean getActivarid_estructuraHistorialPagoNomi() {
		return this.activarid_estructuraHistorialPagoNomi;
	}

	public void setActivarid_estructuraHistorialPagoNomi(Boolean activarid_estructuraHistorialPagoNomi) {
		this.activarid_estructuraHistorialPagoNomi= activarid_estructuraHistorialPagoNomi;
	}

	public Boolean getCargarid_estructuraHistorialPagoNomi() {
		return this.cargarid_estructuraHistorialPagoNomi;
	}

	public void setCargarid_estructuraHistorialPagoNomi(Boolean cargarid_estructuraHistorialPagoNomi) {
		this.cargarid_estructuraHistorialPagoNomi= cargarid_estructuraHistorialPagoNomi;
	}

	public Border setResaltarid_empleadoHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleadoHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoHistorialPagoNomi() {
		return this.resaltarid_empleadoHistorialPagoNomi;
	}

	public void setResaltarid_empleadoHistorialPagoNomi(Border borderResaltar) {
		this.resaltarid_empleadoHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleadoHistorialPagoNomi() {
		return this.mostrarid_empleadoHistorialPagoNomi;
	}

	public void setMostrarid_empleadoHistorialPagoNomi(Boolean mostrarid_empleadoHistorialPagoNomi) {
		this.mostrarid_empleadoHistorialPagoNomi= mostrarid_empleadoHistorialPagoNomi;
	}

	public Boolean getActivarid_empleadoHistorialPagoNomi() {
		return this.activarid_empleadoHistorialPagoNomi;
	}

	public void setActivarid_empleadoHistorialPagoNomi(Boolean activarid_empleadoHistorialPagoNomi) {
		this.activarid_empleadoHistorialPagoNomi= activarid_empleadoHistorialPagoNomi;
	}

	public Boolean getCargarid_empleadoHistorialPagoNomi() {
		return this.cargarid_empleadoHistorialPagoNomi;
	}

	public void setCargarid_empleadoHistorialPagoNomi(Boolean cargarid_empleadoHistorialPagoNomi) {
		this.cargarid_empleadoHistorialPagoNomi= cargarid_empleadoHistorialPagoNomi;
	}

	public Border setResaltarid_rubro_empleaHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaHistorialPagoNomi() {
		return this.resaltarid_rubro_empleaHistorialPagoNomi;
	}

	public void setResaltarid_rubro_empleaHistorialPagoNomi(Border borderResaltar) {
		this.resaltarid_rubro_empleaHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaHistorialPagoNomi() {
		return this.mostrarid_rubro_empleaHistorialPagoNomi;
	}

	public void setMostrarid_rubro_empleaHistorialPagoNomi(Boolean mostrarid_rubro_empleaHistorialPagoNomi) {
		this.mostrarid_rubro_empleaHistorialPagoNomi= mostrarid_rubro_empleaHistorialPagoNomi;
	}

	public Boolean getActivarid_rubro_empleaHistorialPagoNomi() {
		return this.activarid_rubro_empleaHistorialPagoNomi;
	}

	public void setActivarid_rubro_empleaHistorialPagoNomi(Boolean activarid_rubro_empleaHistorialPagoNomi) {
		this.activarid_rubro_empleaHistorialPagoNomi= activarid_rubro_empleaHistorialPagoNomi;
	}

	public Boolean getCargarid_rubro_empleaHistorialPagoNomi() {
		return this.cargarid_rubro_empleaHistorialPagoNomi;
	}

	public void setCargarid_rubro_empleaHistorialPagoNomi(Boolean cargarid_rubro_empleaHistorialPagoNomi) {
		this.cargarid_rubro_empleaHistorialPagoNomi= cargarid_rubro_empleaHistorialPagoNomi;
	}

	public Border setResaltarid_mesHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarid_mesHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesHistorialPagoNomi() {
		return this.resaltarid_mesHistorialPagoNomi;
	}

	public void setResaltarid_mesHistorialPagoNomi(Border borderResaltar) {
		this.resaltarid_mesHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarid_mesHistorialPagoNomi() {
		return this.mostrarid_mesHistorialPagoNomi;
	}

	public void setMostrarid_mesHistorialPagoNomi(Boolean mostrarid_mesHistorialPagoNomi) {
		this.mostrarid_mesHistorialPagoNomi= mostrarid_mesHistorialPagoNomi;
	}

	public Boolean getActivarid_mesHistorialPagoNomi() {
		return this.activarid_mesHistorialPagoNomi;
	}

	public void setActivarid_mesHistorialPagoNomi(Boolean activarid_mesHistorialPagoNomi) {
		this.activarid_mesHistorialPagoNomi= activarid_mesHistorialPagoNomi;
	}

	public Boolean getCargarid_mesHistorialPagoNomi() {
		return this.cargarid_mesHistorialPagoNomi;
	}

	public void setCargarid_mesHistorialPagoNomi(Boolean cargarid_mesHistorialPagoNomi) {
		this.cargarid_mesHistorialPagoNomi= cargarid_mesHistorialPagoNomi;
	}

	public Border setResaltarvalorHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarvalorHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorHistorialPagoNomi() {
		return this.resaltarvalorHistorialPagoNomi;
	}

	public void setResaltarvalorHistorialPagoNomi(Border borderResaltar) {
		this.resaltarvalorHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarvalorHistorialPagoNomi() {
		return this.mostrarvalorHistorialPagoNomi;
	}

	public void setMostrarvalorHistorialPagoNomi(Boolean mostrarvalorHistorialPagoNomi) {
		this.mostrarvalorHistorialPagoNomi= mostrarvalorHistorialPagoNomi;
	}

	public Boolean getActivarvalorHistorialPagoNomi() {
		return this.activarvalorHistorialPagoNomi;
	}

	public void setActivarvalorHistorialPagoNomi(Boolean activarvalorHistorialPagoNomi) {
		this.activarvalorHistorialPagoNomi= activarvalorHistorialPagoNomi;
	}

	public Border setResaltarfechaHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarfechaHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaHistorialPagoNomi() {
		return this.resaltarfechaHistorialPagoNomi;
	}

	public void setResaltarfechaHistorialPagoNomi(Border borderResaltar) {
		this.resaltarfechaHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarfechaHistorialPagoNomi() {
		return this.mostrarfechaHistorialPagoNomi;
	}

	public void setMostrarfechaHistorialPagoNomi(Boolean mostrarfechaHistorialPagoNomi) {
		this.mostrarfechaHistorialPagoNomi= mostrarfechaHistorialPagoNomi;
	}

	public Boolean getActivarfechaHistorialPagoNomi() {
		return this.activarfechaHistorialPagoNomi;
	}

	public void setActivarfechaHistorialPagoNomi(Boolean activarfechaHistorialPagoNomi) {
		this.activarfechaHistorialPagoNomi= activarfechaHistorialPagoNomi;
	}

	public Border setResaltarfecha_liquidacionHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialpagonomiBeanSwingJInternalFrame.jTtoolBarHistorialPagoNomi.setBorder(borderResaltar);
		
		this.resaltarfecha_liquidacionHistorialPagoNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_liquidacionHistorialPagoNomi() {
		return this.resaltarfecha_liquidacionHistorialPagoNomi;
	}

	public void setResaltarfecha_liquidacionHistorialPagoNomi(Border borderResaltar) {
		this.resaltarfecha_liquidacionHistorialPagoNomi= borderResaltar;
	}

	public Boolean getMostrarfecha_liquidacionHistorialPagoNomi() {
		return this.mostrarfecha_liquidacionHistorialPagoNomi;
	}

	public void setMostrarfecha_liquidacionHistorialPagoNomi(Boolean mostrarfecha_liquidacionHistorialPagoNomi) {
		this.mostrarfecha_liquidacionHistorialPagoNomi= mostrarfecha_liquidacionHistorialPagoNomi;
	}

	public Boolean getActivarfecha_liquidacionHistorialPagoNomi() {
		return this.activarfecha_liquidacionHistorialPagoNomi;
	}

	public void setActivarfecha_liquidacionHistorialPagoNomi(Boolean activarfecha_liquidacionHistorialPagoNomi) {
		this.activarfecha_liquidacionHistorialPagoNomi= activarfecha_liquidacionHistorialPagoNomi;
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
		
		
		this.setMostraridHistorialPagoNomi(esInicial);
		this.setMostrarid_empresaHistorialPagoNomi(esInicial);
		this.setMostrarid_estructuraHistorialPagoNomi(esInicial);
		this.setMostrarid_empleadoHistorialPagoNomi(esInicial);
		this.setMostrarid_rubro_empleaHistorialPagoNomi(esInicial);
		this.setMostrarid_mesHistorialPagoNomi(esInicial);
		this.setMostrarvalorHistorialPagoNomi(esInicial);
		this.setMostrarfechaHistorialPagoNomi(esInicial);
		this.setMostrarfecha_liquidacionHistorialPagoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.ID)) {
				this.setMostraridHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDMES)) {
				this.setMostrarid_mesHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.VALOR)) {
				this.setMostrarvalorHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHA)) {
				this.setMostrarfechaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION)) {
				this.setMostrarfecha_liquidacionHistorialPagoNomi(esAsigna);
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
		
		
		this.setActivaridHistorialPagoNomi(esInicial);
		this.setActivarid_empresaHistorialPagoNomi(esInicial);
		this.setActivarid_estructuraHistorialPagoNomi(esInicial);
		this.setActivarid_empleadoHistorialPagoNomi(esInicial);
		this.setActivarid_rubro_empleaHistorialPagoNomi(esInicial);
		this.setActivarid_mesHistorialPagoNomi(esInicial);
		this.setActivarvalorHistorialPagoNomi(esInicial);
		this.setActivarfechaHistorialPagoNomi(esInicial);
		this.setActivarfecha_liquidacionHistorialPagoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.ID)) {
				this.setActivaridHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDMES)) {
				this.setActivarid_mesHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.VALOR)) {
				this.setActivarvalorHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHA)) {
				this.setActivarfechaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION)) {
				this.setActivarfecha_liquidacionHistorialPagoNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialPagoNomi(esInicial);
		this.setResaltarid_empresaHistorialPagoNomi(esInicial);
		this.setResaltarid_estructuraHistorialPagoNomi(esInicial);
		this.setResaltarid_empleadoHistorialPagoNomi(esInicial);
		this.setResaltarid_rubro_empleaHistorialPagoNomi(esInicial);
		this.setResaltarid_mesHistorialPagoNomi(esInicial);
		this.setResaltarvalorHistorialPagoNomi(esInicial);
		this.setResaltarfechaHistorialPagoNomi(esInicial);
		this.setResaltarfecha_liquidacionHistorialPagoNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.ID)) {
				this.setResaltaridHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.IDMES)) {
				this.setResaltarid_mesHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.VALOR)) {
				this.setResaltarvalorHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHA)) {
				this.setResaltarfechaHistorialPagoNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION)) {
				this.setResaltarfecha_liquidacionHistorialPagoNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoHistorialPagoNomi=true;

	public Boolean getMostrarFK_IdEmpleadoHistorialPagoNomi() {
		return this.mostrarFK_IdEmpleadoHistorialPagoNomi;
	}

	public void setMostrarFK_IdEmpleadoHistorialPagoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoHistorialPagoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaHistorialPagoNomi=true;

	public Boolean getMostrarFK_IdEmpresaHistorialPagoNomi() {
		return this.mostrarFK_IdEmpresaHistorialPagoNomi;
	}

	public void setMostrarFK_IdEmpresaHistorialPagoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHistorialPagoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraHistorialPagoNomi=true;

	public Boolean getMostrarFK_IdEstructuraHistorialPagoNomi() {
		return this.mostrarFK_IdEstructuraHistorialPagoNomi;
	}

	public void setMostrarFK_IdEstructuraHistorialPagoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraHistorialPagoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesHistorialPagoNomi=true;

	public Boolean getMostrarFK_IdMesHistorialPagoNomi() {
		return this.mostrarFK_IdMesHistorialPagoNomi;
	}

	public void setMostrarFK_IdMesHistorialPagoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesHistorialPagoNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaHistorialPagoNomi=true;

	public Boolean getMostrarFK_IdRubroEmpleaHistorialPagoNomi() {
		return this.mostrarFK_IdRubroEmpleaHistorialPagoNomi;
	}

	public void setMostrarFK_IdRubroEmpleaHistorialPagoNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaHistorialPagoNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoHistorialPagoNomi=true;

	public Boolean getActivarFK_IdEmpleadoHistorialPagoNomi() {
		return this.activarFK_IdEmpleadoHistorialPagoNomi;
	}

	public void setActivarFK_IdEmpleadoHistorialPagoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoHistorialPagoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaHistorialPagoNomi=true;

	public Boolean getActivarFK_IdEmpresaHistorialPagoNomi() {
		return this.activarFK_IdEmpresaHistorialPagoNomi;
	}

	public void setActivarFK_IdEmpresaHistorialPagoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHistorialPagoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraHistorialPagoNomi=true;

	public Boolean getActivarFK_IdEstructuraHistorialPagoNomi() {
		return this.activarFK_IdEstructuraHistorialPagoNomi;
	}

	public void setActivarFK_IdEstructuraHistorialPagoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraHistorialPagoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdMesHistorialPagoNomi=true;

	public Boolean getActivarFK_IdMesHistorialPagoNomi() {
		return this.activarFK_IdMesHistorialPagoNomi;
	}

	public void setActivarFK_IdMesHistorialPagoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdMesHistorialPagoNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaHistorialPagoNomi=true;

	public Boolean getActivarFK_IdRubroEmpleaHistorialPagoNomi() {
		return this.activarFK_IdRubroEmpleaHistorialPagoNomi;
	}

	public void setActivarFK_IdRubroEmpleaHistorialPagoNomi(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaHistorialPagoNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoHistorialPagoNomi=null;

	public Border getResaltarFK_IdEmpleadoHistorialPagoNomi() {
		return this.resaltarFK_IdEmpleadoHistorialPagoNomi;
	}

	public void setResaltarFK_IdEmpleadoHistorialPagoNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoHistorialPagoNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoHistorialPagoNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaHistorialPagoNomi=null;

	public Border getResaltarFK_IdEmpresaHistorialPagoNomi() {
		return this.resaltarFK_IdEmpresaHistorialPagoNomi;
	}

	public void setResaltarFK_IdEmpresaHistorialPagoNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHistorialPagoNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHistorialPagoNomi= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraHistorialPagoNomi=null;

	public Border getResaltarFK_IdEstructuraHistorialPagoNomi() {
		return this.resaltarFK_IdEstructuraHistorialPagoNomi;
	}

	public void setResaltarFK_IdEstructuraHistorialPagoNomi(Border borderResaltar) {
		this.resaltarFK_IdEstructuraHistorialPagoNomi= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraHistorialPagoNomi= borderResaltar;
	}

	public Border resaltarFK_IdMesHistorialPagoNomi=null;

	public Border getResaltarFK_IdMesHistorialPagoNomi() {
		return this.resaltarFK_IdMesHistorialPagoNomi;
	}

	public void setResaltarFK_IdMesHistorialPagoNomi(Border borderResaltar) {
		this.resaltarFK_IdMesHistorialPagoNomi= borderResaltar;
	}

	public void setResaltarFK_IdMesHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesHistorialPagoNomi= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaHistorialPagoNomi=null;

	public Border getResaltarFK_IdRubroEmpleaHistorialPagoNomi() {
		return this.resaltarFK_IdRubroEmpleaHistorialPagoNomi;
	}

	public void setResaltarFK_IdRubroEmpleaHistorialPagoNomi(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaHistorialPagoNomi= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaHistorialPagoNomi(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialPagoNomiBeanSwingJInternalFrame historialpagonomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaHistorialPagoNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}