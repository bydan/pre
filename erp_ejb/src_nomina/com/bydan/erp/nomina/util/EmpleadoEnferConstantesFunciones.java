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


import com.bydan.erp.nomina.util.EmpleadoEnferConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoEnferParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoEnferParameterGeneral;

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
final public class EmpleadoEnferConstantesFunciones extends EmpleadoEnferConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoEnfer";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoEnfer"+EmpleadoEnferConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoEnferHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoEnferHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoEnferConstantesFunciones.SCHEMA+"_"+EmpleadoEnferConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEnferHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoEnferConstantesFunciones.SCHEMA+"_"+EmpleadoEnferConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoEnferConstantesFunciones.SCHEMA+"_"+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEnferHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoEnferConstantesFunciones.SCHEMA+"_"+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEnferHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEnferHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEnferConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoEnferConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoEnferConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoEnferConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoEnferConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Enferes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Empleado Enfer";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Enfer";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoEnfer";
	public static final String OBJECTNAME="empleadoenfer";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_enfer";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoenfer from "+EmpleadoEnferConstantesFunciones.SPERSISTENCENAME+" empleadoenfer";
	public static String QUERYSELECTNATIVE="select "+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".id,"+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".id_enfermedad,"+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoEnferConstantesFunciones.SCHEMA+"."+EmpleadoEnferConstantesFunciones.TABLENAME;//+" as "+EmpleadoEnferConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoEnferConstantesFuncionesAdditional empleadoenferConstantesFuncionesAdditional=null;
	
	public EmpleadoEnferConstantesFuncionesAdditional getEmpleadoEnferConstantesFuncionesAdditional() {
		return this.empleadoenferConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoEnferConstantesFuncionesAdditional(EmpleadoEnferConstantesFuncionesAdditional empleadoenferConstantesFuncionesAdditional) {
		try {
			this.empleadoenferConstantesFuncionesAdditional=empleadoenferConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDENFERMEDAD= "id_enfermedad";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDENFERMEDAD= "Enfermedad";
		public static final String LABEL_IDENFERMEDAD_LOWER= "Enfermedad";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpleadoEnferLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoEnferConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoEnferConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoEnferConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoEnferConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoEnferConstantesFunciones.IDENFERMEDAD)) {sLabelColumna=EmpleadoEnferConstantesFunciones.LABEL_IDENFERMEDAD;}
		if(sNombreColumna.equals(EmpleadoEnferConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpleadoEnferConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEmpleadoEnferDescripcion(EmpleadoEnfer empleadoenfer) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoenfer !=null/* && empleadoenfer.getId()!=0*/) {
			if(empleadoenfer.getId()!=null) {
				sDescripcion=empleadoenfer.getId().toString();
			}//empleadoenferempleadoenfer.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoEnferDescripcionDetallado(EmpleadoEnfer empleadoenfer) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoEnferConstantesFunciones.ID+"=";
		sDescripcion+=empleadoenfer.getId().toString()+",";
		sDescripcion+=EmpleadoEnferConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoenfer.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoEnferConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoenfer.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoEnferConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoenfer.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoEnferConstantesFunciones.IDENFERMEDAD+"=";
		sDescripcion+=empleadoenfer.getid_enfermedad().toString()+",";
		sDescripcion+=EmpleadoEnferConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empleadoenfer.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoEnferDescripcion(EmpleadoEnfer empleadoenfer,String sValor) throws Exception {			
		if(empleadoenfer !=null) {
			//empleadoenferempleadoenfer.getId().toString();
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

	public static String getEnfermedadDescripcion(Enfermedad enfermedad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(enfermedad!=null/*&&enfermedad.getId()>0*/) {
			sDescripcion=EnfermedadConstantesFunciones.getEnfermedadDescripcion(enfermedad);
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
		} else if(sNombreIndice.equals("FK_IdEnfermedad")) {
			sNombreIndice="Tipo=  Por Enfermedad";
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

	public static String getDetalleIndiceFK_IdEnfermedad(Long id_enfermedad) {
		String sDetalleIndice=" Parametros->";
		if(id_enfermedad!=null) {sDetalleIndice+=" Codigo Unico De Enfermedad="+id_enfermedad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoEnfer(EmpleadoEnfer empleadoenfer,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadoenfer.setdescripcion(empleadoenfer.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpleadoEnfers(List<EmpleadoEnfer> empleadoenfers,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoEnfer empleadoenfer: empleadoenfers) {
			empleadoenfer.setdescripcion(empleadoenfer.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEnfer(EmpleadoEnfer empleadoenfer,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoenfer.getConCambioAuxiliar()) {
			empleadoenfer.setIsDeleted(empleadoenfer.getIsDeletedAuxiliar());	
			empleadoenfer.setIsNew(empleadoenfer.getIsNewAuxiliar());	
			empleadoenfer.setIsChanged(empleadoenfer.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoenfer.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoenfer.setIsDeletedAuxiliar(false);	
			empleadoenfer.setIsNewAuxiliar(false);	
			empleadoenfer.setIsChangedAuxiliar(false);
			
			empleadoenfer.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEnfers(List<EmpleadoEnfer> empleadoenfers,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoEnfer empleadoenfer : empleadoenfers) {
			if(conAsignarBase && empleadoenfer.getConCambioAuxiliar()) {
				empleadoenfer.setIsDeleted(empleadoenfer.getIsDeletedAuxiliar());	
				empleadoenfer.setIsNew(empleadoenfer.getIsNewAuxiliar());	
				empleadoenfer.setIsChanged(empleadoenfer.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoenfer.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoenfer.setIsDeletedAuxiliar(false);	
				empleadoenfer.setIsNewAuxiliar(false);	
				empleadoenfer.setIsChangedAuxiliar(false);
				
				empleadoenfer.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoEnfer(EmpleadoEnfer empleadoenfer,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoEnfers(List<EmpleadoEnfer> empleadoenfers,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoEnfer empleadoenfer: empleadoenfers) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoEnfer(List<EmpleadoEnfer> empleadoenfers,EmpleadoEnfer empleadoenferAux) throws Exception  {
		EmpleadoEnferConstantesFunciones.InicializarValoresEmpleadoEnfer(empleadoenferAux,true);
		
		for(EmpleadoEnfer empleadoenfer: empleadoenfers) {
			if(empleadoenfer.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEnfer(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoEnferConstantesFunciones.getArrayColumnasGlobalesEmpleadoEnfer(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEnfer(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoEnferConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoEnferConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoEnfer(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoEnfer> empleadoenfers,EmpleadoEnfer empleadoenfer,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoEnfer empleadoenferAux: empleadoenfers) {
			if(empleadoenferAux!=null && empleadoenfer!=null) {
				if((empleadoenferAux.getId()==null && empleadoenfer.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoenferAux.getId()!=null && empleadoenfer.getId()!=null){
					if(empleadoenferAux.getId().equals(empleadoenfer.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoEnfer(List<EmpleadoEnfer> empleadoenfers) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoEnfer empleadoenfer: empleadoenfers) {			
			if(empleadoenfer.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoEnfer() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_ID, EmpleadoEnferConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_VERSIONROW, EmpleadoEnferConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_IDEMPRESA, EmpleadoEnferConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoEnferConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_IDENFERMEDAD, EmpleadoEnferConstantesFunciones.IDENFERMEDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEnferConstantesFunciones.LABEL_DESCRIPCION, EmpleadoEnferConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoEnfer() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.IDENFERMEDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEnferConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEnfer() throws Exception  {
		return EmpleadoEnferConstantesFunciones.getTiposSeleccionarEmpleadoEnfer(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEnfer(Boolean conFk) throws Exception  {
		return EmpleadoEnferConstantesFunciones.getTiposSeleccionarEmpleadoEnfer(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEnfer(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEnferConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoEnferConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEnferConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoEnferConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEnferConstantesFunciones.LABEL_IDENFERMEDAD);
			reporte.setsDescripcion(EmpleadoEnferConstantesFunciones.LABEL_IDENFERMEDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEnferConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpleadoEnferConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoEnfer(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEnfer(EmpleadoEnfer empleadoenferAux) throws Exception {
		
			empleadoenferAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoenferAux.getEmpresa()));
			empleadoenferAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoenferAux.getEmpleado()));
			empleadoenferAux.setenfermedad_descripcion(EnfermedadConstantesFunciones.getEnfermedadDescripcion(empleadoenferAux.getEnfermedad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEnfer(List<EmpleadoEnfer> empleadoenfersTemp) throws Exception {
		for(EmpleadoEnfer empleadoenferAux:empleadoenfersTemp) {
			
			empleadoenferAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoenferAux.getEmpresa()));
			empleadoenferAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoenferAux.getEmpleado()));
			empleadoenferAux.setenfermedad_descripcion(EnfermedadConstantesFunciones.getEnfermedadDescripcion(empleadoenferAux.getEnfermedad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoEnfer(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Enfermedad.class));
				
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
					if(clas.clas.equals(Enfermedad.class)) {
						classes.add(new Classe(Enfermedad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoEnfer(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Enfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Enfermedad.class)); continue;
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

					if(Enfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Enfermedad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEnfer(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEnferConstantesFunciones.getClassesRelationshipsOfEmpleadoEnfer(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEnfer(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEnfer(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEnferConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoEnfer(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEnfer(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoEnfer empleadoenfer,List<EmpleadoEnfer> empleadoenfers,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoEnfer empleadoenferEncontrado=null;
			
			for(EmpleadoEnfer empleadoenferLocal:empleadoenfers) {
				if(empleadoenferLocal.getId().equals(empleadoenfer.getId())) {
					empleadoenferEncontrado=empleadoenferLocal;
					
					empleadoenferLocal.setIsChanged(empleadoenfer.getIsChanged());
					empleadoenferLocal.setIsNew(empleadoenfer.getIsNew());
					empleadoenferLocal.setIsDeleted(empleadoenfer.getIsDeleted());
					
					empleadoenferLocal.setGeneralEntityOriginal(empleadoenfer.getGeneralEntityOriginal());
					
					empleadoenferLocal.setId(empleadoenfer.getId());	
					empleadoenferLocal.setVersionRow(empleadoenfer.getVersionRow());	
					empleadoenferLocal.setid_empresa(empleadoenfer.getid_empresa());	
					empleadoenferLocal.setid_empleado(empleadoenfer.getid_empleado());	
					empleadoenferLocal.setid_enfermedad(empleadoenfer.getid_enfermedad());	
					empleadoenferLocal.setdescripcion(empleadoenfer.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoenfer.getIsDeleted()) {
				if(!existe) {
					empleadoenfers.add(empleadoenfer);
				}
			} else {
				if(empleadoenferEncontrado!=null && permiteQuitar)  {
					empleadoenfers.remove(empleadoenferEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoEnfer empleadoenfer,List<EmpleadoEnfer> empleadoenfers) throws Exception {
		try	{			
			for(EmpleadoEnfer empleadoenferLocal:empleadoenfers) {
				if(empleadoenferLocal.getId().equals(empleadoenfer.getId())) {
					empleadoenferLocal.setIsSelected(empleadoenfer.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoEnfer(List<EmpleadoEnfer> empleadoenfersAux) throws Exception {
		//this.empleadoenfersAux=empleadoenfersAux;
		
		for(EmpleadoEnfer empleadoenferAux:empleadoenfersAux) {
			if(empleadoenferAux.getIsChanged()) {
				empleadoenferAux.setIsChanged(false);
			}		
			
			if(empleadoenferAux.getIsNew()) {
				empleadoenferAux.setIsNew(false);
			}	
			
			if(empleadoenferAux.getIsDeleted()) {
				empleadoenferAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoEnfer(EmpleadoEnfer empleadoenferAux) throws Exception {
		//this.empleadoenferAux=empleadoenferAux;
		
			if(empleadoenferAux.getIsChanged()) {
				empleadoenferAux.setIsChanged(false);
			}		
			
			if(empleadoenferAux.getIsNew()) {
				empleadoenferAux.setIsNew(false);
			}	
			
			if(empleadoenferAux.getIsDeleted()) {
				empleadoenferAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoEnfer empleadoenferAsignar,EmpleadoEnfer empleadoenfer) throws Exception {
		empleadoenferAsignar.setId(empleadoenfer.getId());	
		empleadoenferAsignar.setVersionRow(empleadoenfer.getVersionRow());	
		empleadoenferAsignar.setid_empresa(empleadoenfer.getid_empresa());
		empleadoenferAsignar.setempresa_descripcion(empleadoenfer.getempresa_descripcion());	
		empleadoenferAsignar.setid_empleado(empleadoenfer.getid_empleado());
		empleadoenferAsignar.setempleado_descripcion(empleadoenfer.getempleado_descripcion());	
		empleadoenferAsignar.setid_enfermedad(empleadoenfer.getid_enfermedad());
		empleadoenferAsignar.setenfermedad_descripcion(empleadoenfer.getenfermedad_descripcion());	
		empleadoenferAsignar.setdescripcion(empleadoenfer.getdescripcion());	
	}
	
	public static void inicializarEmpleadoEnfer(EmpleadoEnfer empleadoenfer) throws Exception {
		try {
				empleadoenfer.setId(0L);	
					
				empleadoenfer.setid_empresa(-1L);	
				empleadoenfer.setid_empleado(-1L);	
				empleadoenfer.setid_enfermedad(-1L);	
				empleadoenfer.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoEnfer(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEnferConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEnferConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEnferConstantesFunciones.LABEL_IDENFERMEDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEnferConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoEnfer(String sTipo,Row row,Workbook workbook,EmpleadoEnfer empleadoenfer,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoenfer.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoenfer.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoenfer.getenfermedad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoenfer.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoEnfer=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoEnfer() {
		return this.sFinalQueryEmpleadoEnfer;
	}
	
	public void setsFinalQueryEmpleadoEnfer(String sFinalQueryEmpleadoEnfer) {
		this.sFinalQueryEmpleadoEnfer= sFinalQueryEmpleadoEnfer;
	}
	
	public Border resaltarSeleccionarEmpleadoEnfer=null;
	
	public Border setResaltarSeleccionarEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoEnfer= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoEnfer() {
		return this.resaltarSeleccionarEmpleadoEnfer;
	}
	
	public void setResaltarSeleccionarEmpleadoEnfer(Border borderResaltarSeleccionarEmpleadoEnfer) {
		this.resaltarSeleccionarEmpleadoEnfer= borderResaltarSeleccionarEmpleadoEnfer;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoEnfer=null;
	public Boolean mostraridEmpleadoEnfer=true;
	public Boolean activaridEmpleadoEnfer=true;

	public Border resaltarid_empresaEmpleadoEnfer=null;
	public Boolean mostrarid_empresaEmpleadoEnfer=true;
	public Boolean activarid_empresaEmpleadoEnfer=true;
	public Boolean cargarid_empresaEmpleadoEnfer=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoEnfer=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoEnfer=null;
	public Boolean mostrarid_empleadoEmpleadoEnfer=true;
	public Boolean activarid_empleadoEmpleadoEnfer=true;
	public Boolean cargarid_empleadoEmpleadoEnfer=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoEnfer=false;//ConEventDepend=true

	public Border resaltarid_enfermedadEmpleadoEnfer=null;
	public Boolean mostrarid_enfermedadEmpleadoEnfer=true;
	public Boolean activarid_enfermedadEmpleadoEnfer=true;
	public Boolean cargarid_enfermedadEmpleadoEnfer=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_enfermedadEmpleadoEnfer=false;//ConEventDepend=true

	public Border resaltardescripcionEmpleadoEnfer=null;
	public Boolean mostrardescripcionEmpleadoEnfer=true;
	public Boolean activardescripcionEmpleadoEnfer=true;

	
	

	public Border setResaltaridEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoEnfer= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoEnfer() {
		return this.resaltaridEmpleadoEnfer;
	}

	public void setResaltaridEmpleadoEnfer(Border borderResaltar) {
		this.resaltaridEmpleadoEnfer= borderResaltar;
	}

	public Boolean getMostraridEmpleadoEnfer() {
		return this.mostraridEmpleadoEnfer;
	}

	public void setMostraridEmpleadoEnfer(Boolean mostraridEmpleadoEnfer) {
		this.mostraridEmpleadoEnfer= mostraridEmpleadoEnfer;
	}

	public Boolean getActivaridEmpleadoEnfer() {
		return this.activaridEmpleadoEnfer;
	}

	public void setActivaridEmpleadoEnfer(Boolean activaridEmpleadoEnfer) {
		this.activaridEmpleadoEnfer= activaridEmpleadoEnfer;
	}

	public Border setResaltarid_empresaEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoEnfer= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoEnfer() {
		return this.resaltarid_empresaEmpleadoEnfer;
	}

	public void setResaltarid_empresaEmpleadoEnfer(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoEnfer= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoEnfer() {
		return this.mostrarid_empresaEmpleadoEnfer;
	}

	public void setMostrarid_empresaEmpleadoEnfer(Boolean mostrarid_empresaEmpleadoEnfer) {
		this.mostrarid_empresaEmpleadoEnfer= mostrarid_empresaEmpleadoEnfer;
	}

	public Boolean getActivarid_empresaEmpleadoEnfer() {
		return this.activarid_empresaEmpleadoEnfer;
	}

	public void setActivarid_empresaEmpleadoEnfer(Boolean activarid_empresaEmpleadoEnfer) {
		this.activarid_empresaEmpleadoEnfer= activarid_empresaEmpleadoEnfer;
	}

	public Boolean getCargarid_empresaEmpleadoEnfer() {
		return this.cargarid_empresaEmpleadoEnfer;
	}

	public void setCargarid_empresaEmpleadoEnfer(Boolean cargarid_empresaEmpleadoEnfer) {
		this.cargarid_empresaEmpleadoEnfer= cargarid_empresaEmpleadoEnfer;
	}

	public Border setResaltarid_empleadoEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoEnfer= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoEnfer() {
		return this.resaltarid_empleadoEmpleadoEnfer;
	}

	public void setResaltarid_empleadoEmpleadoEnfer(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoEnfer= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoEnfer() {
		return this.mostrarid_empleadoEmpleadoEnfer;
	}

	public void setMostrarid_empleadoEmpleadoEnfer(Boolean mostrarid_empleadoEmpleadoEnfer) {
		this.mostrarid_empleadoEmpleadoEnfer= mostrarid_empleadoEmpleadoEnfer;
	}

	public Boolean getActivarid_empleadoEmpleadoEnfer() {
		return this.activarid_empleadoEmpleadoEnfer;
	}

	public void setActivarid_empleadoEmpleadoEnfer(Boolean activarid_empleadoEmpleadoEnfer) {
		this.activarid_empleadoEmpleadoEnfer= activarid_empleadoEmpleadoEnfer;
	}

	public Boolean getCargarid_empleadoEmpleadoEnfer() {
		return this.cargarid_empleadoEmpleadoEnfer;
	}

	public void setCargarid_empleadoEmpleadoEnfer(Boolean cargarid_empleadoEmpleadoEnfer) {
		this.cargarid_empleadoEmpleadoEnfer= cargarid_empleadoEmpleadoEnfer;
	}

	public Border setResaltarid_enfermedadEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltarid_enfermedadEmpleadoEnfer= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_enfermedadEmpleadoEnfer() {
		return this.resaltarid_enfermedadEmpleadoEnfer;
	}

	public void setResaltarid_enfermedadEmpleadoEnfer(Border borderResaltar) {
		this.resaltarid_enfermedadEmpleadoEnfer= borderResaltar;
	}

	public Boolean getMostrarid_enfermedadEmpleadoEnfer() {
		return this.mostrarid_enfermedadEmpleadoEnfer;
	}

	public void setMostrarid_enfermedadEmpleadoEnfer(Boolean mostrarid_enfermedadEmpleadoEnfer) {
		this.mostrarid_enfermedadEmpleadoEnfer= mostrarid_enfermedadEmpleadoEnfer;
	}

	public Boolean getActivarid_enfermedadEmpleadoEnfer() {
		return this.activarid_enfermedadEmpleadoEnfer;
	}

	public void setActivarid_enfermedadEmpleadoEnfer(Boolean activarid_enfermedadEmpleadoEnfer) {
		this.activarid_enfermedadEmpleadoEnfer= activarid_enfermedadEmpleadoEnfer;
	}

	public Boolean getCargarid_enfermedadEmpleadoEnfer() {
		return this.cargarid_enfermedadEmpleadoEnfer;
	}

	public void setCargarid_enfermedadEmpleadoEnfer(Boolean cargarid_enfermedadEmpleadoEnfer) {
		this.cargarid_enfermedadEmpleadoEnfer= cargarid_enfermedadEmpleadoEnfer;
	}

	public Border setResaltardescripcionEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoenferBeanSwingJInternalFrame.jTtoolBarEmpleadoEnfer.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpleadoEnfer= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpleadoEnfer() {
		return this.resaltardescripcionEmpleadoEnfer;
	}

	public void setResaltardescripcionEmpleadoEnfer(Border borderResaltar) {
		this.resaltardescripcionEmpleadoEnfer= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpleadoEnfer() {
		return this.mostrardescripcionEmpleadoEnfer;
	}

	public void setMostrardescripcionEmpleadoEnfer(Boolean mostrardescripcionEmpleadoEnfer) {
		this.mostrardescripcionEmpleadoEnfer= mostrardescripcionEmpleadoEnfer;
	}

	public Boolean getActivardescripcionEmpleadoEnfer() {
		return this.activardescripcionEmpleadoEnfer;
	}

	public void setActivardescripcionEmpleadoEnfer(Boolean activardescripcionEmpleadoEnfer) {
		this.activardescripcionEmpleadoEnfer= activardescripcionEmpleadoEnfer;
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
		
		
		this.setMostraridEmpleadoEnfer(esInicial);
		this.setMostrarid_empresaEmpleadoEnfer(esInicial);
		this.setMostrarid_empleadoEmpleadoEnfer(esInicial);
		this.setMostrarid_enfermedadEmpleadoEnfer(esInicial);
		this.setMostrardescripcionEmpleadoEnfer(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.ID)) {
				this.setMostraridEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDENFERMEDAD)) {
				this.setMostrarid_enfermedadEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpleadoEnfer(esAsigna);
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
		
		
		this.setActivaridEmpleadoEnfer(esInicial);
		this.setActivarid_empresaEmpleadoEnfer(esInicial);
		this.setActivarid_empleadoEmpleadoEnfer(esInicial);
		this.setActivarid_enfermedadEmpleadoEnfer(esInicial);
		this.setActivardescripcionEmpleadoEnfer(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.ID)) {
				this.setActivaridEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDENFERMEDAD)) {
				this.setActivarid_enfermedadEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpleadoEnfer(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoEnfer(esInicial);
		this.setResaltarid_empresaEmpleadoEnfer(esInicial);
		this.setResaltarid_empleadoEmpleadoEnfer(esInicial);
		this.setResaltarid_enfermedadEmpleadoEnfer(esInicial);
		this.setResaltardescripcionEmpleadoEnfer(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.IDENFERMEDAD)) {
				this.setResaltarid_enfermedadEmpleadoEnfer(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEnferConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpleadoEnfer(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoEnfer=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoEnfer() {
		return this.mostrarFK_IdEmpleadoEmpleadoEnfer;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoEnfer(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoEnfer= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoEnfer=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoEnfer() {
		return this.mostrarFK_IdEmpresaEmpleadoEnfer;
	}

	public void setMostrarFK_IdEmpresaEmpleadoEnfer(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoEnfer= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEnfermedadEmpleadoEnfer=true;

	public Boolean getMostrarFK_IdEnfermedadEmpleadoEnfer() {
		return this.mostrarFK_IdEnfermedadEmpleadoEnfer;
	}

	public void setMostrarFK_IdEnfermedadEmpleadoEnfer(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEnfermedadEmpleadoEnfer= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoEnfer=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoEnfer() {
		return this.activarFK_IdEmpleadoEmpleadoEnfer;
	}

	public void setActivarFK_IdEmpleadoEmpleadoEnfer(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoEnfer= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoEnfer=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoEnfer() {
		return this.activarFK_IdEmpresaEmpleadoEnfer;
	}

	public void setActivarFK_IdEmpresaEmpleadoEnfer(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoEnfer= habilitarResaltar;
	}

	public Boolean activarFK_IdEnfermedadEmpleadoEnfer=true;

	public Boolean getActivarFK_IdEnfermedadEmpleadoEnfer() {
		return this.activarFK_IdEnfermedadEmpleadoEnfer;
	}

	public void setActivarFK_IdEnfermedadEmpleadoEnfer(Boolean habilitarResaltar) {
		this.activarFK_IdEnfermedadEmpleadoEnfer= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoEnfer=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoEnfer() {
		return this.resaltarFK_IdEmpleadoEmpleadoEnfer;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEnfer(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoEnfer= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoEnfer= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoEnfer=null;

	public Border getResaltarFK_IdEmpresaEmpleadoEnfer() {
		return this.resaltarFK_IdEmpresaEmpleadoEnfer;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEnfer(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoEnfer= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoEnfer= borderResaltar;
	}

	public Border resaltarFK_IdEnfermedadEmpleadoEnfer=null;

	public Border getResaltarFK_IdEnfermedadEmpleadoEnfer() {
		return this.resaltarFK_IdEnfermedadEmpleadoEnfer;
	}

	public void setResaltarFK_IdEnfermedadEmpleadoEnfer(Border borderResaltar) {
		this.resaltarFK_IdEnfermedadEmpleadoEnfer= borderResaltar;
	}

	public void setResaltarFK_IdEnfermedadEmpleadoEnfer(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEnferBeanSwingJInternalFrame empleadoenferBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEnfermedadEmpleadoEnfer= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}