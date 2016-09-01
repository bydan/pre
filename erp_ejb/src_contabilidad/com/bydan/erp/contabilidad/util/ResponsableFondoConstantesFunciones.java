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


import com.bydan.erp.contabilidad.util.ResponsableFondoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ResponsableFondoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ResponsableFondoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResponsableFondoConstantesFunciones extends ResponsableFondoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ResponsableFondo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ResponsableFondo"+ResponsableFondoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResponsableFondoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResponsableFondoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResponsableFondoConstantesFunciones.SCHEMA+"_"+ResponsableFondoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableFondoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResponsableFondoConstantesFunciones.SCHEMA+"_"+ResponsableFondoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResponsableFondoConstantesFunciones.SCHEMA+"_"+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableFondoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResponsableFondoConstantesFunciones.SCHEMA+"_"+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableFondoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableFondoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableFondoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResponsableFondoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResponsableFondoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResponsableFondoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResponsableFondoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Responsable Fondo Rotativos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Responsable Fondo Rotativo";
	public static final String SCLASSWEBTITULO_LOWER="Responsable Fondo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ResponsableFondo";
	public static final String OBJECTNAME="responsablefondo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="responsable_fondo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select responsablefondo from "+ResponsableFondoConstantesFunciones.SPERSISTENCENAME+" responsablefondo";
	public static String QUERYSELECTNATIVE="select "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".version_row,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_empresa,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_sucursal,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_empleado,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".secuencial,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".valor_caja from "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME;//+" as "+ResponsableFondoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ResponsableFondoConstantesFuncionesAdditional responsablefondoConstantesFuncionesAdditional=null;
	
	public ResponsableFondoConstantesFuncionesAdditional getResponsableFondoConstantesFuncionesAdditional() {
		return this.responsablefondoConstantesFuncionesAdditional;
	}
	
	public void setResponsableFondoConstantesFuncionesAdditional(ResponsableFondoConstantesFuncionesAdditional responsablefondoConstantesFuncionesAdditional) {
		try {
			this.responsablefondoConstantesFuncionesAdditional=responsablefondoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String SECUENCIAL= "secuencial";
    public static final String VALORCAJA= "valor_caja";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_VALORCAJA= "Valor Caja";
		public static final String LABEL_VALORCAJA_LOWER= "Valor Caja";
	
		
		
		
		
		
		
		
	
	public static String getResponsableFondoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResponsableFondoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ResponsableFondoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ResponsableFondoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ResponsableFondoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ResponsableFondoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ResponsableFondoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ResponsableFondoConstantesFunciones.SECUENCIAL)) {sLabelColumna=ResponsableFondoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ResponsableFondoConstantesFunciones.VALORCAJA)) {sLabelColumna=ResponsableFondoConstantesFunciones.LABEL_VALORCAJA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getResponsableFondoDescripcion(ResponsableFondo responsablefondo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(responsablefondo !=null/* && responsablefondo.getId()!=0*/) {
			if(responsablefondo.getId()!=null) {
				sDescripcion=responsablefondo.getId().toString();
			}//responsablefondoresponsablefondo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getResponsableFondoDescripcionDetallado(ResponsableFondo responsablefondo) {
		String sDescripcion="";
			
		sDescripcion+=ResponsableFondoConstantesFunciones.ID+"=";
		sDescripcion+=responsablefondo.getId().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=responsablefondo.getVersionRow().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=responsablefondo.getid_empresa().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=responsablefondo.getid_sucursal().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=responsablefondo.getid_empleado().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=responsablefondo.getsecuencial().toString()+",";
		sDescripcion+=ResponsableFondoConstantesFunciones.VALORCAJA+"=";
		sDescripcion+=responsablefondo.getvalor_caja().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setResponsableFondoDescripcion(ResponsableFondo responsablefondo,String sValor) throws Exception {			
		if(responsablefondo !=null) {
			//responsablefondoresponsablefondo.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("PorEmpresaPorSucursalPorEmpleado")) {
			sNombreIndice="Tipo=  Por Empresa Por Sucursal Por Empleado";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorSucursalPorEmpleado(Long id_empresa,Long id_sucursal,Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();}
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosResponsableFondo(ResponsableFondo responsablefondo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosResponsableFondos(List<ResponsableFondo> responsablefondos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResponsableFondo responsablefondo: responsablefondos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsableFondo(ResponsableFondo responsablefondo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && responsablefondo.getConCambioAuxiliar()) {
			responsablefondo.setIsDeleted(responsablefondo.getIsDeletedAuxiliar());	
			responsablefondo.setIsNew(responsablefondo.getIsNewAuxiliar());	
			responsablefondo.setIsChanged(responsablefondo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			responsablefondo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			responsablefondo.setIsDeletedAuxiliar(false);	
			responsablefondo.setIsNewAuxiliar(false);	
			responsablefondo.setIsChangedAuxiliar(false);
			
			responsablefondo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsableFondos(List<ResponsableFondo> responsablefondos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ResponsableFondo responsablefondo : responsablefondos) {
			if(conAsignarBase && responsablefondo.getConCambioAuxiliar()) {
				responsablefondo.setIsDeleted(responsablefondo.getIsDeletedAuxiliar());	
				responsablefondo.setIsNew(responsablefondo.getIsNewAuxiliar());	
				responsablefondo.setIsChanged(responsablefondo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				responsablefondo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				responsablefondo.setIsDeletedAuxiliar(false);	
				responsablefondo.setIsNewAuxiliar(false);	
				responsablefondo.setIsChangedAuxiliar(false);
				
				responsablefondo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResponsableFondo(ResponsableFondo responsablefondo,Boolean conEnteros) throws Exception  {
		responsablefondo.setvalor_caja(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			responsablefondo.setsecuencial(0L);
		}
	}		
	
	public static void InicializarValoresResponsableFondos(List<ResponsableFondo> responsablefondos,Boolean conEnteros) throws Exception  {
		
		for(ResponsableFondo responsablefondo: responsablefondos) {
			responsablefondo.setvalor_caja(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				responsablefondo.setsecuencial(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaResponsableFondo(List<ResponsableFondo> responsablefondos,ResponsableFondo responsablefondoAux) throws Exception  {
		ResponsableFondoConstantesFunciones.InicializarValoresResponsableFondo(responsablefondoAux,true);
		
		for(ResponsableFondo responsablefondo: responsablefondos) {
			if(responsablefondo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			responsablefondoAux.setsecuencial(responsablefondoAux.getsecuencial()+responsablefondo.getsecuencial());			
			responsablefondoAux.setvalor_caja(responsablefondoAux.getvalor_caja()+responsablefondo.getvalor_caja());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsableFondo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResponsableFondoConstantesFunciones.getArrayColumnasGlobalesResponsableFondo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsableFondo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableFondoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableFondoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableFondoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableFondoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResponsableFondo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResponsableFondo> responsablefondos,ResponsableFondo responsablefondo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResponsableFondo responsablefondoAux: responsablefondos) {
			if(responsablefondoAux!=null && responsablefondo!=null) {
				if((responsablefondoAux.getId()==null && responsablefondo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(responsablefondoAux.getId()!=null && responsablefondo.getId()!=null){
					if(responsablefondoAux.getId().equals(responsablefondo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsableFondo(List<ResponsableFondo> responsablefondos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_cajaTotal=0.0;
	
		for(ResponsableFondo responsablefondo: responsablefondos) {			
			if(responsablefondo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_cajaTotal+=responsablefondo.getvalor_caja();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ResponsableFondoConstantesFunciones.VALORCAJA);
		datoGeneral.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_VALORCAJA);
		datoGeneral.setdValorDouble(valor_cajaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResponsableFondo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_ID, ResponsableFondoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_VERSIONROW, ResponsableFondoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_IDEMPRESA, ResponsableFondoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_IDSUCURSAL, ResponsableFondoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_IDEMPLEADO, ResponsableFondoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_SECUENCIAL, ResponsableFondoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableFondoConstantesFunciones.LABEL_VALORCAJA, ResponsableFondoConstantesFunciones.VALORCAJA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResponsableFondo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableFondoConstantesFunciones.VALORCAJA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableFondo() throws Exception  {
		return ResponsableFondoConstantesFunciones.getTiposSeleccionarResponsableFondo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableFondo(Boolean conFk) throws Exception  {
		return ResponsableFondoConstantesFunciones.getTiposSeleccionarResponsableFondo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsableFondo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableFondoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableFondoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableFondoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableFondoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableFondoConstantesFunciones.LABEL_VALORCAJA);
			reporte.setsDescripcion(ResponsableFondoConstantesFunciones.LABEL_VALORCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResponsableFondo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResponsableFondo(ResponsableFondo responsablefondoAux) throws Exception {
		
			responsablefondoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsablefondoAux.getEmpresa()));
			responsablefondoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsablefondoAux.getSucursal()));
			responsablefondoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(responsablefondoAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResponsableFondo(List<ResponsableFondo> responsablefondosTemp) throws Exception {
		for(ResponsableFondo responsablefondoAux:responsablefondosTemp) {
			
			responsablefondoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsablefondoAux.getEmpresa()));
			responsablefondoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsablefondoAux.getSucursal()));
			responsablefondoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(responsablefondoAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResponsableFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResponsableFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableFondoConstantesFunciones.getClassesRelationshipsOfResponsableFondo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaProveedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedor.class)) {
						classes.add(new Classe(FacturaProveedor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsableFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableFondoConstantesFunciones.getClassesRelationshipsFromStringsOfResponsableFondo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsableFondo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
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
	public static void actualizarLista(ResponsableFondo responsablefondo,List<ResponsableFondo> responsablefondos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ResponsableFondo responsablefondoEncontrado=null;
			
			for(ResponsableFondo responsablefondoLocal:responsablefondos) {
				if(responsablefondoLocal.getId().equals(responsablefondo.getId())) {
					responsablefondoEncontrado=responsablefondoLocal;
					
					responsablefondoLocal.setIsChanged(responsablefondo.getIsChanged());
					responsablefondoLocal.setIsNew(responsablefondo.getIsNew());
					responsablefondoLocal.setIsDeleted(responsablefondo.getIsDeleted());
					
					responsablefondoLocal.setGeneralEntityOriginal(responsablefondo.getGeneralEntityOriginal());
					
					responsablefondoLocal.setId(responsablefondo.getId());	
					responsablefondoLocal.setVersionRow(responsablefondo.getVersionRow());	
					responsablefondoLocal.setid_empresa(responsablefondo.getid_empresa());	
					responsablefondoLocal.setid_sucursal(responsablefondo.getid_sucursal());	
					responsablefondoLocal.setid_empleado(responsablefondo.getid_empleado());	
					responsablefondoLocal.setsecuencial(responsablefondo.getsecuencial());	
					responsablefondoLocal.setvalor_caja(responsablefondo.getvalor_caja());	
					
					
					responsablefondoLocal.setFacturaProveedors(responsablefondo.getFacturaProveedors());
					
					existe=true;
					break;
				}
			}
			
			if(!responsablefondo.getIsDeleted()) {
				if(!existe) {
					responsablefondos.add(responsablefondo);
				}
			} else {
				if(responsablefondoEncontrado!=null && permiteQuitar)  {
					responsablefondos.remove(responsablefondoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ResponsableFondo responsablefondo,List<ResponsableFondo> responsablefondos) throws Exception {
		try	{			
			for(ResponsableFondo responsablefondoLocal:responsablefondos) {
				if(responsablefondoLocal.getId().equals(responsablefondo.getId())) {
					responsablefondoLocal.setIsSelected(responsablefondo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResponsableFondo(List<ResponsableFondo> responsablefondosAux) throws Exception {
		//this.responsablefondosAux=responsablefondosAux;
		
		for(ResponsableFondo responsablefondoAux:responsablefondosAux) {
			if(responsablefondoAux.getIsChanged()) {
				responsablefondoAux.setIsChanged(false);
			}		
			
			if(responsablefondoAux.getIsNew()) {
				responsablefondoAux.setIsNew(false);
			}	
			
			if(responsablefondoAux.getIsDeleted()) {
				responsablefondoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResponsableFondo(ResponsableFondo responsablefondoAux) throws Exception {
		//this.responsablefondoAux=responsablefondoAux;
		
			if(responsablefondoAux.getIsChanged()) {
				responsablefondoAux.setIsChanged(false);
			}		
			
			if(responsablefondoAux.getIsNew()) {
				responsablefondoAux.setIsNew(false);
			}	
			
			if(responsablefondoAux.getIsDeleted()) {
				responsablefondoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ResponsableFondo responsablefondoAsignar,ResponsableFondo responsablefondo) throws Exception {
		responsablefondoAsignar.setId(responsablefondo.getId());	
		responsablefondoAsignar.setVersionRow(responsablefondo.getVersionRow());	
		responsablefondoAsignar.setid_empresa(responsablefondo.getid_empresa());
		responsablefondoAsignar.setempresa_descripcion(responsablefondo.getempresa_descripcion());	
		responsablefondoAsignar.setid_sucursal(responsablefondo.getid_sucursal());
		responsablefondoAsignar.setsucursal_descripcion(responsablefondo.getsucursal_descripcion());	
		responsablefondoAsignar.setid_empleado(responsablefondo.getid_empleado());
		responsablefondoAsignar.setempleado_descripcion(responsablefondo.getempleado_descripcion());	
		responsablefondoAsignar.setsecuencial(responsablefondo.getsecuencial());	
		responsablefondoAsignar.setvalor_caja(responsablefondo.getvalor_caja());	
	}
	
	public static void inicializarResponsableFondo(ResponsableFondo responsablefondo) throws Exception {
		try {
				responsablefondo.setId(0L);	
					
				responsablefondo.setid_empresa(-1L);	
				responsablefondo.setid_sucursal(-1L);	
				responsablefondo.setid_empleado(-1L);	
				responsablefondo.setsecuencial(0L);	
				responsablefondo.setvalor_caja(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResponsableFondo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableFondoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableFondoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableFondoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableFondoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableFondoConstantesFunciones.LABEL_VALORCAJA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResponsableFondo(String sTipo,Row row,Workbook workbook,ResponsableFondo responsablefondo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(responsablefondo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsablefondo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsablefondo.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsablefondo.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsablefondo.getvalor_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResponsableFondo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryResponsableFondo() {
		return this.sFinalQueryResponsableFondo;
	}
	
	public void setsFinalQueryResponsableFondo(String sFinalQueryResponsableFondo) {
		this.sFinalQueryResponsableFondo= sFinalQueryResponsableFondo;
	}
	
	public Border resaltarSeleccionarResponsableFondo=null;
	
	public Border setResaltarSeleccionarResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResponsableFondo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResponsableFondo() {
		return this.resaltarSeleccionarResponsableFondo;
	}
	
	public void setResaltarSeleccionarResponsableFondo(Border borderResaltarSeleccionarResponsableFondo) {
		this.resaltarSeleccionarResponsableFondo= borderResaltarSeleccionarResponsableFondo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResponsableFondo=null;
	public Boolean mostraridResponsableFondo=true;
	public Boolean activaridResponsableFondo=true;

	public Border resaltarid_empresaResponsableFondo=null;
	public Boolean mostrarid_empresaResponsableFondo=true;
	public Boolean activarid_empresaResponsableFondo=true;
	public Boolean cargarid_empresaResponsableFondo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaResponsableFondo=false;//ConEventDepend=true

	public Border resaltarid_sucursalResponsableFondo=null;
	public Boolean mostrarid_sucursalResponsableFondo=true;
	public Boolean activarid_sucursalResponsableFondo=true;
	public Boolean cargarid_sucursalResponsableFondo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalResponsableFondo=false;//ConEventDepend=true

	public Border resaltarid_empleadoResponsableFondo=null;
	public Boolean mostrarid_empleadoResponsableFondo=true;
	public Boolean activarid_empleadoResponsableFondo=true;
	public Boolean cargarid_empleadoResponsableFondo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoResponsableFondo=false;//ConEventDepend=true

	public Border resaltarsecuencialResponsableFondo=null;
	public Boolean mostrarsecuencialResponsableFondo=true;
	public Boolean activarsecuencialResponsableFondo=true;

	public Border resaltarvalor_cajaResponsableFondo=null;
	public Boolean mostrarvalor_cajaResponsableFondo=true;
	public Boolean activarvalor_cajaResponsableFondo=true;

	
	

	public Border setResaltaridResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltaridResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResponsableFondo() {
		return this.resaltaridResponsableFondo;
	}

	public void setResaltaridResponsableFondo(Border borderResaltar) {
		this.resaltaridResponsableFondo= borderResaltar;
	}

	public Boolean getMostraridResponsableFondo() {
		return this.mostraridResponsableFondo;
	}

	public void setMostraridResponsableFondo(Boolean mostraridResponsableFondo) {
		this.mostraridResponsableFondo= mostraridResponsableFondo;
	}

	public Boolean getActivaridResponsableFondo() {
		return this.activaridResponsableFondo;
	}

	public void setActivaridResponsableFondo(Boolean activaridResponsableFondo) {
		this.activaridResponsableFondo= activaridResponsableFondo;
	}

	public Border setResaltarid_empresaResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarid_empresaResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaResponsableFondo() {
		return this.resaltarid_empresaResponsableFondo;
	}

	public void setResaltarid_empresaResponsableFondo(Border borderResaltar) {
		this.resaltarid_empresaResponsableFondo= borderResaltar;
	}

	public Boolean getMostrarid_empresaResponsableFondo() {
		return this.mostrarid_empresaResponsableFondo;
	}

	public void setMostrarid_empresaResponsableFondo(Boolean mostrarid_empresaResponsableFondo) {
		this.mostrarid_empresaResponsableFondo= mostrarid_empresaResponsableFondo;
	}

	public Boolean getActivarid_empresaResponsableFondo() {
		return this.activarid_empresaResponsableFondo;
	}

	public void setActivarid_empresaResponsableFondo(Boolean activarid_empresaResponsableFondo) {
		this.activarid_empresaResponsableFondo= activarid_empresaResponsableFondo;
	}

	public Boolean getCargarid_empresaResponsableFondo() {
		return this.cargarid_empresaResponsableFondo;
	}

	public void setCargarid_empresaResponsableFondo(Boolean cargarid_empresaResponsableFondo) {
		this.cargarid_empresaResponsableFondo= cargarid_empresaResponsableFondo;
	}

	public Border setResaltarid_sucursalResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalResponsableFondo() {
		return this.resaltarid_sucursalResponsableFondo;
	}

	public void setResaltarid_sucursalResponsableFondo(Border borderResaltar) {
		this.resaltarid_sucursalResponsableFondo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalResponsableFondo() {
		return this.mostrarid_sucursalResponsableFondo;
	}

	public void setMostrarid_sucursalResponsableFondo(Boolean mostrarid_sucursalResponsableFondo) {
		this.mostrarid_sucursalResponsableFondo= mostrarid_sucursalResponsableFondo;
	}

	public Boolean getActivarid_sucursalResponsableFondo() {
		return this.activarid_sucursalResponsableFondo;
	}

	public void setActivarid_sucursalResponsableFondo(Boolean activarid_sucursalResponsableFondo) {
		this.activarid_sucursalResponsableFondo= activarid_sucursalResponsableFondo;
	}

	public Boolean getCargarid_sucursalResponsableFondo() {
		return this.cargarid_sucursalResponsableFondo;
	}

	public void setCargarid_sucursalResponsableFondo(Boolean cargarid_sucursalResponsableFondo) {
		this.cargarid_sucursalResponsableFondo= cargarid_sucursalResponsableFondo;
	}

	public Border setResaltarid_empleadoResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarid_empleadoResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoResponsableFondo() {
		return this.resaltarid_empleadoResponsableFondo;
	}

	public void setResaltarid_empleadoResponsableFondo(Border borderResaltar) {
		this.resaltarid_empleadoResponsableFondo= borderResaltar;
	}

	public Boolean getMostrarid_empleadoResponsableFondo() {
		return this.mostrarid_empleadoResponsableFondo;
	}

	public void setMostrarid_empleadoResponsableFondo(Boolean mostrarid_empleadoResponsableFondo) {
		this.mostrarid_empleadoResponsableFondo= mostrarid_empleadoResponsableFondo;
	}

	public Boolean getActivarid_empleadoResponsableFondo() {
		return this.activarid_empleadoResponsableFondo;
	}

	public void setActivarid_empleadoResponsableFondo(Boolean activarid_empleadoResponsableFondo) {
		this.activarid_empleadoResponsableFondo= activarid_empleadoResponsableFondo;
	}

	public Boolean getCargarid_empleadoResponsableFondo() {
		return this.cargarid_empleadoResponsableFondo;
	}

	public void setCargarid_empleadoResponsableFondo(Boolean cargarid_empleadoResponsableFondo) {
		this.cargarid_empleadoResponsableFondo= cargarid_empleadoResponsableFondo;
	}

	public Border setResaltarsecuencialResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarsecuencialResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialResponsableFondo() {
		return this.resaltarsecuencialResponsableFondo;
	}

	public void setResaltarsecuencialResponsableFondo(Border borderResaltar) {
		this.resaltarsecuencialResponsableFondo= borderResaltar;
	}

	public Boolean getMostrarsecuencialResponsableFondo() {
		return this.mostrarsecuencialResponsableFondo;
	}

	public void setMostrarsecuencialResponsableFondo(Boolean mostrarsecuencialResponsableFondo) {
		this.mostrarsecuencialResponsableFondo= mostrarsecuencialResponsableFondo;
	}

	public Boolean getActivarsecuencialResponsableFondo() {
		return this.activarsecuencialResponsableFondo;
	}

	public void setActivarsecuencialResponsableFondo(Boolean activarsecuencialResponsableFondo) {
		this.activarsecuencialResponsableFondo= activarsecuencialResponsableFondo;
	}

	public Border setResaltarvalor_cajaResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltar);
		
		this.resaltarvalor_cajaResponsableFondo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_cajaResponsableFondo() {
		return this.resaltarvalor_cajaResponsableFondo;
	}

	public void setResaltarvalor_cajaResponsableFondo(Border borderResaltar) {
		this.resaltarvalor_cajaResponsableFondo= borderResaltar;
	}

	public Boolean getMostrarvalor_cajaResponsableFondo() {
		return this.mostrarvalor_cajaResponsableFondo;
	}

	public void setMostrarvalor_cajaResponsableFondo(Boolean mostrarvalor_cajaResponsableFondo) {
		this.mostrarvalor_cajaResponsableFondo= mostrarvalor_cajaResponsableFondo;
	}

	public Boolean getActivarvalor_cajaResponsableFondo() {
		return this.activarvalor_cajaResponsableFondo;
	}

	public void setActivarvalor_cajaResponsableFondo(Boolean activarvalor_cajaResponsableFondo) {
		this.activarvalor_cajaResponsableFondo= activarvalor_cajaResponsableFondo;
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
		
		
		this.setMostraridResponsableFondo(esInicial);
		this.setMostrarid_empresaResponsableFondo(esInicial);
		this.setMostrarid_sucursalResponsableFondo(esInicial);
		this.setMostrarid_empleadoResponsableFondo(esInicial);
		this.setMostrarsecuencialResponsableFondo(esInicial);
		this.setMostrarvalor_cajaResponsableFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.ID)) {
				this.setMostraridResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.VALORCAJA)) {
				this.setMostrarvalor_cajaResponsableFondo(esAsigna);
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
		
		
		this.setActivaridResponsableFondo(esInicial);
		this.setActivarid_empresaResponsableFondo(esInicial);
		this.setActivarid_sucursalResponsableFondo(esInicial);
		this.setActivarid_empleadoResponsableFondo(esInicial);
		this.setActivarsecuencialResponsableFondo(esInicial);
		this.setActivarvalor_cajaResponsableFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.ID)) {
				this.setActivaridResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.VALORCAJA)) {
				this.setActivarvalor_cajaResponsableFondo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResponsableFondo(esInicial);
		this.setResaltarid_empresaResponsableFondo(esInicial);
		this.setResaltarid_sucursalResponsableFondo(esInicial);
		this.setResaltarid_empleadoResponsableFondo(esInicial);
		this.setResaltarsecuencialResponsableFondo(esInicial);
		this.setResaltarvalor_cajaResponsableFondo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.ID)) {
				this.setResaltaridResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialResponsableFondo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableFondoConstantesFunciones.VALORCAJA)) {
				this.setResaltarvalor_cajaResponsableFondo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaProveedorResponsableFondo=null;

	public Border getResaltarFacturaProveedorResponsableFondo() {
		return this.resaltarFacturaProveedorResponsableFondo;
	}

	public void setResaltarFacturaProveedorResponsableFondo(Border borderResaltarFacturaProveedor) {
		if(borderResaltarFacturaProveedor!=null) {
			this.resaltarFacturaProveedorResponsableFondo= borderResaltarFacturaProveedor;
		}
	}

	public Border setResaltarFacturaProveedorResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsablefondoBeanSwingJInternalFrame.jTtoolBarResponsableFondo.setBorder(borderResaltarFacturaProveedor);
			
		this.resaltarFacturaProveedorResponsableFondo= borderResaltarFacturaProveedor;

		 return borderResaltarFacturaProveedor;
	}



	public Boolean mostrarFacturaProveedorResponsableFondo=true;

	public Boolean getMostrarFacturaProveedorResponsableFondo() {
		return this.mostrarFacturaProveedorResponsableFondo;
	}

	public void setMostrarFacturaProveedorResponsableFondo(Boolean visibilidadResaltarFacturaProveedor) {
		this.mostrarFacturaProveedorResponsableFondo= visibilidadResaltarFacturaProveedor;
	}



	public Boolean activarFacturaProveedorResponsableFondo=true;

	public Boolean gethabilitarResaltarFacturaProveedorResponsableFondo() {
		return this.activarFacturaProveedorResponsableFondo;
	}

	public void setActivarFacturaProveedorResponsableFondo(Boolean habilitarResaltarFacturaProveedor) {
		this.activarFacturaProveedorResponsableFondo= habilitarResaltarFacturaProveedor;
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

		this.setMostrarFacturaProveedorResponsableFondo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaProveedor.class)) {
				this.setMostrarFacturaProveedorResponsableFondo(esAsigna);
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

		this.setActivarFacturaProveedorResponsableFondo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaProveedor.class)) {
				this.setActivarFacturaProveedorResponsableFondo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaProveedorResponsableFondo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaProveedor.class)) {
				this.setResaltarFacturaProveedorResponsableFondo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpleadoResponsableFondo=true;

	public Boolean getMostrarFK_IdEmpleadoResponsableFondo() {
		return this.mostrarFK_IdEmpleadoResponsableFondo;
	}

	public void setMostrarFK_IdEmpleadoResponsableFondo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoResponsableFondo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaResponsableFondo=true;

	public Boolean getMostrarFK_IdEmpresaResponsableFondo() {
		return this.mostrarFK_IdEmpresaResponsableFondo;
	}

	public void setMostrarFK_IdEmpresaResponsableFondo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaResponsableFondo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalResponsableFondo=true;

	public Boolean getMostrarFK_IdSucursalResponsableFondo() {
		return this.mostrarFK_IdSucursalResponsableFondo;
	}

	public void setMostrarFK_IdSucursalResponsableFondo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalResponsableFondo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoResponsableFondo=true;

	public Boolean getActivarFK_IdEmpleadoResponsableFondo() {
		return this.activarFK_IdEmpleadoResponsableFondo;
	}

	public void setActivarFK_IdEmpleadoResponsableFondo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoResponsableFondo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaResponsableFondo=true;

	public Boolean getActivarFK_IdEmpresaResponsableFondo() {
		return this.activarFK_IdEmpresaResponsableFondo;
	}

	public void setActivarFK_IdEmpresaResponsableFondo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaResponsableFondo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalResponsableFondo=true;

	public Boolean getActivarFK_IdSucursalResponsableFondo() {
		return this.activarFK_IdSucursalResponsableFondo;
	}

	public void setActivarFK_IdSucursalResponsableFondo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalResponsableFondo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoResponsableFondo=null;

	public Border getResaltarFK_IdEmpleadoResponsableFondo() {
		return this.resaltarFK_IdEmpleadoResponsableFondo;
	}

	public void setResaltarFK_IdEmpleadoResponsableFondo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoResponsableFondo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoResponsableFondo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaResponsableFondo=null;

	public Border getResaltarFK_IdEmpresaResponsableFondo() {
		return this.resaltarFK_IdEmpresaResponsableFondo;
	}

	public void setResaltarFK_IdEmpresaResponsableFondo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaResponsableFondo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaResponsableFondo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalResponsableFondo=null;

	public Border getResaltarFK_IdSucursalResponsableFondo() {
		return this.resaltarFK_IdSucursalResponsableFondo;
	}

	public void setResaltarFK_IdSucursalResponsableFondo(Border borderResaltar) {
		this.resaltarFK_IdSucursalResponsableFondo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalResponsableFondo(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableFondoBeanSwingJInternalFrame responsablefondoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalResponsableFondo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}