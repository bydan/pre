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


import com.bydan.erp.nomina.util.EmpleadoHerraConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoHerraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoHerraParameterGeneral;

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
final public class EmpleadoHerraConstantesFunciones extends EmpleadoHerraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoHerra";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoHerra"+EmpleadoHerraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoHerraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoHerraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoHerraConstantesFunciones.SCHEMA+"_"+EmpleadoHerraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHerraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoHerraConstantesFunciones.SCHEMA+"_"+EmpleadoHerraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoHerraConstantesFunciones.SCHEMA+"_"+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHerraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoHerraConstantesFunciones.SCHEMA+"_"+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHerraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHerraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHerraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoHerraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoHerraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoHerraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoHerraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Herras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Herra";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Herra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoHerra";
	public static final String OBJECTNAME="empleadoherra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_herra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoherra from "+EmpleadoHerraConstantesFunciones.SPERSISTENCENAME+" empleadoherra";
	public static String QUERYSELECTNATIVE="select "+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".id,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".version_row,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".id_herramienta,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".cantidad,"+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME+".esta_activo from "+EmpleadoHerraConstantesFunciones.SCHEMA+"."+EmpleadoHerraConstantesFunciones.TABLENAME;//+" as "+EmpleadoHerraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoHerraConstantesFuncionesAdditional empleadoherraConstantesFuncionesAdditional=null;
	
	public EmpleadoHerraConstantesFuncionesAdditional getEmpleadoHerraConstantesFuncionesAdditional() {
		return this.empleadoherraConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoHerraConstantesFuncionesAdditional(EmpleadoHerraConstantesFuncionesAdditional empleadoherraConstantesFuncionesAdditional) {
		try {
			this.empleadoherraConstantesFuncionesAdditional=empleadoherraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDHERRAMIENTA= "id_herramienta";
    public static final String CANTIDAD= "cantidad";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDHERRAMIENTA= "Herramienta";
		public static final String LABEL_IDHERRAMIENTA_LOWER= "Herramienta";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	
	public static String getEmpleadoHerraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoHerraConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoHerraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoHerraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoHerraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoHerraConstantesFunciones.IDHERRAMIENTA)) {sLabelColumna=EmpleadoHerraConstantesFunciones.LABEL_IDHERRAMIENTA;}
		if(sNombreColumna.equals(EmpleadoHerraConstantesFunciones.CANTIDAD)) {sLabelColumna=EmpleadoHerraConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(EmpleadoHerraConstantesFunciones.ESTAACTIVO)) {sLabelColumna=EmpleadoHerraConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(EmpleadoHerra empleadoherra) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoherra.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(EmpleadoHerra empleadoherra) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoherra.getId(),empleadoherra.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getEmpleadoHerraDescripcion(EmpleadoHerra empleadoherra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoherra !=null/* && empleadoherra.getId()!=0*/) {
			if(empleadoherra.getId()!=null) {
				sDescripcion=empleadoherra.getId().toString();
			}//empleadoherraempleadoherra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoHerraDescripcionDetallado(EmpleadoHerra empleadoherra) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoHerraConstantesFunciones.ID+"=";
		sDescripcion+=empleadoherra.getId().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoherra.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoherra.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoherra.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.IDHERRAMIENTA+"=";
		sDescripcion+=empleadoherra.getid_herramienta().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=empleadoherra.getcantidad().toString()+",";
		sDescripcion+=EmpleadoHerraConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=empleadoherra.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoHerraDescripcion(EmpleadoHerra empleadoherra,String sValor) throws Exception {			
		if(empleadoherra !=null) {
			//empleadoherraempleadoherra.getId().toString();
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

	public static String getHerramientaDescripcion(Herramienta herramienta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(herramienta!=null/*&&herramienta.getId()>0*/) {
			sDescripcion=HerramientaConstantesFunciones.getHerramientaDescripcion(herramienta);
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
		} else if(sNombreIndice.equals("FK_IdHerramienta")) {
			sNombreIndice="Tipo=  Por Herramienta";
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

	public static String getDetalleIndiceFK_IdHerramienta(Long id_herramienta) {
		String sDetalleIndice=" Parametros->";
		if(id_herramienta!=null) {sDetalleIndice+=" Codigo Unico De Herramienta="+id_herramienta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoHerra(EmpleadoHerra empleadoherra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEmpleadoHerras(List<EmpleadoHerra> empleadoherras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoHerra empleadoherra: empleadoherras) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoHerra(EmpleadoHerra empleadoherra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoherra.getConCambioAuxiliar()) {
			empleadoherra.setIsDeleted(empleadoherra.getIsDeletedAuxiliar());	
			empleadoherra.setIsNew(empleadoherra.getIsNewAuxiliar());	
			empleadoherra.setIsChanged(empleadoherra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoherra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoherra.setIsDeletedAuxiliar(false);	
			empleadoherra.setIsNewAuxiliar(false);	
			empleadoherra.setIsChangedAuxiliar(false);
			
			empleadoherra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoHerras(List<EmpleadoHerra> empleadoherras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoHerra empleadoherra : empleadoherras) {
			if(conAsignarBase && empleadoherra.getConCambioAuxiliar()) {
				empleadoherra.setIsDeleted(empleadoherra.getIsDeletedAuxiliar());	
				empleadoherra.setIsNew(empleadoherra.getIsNewAuxiliar());	
				empleadoherra.setIsChanged(empleadoherra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoherra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoherra.setIsDeletedAuxiliar(false);	
				empleadoherra.setIsNewAuxiliar(false);	
				empleadoherra.setIsChangedAuxiliar(false);
				
				empleadoherra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoHerra(EmpleadoHerra empleadoherra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			empleadoherra.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresEmpleadoHerras(List<EmpleadoHerra> empleadoherras,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoHerra empleadoherra: empleadoherras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				empleadoherra.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoHerra(List<EmpleadoHerra> empleadoherras,EmpleadoHerra empleadoherraAux) throws Exception  {
		EmpleadoHerraConstantesFunciones.InicializarValoresEmpleadoHerra(empleadoherraAux,true);
		
		for(EmpleadoHerra empleadoherra: empleadoherras) {
			if(empleadoherra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoherraAux.setcantidad(empleadoherraAux.getcantidad()+empleadoherra.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoHerra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoHerraConstantesFunciones.getArrayColumnasGlobalesEmpleadoHerra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoHerra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoHerraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoHerraConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoHerra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoHerra> empleadoherras,EmpleadoHerra empleadoherra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoHerra empleadoherraAux: empleadoherras) {
			if(empleadoherraAux!=null && empleadoherra!=null) {
				if((empleadoherraAux.getId()==null && empleadoherra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoherraAux.getId()!=null && empleadoherra.getId()!=null){
					if(empleadoherraAux.getId().equals(empleadoherra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoHerra(List<EmpleadoHerra> empleadoherras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoHerra empleadoherra: empleadoherras) {			
			if(empleadoherra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoHerra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_ID, EmpleadoHerraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_VERSIONROW, EmpleadoHerraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_IDEMPRESA, EmpleadoHerraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoHerraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_IDHERRAMIENTA, EmpleadoHerraConstantesFunciones.IDHERRAMIENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_CANTIDAD, EmpleadoHerraConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHerraConstantesFunciones.LABEL_ESTAACTIVO, EmpleadoHerraConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoHerra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.IDHERRAMIENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHerraConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHerra() throws Exception  {
		return EmpleadoHerraConstantesFunciones.getTiposSeleccionarEmpleadoHerra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHerra(Boolean conFk) throws Exception  {
		return EmpleadoHerraConstantesFunciones.getTiposSeleccionarEmpleadoHerra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHerra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHerraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoHerraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHerraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoHerraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHerraConstantesFunciones.LABEL_IDHERRAMIENTA);
			reporte.setsDescripcion(EmpleadoHerraConstantesFunciones.LABEL_IDHERRAMIENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHerraConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(EmpleadoHerraConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHerraConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(EmpleadoHerraConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoHerra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoHerra(EmpleadoHerra empleadoherraAux) throws Exception {
		
			empleadoherraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoherraAux.getEmpresa()));
			empleadoherraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoherraAux.getEmpleado()));
			empleadoherraAux.setherramienta_descripcion(HerramientaConstantesFunciones.getHerramientaDescripcion(empleadoherraAux.getHerramienta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoHerra(List<EmpleadoHerra> empleadoherrasTemp) throws Exception {
		for(EmpleadoHerra empleadoherraAux:empleadoherrasTemp) {
			
			empleadoherraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoherraAux.getEmpresa()));
			empleadoherraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoherraAux.getEmpleado()));
			empleadoherraAux.setherramienta_descripcion(HerramientaConstantesFunciones.getHerramientaDescripcion(empleadoherraAux.getHerramienta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoHerra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Herramienta.class));
				
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
					if(clas.clas.equals(Herramienta.class)) {
						classes.add(new Classe(Herramienta.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoHerra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Herramienta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Herramienta.class)); continue;
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

					if(Herramienta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Herramienta.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHerra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoHerraConstantesFunciones.getClassesRelationshipsOfEmpleadoHerra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHerra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoHerra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoHerraConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoHerra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoHerra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoHerra empleadoherra,List<EmpleadoHerra> empleadoherras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoHerra empleadoherraEncontrado=null;
			
			for(EmpleadoHerra empleadoherraLocal:empleadoherras) {
				if(empleadoherraLocal.getId().equals(empleadoherra.getId())) {
					empleadoherraEncontrado=empleadoherraLocal;
					
					empleadoherraLocal.setIsChanged(empleadoherra.getIsChanged());
					empleadoherraLocal.setIsNew(empleadoherra.getIsNew());
					empleadoherraLocal.setIsDeleted(empleadoherra.getIsDeleted());
					
					empleadoherraLocal.setGeneralEntityOriginal(empleadoherra.getGeneralEntityOriginal());
					
					empleadoherraLocal.setId(empleadoherra.getId());	
					empleadoherraLocal.setVersionRow(empleadoherra.getVersionRow());	
					empleadoherraLocal.setid_empresa(empleadoherra.getid_empresa());	
					empleadoherraLocal.setid_empleado(empleadoherra.getid_empleado());	
					empleadoherraLocal.setid_herramienta(empleadoherra.getid_herramienta());	
					empleadoherraLocal.setcantidad(empleadoherra.getcantidad());	
					empleadoherraLocal.setesta_activo(empleadoherra.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoherra.getIsDeleted()) {
				if(!existe) {
					empleadoherras.add(empleadoherra);
				}
			} else {
				if(empleadoherraEncontrado!=null && permiteQuitar)  {
					empleadoherras.remove(empleadoherraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoHerra empleadoherra,List<EmpleadoHerra> empleadoherras) throws Exception {
		try	{			
			for(EmpleadoHerra empleadoherraLocal:empleadoherras) {
				if(empleadoherraLocal.getId().equals(empleadoherra.getId())) {
					empleadoherraLocal.setIsSelected(empleadoherra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoHerra(List<EmpleadoHerra> empleadoherrasAux) throws Exception {
		//this.empleadoherrasAux=empleadoherrasAux;
		
		for(EmpleadoHerra empleadoherraAux:empleadoherrasAux) {
			if(empleadoherraAux.getIsChanged()) {
				empleadoherraAux.setIsChanged(false);
			}		
			
			if(empleadoherraAux.getIsNew()) {
				empleadoherraAux.setIsNew(false);
			}	
			
			if(empleadoherraAux.getIsDeleted()) {
				empleadoherraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoHerra(EmpleadoHerra empleadoherraAux) throws Exception {
		//this.empleadoherraAux=empleadoherraAux;
		
			if(empleadoherraAux.getIsChanged()) {
				empleadoherraAux.setIsChanged(false);
			}		
			
			if(empleadoherraAux.getIsNew()) {
				empleadoherraAux.setIsNew(false);
			}	
			
			if(empleadoherraAux.getIsDeleted()) {
				empleadoherraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoHerra empleadoherraAsignar,EmpleadoHerra empleadoherra) throws Exception {
		empleadoherraAsignar.setId(empleadoherra.getId());	
		empleadoherraAsignar.setVersionRow(empleadoherra.getVersionRow());	
		empleadoherraAsignar.setid_empresa(empleadoherra.getid_empresa());
		empleadoherraAsignar.setempresa_descripcion(empleadoherra.getempresa_descripcion());	
		empleadoherraAsignar.setid_empleado(empleadoherra.getid_empleado());
		empleadoherraAsignar.setempleado_descripcion(empleadoherra.getempleado_descripcion());	
		empleadoherraAsignar.setid_herramienta(empleadoherra.getid_herramienta());
		empleadoherraAsignar.setherramienta_descripcion(empleadoherra.getherramienta_descripcion());	
		empleadoherraAsignar.setcantidad(empleadoherra.getcantidad());	
		empleadoherraAsignar.setesta_activo(empleadoherra.getesta_activo());	
	}
	
	public static void inicializarEmpleadoHerra(EmpleadoHerra empleadoherra) throws Exception {
		try {
				empleadoherra.setId(0L);	
					
				empleadoherra.setid_empresa(-1L);	
				empleadoherra.setid_empleado(-1L);	
				empleadoherra.setid_herramienta(-1L);	
				empleadoherra.setcantidad(0);	
				empleadoherra.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoHerra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHerraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHerraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHerraConstantesFunciones.LABEL_IDHERRAMIENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHerraConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHerraConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoHerra(String sTipo,Row row,Workbook workbook,EmpleadoHerra empleadoherra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoherra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoherra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoherra.getherramienta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoherra.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoherra.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoHerra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoHerra() {
		return this.sFinalQueryEmpleadoHerra;
	}
	
	public void setsFinalQueryEmpleadoHerra(String sFinalQueryEmpleadoHerra) {
		this.sFinalQueryEmpleadoHerra= sFinalQueryEmpleadoHerra;
	}
	
	public Border resaltarSeleccionarEmpleadoHerra=null;
	
	public Border setResaltarSeleccionarEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoHerra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoHerra() {
		return this.resaltarSeleccionarEmpleadoHerra;
	}
	
	public void setResaltarSeleccionarEmpleadoHerra(Border borderResaltarSeleccionarEmpleadoHerra) {
		this.resaltarSeleccionarEmpleadoHerra= borderResaltarSeleccionarEmpleadoHerra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoHerra=null;
	public Boolean mostraridEmpleadoHerra=true;
	public Boolean activaridEmpleadoHerra=true;

	public Border resaltarid_empresaEmpleadoHerra=null;
	public Boolean mostrarid_empresaEmpleadoHerra=true;
	public Boolean activarid_empresaEmpleadoHerra=true;
	public Boolean cargarid_empresaEmpleadoHerra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoHerra=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoHerra=null;
	public Boolean mostrarid_empleadoEmpleadoHerra=true;
	public Boolean activarid_empleadoEmpleadoHerra=true;
	public Boolean cargarid_empleadoEmpleadoHerra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoHerra=false;//ConEventDepend=true

	public Border resaltarid_herramientaEmpleadoHerra=null;
	public Boolean mostrarid_herramientaEmpleadoHerra=true;
	public Boolean activarid_herramientaEmpleadoHerra=true;
	public Boolean cargarid_herramientaEmpleadoHerra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_herramientaEmpleadoHerra=false;//ConEventDepend=true

	public Border resaltarcantidadEmpleadoHerra=null;
	public Boolean mostrarcantidadEmpleadoHerra=true;
	public Boolean activarcantidadEmpleadoHerra=true;

	public Border resaltaresta_activoEmpleadoHerra=null;
	public Boolean mostraresta_activoEmpleadoHerra=true;
	public Boolean activaresta_activoEmpleadoHerra=true;

	
	

	public Border setResaltaridEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoHerra() {
		return this.resaltaridEmpleadoHerra;
	}

	public void setResaltaridEmpleadoHerra(Border borderResaltar) {
		this.resaltaridEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostraridEmpleadoHerra() {
		return this.mostraridEmpleadoHerra;
	}

	public void setMostraridEmpleadoHerra(Boolean mostraridEmpleadoHerra) {
		this.mostraridEmpleadoHerra= mostraridEmpleadoHerra;
	}

	public Boolean getActivaridEmpleadoHerra() {
		return this.activaridEmpleadoHerra;
	}

	public void setActivaridEmpleadoHerra(Boolean activaridEmpleadoHerra) {
		this.activaridEmpleadoHerra= activaridEmpleadoHerra;
	}

	public Border setResaltarid_empresaEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoHerra() {
		return this.resaltarid_empresaEmpleadoHerra;
	}

	public void setResaltarid_empresaEmpleadoHerra(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoHerra() {
		return this.mostrarid_empresaEmpleadoHerra;
	}

	public void setMostrarid_empresaEmpleadoHerra(Boolean mostrarid_empresaEmpleadoHerra) {
		this.mostrarid_empresaEmpleadoHerra= mostrarid_empresaEmpleadoHerra;
	}

	public Boolean getActivarid_empresaEmpleadoHerra() {
		return this.activarid_empresaEmpleadoHerra;
	}

	public void setActivarid_empresaEmpleadoHerra(Boolean activarid_empresaEmpleadoHerra) {
		this.activarid_empresaEmpleadoHerra= activarid_empresaEmpleadoHerra;
	}

	public Boolean getCargarid_empresaEmpleadoHerra() {
		return this.cargarid_empresaEmpleadoHerra;
	}

	public void setCargarid_empresaEmpleadoHerra(Boolean cargarid_empresaEmpleadoHerra) {
		this.cargarid_empresaEmpleadoHerra= cargarid_empresaEmpleadoHerra;
	}

	public Border setResaltarid_empleadoEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoHerra() {
		return this.resaltarid_empleadoEmpleadoHerra;
	}

	public void setResaltarid_empleadoEmpleadoHerra(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoHerra() {
		return this.mostrarid_empleadoEmpleadoHerra;
	}

	public void setMostrarid_empleadoEmpleadoHerra(Boolean mostrarid_empleadoEmpleadoHerra) {
		this.mostrarid_empleadoEmpleadoHerra= mostrarid_empleadoEmpleadoHerra;
	}

	public Boolean getActivarid_empleadoEmpleadoHerra() {
		return this.activarid_empleadoEmpleadoHerra;
	}

	public void setActivarid_empleadoEmpleadoHerra(Boolean activarid_empleadoEmpleadoHerra) {
		this.activarid_empleadoEmpleadoHerra= activarid_empleadoEmpleadoHerra;
	}

	public Boolean getCargarid_empleadoEmpleadoHerra() {
		return this.cargarid_empleadoEmpleadoHerra;
	}

	public void setCargarid_empleadoEmpleadoHerra(Boolean cargarid_empleadoEmpleadoHerra) {
		this.cargarid_empleadoEmpleadoHerra= cargarid_empleadoEmpleadoHerra;
	}

	public Border setResaltarid_herramientaEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltarid_herramientaEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_herramientaEmpleadoHerra() {
		return this.resaltarid_herramientaEmpleadoHerra;
	}

	public void setResaltarid_herramientaEmpleadoHerra(Border borderResaltar) {
		this.resaltarid_herramientaEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostrarid_herramientaEmpleadoHerra() {
		return this.mostrarid_herramientaEmpleadoHerra;
	}

	public void setMostrarid_herramientaEmpleadoHerra(Boolean mostrarid_herramientaEmpleadoHerra) {
		this.mostrarid_herramientaEmpleadoHerra= mostrarid_herramientaEmpleadoHerra;
	}

	public Boolean getActivarid_herramientaEmpleadoHerra() {
		return this.activarid_herramientaEmpleadoHerra;
	}

	public void setActivarid_herramientaEmpleadoHerra(Boolean activarid_herramientaEmpleadoHerra) {
		this.activarid_herramientaEmpleadoHerra= activarid_herramientaEmpleadoHerra;
	}

	public Boolean getCargarid_herramientaEmpleadoHerra() {
		return this.cargarid_herramientaEmpleadoHerra;
	}

	public void setCargarid_herramientaEmpleadoHerra(Boolean cargarid_herramientaEmpleadoHerra) {
		this.cargarid_herramientaEmpleadoHerra= cargarid_herramientaEmpleadoHerra;
	}

	public Border setResaltarcantidadEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltarcantidadEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadEmpleadoHerra() {
		return this.resaltarcantidadEmpleadoHerra;
	}

	public void setResaltarcantidadEmpleadoHerra(Border borderResaltar) {
		this.resaltarcantidadEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostrarcantidadEmpleadoHerra() {
		return this.mostrarcantidadEmpleadoHerra;
	}

	public void setMostrarcantidadEmpleadoHerra(Boolean mostrarcantidadEmpleadoHerra) {
		this.mostrarcantidadEmpleadoHerra= mostrarcantidadEmpleadoHerra;
	}

	public Boolean getActivarcantidadEmpleadoHerra() {
		return this.activarcantidadEmpleadoHerra;
	}

	public void setActivarcantidadEmpleadoHerra(Boolean activarcantidadEmpleadoHerra) {
		this.activarcantidadEmpleadoHerra= activarcantidadEmpleadoHerra;
	}

	public Border setResaltaresta_activoEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoherraBeanSwingJInternalFrame.jTtoolBarEmpleadoHerra.setBorder(borderResaltar);
		
		this.resaltaresta_activoEmpleadoHerra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoEmpleadoHerra() {
		return this.resaltaresta_activoEmpleadoHerra;
	}

	public void setResaltaresta_activoEmpleadoHerra(Border borderResaltar) {
		this.resaltaresta_activoEmpleadoHerra= borderResaltar;
	}

	public Boolean getMostraresta_activoEmpleadoHerra() {
		return this.mostraresta_activoEmpleadoHerra;
	}

	public void setMostraresta_activoEmpleadoHerra(Boolean mostraresta_activoEmpleadoHerra) {
		this.mostraresta_activoEmpleadoHerra= mostraresta_activoEmpleadoHerra;
	}

	public Boolean getActivaresta_activoEmpleadoHerra() {
		return this.activaresta_activoEmpleadoHerra;
	}

	public void setActivaresta_activoEmpleadoHerra(Boolean activaresta_activoEmpleadoHerra) {
		this.activaresta_activoEmpleadoHerra= activaresta_activoEmpleadoHerra;
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
		
		
		this.setMostraridEmpleadoHerra(esInicial);
		this.setMostrarid_empresaEmpleadoHerra(esInicial);
		this.setMostrarid_empleadoEmpleadoHerra(esInicial);
		this.setMostrarid_herramientaEmpleadoHerra(esInicial);
		this.setMostrarcantidadEmpleadoHerra(esInicial);
		this.setMostraresta_activoEmpleadoHerra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ID)) {
				this.setMostraridEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDHERRAMIENTA)) {
				this.setMostrarid_herramientaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoEmpleadoHerra(esAsigna);
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
		
		
		this.setActivaridEmpleadoHerra(esInicial);
		this.setActivarid_empresaEmpleadoHerra(esInicial);
		this.setActivarid_empleadoEmpleadoHerra(esInicial);
		this.setActivarid_herramientaEmpleadoHerra(esInicial);
		this.setActivarcantidadEmpleadoHerra(esInicial);
		this.setActivaresta_activoEmpleadoHerra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ID)) {
				this.setActivaridEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDHERRAMIENTA)) {
				this.setActivarid_herramientaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoEmpleadoHerra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoHerra(esInicial);
		this.setResaltarid_empresaEmpleadoHerra(esInicial);
		this.setResaltarid_empleadoEmpleadoHerra(esInicial);
		this.setResaltarid_herramientaEmpleadoHerra(esInicial);
		this.setResaltarcantidadEmpleadoHerra(esInicial);
		this.setResaltaresta_activoEmpleadoHerra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.IDHERRAMIENTA)) {
				this.setResaltarid_herramientaEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadEmpleadoHerra(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHerraConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoEmpleadoHerra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoHerra=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoHerra() {
		return this.mostrarFK_IdEmpleadoEmpleadoHerra;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoHerra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoHerra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoHerra=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoHerra() {
		return this.mostrarFK_IdEmpresaEmpleadoHerra;
	}

	public void setMostrarFK_IdEmpresaEmpleadoHerra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoHerra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdHerramientaEmpleadoHerra=true;

	public Boolean getMostrarFK_IdHerramientaEmpleadoHerra() {
		return this.mostrarFK_IdHerramientaEmpleadoHerra;
	}

	public void setMostrarFK_IdHerramientaEmpleadoHerra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdHerramientaEmpleadoHerra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoHerra=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoHerra() {
		return this.activarFK_IdEmpleadoEmpleadoHerra;
	}

	public void setActivarFK_IdEmpleadoEmpleadoHerra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoHerra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoHerra=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoHerra() {
		return this.activarFK_IdEmpresaEmpleadoHerra;
	}

	public void setActivarFK_IdEmpresaEmpleadoHerra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoHerra= habilitarResaltar;
	}

	public Boolean activarFK_IdHerramientaEmpleadoHerra=true;

	public Boolean getActivarFK_IdHerramientaEmpleadoHerra() {
		return this.activarFK_IdHerramientaEmpleadoHerra;
	}

	public void setActivarFK_IdHerramientaEmpleadoHerra(Boolean habilitarResaltar) {
		this.activarFK_IdHerramientaEmpleadoHerra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoHerra=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoHerra() {
		return this.resaltarFK_IdEmpleadoEmpleadoHerra;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoHerra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoHerra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoHerra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoHerra=null;

	public Border getResaltarFK_IdEmpresaEmpleadoHerra() {
		return this.resaltarFK_IdEmpresaEmpleadoHerra;
	}

	public void setResaltarFK_IdEmpresaEmpleadoHerra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoHerra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoHerra= borderResaltar;
	}

	public Border resaltarFK_IdHerramientaEmpleadoHerra=null;

	public Border getResaltarFK_IdHerramientaEmpleadoHerra() {
		return this.resaltarFK_IdHerramientaEmpleadoHerra;
	}

	public void setResaltarFK_IdHerramientaEmpleadoHerra(Border borderResaltar) {
		this.resaltarFK_IdHerramientaEmpleadoHerra= borderResaltar;
	}

	public void setResaltarFK_IdHerramientaEmpleadoHerra(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHerraBeanSwingJInternalFrame empleadoherraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdHerramientaEmpleadoHerra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}