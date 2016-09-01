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


import com.bydan.erp.nomina.util.EmpleadoConstanteConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoConstanteParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoConstanteParameterGeneral;

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
final public class EmpleadoConstanteConstantesFunciones extends EmpleadoConstanteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoConstante";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoConstante"+EmpleadoConstanteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoConstanteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoConstanteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoConstanteConstantesFunciones.SCHEMA+"_"+EmpleadoConstanteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoConstanteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoConstanteConstantesFunciones.SCHEMA+"_"+EmpleadoConstanteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoConstanteConstantesFunciones.SCHEMA+"_"+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoConstanteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoConstanteConstantesFunciones.SCHEMA+"_"+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoConstanteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoConstanteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoConstanteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoConstanteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoConstanteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoConstanteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoConstanteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Constantes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Constante";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Constante";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoConstante";
	public static final String OBJECTNAME="empleadoconstante";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_constante";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoconstante from "+EmpleadoConstanteConstantesFunciones.SPERSISTENCENAME+" empleadoconstante";
	public static String QUERYSELECTNATIVE="select "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".version_row,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_constante_nomi,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".valor,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".esta_activo from "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstanteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoConstanteConstantesFuncionesAdditional empleadoconstanteConstantesFuncionesAdditional=null;
	
	public EmpleadoConstanteConstantesFuncionesAdditional getEmpleadoConstanteConstantesFuncionesAdditional() {
		return this.empleadoconstanteConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoConstanteConstantesFuncionesAdditional(EmpleadoConstanteConstantesFuncionesAdditional empleadoconstanteConstantesFuncionesAdditional) {
		try {
			this.empleadoconstanteConstantesFuncionesAdditional=empleadoconstanteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDCONSTANTENOMI= "id_constante_nomi";
    public static final String VALOR= "valor";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDCONSTANTENOMI= "Constante Nomi";
		public static final String LABEL_IDCONSTANTENOMI_LOWER= "Constante Nomi";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	
	public static String getEmpleadoConstanteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoConstanteConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoConstanteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoConstanteConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoConstanteConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI)) {sLabelColumna=EmpleadoConstanteConstantesFunciones.LABEL_IDCONSTANTENOMI;}
		if(sNombreColumna.equals(EmpleadoConstanteConstantesFunciones.VALOR)) {sLabelColumna=EmpleadoConstanteConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(EmpleadoConstanteConstantesFunciones.ESTAACTIVO)) {sLabelColumna=EmpleadoConstanteConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(EmpleadoConstante empleadoconstante) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoconstante.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(EmpleadoConstante empleadoconstante) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoconstante.getId(),empleadoconstante.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getEmpleadoConstanteDescripcion(EmpleadoConstante empleadoconstante) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoconstante !=null/* && empleadoconstante.getId()!=0*/) {
			if(empleadoconstante.getId()!=null) {
				sDescripcion=empleadoconstante.getId().toString();
			}//empleadoconstanteempleadoconstante.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoConstanteDescripcionDetallado(EmpleadoConstante empleadoconstante) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoConstanteConstantesFunciones.ID+"=";
		sDescripcion+=empleadoconstante.getId().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoconstante.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoconstante.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoconstante.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI+"=";
		sDescripcion+=empleadoconstante.getid_constante_nomi().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.VALOR+"=";
		sDescripcion+=empleadoconstante.getvalor().toString()+",";
		sDescripcion+=EmpleadoConstanteConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=empleadoconstante.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoConstanteDescripcion(EmpleadoConstante empleadoconstante,String sValor) throws Exception {			
		if(empleadoconstante !=null) {
			//empleadoconstanteempleadoconstante.getId().toString();
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

	public static String getConstanteNomiDescripcion(ConstanteNomi constantenomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(constantenomi!=null/*&&constantenomi.getId()>0*/) {
			sDescripcion=ConstanteNomiConstantesFunciones.getConstanteNomiDescripcion(constantenomi);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdConstanteNomi")) {
			sNombreIndice="Tipo=  Por Constante Nomi";
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

	public static String getDetalleIndiceFK_IdConstanteNomi(Long id_constante_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_constante_nomi!=null) {sDetalleIndice+=" Codigo Unico De Constante Nomi="+id_constante_nomi.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoConstante(EmpleadoConstante empleadoconstante,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoConstante empleadoconstante: empleadoconstantes) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoConstante(EmpleadoConstante empleadoconstante,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoconstante.getConCambioAuxiliar()) {
			empleadoconstante.setIsDeleted(empleadoconstante.getIsDeletedAuxiliar());	
			empleadoconstante.setIsNew(empleadoconstante.getIsNewAuxiliar());	
			empleadoconstante.setIsChanged(empleadoconstante.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoconstante.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoconstante.setIsDeletedAuxiliar(false);	
			empleadoconstante.setIsNewAuxiliar(false);	
			empleadoconstante.setIsChangedAuxiliar(false);
			
			empleadoconstante.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoConstante empleadoconstante : empleadoconstantes) {
			if(conAsignarBase && empleadoconstante.getConCambioAuxiliar()) {
				empleadoconstante.setIsDeleted(empleadoconstante.getIsDeletedAuxiliar());	
				empleadoconstante.setIsNew(empleadoconstante.getIsNewAuxiliar());	
				empleadoconstante.setIsChanged(empleadoconstante.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoconstante.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoconstante.setIsDeletedAuxiliar(false);	
				empleadoconstante.setIsNewAuxiliar(false);	
				empleadoconstante.setIsChangedAuxiliar(false);
				
				empleadoconstante.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoConstante(EmpleadoConstante empleadoconstante,Boolean conEnteros) throws Exception  {
		empleadoconstante.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoConstante empleadoconstante: empleadoconstantes) {
			empleadoconstante.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoConstante(List<EmpleadoConstante> empleadoconstantes,EmpleadoConstante empleadoconstanteAux) throws Exception  {
		EmpleadoConstanteConstantesFunciones.InicializarValoresEmpleadoConstante(empleadoconstanteAux,true);
		
		for(EmpleadoConstante empleadoconstante: empleadoconstantes) {
			if(empleadoconstante.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoconstanteAux.setvalor(empleadoconstanteAux.getvalor()+empleadoconstante.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoConstante(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoConstanteConstantesFunciones.getArrayColumnasGlobalesEmpleadoConstante(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoConstante(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoConstanteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoConstanteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoConstante(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoConstante> empleadoconstantes,EmpleadoConstante empleadoconstante,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoConstante empleadoconstanteAux: empleadoconstantes) {
			if(empleadoconstanteAux!=null && empleadoconstante!=null) {
				if((empleadoconstanteAux.getId()==null && empleadoconstante.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoconstanteAux.getId()!=null && empleadoconstante.getId()!=null){
					if(empleadoconstanteAux.getId().equals(empleadoconstante.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoConstante(List<EmpleadoConstante> empleadoconstantes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(EmpleadoConstante empleadoconstante: empleadoconstantes) {			
			if(empleadoconstante.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=empleadoconstante.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoConstanteConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoConstante() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_ID, EmpleadoConstanteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_VERSIONROW, EmpleadoConstanteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_IDEMPRESA, EmpleadoConstanteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoConstanteConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_IDCONSTANTENOMI, EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_VALOR, EmpleadoConstanteConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoConstanteConstantesFunciones.LABEL_ESTAACTIVO, EmpleadoConstanteConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoConstante() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoConstanteConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoConstante() throws Exception  {
		return EmpleadoConstanteConstantesFunciones.getTiposSeleccionarEmpleadoConstante(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoConstante(Boolean conFk) throws Exception  {
		return EmpleadoConstanteConstantesFunciones.getTiposSeleccionarEmpleadoConstante(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoConstante(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstanteConstantesFunciones.LABEL_IDCONSTANTENOMI);
			reporte.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_IDCONSTANTENOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstanteConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoConstanteConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(EmpleadoConstanteConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoConstante(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoConstante(EmpleadoConstante empleadoconstanteAux) throws Exception {
		
			empleadoconstanteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoconstanteAux.getEmpresa()));
			empleadoconstanteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoconstanteAux.getEmpleado()));
			empleadoconstanteAux.setconstantenomi_descripcion(ConstanteNomiConstantesFunciones.getConstanteNomiDescripcion(empleadoconstanteAux.getConstanteNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoConstante(List<EmpleadoConstante> empleadoconstantesTemp) throws Exception {
		for(EmpleadoConstante empleadoconstanteAux:empleadoconstantesTemp) {
			
			empleadoconstanteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoconstanteAux.getEmpresa()));
			empleadoconstanteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoconstanteAux.getEmpleado()));
			empleadoconstanteAux.setconstantenomi_descripcion(ConstanteNomiConstantesFunciones.getConstanteNomiDescripcion(empleadoconstanteAux.getConstanteNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoConstante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(ConstanteNomi.class));
				
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
					if(clas.clas.equals(ConstanteNomi.class)) {
						classes.add(new Classe(ConstanteNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoConstante(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(ConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConstanteNomi.class)); continue;
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

					if(ConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConstanteNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoConstante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoConstanteConstantesFunciones.getClassesRelationshipsOfEmpleadoConstante(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoConstante(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoConstante(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoConstanteConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoConstante(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoConstante(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoConstante empleadoconstante,List<EmpleadoConstante> empleadoconstantes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoConstante empleadoconstanteEncontrado=null;
			
			for(EmpleadoConstante empleadoconstanteLocal:empleadoconstantes) {
				if(empleadoconstanteLocal.getId().equals(empleadoconstante.getId())) {
					empleadoconstanteEncontrado=empleadoconstanteLocal;
					
					empleadoconstanteLocal.setIsChanged(empleadoconstante.getIsChanged());
					empleadoconstanteLocal.setIsNew(empleadoconstante.getIsNew());
					empleadoconstanteLocal.setIsDeleted(empleadoconstante.getIsDeleted());
					
					empleadoconstanteLocal.setGeneralEntityOriginal(empleadoconstante.getGeneralEntityOriginal());
					
					empleadoconstanteLocal.setId(empleadoconstante.getId());	
					empleadoconstanteLocal.setVersionRow(empleadoconstante.getVersionRow());	
					empleadoconstanteLocal.setid_empresa(empleadoconstante.getid_empresa());	
					empleadoconstanteLocal.setid_empleado(empleadoconstante.getid_empleado());	
					empleadoconstanteLocal.setid_constante_nomi(empleadoconstante.getid_constante_nomi());	
					empleadoconstanteLocal.setvalor(empleadoconstante.getvalor());	
					empleadoconstanteLocal.setesta_activo(empleadoconstante.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoconstante.getIsDeleted()) {
				if(!existe) {
					empleadoconstantes.add(empleadoconstante);
				}
			} else {
				if(empleadoconstanteEncontrado!=null && permiteQuitar)  {
					empleadoconstantes.remove(empleadoconstanteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoConstante empleadoconstante,List<EmpleadoConstante> empleadoconstantes) throws Exception {
		try	{			
			for(EmpleadoConstante empleadoconstanteLocal:empleadoconstantes) {
				if(empleadoconstanteLocal.getId().equals(empleadoconstante.getId())) {
					empleadoconstanteLocal.setIsSelected(empleadoconstante.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoConstante(List<EmpleadoConstante> empleadoconstantesAux) throws Exception {
		//this.empleadoconstantesAux=empleadoconstantesAux;
		
		for(EmpleadoConstante empleadoconstanteAux:empleadoconstantesAux) {
			if(empleadoconstanteAux.getIsChanged()) {
				empleadoconstanteAux.setIsChanged(false);
			}		
			
			if(empleadoconstanteAux.getIsNew()) {
				empleadoconstanteAux.setIsNew(false);
			}	
			
			if(empleadoconstanteAux.getIsDeleted()) {
				empleadoconstanteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoConstante(EmpleadoConstante empleadoconstanteAux) throws Exception {
		//this.empleadoconstanteAux=empleadoconstanteAux;
		
			if(empleadoconstanteAux.getIsChanged()) {
				empleadoconstanteAux.setIsChanged(false);
			}		
			
			if(empleadoconstanteAux.getIsNew()) {
				empleadoconstanteAux.setIsNew(false);
			}	
			
			if(empleadoconstanteAux.getIsDeleted()) {
				empleadoconstanteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoConstante empleadoconstanteAsignar,EmpleadoConstante empleadoconstante) throws Exception {
		empleadoconstanteAsignar.setId(empleadoconstante.getId());	
		empleadoconstanteAsignar.setVersionRow(empleadoconstante.getVersionRow());	
		empleadoconstanteAsignar.setid_empresa(empleadoconstante.getid_empresa());
		empleadoconstanteAsignar.setempresa_descripcion(empleadoconstante.getempresa_descripcion());	
		empleadoconstanteAsignar.setid_empleado(empleadoconstante.getid_empleado());
		empleadoconstanteAsignar.setempleado_descripcion(empleadoconstante.getempleado_descripcion());	
		empleadoconstanteAsignar.setid_constante_nomi(empleadoconstante.getid_constante_nomi());
		empleadoconstanteAsignar.setconstantenomi_descripcion(empleadoconstante.getconstantenomi_descripcion());	
		empleadoconstanteAsignar.setvalor(empleadoconstante.getvalor());	
		empleadoconstanteAsignar.setesta_activo(empleadoconstante.getesta_activo());	
	}
	
	public static void inicializarEmpleadoConstante(EmpleadoConstante empleadoconstante) throws Exception {
		try {
				empleadoconstante.setId(0L);	
					
				empleadoconstante.setid_empresa(-1L);	
				empleadoconstante.setid_empleado(-1L);	
				empleadoconstante.setid_constante_nomi(-1L);	
				empleadoconstante.setvalor(0.0);	
				empleadoconstante.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoConstante(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstanteConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstanteConstantesFunciones.LABEL_IDCONSTANTENOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstanteConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoConstanteConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoConstante(String sTipo,Row row,Workbook workbook,EmpleadoConstante empleadoconstante,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoconstante.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoconstante.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoconstante.getconstantenomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoconstante.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoconstante.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoConstante=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoConstante() {
		return this.sFinalQueryEmpleadoConstante;
	}
	
	public void setsFinalQueryEmpleadoConstante(String sFinalQueryEmpleadoConstante) {
		this.sFinalQueryEmpleadoConstante= sFinalQueryEmpleadoConstante;
	}
	
	public Border resaltarSeleccionarEmpleadoConstante=null;
	
	public Border setResaltarSeleccionarEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoConstante= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoConstante() {
		return this.resaltarSeleccionarEmpleadoConstante;
	}
	
	public void setResaltarSeleccionarEmpleadoConstante(Border borderResaltarSeleccionarEmpleadoConstante) {
		this.resaltarSeleccionarEmpleadoConstante= borderResaltarSeleccionarEmpleadoConstante;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoConstante=null;
	public Boolean mostraridEmpleadoConstante=true;
	public Boolean activaridEmpleadoConstante=true;

	public Border resaltarid_empresaEmpleadoConstante=null;
	public Boolean mostrarid_empresaEmpleadoConstante=true;
	public Boolean activarid_empresaEmpleadoConstante=true;
	public Boolean cargarid_empresaEmpleadoConstante=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoConstante=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoConstante=null;
	public Boolean mostrarid_empleadoEmpleadoConstante=true;
	public Boolean activarid_empleadoEmpleadoConstante=true;
	public Boolean cargarid_empleadoEmpleadoConstante=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoConstante=false;//ConEventDepend=true

	public Border resaltarid_constante_nomiEmpleadoConstante=null;
	public Boolean mostrarid_constante_nomiEmpleadoConstante=true;
	public Boolean activarid_constante_nomiEmpleadoConstante=true;
	public Boolean cargarid_constante_nomiEmpleadoConstante=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_constante_nomiEmpleadoConstante=false;//ConEventDepend=true

	public Border resaltarvalorEmpleadoConstante=null;
	public Boolean mostrarvalorEmpleadoConstante=true;
	public Boolean activarvalorEmpleadoConstante=true;

	public Border resaltaresta_activoEmpleadoConstante=null;
	public Boolean mostraresta_activoEmpleadoConstante=true;
	public Boolean activaresta_activoEmpleadoConstante=true;

	
	

	public Border setResaltaridEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoConstante() {
		return this.resaltaridEmpleadoConstante;
	}

	public void setResaltaridEmpleadoConstante(Border borderResaltar) {
		this.resaltaridEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostraridEmpleadoConstante() {
		return this.mostraridEmpleadoConstante;
	}

	public void setMostraridEmpleadoConstante(Boolean mostraridEmpleadoConstante) {
		this.mostraridEmpleadoConstante= mostraridEmpleadoConstante;
	}

	public Boolean getActivaridEmpleadoConstante() {
		return this.activaridEmpleadoConstante;
	}

	public void setActivaridEmpleadoConstante(Boolean activaridEmpleadoConstante) {
		this.activaridEmpleadoConstante= activaridEmpleadoConstante;
	}

	public Border setResaltarid_empresaEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoConstante() {
		return this.resaltarid_empresaEmpleadoConstante;
	}

	public void setResaltarid_empresaEmpleadoConstante(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoConstante() {
		return this.mostrarid_empresaEmpleadoConstante;
	}

	public void setMostrarid_empresaEmpleadoConstante(Boolean mostrarid_empresaEmpleadoConstante) {
		this.mostrarid_empresaEmpleadoConstante= mostrarid_empresaEmpleadoConstante;
	}

	public Boolean getActivarid_empresaEmpleadoConstante() {
		return this.activarid_empresaEmpleadoConstante;
	}

	public void setActivarid_empresaEmpleadoConstante(Boolean activarid_empresaEmpleadoConstante) {
		this.activarid_empresaEmpleadoConstante= activarid_empresaEmpleadoConstante;
	}

	public Boolean getCargarid_empresaEmpleadoConstante() {
		return this.cargarid_empresaEmpleadoConstante;
	}

	public void setCargarid_empresaEmpleadoConstante(Boolean cargarid_empresaEmpleadoConstante) {
		this.cargarid_empresaEmpleadoConstante= cargarid_empresaEmpleadoConstante;
	}

	public Border setResaltarid_empleadoEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoConstante() {
		return this.resaltarid_empleadoEmpleadoConstante;
	}

	public void setResaltarid_empleadoEmpleadoConstante(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoConstante() {
		return this.mostrarid_empleadoEmpleadoConstante;
	}

	public void setMostrarid_empleadoEmpleadoConstante(Boolean mostrarid_empleadoEmpleadoConstante) {
		this.mostrarid_empleadoEmpleadoConstante= mostrarid_empleadoEmpleadoConstante;
	}

	public Boolean getActivarid_empleadoEmpleadoConstante() {
		return this.activarid_empleadoEmpleadoConstante;
	}

	public void setActivarid_empleadoEmpleadoConstante(Boolean activarid_empleadoEmpleadoConstante) {
		this.activarid_empleadoEmpleadoConstante= activarid_empleadoEmpleadoConstante;
	}

	public Boolean getCargarid_empleadoEmpleadoConstante() {
		return this.cargarid_empleadoEmpleadoConstante;
	}

	public void setCargarid_empleadoEmpleadoConstante(Boolean cargarid_empleadoEmpleadoConstante) {
		this.cargarid_empleadoEmpleadoConstante= cargarid_empleadoEmpleadoConstante;
	}

	public Border setResaltarid_constante_nomiEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltarid_constante_nomiEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_constante_nomiEmpleadoConstante() {
		return this.resaltarid_constante_nomiEmpleadoConstante;
	}

	public void setResaltarid_constante_nomiEmpleadoConstante(Border borderResaltar) {
		this.resaltarid_constante_nomiEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostrarid_constante_nomiEmpleadoConstante() {
		return this.mostrarid_constante_nomiEmpleadoConstante;
	}

	public void setMostrarid_constante_nomiEmpleadoConstante(Boolean mostrarid_constante_nomiEmpleadoConstante) {
		this.mostrarid_constante_nomiEmpleadoConstante= mostrarid_constante_nomiEmpleadoConstante;
	}

	public Boolean getActivarid_constante_nomiEmpleadoConstante() {
		return this.activarid_constante_nomiEmpleadoConstante;
	}

	public void setActivarid_constante_nomiEmpleadoConstante(Boolean activarid_constante_nomiEmpleadoConstante) {
		this.activarid_constante_nomiEmpleadoConstante= activarid_constante_nomiEmpleadoConstante;
	}

	public Boolean getCargarid_constante_nomiEmpleadoConstante() {
		return this.cargarid_constante_nomiEmpleadoConstante;
	}

	public void setCargarid_constante_nomiEmpleadoConstante(Boolean cargarid_constante_nomiEmpleadoConstante) {
		this.cargarid_constante_nomiEmpleadoConstante= cargarid_constante_nomiEmpleadoConstante;
	}

	public Border setResaltarvalorEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltarvalorEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorEmpleadoConstante() {
		return this.resaltarvalorEmpleadoConstante;
	}

	public void setResaltarvalorEmpleadoConstante(Border borderResaltar) {
		this.resaltarvalorEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostrarvalorEmpleadoConstante() {
		return this.mostrarvalorEmpleadoConstante;
	}

	public void setMostrarvalorEmpleadoConstante(Boolean mostrarvalorEmpleadoConstante) {
		this.mostrarvalorEmpleadoConstante= mostrarvalorEmpleadoConstante;
	}

	public Boolean getActivarvalorEmpleadoConstante() {
		return this.activarvalorEmpleadoConstante;
	}

	public void setActivarvalorEmpleadoConstante(Boolean activarvalorEmpleadoConstante) {
		this.activarvalorEmpleadoConstante= activarvalorEmpleadoConstante;
	}

	public Border setResaltaresta_activoEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoconstanteBeanSwingJInternalFrame.jTtoolBarEmpleadoConstante.setBorder(borderResaltar);
		
		this.resaltaresta_activoEmpleadoConstante= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoEmpleadoConstante() {
		return this.resaltaresta_activoEmpleadoConstante;
	}

	public void setResaltaresta_activoEmpleadoConstante(Border borderResaltar) {
		this.resaltaresta_activoEmpleadoConstante= borderResaltar;
	}

	public Boolean getMostraresta_activoEmpleadoConstante() {
		return this.mostraresta_activoEmpleadoConstante;
	}

	public void setMostraresta_activoEmpleadoConstante(Boolean mostraresta_activoEmpleadoConstante) {
		this.mostraresta_activoEmpleadoConstante= mostraresta_activoEmpleadoConstante;
	}

	public Boolean getActivaresta_activoEmpleadoConstante() {
		return this.activaresta_activoEmpleadoConstante;
	}

	public void setActivaresta_activoEmpleadoConstante(Boolean activaresta_activoEmpleadoConstante) {
		this.activaresta_activoEmpleadoConstante= activaresta_activoEmpleadoConstante;
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
		
		
		this.setMostraridEmpleadoConstante(esInicial);
		this.setMostrarid_empresaEmpleadoConstante(esInicial);
		this.setMostrarid_empleadoEmpleadoConstante(esInicial);
		this.setMostrarid_constante_nomiEmpleadoConstante(esInicial);
		this.setMostrarvalorEmpleadoConstante(esInicial);
		this.setMostraresta_activoEmpleadoConstante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ID)) {
				this.setMostraridEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI)) {
				this.setMostrarid_constante_nomiEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.VALOR)) {
				this.setMostrarvalorEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoEmpleadoConstante(esAsigna);
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
		
		
		this.setActivaridEmpleadoConstante(esInicial);
		this.setActivarid_empresaEmpleadoConstante(esInicial);
		this.setActivarid_empleadoEmpleadoConstante(esInicial);
		this.setActivarid_constante_nomiEmpleadoConstante(esInicial);
		this.setActivarvalorEmpleadoConstante(esInicial);
		this.setActivaresta_activoEmpleadoConstante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ID)) {
				this.setActivaridEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI)) {
				this.setActivarid_constante_nomiEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.VALOR)) {
				this.setActivarvalorEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoEmpleadoConstante(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoConstante(esInicial);
		this.setResaltarid_empresaEmpleadoConstante(esInicial);
		this.setResaltarid_empleadoEmpleadoConstante(esInicial);
		this.setResaltarid_constante_nomiEmpleadoConstante(esInicial);
		this.setResaltarvalorEmpleadoConstante(esInicial);
		this.setResaltaresta_activoEmpleadoConstante(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI)) {
				this.setResaltarid_constante_nomiEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.VALOR)) {
				this.setResaltarvalorEmpleadoConstante(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoConstanteConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoEmpleadoConstante(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdConstanteNomiEmpleadoConstante=true;

	public Boolean getMostrarFK_IdConstanteNomiEmpleadoConstante() {
		return this.mostrarFK_IdConstanteNomiEmpleadoConstante;
	}

	public void setMostrarFK_IdConstanteNomiEmpleadoConstante(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConstanteNomiEmpleadoConstante= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEmpleadoConstante=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoConstante() {
		return this.mostrarFK_IdEmpleadoEmpleadoConstante;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoConstante(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoConstante= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoConstante=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoConstante() {
		return this.mostrarFK_IdEmpresaEmpleadoConstante;
	}

	public void setMostrarFK_IdEmpresaEmpleadoConstante(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoConstante= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdConstanteNomiEmpleadoConstante=true;

	public Boolean getActivarFK_IdConstanteNomiEmpleadoConstante() {
		return this.activarFK_IdConstanteNomiEmpleadoConstante;
	}

	public void setActivarFK_IdConstanteNomiEmpleadoConstante(Boolean habilitarResaltar) {
		this.activarFK_IdConstanteNomiEmpleadoConstante= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEmpleadoConstante=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoConstante() {
		return this.activarFK_IdEmpleadoEmpleadoConstante;
	}

	public void setActivarFK_IdEmpleadoEmpleadoConstante(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoConstante= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoConstante=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoConstante() {
		return this.activarFK_IdEmpresaEmpleadoConstante;
	}

	public void setActivarFK_IdEmpresaEmpleadoConstante(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoConstante= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdConstanteNomiEmpleadoConstante=null;

	public Border getResaltarFK_IdConstanteNomiEmpleadoConstante() {
		return this.resaltarFK_IdConstanteNomiEmpleadoConstante;
	}

	public void setResaltarFK_IdConstanteNomiEmpleadoConstante(Border borderResaltar) {
		this.resaltarFK_IdConstanteNomiEmpleadoConstante= borderResaltar;
	}

	public void setResaltarFK_IdConstanteNomiEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConstanteNomiEmpleadoConstante= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEmpleadoConstante=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoConstante() {
		return this.resaltarFK_IdEmpleadoEmpleadoConstante;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoConstante(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoConstante= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoConstante= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoConstante=null;

	public Border getResaltarFK_IdEmpresaEmpleadoConstante() {
		return this.resaltarFK_IdEmpresaEmpleadoConstante;
	}

	public void setResaltarFK_IdEmpresaEmpleadoConstante(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoConstante= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoConstante(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoConstanteBeanSwingJInternalFrame empleadoconstanteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoConstante= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}