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


import com.bydan.erp.nomina.util.RubroEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleadoParameterGeneral;

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
final public class RubroEmpleadoConstantesFunciones extends RubroEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RubroEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RubroEmpleado"+RubroEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RubroEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RubroEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RubroEmpleadoConstantesFunciones.SCHEMA+"_"+RubroEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RubroEmpleadoConstantesFunciones.SCHEMA+"_"+RubroEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RubroEmpleadoConstantesFunciones.SCHEMA+"_"+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RubroEmpleadoConstantesFunciones.SCHEMA+"_"+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RubroEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RubroEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RubroEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RubroEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rubro Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rubro Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Rubro Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RubroEmpleado";
	public static final String OBJECTNAME="rubroempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rubro_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rubroempleado from "+RubroEmpleadoConstantesFunciones.SPERSISTENCENAME+" rubroempleado";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_estado_rubro,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".valor from "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME;//+" as "+RubroEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RubroEmpleadoConstantesFuncionesAdditional rubroempleadoConstantesFuncionesAdditional=null;
	
	public RubroEmpleadoConstantesFuncionesAdditional getRubroEmpleadoConstantesFuncionesAdditional() {
		return this.rubroempleadoConstantesFuncionesAdditional;
	}
	
	public void setRubroEmpleadoConstantesFuncionesAdditional(RubroEmpleadoConstantesFuncionesAdditional rubroempleadoConstantesFuncionesAdditional) {
		try {
			this.rubroempleadoConstantesFuncionesAdditional=rubroempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDESTADORUBRO= "id_estado_rubro";
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
    	public static final String LABEL_IDESTADORUBRO= "Estado Rubro";
		public static final String LABEL_IDESTADORUBRO_LOWER= "Estado Rubro";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
	
	public static String getRubroEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RubroEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=RubroEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RubroEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=RubroEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=RubroEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(RubroEmpleadoConstantesFunciones.IDESTADORUBRO)) {sLabelColumna=RubroEmpleadoConstantesFunciones.LABEL_IDESTADORUBRO;}
		if(sNombreColumna.equals(RubroEmpleadoConstantesFunciones.VALOR)) {sLabelColumna=RubroEmpleadoConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getRubroEmpleadoDescripcion(RubroEmpleado rubroempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rubroempleado !=null/* && rubroempleado.getId()!=0*/) {
			if(rubroempleado.getId()!=null) {
				sDescripcion=rubroempleado.getId().toString();
			}//rubroempleadorubroempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRubroEmpleadoDescripcionDetallado(RubroEmpleado rubroempleado) {
		String sDescripcion="";
			
		sDescripcion+=RubroEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=rubroempleado.getId().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rubroempleado.getVersionRow().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rubroempleado.getid_empresa().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=rubroempleado.getid_empleado().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=rubroempleado.getid_rubro_emplea().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.IDESTADORUBRO+"=";
		sDescripcion+=rubroempleado.getid_estado_rubro().toString()+",";
		sDescripcion+=RubroEmpleadoConstantesFunciones.VALOR+"=";
		sDescripcion+=rubroempleado.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRubroEmpleadoDescripcion(RubroEmpleado rubroempleado,String sValor) throws Exception {			
		if(rubroempleado !=null) {
			//rubroempleadorubroempleado.getId().toString();
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

	public static String getEstadoRubroDescripcion(EstadoRubro estadorubro) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadorubro!=null/*&&estadorubro.getId()>0*/) {
			sDescripcion=EstadoRubroConstantesFunciones.getEstadoRubroDescripcion(estadorubro);
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
		} else if(sNombreIndice.equals("FK_IdEstadoRubro")) {
			sNombreIndice="Tipo=  Por Estado Rubro";
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

	public static String getDetalleIndiceFK_IdEstadoRubro(Long id_estado_rubro) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_rubro!=null) {sDetalleIndice+=" Codigo Unico De Estado Rubro="+id_estado_rubro.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRubroEmpleado(RubroEmpleado rubroempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRubroEmpleados(List<RubroEmpleado> rubroempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RubroEmpleado rubroempleado: rubroempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmpleado(RubroEmpleado rubroempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rubroempleado.getConCambioAuxiliar()) {
			rubroempleado.setIsDeleted(rubroempleado.getIsDeletedAuxiliar());	
			rubroempleado.setIsNew(rubroempleado.getIsNewAuxiliar());	
			rubroempleado.setIsChanged(rubroempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rubroempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rubroempleado.setIsDeletedAuxiliar(false);	
			rubroempleado.setIsNewAuxiliar(false);	
			rubroempleado.setIsChangedAuxiliar(false);
			
			rubroempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmpleados(List<RubroEmpleado> rubroempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RubroEmpleado rubroempleado : rubroempleados) {
			if(conAsignarBase && rubroempleado.getConCambioAuxiliar()) {
				rubroempleado.setIsDeleted(rubroempleado.getIsDeletedAuxiliar());	
				rubroempleado.setIsNew(rubroempleado.getIsNewAuxiliar());	
				rubroempleado.setIsChanged(rubroempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rubroempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rubroempleado.setIsDeletedAuxiliar(false);	
				rubroempleado.setIsNewAuxiliar(false);	
				rubroempleado.setIsChangedAuxiliar(false);
				
				rubroempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRubroEmpleado(RubroEmpleado rubroempleado,Boolean conEnteros) throws Exception  {
		rubroempleado.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRubroEmpleados(List<RubroEmpleado> rubroempleados,Boolean conEnteros) throws Exception  {
		
		for(RubroEmpleado rubroempleado: rubroempleados) {
			rubroempleado.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRubroEmpleado(List<RubroEmpleado> rubroempleados,RubroEmpleado rubroempleadoAux) throws Exception  {
		RubroEmpleadoConstantesFunciones.InicializarValoresRubroEmpleado(rubroempleadoAux,true);
		
		for(RubroEmpleado rubroempleado: rubroempleados) {
			if(rubroempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rubroempleadoAux.setvalor(rubroempleadoAux.getvalor()+rubroempleado.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RubroEmpleadoConstantesFunciones.getArrayColumnasGlobalesRubroEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRubroEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RubroEmpleado> rubroempleados,RubroEmpleado rubroempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RubroEmpleado rubroempleadoAux: rubroempleados) {
			if(rubroempleadoAux!=null && rubroempleado!=null) {
				if((rubroempleadoAux.getId()==null && rubroempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rubroempleadoAux.getId()!=null && rubroempleado.getId()!=null){
					if(rubroempleadoAux.getId().equals(rubroempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRubroEmpleado(List<RubroEmpleado> rubroempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(RubroEmpleado rubroempleado: rubroempleados) {			
			if(rubroempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=rubroempleado.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RubroEmpleadoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRubroEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_ID, RubroEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_VERSIONROW, RubroEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_IDEMPRESA, RubroEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, RubroEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA, RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_IDESTADORUBRO, RubroEmpleadoConstantesFunciones.IDESTADORUBRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleadoConstantesFunciones.LABEL_VALOR, RubroEmpleadoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRubroEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.IDESTADORUBRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleadoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleado() throws Exception  {
		return RubroEmpleadoConstantesFunciones.getTiposSeleccionarRubroEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleado(Boolean conFk) throws Exception  {
		return RubroEmpleadoConstantesFunciones.getTiposSeleccionarRubroEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleadoConstantesFunciones.LABEL_IDESTADORUBRO);
			reporte.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_IDESTADORUBRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleadoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RubroEmpleadoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRubroEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmpleado(RubroEmpleado rubroempleadoAux) throws Exception {
		
			rubroempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleadoAux.getEmpresa()));
			rubroempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(rubroempleadoAux.getEmpleado()));
			rubroempleadoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroempleadoAux.getRubroEmplea()));
			rubroempleadoAux.setestadorubro_descripcion(EstadoRubroConstantesFunciones.getEstadoRubroDescripcion(rubroempleadoAux.getEstadoRubro()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmpleado(List<RubroEmpleado> rubroempleadosTemp) throws Exception {
		for(RubroEmpleado rubroempleadoAux:rubroempleadosTemp) {
			
			rubroempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleadoAux.getEmpresa()));
			rubroempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(rubroempleadoAux.getEmpleado()));
			rubroempleadoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroempleadoAux.getRubroEmplea()));
			rubroempleadoAux.setestadorubro_descripcion(EstadoRubroConstantesFunciones.getEstadoRubroDescripcion(rubroempleadoAux.getEstadoRubro()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(EstadoRubro.class));
				
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
					if(clas.clas.equals(EstadoRubro.class)) {
						classes.add(new Classe(EstadoRubro.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRubroEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(EstadoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRubro.class)); continue;
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

					if(EstadoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRubro.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleadoConstantesFunciones.getClassesRelationshipsOfRubroEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfRubroEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RubroEmpleado rubroempleado,List<RubroEmpleado> rubroempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RubroEmpleado rubroempleadoEncontrado=null;
			
			for(RubroEmpleado rubroempleadoLocal:rubroempleados) {
				if(rubroempleadoLocal.getId().equals(rubroempleado.getId())) {
					rubroempleadoEncontrado=rubroempleadoLocal;
					
					rubroempleadoLocal.setIsChanged(rubroempleado.getIsChanged());
					rubroempleadoLocal.setIsNew(rubroempleado.getIsNew());
					rubroempleadoLocal.setIsDeleted(rubroempleado.getIsDeleted());
					
					rubroempleadoLocal.setGeneralEntityOriginal(rubroempleado.getGeneralEntityOriginal());
					
					rubroempleadoLocal.setId(rubroempleado.getId());	
					rubroempleadoLocal.setVersionRow(rubroempleado.getVersionRow());	
					rubroempleadoLocal.setid_empresa(rubroempleado.getid_empresa());	
					rubroempleadoLocal.setid_empleado(rubroempleado.getid_empleado());	
					rubroempleadoLocal.setid_rubro_emplea(rubroempleado.getid_rubro_emplea());	
					rubroempleadoLocal.setid_estado_rubro(rubroempleado.getid_estado_rubro());	
					rubroempleadoLocal.setvalor(rubroempleado.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!rubroempleado.getIsDeleted()) {
				if(!existe) {
					rubroempleados.add(rubroempleado);
				}
			} else {
				if(rubroempleadoEncontrado!=null && permiteQuitar)  {
					rubroempleados.remove(rubroempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RubroEmpleado rubroempleado,List<RubroEmpleado> rubroempleados) throws Exception {
		try	{			
			for(RubroEmpleado rubroempleadoLocal:rubroempleados) {
				if(rubroempleadoLocal.getId().equals(rubroempleado.getId())) {
					rubroempleadoLocal.setIsSelected(rubroempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRubroEmpleado(List<RubroEmpleado> rubroempleadosAux) throws Exception {
		//this.rubroempleadosAux=rubroempleadosAux;
		
		for(RubroEmpleado rubroempleadoAux:rubroempleadosAux) {
			if(rubroempleadoAux.getIsChanged()) {
				rubroempleadoAux.setIsChanged(false);
			}		
			
			if(rubroempleadoAux.getIsNew()) {
				rubroempleadoAux.setIsNew(false);
			}	
			
			if(rubroempleadoAux.getIsDeleted()) {
				rubroempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRubroEmpleado(RubroEmpleado rubroempleadoAux) throws Exception {
		//this.rubroempleadoAux=rubroempleadoAux;
		
			if(rubroempleadoAux.getIsChanged()) {
				rubroempleadoAux.setIsChanged(false);
			}		
			
			if(rubroempleadoAux.getIsNew()) {
				rubroempleadoAux.setIsNew(false);
			}	
			
			if(rubroempleadoAux.getIsDeleted()) {
				rubroempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RubroEmpleado rubroempleadoAsignar,RubroEmpleado rubroempleado) throws Exception {
		rubroempleadoAsignar.setId(rubroempleado.getId());	
		rubroempleadoAsignar.setVersionRow(rubroempleado.getVersionRow());	
		rubroempleadoAsignar.setid_empresa(rubroempleado.getid_empresa());
		rubroempleadoAsignar.setempresa_descripcion(rubroempleado.getempresa_descripcion());	
		rubroempleadoAsignar.setid_empleado(rubroempleado.getid_empleado());
		rubroempleadoAsignar.setempleado_descripcion(rubroempleado.getempleado_descripcion());	
		rubroempleadoAsignar.setid_rubro_emplea(rubroempleado.getid_rubro_emplea());
		rubroempleadoAsignar.setrubroemplea_descripcion(rubroempleado.getrubroemplea_descripcion());	
		rubroempleadoAsignar.setid_estado_rubro(rubroempleado.getid_estado_rubro());
		rubroempleadoAsignar.setestadorubro_descripcion(rubroempleado.getestadorubro_descripcion());	
		rubroempleadoAsignar.setvalor(rubroempleado.getvalor());	
	}
	
	public static void inicializarRubroEmpleado(RubroEmpleado rubroempleado) throws Exception {
		try {
				rubroempleado.setId(0L);	
					
				rubroempleado.setid_empresa(-1L);	
				rubroempleado.setid_empleado(-1L);	
				rubroempleado.setid_rubro_emplea(-1L);	
				rubroempleado.setid_estado_rubro(-1L);	
				rubroempleado.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRubroEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleadoConstantesFunciones.LABEL_IDESTADORUBRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleadoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRubroEmpleado(String sTipo,Row row,Workbook workbook,RubroEmpleado rubroempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleado.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleado.getestadorubro_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroempleado.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRubroEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRubroEmpleado() {
		return this.sFinalQueryRubroEmpleado;
	}
	
	public void setsFinalQueryRubroEmpleado(String sFinalQueryRubroEmpleado) {
		this.sFinalQueryRubroEmpleado= sFinalQueryRubroEmpleado;
	}
	
	public Border resaltarSeleccionarRubroEmpleado=null;
	
	public Border setResaltarSeleccionarRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRubroEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRubroEmpleado() {
		return this.resaltarSeleccionarRubroEmpleado;
	}
	
	public void setResaltarSeleccionarRubroEmpleado(Border borderResaltarSeleccionarRubroEmpleado) {
		this.resaltarSeleccionarRubroEmpleado= borderResaltarSeleccionarRubroEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRubroEmpleado=null;
	public Boolean mostraridRubroEmpleado=true;
	public Boolean activaridRubroEmpleado=true;

	public Border resaltarid_empresaRubroEmpleado=null;
	public Boolean mostrarid_empresaRubroEmpleado=true;
	public Boolean activarid_empresaRubroEmpleado=true;
	public Boolean cargarid_empresaRubroEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRubroEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoRubroEmpleado=null;
	public Boolean mostrarid_empleadoRubroEmpleado=true;
	public Boolean activarid_empleadoRubroEmpleado=true;
	public Boolean cargarid_empleadoRubroEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoRubroEmpleado=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaRubroEmpleado=null;
	public Boolean mostrarid_rubro_empleaRubroEmpleado=true;
	public Boolean activarid_rubro_empleaRubroEmpleado=true;
	public Boolean cargarid_rubro_empleaRubroEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaRubroEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estado_rubroRubroEmpleado=null;
	public Boolean mostrarid_estado_rubroRubroEmpleado=true;
	public Boolean activarid_estado_rubroRubroEmpleado=true;
	public Boolean cargarid_estado_rubroRubroEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_rubroRubroEmpleado=false;//ConEventDepend=true

	public Border resaltarvalorRubroEmpleado=null;
	public Boolean mostrarvalorRubroEmpleado=true;
	public Boolean activarvalorRubroEmpleado=true;

	
	

	public Border setResaltaridRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltaridRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRubroEmpleado() {
		return this.resaltaridRubroEmpleado;
	}

	public void setResaltaridRubroEmpleado(Border borderResaltar) {
		this.resaltaridRubroEmpleado= borderResaltar;
	}

	public Boolean getMostraridRubroEmpleado() {
		return this.mostraridRubroEmpleado;
	}

	public void setMostraridRubroEmpleado(Boolean mostraridRubroEmpleado) {
		this.mostraridRubroEmpleado= mostraridRubroEmpleado;
	}

	public Boolean getActivaridRubroEmpleado() {
		return this.activaridRubroEmpleado;
	}

	public void setActivaridRubroEmpleado(Boolean activaridRubroEmpleado) {
		this.activaridRubroEmpleado= activaridRubroEmpleado;
	}

	public Border setResaltarid_empresaRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRubroEmpleado() {
		return this.resaltarid_empresaRubroEmpleado;
	}

	public void setResaltarid_empresaRubroEmpleado(Border borderResaltar) {
		this.resaltarid_empresaRubroEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaRubroEmpleado() {
		return this.mostrarid_empresaRubroEmpleado;
	}

	public void setMostrarid_empresaRubroEmpleado(Boolean mostrarid_empresaRubroEmpleado) {
		this.mostrarid_empresaRubroEmpleado= mostrarid_empresaRubroEmpleado;
	}

	public Boolean getActivarid_empresaRubroEmpleado() {
		return this.activarid_empresaRubroEmpleado;
	}

	public void setActivarid_empresaRubroEmpleado(Boolean activarid_empresaRubroEmpleado) {
		this.activarid_empresaRubroEmpleado= activarid_empresaRubroEmpleado;
	}

	public Boolean getCargarid_empresaRubroEmpleado() {
		return this.cargarid_empresaRubroEmpleado;
	}

	public void setCargarid_empresaRubroEmpleado(Boolean cargarid_empresaRubroEmpleado) {
		this.cargarid_empresaRubroEmpleado= cargarid_empresaRubroEmpleado;
	}

	public Border setResaltarid_empleadoRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoRubroEmpleado() {
		return this.resaltarid_empleadoRubroEmpleado;
	}

	public void setResaltarid_empleadoRubroEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoRubroEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoRubroEmpleado() {
		return this.mostrarid_empleadoRubroEmpleado;
	}

	public void setMostrarid_empleadoRubroEmpleado(Boolean mostrarid_empleadoRubroEmpleado) {
		this.mostrarid_empleadoRubroEmpleado= mostrarid_empleadoRubroEmpleado;
	}

	public Boolean getActivarid_empleadoRubroEmpleado() {
		return this.activarid_empleadoRubroEmpleado;
	}

	public void setActivarid_empleadoRubroEmpleado(Boolean activarid_empleadoRubroEmpleado) {
		this.activarid_empleadoRubroEmpleado= activarid_empleadoRubroEmpleado;
	}

	public Boolean getCargarid_empleadoRubroEmpleado() {
		return this.cargarid_empleadoRubroEmpleado;
	}

	public void setCargarid_empleadoRubroEmpleado(Boolean cargarid_empleadoRubroEmpleado) {
		this.cargarid_empleadoRubroEmpleado= cargarid_empleadoRubroEmpleado;
	}

	public Border setResaltarid_rubro_empleaRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaRubroEmpleado() {
		return this.resaltarid_rubro_empleaRubroEmpleado;
	}

	public void setResaltarid_rubro_empleaRubroEmpleado(Border borderResaltar) {
		this.resaltarid_rubro_empleaRubroEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaRubroEmpleado() {
		return this.mostrarid_rubro_empleaRubroEmpleado;
	}

	public void setMostrarid_rubro_empleaRubroEmpleado(Boolean mostrarid_rubro_empleaRubroEmpleado) {
		this.mostrarid_rubro_empleaRubroEmpleado= mostrarid_rubro_empleaRubroEmpleado;
	}

	public Boolean getActivarid_rubro_empleaRubroEmpleado() {
		return this.activarid_rubro_empleaRubroEmpleado;
	}

	public void setActivarid_rubro_empleaRubroEmpleado(Boolean activarid_rubro_empleaRubroEmpleado) {
		this.activarid_rubro_empleaRubroEmpleado= activarid_rubro_empleaRubroEmpleado;
	}

	public Boolean getCargarid_rubro_empleaRubroEmpleado() {
		return this.cargarid_rubro_empleaRubroEmpleado;
	}

	public void setCargarid_rubro_empleaRubroEmpleado(Boolean cargarid_rubro_empleaRubroEmpleado) {
		this.cargarid_rubro_empleaRubroEmpleado= cargarid_rubro_empleaRubroEmpleado;
	}

	public Border setResaltarid_estado_rubroRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estado_rubroRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_rubroRubroEmpleado() {
		return this.resaltarid_estado_rubroRubroEmpleado;
	}

	public void setResaltarid_estado_rubroRubroEmpleado(Border borderResaltar) {
		this.resaltarid_estado_rubroRubroEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estado_rubroRubroEmpleado() {
		return this.mostrarid_estado_rubroRubroEmpleado;
	}

	public void setMostrarid_estado_rubroRubroEmpleado(Boolean mostrarid_estado_rubroRubroEmpleado) {
		this.mostrarid_estado_rubroRubroEmpleado= mostrarid_estado_rubroRubroEmpleado;
	}

	public Boolean getActivarid_estado_rubroRubroEmpleado() {
		return this.activarid_estado_rubroRubroEmpleado;
	}

	public void setActivarid_estado_rubroRubroEmpleado(Boolean activarid_estado_rubroRubroEmpleado) {
		this.activarid_estado_rubroRubroEmpleado= activarid_estado_rubroRubroEmpleado;
	}

	public Boolean getCargarid_estado_rubroRubroEmpleado() {
		return this.cargarid_estado_rubroRubroEmpleado;
	}

	public void setCargarid_estado_rubroRubroEmpleado(Boolean cargarid_estado_rubroRubroEmpleado) {
		this.cargarid_estado_rubroRubroEmpleado= cargarid_estado_rubroRubroEmpleado;
	}

	public Border setResaltarvalorRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleadoBeanSwingJInternalFrame.jTtoolBarRubroEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalorRubroEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRubroEmpleado() {
		return this.resaltarvalorRubroEmpleado;
	}

	public void setResaltarvalorRubroEmpleado(Border borderResaltar) {
		this.resaltarvalorRubroEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalorRubroEmpleado() {
		return this.mostrarvalorRubroEmpleado;
	}

	public void setMostrarvalorRubroEmpleado(Boolean mostrarvalorRubroEmpleado) {
		this.mostrarvalorRubroEmpleado= mostrarvalorRubroEmpleado;
	}

	public Boolean getActivarvalorRubroEmpleado() {
		return this.activarvalorRubroEmpleado;
	}

	public void setActivarvalorRubroEmpleado(Boolean activarvalorRubroEmpleado) {
		this.activarvalorRubroEmpleado= activarvalorRubroEmpleado;
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
		
		
		this.setMostraridRubroEmpleado(esInicial);
		this.setMostrarid_empresaRubroEmpleado(esInicial);
		this.setMostrarid_empleadoRubroEmpleado(esInicial);
		this.setMostrarid_rubro_empleaRubroEmpleado(esInicial);
		this.setMostrarid_estado_rubroRubroEmpleado(esInicial);
		this.setMostrarvalorRubroEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.ID)) {
				this.setMostraridRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDESTADORUBRO)) {
				this.setMostrarid_estado_rubroRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.VALOR)) {
				this.setMostrarvalorRubroEmpleado(esAsigna);
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
		
		
		this.setActivaridRubroEmpleado(esInicial);
		this.setActivarid_empresaRubroEmpleado(esInicial);
		this.setActivarid_empleadoRubroEmpleado(esInicial);
		this.setActivarid_rubro_empleaRubroEmpleado(esInicial);
		this.setActivarid_estado_rubroRubroEmpleado(esInicial);
		this.setActivarvalorRubroEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.ID)) {
				this.setActivaridRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDESTADORUBRO)) {
				this.setActivarid_estado_rubroRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.VALOR)) {
				this.setActivarvalorRubroEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRubroEmpleado(esInicial);
		this.setResaltarid_empresaRubroEmpleado(esInicial);
		this.setResaltarid_empleadoRubroEmpleado(esInicial);
		this.setResaltarid_rubro_empleaRubroEmpleado(esInicial);
		this.setResaltarid_estado_rubroRubroEmpleado(esInicial);
		this.setResaltarvalorRubroEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.IDESTADORUBRO)) {
				this.setResaltarid_estado_rubroRubroEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleadoConstantesFunciones.VALOR)) {
				this.setResaltarvalorRubroEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoRubroEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoRubroEmpleado() {
		return this.mostrarFK_IdEmpleadoRubroEmpleado;
	}

	public void setMostrarFK_IdEmpleadoRubroEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoRubroEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRubroEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaRubroEmpleado() {
		return this.mostrarFK_IdEmpresaRubroEmpleado;
	}

	public void setMostrarFK_IdEmpresaRubroEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRubroEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoRubroRubroEmpleado=true;

	public Boolean getMostrarFK_IdEstadoRubroRubroEmpleado() {
		return this.mostrarFK_IdEstadoRubroRubroEmpleado;
	}

	public void setMostrarFK_IdEstadoRubroRubroEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoRubroRubroEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaRubroEmpleado=true;

	public Boolean getMostrarFK_IdRubroEmpleaRubroEmpleado() {
		return this.mostrarFK_IdRubroEmpleaRubroEmpleado;
	}

	public void setMostrarFK_IdRubroEmpleaRubroEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaRubroEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoRubroEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoRubroEmpleado() {
		return this.activarFK_IdEmpleadoRubroEmpleado;
	}

	public void setActivarFK_IdEmpleadoRubroEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoRubroEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRubroEmpleado=true;

	public Boolean getActivarFK_IdEmpresaRubroEmpleado() {
		return this.activarFK_IdEmpresaRubroEmpleado;
	}

	public void setActivarFK_IdEmpresaRubroEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRubroEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoRubroRubroEmpleado=true;

	public Boolean getActivarFK_IdEstadoRubroRubroEmpleado() {
		return this.activarFK_IdEstadoRubroRubroEmpleado;
	}

	public void setActivarFK_IdEstadoRubroRubroEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoRubroRubroEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaRubroEmpleado=true;

	public Boolean getActivarFK_IdRubroEmpleaRubroEmpleado() {
		return this.activarFK_IdRubroEmpleaRubroEmpleado;
	}

	public void setActivarFK_IdRubroEmpleaRubroEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaRubroEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoRubroEmpleado=null;

	public Border getResaltarFK_IdEmpleadoRubroEmpleado() {
		return this.resaltarFK_IdEmpleadoRubroEmpleado;
	}

	public void setResaltarFK_IdEmpleadoRubroEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoRubroEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoRubroEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRubroEmpleado=null;

	public Border getResaltarFK_IdEmpresaRubroEmpleado() {
		return this.resaltarFK_IdEmpresaRubroEmpleado;
	}

	public void setResaltarFK_IdEmpresaRubroEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRubroEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRubroEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstadoRubroRubroEmpleado=null;

	public Border getResaltarFK_IdEstadoRubroRubroEmpleado() {
		return this.resaltarFK_IdEstadoRubroRubroEmpleado;
	}

	public void setResaltarFK_IdEstadoRubroRubroEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstadoRubroRubroEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstadoRubroRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoRubroRubroEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaRubroEmpleado=null;

	public Border getResaltarFK_IdRubroEmpleaRubroEmpleado() {
		return this.resaltarFK_IdRubroEmpleaRubroEmpleado;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEmpleado(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaRubroEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleadoBeanSwingJInternalFrame rubroempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaRubroEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}