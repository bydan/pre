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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.GrupoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.GrupoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.GrupoClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GrupoClienteConstantesFunciones extends GrupoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoCliente"+GrupoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoClienteConstantesFunciones.SCHEMA+"_"+GrupoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoClienteConstantesFunciones.SCHEMA+"_"+GrupoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoClienteConstantesFunciones.SCHEMA+"_"+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoClienteConstantesFunciones.SCHEMA+"_"+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Grupo Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoCliente";
	public static final String OBJECTNAME="grupocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="grupo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupocliente from "+GrupoClienteConstantesFunciones.SPERSISTENCENAME+" grupocliente";
	public static String QUERYSELECTNATIVE="select "+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".id,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".version_row,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".id_empresa,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".id_modulo,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".codigo,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".nombre,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".siglas,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".secuencial,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".descripcion,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".es_prove,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".id_cuenta_contable,"+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME+".id_centro_costo from "+GrupoClienteConstantesFunciones.SCHEMA+"."+GrupoClienteConstantesFunciones.TABLENAME;//+" as "+GrupoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GrupoClienteConstantesFuncionesAdditional grupoclienteConstantesFuncionesAdditional=null;
	
	public GrupoClienteConstantesFuncionesAdditional getGrupoClienteConstantesFuncionesAdditional() {
		return this.grupoclienteConstantesFuncionesAdditional;
	}
	
	public void setGrupoClienteConstantesFuncionesAdditional(GrupoClienteConstantesFuncionesAdditional grupoclienteConstantesFuncionesAdditional) {
		try {
			this.grupoclienteConstantesFuncionesAdditional=grupoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String SECUENCIAL= "secuencial";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESPROVE= "es_prove";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCENTROCOSTO= "id_centro_costo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESPROVE= "Es Proveedor";
		public static final String LABEL_ESPROVE_LOWER= "Es Prove";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getGrupoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.IDMODULO)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.CODIGO)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.NOMBRE)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.SIGLAS)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.SECUENCIAL)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.ESPROVE)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_ESPROVE;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(GrupoClienteConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=GrupoClienteConstantesFunciones.LABEL_IDCENTROCOSTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_proveDescripcion(GrupoCliente grupocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!grupocliente.getes_prove()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveHtmlDescripcion(GrupoCliente grupocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(grupocliente.getId(),grupocliente.getes_prove());

		return sDescripcion;
	}	
			
			
	
	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupocliente !=null/* && grupocliente.getId()!=0*/) {
			sDescripcion=grupocliente.getcodigo()+"-"+grupocliente.getnombre();//grupoclientegrupocliente.getcodigo().trim()+"-"+grupocliente.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoClienteDescripcionDetallado(GrupoCliente grupocliente) {
		String sDescripcion="";
			
		sDescripcion+=GrupoClienteConstantesFunciones.ID+"=";
		sDescripcion+=grupocliente.getId().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupocliente.getVersionRow().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=grupocliente.getid_empresa().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.IDMODULO+"=";
		sDescripcion+=grupocliente.getid_modulo().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=grupocliente.getcodigo()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=grupocliente.getnombre()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.SIGLAS+"=";
		sDescripcion+=grupocliente.getsiglas()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=grupocliente.getsecuencial()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=grupocliente.getdescripcion()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.ESPROVE+"=";
		sDescripcion+=grupocliente.getes_prove().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=grupocliente.getid_cuenta_contable().toString()+",";
		sDescripcion+=GrupoClienteConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=grupocliente.getid_centro_costo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoClienteDescripcion(GrupoCliente grupocliente,String sValor) throws Exception {			
		if(grupocliente !=null) {
			grupocliente.setcodigo(sValor);
grupocliente.setnombre(sValor);;//grupoclientegrupocliente.getcodigo().trim()+"-"+grupocliente.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("PorEmpresaPorCodigo")) {
			sNombreIndice="Tipo=  Por Empresa Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorCodigo(Long id_empresa,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGrupoCliente(GrupoCliente grupocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		grupocliente.setcodigo(grupocliente.getcodigo().trim());
		grupocliente.setnombre(grupocliente.getnombre().trim());
		grupocliente.setsiglas(grupocliente.getsiglas().trim());
		grupocliente.setsecuencial(grupocliente.getsecuencial().trim());
		grupocliente.setdescripcion(grupocliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosGrupoClientes(List<GrupoCliente> grupoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoCliente grupocliente: grupoclientes) {
			grupocliente.setcodigo(grupocliente.getcodigo().trim());
			grupocliente.setnombre(grupocliente.getnombre().trim());
			grupocliente.setsiglas(grupocliente.getsiglas().trim());
			grupocliente.setsecuencial(grupocliente.getsecuencial().trim());
			grupocliente.setdescripcion(grupocliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoCliente(GrupoCliente grupocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupocliente.getConCambioAuxiliar()) {
			grupocliente.setIsDeleted(grupocliente.getIsDeletedAuxiliar());	
			grupocliente.setIsNew(grupocliente.getIsNewAuxiliar());	
			grupocliente.setIsChanged(grupocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupocliente.setIsDeletedAuxiliar(false);	
			grupocliente.setIsNewAuxiliar(false);	
			grupocliente.setIsChangedAuxiliar(false);
			
			grupocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoClientes(List<GrupoCliente> grupoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoCliente grupocliente : grupoclientes) {
			if(conAsignarBase && grupocliente.getConCambioAuxiliar()) {
				grupocliente.setIsDeleted(grupocliente.getIsDeletedAuxiliar());	
				grupocliente.setIsNew(grupocliente.getIsNewAuxiliar());	
				grupocliente.setIsChanged(grupocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupocliente.setIsDeletedAuxiliar(false);	
				grupocliente.setIsNewAuxiliar(false);	
				grupocliente.setIsChangedAuxiliar(false);
				
				grupocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoCliente(GrupoCliente grupocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGrupoClientes(List<GrupoCliente> grupoclientes,Boolean conEnteros) throws Exception  {
		
		for(GrupoCliente grupocliente: grupoclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoCliente(List<GrupoCliente> grupoclientes,GrupoCliente grupoclienteAux) throws Exception  {
		GrupoClienteConstantesFunciones.InicializarValoresGrupoCliente(grupoclienteAux,true);
		
		for(GrupoCliente grupocliente: grupoclientes) {
			if(grupocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoClienteConstantesFunciones.getArrayColumnasGlobalesGrupoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoClienteConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoClienteConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoCliente> grupoclientes,GrupoCliente grupocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoCliente grupoclienteAux: grupoclientes) {
			if(grupoclienteAux!=null && grupocliente!=null) {
				if((grupoclienteAux.getId()==null && grupocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupoclienteAux.getId()!=null && grupocliente.getId()!=null){
					if(grupoclienteAux.getId().equals(grupocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoCliente(List<GrupoCliente> grupoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoCliente grupocliente: grupoclientes) {			
			if(grupocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_ID, GrupoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_VERSIONROW, GrupoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_IDEMPRESA, GrupoClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_IDMODULO, GrupoClienteConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_CODIGO, GrupoClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_NOMBRE, GrupoClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_SIGLAS, GrupoClienteConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_SECUENCIAL, GrupoClienteConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_DESCRIPCION, GrupoClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_ESPROVE, GrupoClienteConstantesFunciones.ESPROVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_IDCUENTACONTABLE, GrupoClienteConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoClienteConstantesFunciones.LABEL_IDCENTROCOSTO, GrupoClienteConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.ESPROVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoClienteConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoCliente() throws Exception  {
		return GrupoClienteConstantesFunciones.getTiposSeleccionarGrupoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoCliente(Boolean conFk) throws Exception  {
		return GrupoClienteConstantesFunciones.getTiposSeleccionarGrupoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_ESPROVE);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_ESPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoClienteConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(GrupoClienteConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoCliente(GrupoCliente grupoclienteAux) throws Exception {
		
			grupoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoclienteAux.getEmpresa()));
			grupoclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(grupoclienteAux.getModulo()));
			grupoclienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupoclienteAux.getCuentaContable()));
			grupoclienteAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(grupoclienteAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoCliente(List<GrupoCliente> grupoclientesTemp) throws Exception {
		for(GrupoCliente grupoclienteAux:grupoclientesTemp) {
			
			grupoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoclienteAux.getEmpresa()));
			grupoclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(grupoclienteAux.getModulo()));
			grupoclienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(grupoclienteAux.getCuentaContable()));
			grupoclienteAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(grupoclienteAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CentroCosto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoClienteConstantesFunciones.getClassesRelationshipsOfGrupoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(GrupoClienteFormaPago.class));
				classes.add(new Classe(PoliticaFactu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoClienteFormaPago.class)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticaFactu.class)) {
						classes.add(new Classe(PoliticaFactu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(GrupoClienteFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); continue;
					}

					if(PoliticaFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaFactu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(GrupoClienteFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); continue;
					}

					if(PoliticaFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaFactu.class)); continue;
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
	public static void actualizarLista(GrupoCliente grupocliente,List<GrupoCliente> grupoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoCliente grupoclienteEncontrado=null;
			
			for(GrupoCliente grupoclienteLocal:grupoclientes) {
				if(grupoclienteLocal.getId().equals(grupocliente.getId())) {
					grupoclienteEncontrado=grupoclienteLocal;
					
					grupoclienteLocal.setIsChanged(grupocliente.getIsChanged());
					grupoclienteLocal.setIsNew(grupocliente.getIsNew());
					grupoclienteLocal.setIsDeleted(grupocliente.getIsDeleted());
					
					grupoclienteLocal.setGeneralEntityOriginal(grupocliente.getGeneralEntityOriginal());
					
					grupoclienteLocal.setId(grupocliente.getId());	
					grupoclienteLocal.setVersionRow(grupocliente.getVersionRow());	
					grupoclienteLocal.setid_empresa(grupocliente.getid_empresa());	
					grupoclienteLocal.setid_modulo(grupocliente.getid_modulo());	
					grupoclienteLocal.setcodigo(grupocliente.getcodigo());	
					grupoclienteLocal.setnombre(grupocliente.getnombre());	
					grupoclienteLocal.setsiglas(grupocliente.getsiglas());	
					grupoclienteLocal.setsecuencial(grupocliente.getsecuencial());	
					grupoclienteLocal.setdescripcion(grupocliente.getdescripcion());	
					grupoclienteLocal.setes_prove(grupocliente.getes_prove());	
					grupoclienteLocal.setid_cuenta_contable(grupocliente.getid_cuenta_contable());	
					grupoclienteLocal.setid_centro_costo(grupocliente.getid_centro_costo());	
					
					
					grupoclienteLocal.setClientes(grupocliente.getClientes());
					grupoclienteLocal.setGrupoClienteFormaPagos(grupocliente.getGrupoClienteFormaPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!grupocliente.getIsDeleted()) {
				if(!existe) {
					grupoclientes.add(grupocliente);
				}
			} else {
				if(grupoclienteEncontrado!=null && permiteQuitar)  {
					grupoclientes.remove(grupoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoCliente grupocliente,List<GrupoCliente> grupoclientes) throws Exception {
		try	{			
			for(GrupoCliente grupoclienteLocal:grupoclientes) {
				if(grupoclienteLocal.getId().equals(grupocliente.getId())) {
					grupoclienteLocal.setIsSelected(grupocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoCliente(List<GrupoCliente> grupoclientesAux) throws Exception {
		//this.grupoclientesAux=grupoclientesAux;
		
		for(GrupoCliente grupoclienteAux:grupoclientesAux) {
			if(grupoclienteAux.getIsChanged()) {
				grupoclienteAux.setIsChanged(false);
			}		
			
			if(grupoclienteAux.getIsNew()) {
				grupoclienteAux.setIsNew(false);
			}	
			
			if(grupoclienteAux.getIsDeleted()) {
				grupoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoCliente(GrupoCliente grupoclienteAux) throws Exception {
		//this.grupoclienteAux=grupoclienteAux;
		
			if(grupoclienteAux.getIsChanged()) {
				grupoclienteAux.setIsChanged(false);
			}		
			
			if(grupoclienteAux.getIsNew()) {
				grupoclienteAux.setIsNew(false);
			}	
			
			if(grupoclienteAux.getIsDeleted()) {
				grupoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoCliente grupoclienteAsignar,GrupoCliente grupocliente) throws Exception {
		grupoclienteAsignar.setId(grupocliente.getId());	
		grupoclienteAsignar.setVersionRow(grupocliente.getVersionRow());	
		grupoclienteAsignar.setid_empresa(grupocliente.getid_empresa());
		grupoclienteAsignar.setempresa_descripcion(grupocliente.getempresa_descripcion());	
		grupoclienteAsignar.setid_modulo(grupocliente.getid_modulo());
		grupoclienteAsignar.setmodulo_descripcion(grupocliente.getmodulo_descripcion());	
		grupoclienteAsignar.setcodigo(grupocliente.getcodigo());	
		grupoclienteAsignar.setnombre(grupocliente.getnombre());	
		grupoclienteAsignar.setsiglas(grupocliente.getsiglas());	
		grupoclienteAsignar.setsecuencial(grupocliente.getsecuencial());	
		grupoclienteAsignar.setdescripcion(grupocliente.getdescripcion());	
		grupoclienteAsignar.setes_prove(grupocliente.getes_prove());	
		grupoclienteAsignar.setid_cuenta_contable(grupocliente.getid_cuenta_contable());
		grupoclienteAsignar.setcuentacontable_descripcion(grupocliente.getcuentacontable_descripcion());	
		grupoclienteAsignar.setid_centro_costo(grupocliente.getid_centro_costo());
		grupoclienteAsignar.setcentrocosto_descripcion(grupocliente.getcentrocosto_descripcion());	
	}
	
	public static void inicializarGrupoCliente(GrupoCliente grupocliente) throws Exception {
		try {
				grupocliente.setId(0L);	
					
				grupocliente.setid_empresa(-1L);	
				grupocliente.setid_modulo(-1L);	
				grupocliente.setcodigo("");	
				grupocliente.setnombre("");	
				grupocliente.setsiglas("");	
				grupocliente.setsecuencial("");	
				grupocliente.setdescripcion("");	
				grupocliente.setes_prove(false);	
				grupocliente.setid_cuenta_contable(null);	
				grupocliente.setid_centro_costo(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_ESPROVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoClienteConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoCliente(String sTipo,Row row,Workbook workbook,GrupoCliente grupocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(grupocliente.getes_prove()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocliente.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoCliente() {
		return this.sFinalQueryGrupoCliente;
	}
	
	public void setsFinalQueryGrupoCliente(String sFinalQueryGrupoCliente) {
		this.sFinalQueryGrupoCliente= sFinalQueryGrupoCliente;
	}
	
	public Border resaltarSeleccionarGrupoCliente=null;
	
	public Border setResaltarSeleccionarGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoCliente() {
		return this.resaltarSeleccionarGrupoCliente;
	}
	
	public void setResaltarSeleccionarGrupoCliente(Border borderResaltarSeleccionarGrupoCliente) {
		this.resaltarSeleccionarGrupoCliente= borderResaltarSeleccionarGrupoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoCliente=null;
	public Boolean mostraridGrupoCliente=true;
	public Boolean activaridGrupoCliente=true;

	public Border resaltarid_empresaGrupoCliente=null;
	public Boolean mostrarid_empresaGrupoCliente=true;
	public Boolean activarid_empresaGrupoCliente=true;
	public Boolean cargarid_empresaGrupoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGrupoCliente=false;//ConEventDepend=true

	public Border resaltarid_moduloGrupoCliente=null;
	public Boolean mostrarid_moduloGrupoCliente=true;
	public Boolean activarid_moduloGrupoCliente=true;
	public Boolean cargarid_moduloGrupoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloGrupoCliente=false;//ConEventDepend=true

	public Border resaltarcodigoGrupoCliente=null;
	public Boolean mostrarcodigoGrupoCliente=true;
	public Boolean activarcodigoGrupoCliente=true;

	public Border resaltarnombreGrupoCliente=null;
	public Boolean mostrarnombreGrupoCliente=true;
	public Boolean activarnombreGrupoCliente=true;

	public Border resaltarsiglasGrupoCliente=null;
	public Boolean mostrarsiglasGrupoCliente=true;
	public Boolean activarsiglasGrupoCliente=true;

	public Border resaltarsecuencialGrupoCliente=null;
	public Boolean mostrarsecuencialGrupoCliente=true;
	public Boolean activarsecuencialGrupoCliente=true;

	public Border resaltardescripcionGrupoCliente=null;
	public Boolean mostrardescripcionGrupoCliente=true;
	public Boolean activardescripcionGrupoCliente=true;

	public Border resaltares_proveGrupoCliente=null;
	public Boolean mostrares_proveGrupoCliente=true;
	public Boolean activares_proveGrupoCliente=true;

	public Border resaltarid_cuenta_contableGrupoCliente=null;
	public Boolean mostrarid_cuenta_contableGrupoCliente=true;
	public Boolean activarid_cuenta_contableGrupoCliente=true;
	public Boolean cargarid_cuenta_contableGrupoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableGrupoCliente=false;//ConEventDepend=true

	public Border resaltarid_centro_costoGrupoCliente=null;
	public Boolean mostrarid_centro_costoGrupoCliente=true;
	public Boolean activarid_centro_costoGrupoCliente=true;
	public Boolean cargarid_centro_costoGrupoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoGrupoCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltaridGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoCliente() {
		return this.resaltaridGrupoCliente;
	}

	public void setResaltaridGrupoCliente(Border borderResaltar) {
		this.resaltaridGrupoCliente= borderResaltar;
	}

	public Boolean getMostraridGrupoCliente() {
		return this.mostraridGrupoCliente;
	}

	public void setMostraridGrupoCliente(Boolean mostraridGrupoCliente) {
		this.mostraridGrupoCliente= mostraridGrupoCliente;
	}

	public Boolean getActivaridGrupoCliente() {
		return this.activaridGrupoCliente;
	}

	public void setActivaridGrupoCliente(Boolean activaridGrupoCliente) {
		this.activaridGrupoCliente= activaridGrupoCliente;
	}

	public Border setResaltarid_empresaGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGrupoCliente() {
		return this.resaltarid_empresaGrupoCliente;
	}

	public void setResaltarid_empresaGrupoCliente(Border borderResaltar) {
		this.resaltarid_empresaGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaGrupoCliente() {
		return this.mostrarid_empresaGrupoCliente;
	}

	public void setMostrarid_empresaGrupoCliente(Boolean mostrarid_empresaGrupoCliente) {
		this.mostrarid_empresaGrupoCliente= mostrarid_empresaGrupoCliente;
	}

	public Boolean getActivarid_empresaGrupoCliente() {
		return this.activarid_empresaGrupoCliente;
	}

	public void setActivarid_empresaGrupoCliente(Boolean activarid_empresaGrupoCliente) {
		this.activarid_empresaGrupoCliente= activarid_empresaGrupoCliente;
	}

	public Boolean getCargarid_empresaGrupoCliente() {
		return this.cargarid_empresaGrupoCliente;
	}

	public void setCargarid_empresaGrupoCliente(Boolean cargarid_empresaGrupoCliente) {
		this.cargarid_empresaGrupoCliente= cargarid_empresaGrupoCliente;
	}

	public Border setResaltarid_moduloGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarid_moduloGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloGrupoCliente() {
		return this.resaltarid_moduloGrupoCliente;
	}

	public void setResaltarid_moduloGrupoCliente(Border borderResaltar) {
		this.resaltarid_moduloGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarid_moduloGrupoCliente() {
		return this.mostrarid_moduloGrupoCliente;
	}

	public void setMostrarid_moduloGrupoCliente(Boolean mostrarid_moduloGrupoCliente) {
		this.mostrarid_moduloGrupoCliente= mostrarid_moduloGrupoCliente;
	}

	public Boolean getActivarid_moduloGrupoCliente() {
		return this.activarid_moduloGrupoCliente;
	}

	public void setActivarid_moduloGrupoCliente(Boolean activarid_moduloGrupoCliente) {
		this.activarid_moduloGrupoCliente= activarid_moduloGrupoCliente;
	}

	public Boolean getCargarid_moduloGrupoCliente() {
		return this.cargarid_moduloGrupoCliente;
	}

	public void setCargarid_moduloGrupoCliente(Boolean cargarid_moduloGrupoCliente) {
		this.cargarid_moduloGrupoCliente= cargarid_moduloGrupoCliente;
	}

	public Border setResaltarcodigoGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoGrupoCliente() {
		return this.resaltarcodigoGrupoCliente;
	}

	public void setResaltarcodigoGrupoCliente(Border borderResaltar) {
		this.resaltarcodigoGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoGrupoCliente() {
		return this.mostrarcodigoGrupoCliente;
	}

	public void setMostrarcodigoGrupoCliente(Boolean mostrarcodigoGrupoCliente) {
		this.mostrarcodigoGrupoCliente= mostrarcodigoGrupoCliente;
	}

	public Boolean getActivarcodigoGrupoCliente() {
		return this.activarcodigoGrupoCliente;
	}

	public void setActivarcodigoGrupoCliente(Boolean activarcodigoGrupoCliente) {
		this.activarcodigoGrupoCliente= activarcodigoGrupoCliente;
	}

	public Border setResaltarnombreGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarnombreGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreGrupoCliente() {
		return this.resaltarnombreGrupoCliente;
	}

	public void setResaltarnombreGrupoCliente(Border borderResaltar) {
		this.resaltarnombreGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarnombreGrupoCliente() {
		return this.mostrarnombreGrupoCliente;
	}

	public void setMostrarnombreGrupoCliente(Boolean mostrarnombreGrupoCliente) {
		this.mostrarnombreGrupoCliente= mostrarnombreGrupoCliente;
	}

	public Boolean getActivarnombreGrupoCliente() {
		return this.activarnombreGrupoCliente;
	}

	public void setActivarnombreGrupoCliente(Boolean activarnombreGrupoCliente) {
		this.activarnombreGrupoCliente= activarnombreGrupoCliente;
	}

	public Border setResaltarsiglasGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarsiglasGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasGrupoCliente() {
		return this.resaltarsiglasGrupoCliente;
	}

	public void setResaltarsiglasGrupoCliente(Border borderResaltar) {
		this.resaltarsiglasGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarsiglasGrupoCliente() {
		return this.mostrarsiglasGrupoCliente;
	}

	public void setMostrarsiglasGrupoCliente(Boolean mostrarsiglasGrupoCliente) {
		this.mostrarsiglasGrupoCliente= mostrarsiglasGrupoCliente;
	}

	public Boolean getActivarsiglasGrupoCliente() {
		return this.activarsiglasGrupoCliente;
	}

	public void setActivarsiglasGrupoCliente(Boolean activarsiglasGrupoCliente) {
		this.activarsiglasGrupoCliente= activarsiglasGrupoCliente;
	}

	public Border setResaltarsecuencialGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarsecuencialGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialGrupoCliente() {
		return this.resaltarsecuencialGrupoCliente;
	}

	public void setResaltarsecuencialGrupoCliente(Border borderResaltar) {
		this.resaltarsecuencialGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarsecuencialGrupoCliente() {
		return this.mostrarsecuencialGrupoCliente;
	}

	public void setMostrarsecuencialGrupoCliente(Boolean mostrarsecuencialGrupoCliente) {
		this.mostrarsecuencialGrupoCliente= mostrarsecuencialGrupoCliente;
	}

	public Boolean getActivarsecuencialGrupoCliente() {
		return this.activarsecuencialGrupoCliente;
	}

	public void setActivarsecuencialGrupoCliente(Boolean activarsecuencialGrupoCliente) {
		this.activarsecuencialGrupoCliente= activarsecuencialGrupoCliente;
	}

	public Border setResaltardescripcionGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionGrupoCliente() {
		return this.resaltardescripcionGrupoCliente;
	}

	public void setResaltardescripcionGrupoCliente(Border borderResaltar) {
		this.resaltardescripcionGrupoCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionGrupoCliente() {
		return this.mostrardescripcionGrupoCliente;
	}

	public void setMostrardescripcionGrupoCliente(Boolean mostrardescripcionGrupoCliente) {
		this.mostrardescripcionGrupoCliente= mostrardescripcionGrupoCliente;
	}

	public Boolean getActivardescripcionGrupoCliente() {
		return this.activardescripcionGrupoCliente;
	}

	public void setActivardescripcionGrupoCliente(Boolean activardescripcionGrupoCliente) {
		this.activardescripcionGrupoCliente= activardescripcionGrupoCliente;
	}

	public Border setResaltares_proveGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltares_proveGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveGrupoCliente() {
		return this.resaltares_proveGrupoCliente;
	}

	public void setResaltares_proveGrupoCliente(Border borderResaltar) {
		this.resaltares_proveGrupoCliente= borderResaltar;
	}

	public Boolean getMostrares_proveGrupoCliente() {
		return this.mostrares_proveGrupoCliente;
	}

	public void setMostrares_proveGrupoCliente(Boolean mostrares_proveGrupoCliente) {
		this.mostrares_proveGrupoCliente= mostrares_proveGrupoCliente;
	}

	public Boolean getActivares_proveGrupoCliente() {
		return this.activares_proveGrupoCliente;
	}

	public void setActivares_proveGrupoCliente(Boolean activares_proveGrupoCliente) {
		this.activares_proveGrupoCliente= activares_proveGrupoCliente;
	}

	public Border setResaltarid_cuenta_contableGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableGrupoCliente() {
		return this.resaltarid_cuenta_contableGrupoCliente;
	}

	public void setResaltarid_cuenta_contableGrupoCliente(Border borderResaltar) {
		this.resaltarid_cuenta_contableGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableGrupoCliente() {
		return this.mostrarid_cuenta_contableGrupoCliente;
	}

	public void setMostrarid_cuenta_contableGrupoCliente(Boolean mostrarid_cuenta_contableGrupoCliente) {
		this.mostrarid_cuenta_contableGrupoCliente= mostrarid_cuenta_contableGrupoCliente;
	}

	public Boolean getActivarid_cuenta_contableGrupoCliente() {
		return this.activarid_cuenta_contableGrupoCliente;
	}

	public void setActivarid_cuenta_contableGrupoCliente(Boolean activarid_cuenta_contableGrupoCliente) {
		this.activarid_cuenta_contableGrupoCliente= activarid_cuenta_contableGrupoCliente;
	}

	public Boolean getCargarid_cuenta_contableGrupoCliente() {
		return this.cargarid_cuenta_contableGrupoCliente;
	}

	public void setCargarid_cuenta_contableGrupoCliente(Boolean cargarid_cuenta_contableGrupoCliente) {
		this.cargarid_cuenta_contableGrupoCliente= cargarid_cuenta_contableGrupoCliente;
	}

	public Border setResaltarid_centro_costoGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoGrupoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoGrupoCliente() {
		return this.resaltarid_centro_costoGrupoCliente;
	}

	public void setResaltarid_centro_costoGrupoCliente(Border borderResaltar) {
		this.resaltarid_centro_costoGrupoCliente= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoGrupoCliente() {
		return this.mostrarid_centro_costoGrupoCliente;
	}

	public void setMostrarid_centro_costoGrupoCliente(Boolean mostrarid_centro_costoGrupoCliente) {
		this.mostrarid_centro_costoGrupoCliente= mostrarid_centro_costoGrupoCliente;
	}

	public Boolean getActivarid_centro_costoGrupoCliente() {
		return this.activarid_centro_costoGrupoCliente;
	}

	public void setActivarid_centro_costoGrupoCliente(Boolean activarid_centro_costoGrupoCliente) {
		this.activarid_centro_costoGrupoCliente= activarid_centro_costoGrupoCliente;
	}

	public Boolean getCargarid_centro_costoGrupoCliente() {
		return this.cargarid_centro_costoGrupoCliente;
	}

	public void setCargarid_centro_costoGrupoCliente(Boolean cargarid_centro_costoGrupoCliente) {
		this.cargarid_centro_costoGrupoCliente= cargarid_centro_costoGrupoCliente;
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
		
		
		this.setMostraridGrupoCliente(esInicial);
		this.setMostrarid_empresaGrupoCliente(esInicial);
		this.setMostrarid_moduloGrupoCliente(esInicial);
		this.setMostrarcodigoGrupoCliente(esInicial);
		this.setMostrarnombreGrupoCliente(esInicial);
		this.setMostrarsiglasGrupoCliente(esInicial);
		this.setMostrarsecuencialGrupoCliente(esInicial);
		this.setMostrardescripcionGrupoCliente(esInicial);
		this.setMostrares_proveGrupoCliente(esInicial);
		this.setMostrarid_cuenta_contableGrupoCliente(esInicial);
		this.setMostrarid_centro_costoGrupoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ID)) {
				this.setMostraridGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ESPROVE)) {
				this.setMostrares_proveGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoGrupoCliente(esAsigna);
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
		
		
		this.setActivaridGrupoCliente(esInicial);
		this.setActivarid_empresaGrupoCliente(esInicial);
		this.setActivarid_moduloGrupoCliente(esInicial);
		this.setActivarcodigoGrupoCliente(esInicial);
		this.setActivarnombreGrupoCliente(esInicial);
		this.setActivarsiglasGrupoCliente(esInicial);
		this.setActivarsecuencialGrupoCliente(esInicial);
		this.setActivardescripcionGrupoCliente(esInicial);
		this.setActivares_proveGrupoCliente(esInicial);
		this.setActivarid_cuenta_contableGrupoCliente(esInicial);
		this.setActivarid_centro_costoGrupoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ID)) {
				this.setActivaridGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ESPROVE)) {
				this.setActivares_proveGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoGrupoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoCliente(esInicial);
		this.setResaltarid_empresaGrupoCliente(esInicial);
		this.setResaltarid_moduloGrupoCliente(esInicial);
		this.setResaltarcodigoGrupoCliente(esInicial);
		this.setResaltarnombreGrupoCliente(esInicial);
		this.setResaltarsiglasGrupoCliente(esInicial);
		this.setResaltarsecuencialGrupoCliente(esInicial);
		this.setResaltardescripcionGrupoCliente(esInicial);
		this.setResaltares_proveGrupoCliente(esInicial);
		this.setResaltarid_cuenta_contableGrupoCliente(esInicial);
		this.setResaltarid_centro_costoGrupoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ID)) {
				this.setResaltaridGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.ESPROVE)) {
				this.setResaltares_proveGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableGrupoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoClienteConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoGrupoCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteGrupoCliente=null;

	public Border getResaltarClienteGrupoCliente() {
		return this.resaltarClienteGrupoCliente;
	}

	public void setResaltarClienteGrupoCliente(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteGrupoCliente= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltarCliente);
			
		this.resaltarClienteGrupoCliente= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteGrupoCliente=true;

	public Boolean getMostrarClienteGrupoCliente() {
		return this.mostrarClienteGrupoCliente;
	}

	public void setMostrarClienteGrupoCliente(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteGrupoCliente= visibilidadResaltarCliente;
	}



	public Boolean activarClienteGrupoCliente=true;

	public Boolean gethabilitarResaltarClienteGrupoCliente() {
		return this.activarClienteGrupoCliente;
	}

	public void setActivarClienteGrupoCliente(Boolean habilitarResaltarCliente) {
		this.activarClienteGrupoCliente= habilitarResaltarCliente;
	}


	public Border resaltarGrupoClienteFormaPagoGrupoCliente=null;

	public Border getResaltarGrupoClienteFormaPagoGrupoCliente() {
		return this.resaltarGrupoClienteFormaPagoGrupoCliente;
	}

	public void setResaltarGrupoClienteFormaPagoGrupoCliente(Border borderResaltarGrupoClienteFormaPago) {
		if(borderResaltarGrupoClienteFormaPago!=null) {
			this.resaltarGrupoClienteFormaPagoGrupoCliente= borderResaltarGrupoClienteFormaPago;
		}
	}

	public Border setResaltarGrupoClienteFormaPagoGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarGrupoClienteFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoclienteBeanSwingJInternalFrame.jTtoolBarGrupoCliente.setBorder(borderResaltarGrupoClienteFormaPago);
			
		this.resaltarGrupoClienteFormaPagoGrupoCliente= borderResaltarGrupoClienteFormaPago;

		 return borderResaltarGrupoClienteFormaPago;
	}



	public Boolean mostrarGrupoClienteFormaPagoGrupoCliente=true;

	public Boolean getMostrarGrupoClienteFormaPagoGrupoCliente() {
		return this.mostrarGrupoClienteFormaPagoGrupoCliente;
	}

	public void setMostrarGrupoClienteFormaPagoGrupoCliente(Boolean visibilidadResaltarGrupoClienteFormaPago) {
		this.mostrarGrupoClienteFormaPagoGrupoCliente= visibilidadResaltarGrupoClienteFormaPago;
	}



	public Boolean activarGrupoClienteFormaPagoGrupoCliente=true;

	public Boolean gethabilitarResaltarGrupoClienteFormaPagoGrupoCliente() {
		return this.activarGrupoClienteFormaPagoGrupoCliente;
	}

	public void setActivarGrupoClienteFormaPagoGrupoCliente(Boolean habilitarResaltarGrupoClienteFormaPago) {
		this.activarGrupoClienteFormaPagoGrupoCliente= habilitarResaltarGrupoClienteFormaPago;
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

		this.setMostrarClienteGrupoCliente(esInicial);
		this.setMostrarGrupoClienteFormaPagoGrupoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteGrupoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setMostrarGrupoClienteFormaPagoGrupoCliente(esAsigna);
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

		this.setActivarClienteGrupoCliente(esInicial);
		this.setActivarGrupoClienteFormaPagoGrupoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteGrupoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setActivarGrupoClienteFormaPagoGrupoCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteGrupoCliente(esInicial);
		this.setResaltarGrupoClienteFormaPagoGrupoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteGrupoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setResaltarGrupoClienteFormaPagoGrupoCliente(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoGrupoCliente=true;

	public Boolean getMostrarBusquedaPorCodigoGrupoCliente() {
		return this.mostrarBusquedaPorCodigoGrupoCliente;
	}

	public void setMostrarBusquedaPorCodigoGrupoCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoGrupoCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreGrupoCliente=true;

	public Boolean getMostrarBusquedaPorNombreGrupoCliente() {
		return this.mostrarBusquedaPorNombreGrupoCliente;
	}

	public void setMostrarBusquedaPorNombreGrupoCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreGrupoCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasGrupoCliente=true;

	public Boolean getMostrarBusquedaPorSiglasGrupoCliente() {
		return this.mostrarBusquedaPorSiglasGrupoCliente;
	}

	public void setMostrarBusquedaPorSiglasGrupoCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasGrupoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGrupoCliente=true;

	public Boolean getMostrarFK_IdEmpresaGrupoCliente() {
		return this.mostrarFK_IdEmpresaGrupoCliente;
	}

	public void setMostrarFK_IdEmpresaGrupoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGrupoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoGrupoCliente=true;

	public Boolean getActivarBusquedaPorCodigoGrupoCliente() {
		return this.activarBusquedaPorCodigoGrupoCliente;
	}

	public void setActivarBusquedaPorCodigoGrupoCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoGrupoCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreGrupoCliente=true;

	public Boolean getActivarBusquedaPorNombreGrupoCliente() {
		return this.activarBusquedaPorNombreGrupoCliente;
	}

	public void setActivarBusquedaPorNombreGrupoCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreGrupoCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasGrupoCliente=true;

	public Boolean getActivarBusquedaPorSiglasGrupoCliente() {
		return this.activarBusquedaPorSiglasGrupoCliente;
	}

	public void setActivarBusquedaPorSiglasGrupoCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasGrupoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGrupoCliente=true;

	public Boolean getActivarFK_IdEmpresaGrupoCliente() {
		return this.activarFK_IdEmpresaGrupoCliente;
	}

	public void setActivarFK_IdEmpresaGrupoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGrupoCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoGrupoCliente=null;

	public Border getResaltarBusquedaPorCodigoGrupoCliente() {
		return this.resaltarBusquedaPorCodigoGrupoCliente;
	}

	public void setResaltarBusquedaPorCodigoGrupoCliente(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoGrupoCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoGrupoCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreGrupoCliente=null;

	public Border getResaltarBusquedaPorNombreGrupoCliente() {
		return this.resaltarBusquedaPorNombreGrupoCliente;
	}

	public void setResaltarBusquedaPorNombreGrupoCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreGrupoCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreGrupoCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasGrupoCliente=null;

	public Border getResaltarBusquedaPorSiglasGrupoCliente() {
		return this.resaltarBusquedaPorSiglasGrupoCliente;
	}

	public void setResaltarBusquedaPorSiglasGrupoCliente(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasGrupoCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasGrupoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGrupoCliente=null;

	public Border getResaltarFK_IdEmpresaGrupoCliente() {
		return this.resaltarFK_IdEmpresaGrupoCliente;
	}

	public void setResaltarFK_IdEmpresaGrupoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGrupoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGrupoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoClienteBeanSwingJInternalFrame grupoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGrupoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}